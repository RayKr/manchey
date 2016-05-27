package com.manchey.model.vo.wechat.message.request;

/**
 * 点击菜单事件
 * Created by Ray on 2016/5/27.
 */
public class ReqMenuEventMessage extends ReqEventMessage {

    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
