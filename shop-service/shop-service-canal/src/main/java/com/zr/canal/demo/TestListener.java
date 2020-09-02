package com.zr.canal.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;
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

    //更新监听，需要看操作之后的数据
    @UpdateListenPoint
    public void onEventUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getBeforeColumnsList())
            log.info("更新操作 修改前：{} : {}", column.getName(), column.getValue());

        for (CanalEntry.Column column : rowData.getAfterColumnsList())
            log.info("更新操作 修改后：{} : {}", column.getName(), column.getValue());
    }

    //删除监听，需要看操作之前的数据
    @DeleteListenPoint
    public void onEventDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getBeforeColumnsList())
            log.info("删除操作：{} : {}", column.getName(), column.getValue());
    }

    //自定义监控：指定监听的类型、数据库、表、实例地址
    @ListenPoint(
            eventType = {CanalEntry.EventType.DELETE, CanalEntry.EventType.INSERT},
            schema = {"shop_ad"},
            table = {"SHOP_AD_CONTENT"},
            destination = "example"
    )
    public void onEventCustomize(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getBeforeColumnsList())
            log.info("自定义操作 修改前：{} : {}", column.getName(), column.getValue());

        for (CanalEntry.Column column : rowData.getAfterColumnsList())
            log.info("自定义操作 修改后：{} : {}", column.getName(), column.getValue());
    }

}
