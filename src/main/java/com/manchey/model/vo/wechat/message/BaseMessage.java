package com.manchey.model.vo.wechat.message;

import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 消息基类
 * Created by Ray on 2016/5/27.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseMessage {

    @XmlElement(name = "ToUserName")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String toUserName; // 目标帐号

    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String fromUserName; // 源头帐号

    @XmlElement(name = "CreateTime")
    protected long createTime; // 消息创建时间 （整型）

    @XmlElement(name = "MsgType")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String msgType; // 消息类型

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
