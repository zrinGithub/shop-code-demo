package com.zr.search.service.impl;

import com.zr.search.service.InitService;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/11 11:32
 */
@Service
public class InitServiceImpl implements InitService {

    @Resource
    private ElasticsearchTemplate templates;

    @Override
    public void createMappingAndIndex() {

    }

    @Override
    public void importAll() {

    }
}
