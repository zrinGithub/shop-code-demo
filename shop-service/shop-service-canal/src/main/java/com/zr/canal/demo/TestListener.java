package com.zr.canal.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Description:
 * 测试Canal 数据监听
 *
 * @author zhangr
 * 2020/8/31 16:56
 */
@CanalEventListener
@Slf4j
public class TestListener {
    //增加监听，需要看操作之后的数据
    @InsertListenPoint
    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getAfterColumnsList())
            log.info("增加操作：{} : {}", column.getName(), column.getValue());
    }


}
