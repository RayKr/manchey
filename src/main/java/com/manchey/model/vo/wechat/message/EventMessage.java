package com.manchey.model.vo.wechat.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 订阅事件消息
 * Created by Ray on 2016/5/27.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class EventMessage extends BaseMessage {

    @XmlElement(name = "Event")
    protected String event; // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
