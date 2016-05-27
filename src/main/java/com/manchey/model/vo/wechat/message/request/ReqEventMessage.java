package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.BaseMessage;

/**
 * 事件消息
 * Created by Ray on 2016/5/27.
 */
public class ReqEventMessage extends BaseMessage {

    // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
