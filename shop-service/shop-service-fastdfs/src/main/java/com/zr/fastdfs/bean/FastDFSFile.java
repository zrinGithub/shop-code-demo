package com.zr.fastdfs.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * 封装信息，用于上传
 *
 * @author zhangr
 * 2020/8/20 16:50
 */
@Data
@Accessors(chain = true)
public class FastDFSFile {
    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件创建作者
    private String author;
}

