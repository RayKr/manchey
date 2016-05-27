package com.manchey.model.vo.wechat.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 普通消息的抽象基类
 * Created by Ray on 2016/5/27.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class NormalMessage extends BaseMessage {

    @XmlElement(name = "MsgId")
    protected Integer msgId; // 消息id，64位整型

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

}
