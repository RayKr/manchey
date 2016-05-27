package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.EventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 二维码扫描事件消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqScanMessage extends EventMessage {

    @XmlElement(name = "EventKey")
    private long eventKey; // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id

    @XmlElement(name = "Ticket")
    private String ticket; // 二维码的ticket，可用来换取二维码图片

    public long getEventKey() {
        return eventKey;
    }

    public void setEventKey(long eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
