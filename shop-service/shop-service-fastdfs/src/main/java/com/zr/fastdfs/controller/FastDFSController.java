package com.zr.fastdfs.controller;

import com.zr.common.entity.RespVo;
import com.zr.fastdfs.bean.FastDFSFile;
import com.zr.fastdfs.client.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.csource.common.MyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Description:
 *
 * @author zhangr
 * 2020/8/20 16:57
 */
@RestController
@RequestMapping("fastdfs")
@Slf4j
public class FastDFSController {
    @Resource
    private FastDFSClient client;

    @PostMapping("upload")
    public RespVo<String> upload(MultipartFile file) {
        if (file == null) {
            return new RespVo<>(false, null, "文件不存在");
        }

        String filename = file.getOriginalFilename();
        if (StringUtils.isEmpty(filename)) {
            return new RespVo<>(false, null, "文件不存在");
        }

        try {
            String ext = filename.substring(filename.lastIndexOf(".") + 1);
            //TODO: 这里结合后面的权限校验把申请用户填进去
            FastDFSFile dfsFile = new FastDFSFile().setContent(file.getBytes()).setExt(ext).setName(filename).setAuthor("root");
            String fileDfsPath = client.uploadFile(dfsFile);
            return new RespVo<>(true, fileDfsPath, "文件上传成功");
        } catch (Exception e) {
            log.error("文件上传失败", e);
            return new RespVo<>(false, null, "文件上传失败");
        }
    }

    @GetMapping("delete")
    public RespVo<String> delete(@RequestParam("filePath") String filePath) throws IOException, MyException {
        if (client.deleteFile(filePath))
            return new RespVo<>(true, null, "文件删除成功");
        return new RespVo<>(false, null, "文件删除失败");
    }
}
