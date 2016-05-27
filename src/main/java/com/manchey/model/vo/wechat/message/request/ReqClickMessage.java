package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.EventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 点击菜单事件
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqClickMessage extends EventMessage {

    @XmlElement(name = "EventKey")
    private String eventKey; // 事件KEY值，与自定义菜单接口中KEY值对应

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
