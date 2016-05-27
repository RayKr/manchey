package com.manchey.model.vo;

/**
 * 点击菜单事件
 * Created by Ray on 2016/5/27.
 */
public class MenuEventMessage extends EventMessage {

    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
