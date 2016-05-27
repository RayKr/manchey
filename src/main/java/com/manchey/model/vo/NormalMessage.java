package com.manchey.model.vo;

/**
 * 普通消息的抽象基类
 * Created by Ray on 2016/5/27.
 */
public abstract class NormalMessage extends BaseMessage {
    // 消息id，64位整型
    private Integer msgId;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

}
