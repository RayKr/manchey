package com.manchey.model.vo.wechat.message;

import com.manchey.utils.wechat.AdapterStringCDATA;
import com.manchey.utils.wechat.AdapterIntegerCDATA;

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
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    protected String toUserName; // 目标帐号

    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    protected String fromUserName; // 源头帐号

    @XmlElement(name = "CreateTime")
    @XmlJavaTypeAdapter(AdapterIntegerCDATA.class)
    protected Integer createTime; // 消息创建时间 （整型）

    @XmlElement(name = "MsgType")
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
