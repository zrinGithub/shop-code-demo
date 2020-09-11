package com.zr.search.service;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/11 11:32
 */
public interface InitService {
    //创建索引库结构
    void createMappingAndIndex();

    //导入全部数据进入es
    void importAll();
}
