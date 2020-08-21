package com.zr.fastdfs.client;

import com.zr.fastdfs.bean.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * Description:
 * 使用https://github.com/happyfish100/fastdfs-com.zr.fastdfs.client-java的源码包
 * 注意里面的三个client：TrackerClient、StorageClient1、StorageClient都不是线程安全的
 *
 * @author zhangr
 * 2020/8/20 15:57
 */
@Component
@Slf4j
public class FastDFSClient {
    private TrackerServer trackerServer;
    private TrackerClient trackerClient;
    private StorageServer storageServer;
    //使用StorageClient1而不是StorageClient只是为了方便操作组名和文件路径（想一下你不用自己去加分隔符了）
    private StorageClient1 storageClient;

    //设定默认的配置，可以在application.yml里面修改
    @Value("${fastdfs.http.permit.types:png,jpg,jpeg,doc,xls,pdf,bmp,gif}")
    private String permitTypes;
    private String[] types;
    private String prefix;

    @PostConstruct
    public void init() throws Exception {
        String path = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(path);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getTrackerServer();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer, storageServer);
        types = permitTypes.split(",");
        prefix = "http://" + trackerServer.getInetSocketAddress().getHostString()
                + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }

    /**
     * 上传输入流
     *
     * @param file 包装的文件数据
     * @return 文件路径
     */
    public String uploadFile(FastDFSFile file) throws Exception {
        //1.判定文件类型是否合法
        boolean permit = false;
        for (String type : types) {
            if (type.equals(file.getExt())) {
                permit = true;
                break;
            }
        }

        if (!permit) {
            String errMsg = "上传文件格式不允许";
            log.error(errMsg);
            throw new Exception(errMsg);
        }
        //2.封装参数
        NameValuePair[] metas = new NameValuePair[2];
        metas[0] = new NameValuePair("name", file.getName());
        metas[1] = new NameValuePair("author", file.getAuthor());
        //3.上传文件
        String relativePath = storageClient.upload_file1(file.getContent(), file.getExt(), metas);
        return prefix + relativePath;
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 返回操作结果判定
     * @throws IOException
     * @throws MyException
     */
    public boolean deleteFile(String filePath) throws IOException, MyException {
        return 0 == storageClient.delete_file1(StringUtils.replace(filePath, prefix, ""));
    }

    /**
     * 获取下载文件流
     *
     * @param filePath 文件完整路径
     * @return 返回输入流
     * @throws IOException
     * @throws MyException
     */
    public InputStream downloadFileStream(String filePath) throws IOException, MyException {
        byte[] content = storageClient.download_file1(filePath);
        return new ByteArrayInputStream(content);
    }

    /**
     * 获取下载文件Base64编码
     *
     * @param filePath 文件完整路径
     * @return 返回BASE64编码
     * @throws IOException
     * @throws MyException
     */
    public String downloadFileBase64(String filePath) throws IOException, MyException {
        try (InputStream inputStream = downloadFileStream(filePath)) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            String fileType = StringUtils.substringAfterLast(filePath, ".");
            String encodeStr = Base64.getEncoder().encodeToString(bytes);
            return String.format("data:image/%s;base64,", fileType) + encodeStr;
        } catch (Exception e) {
            return null;
        }
    }
}
