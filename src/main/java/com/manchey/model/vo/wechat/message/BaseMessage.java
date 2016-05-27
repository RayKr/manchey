package com.manchey.model.vo.wechat.message;

/**
 * 消息基类
 * Created by Ray on 2016/5/27.
 */
public abstract class BaseMessage {
    // 目标帐号
    private String toUserName;
    // 源头帐号
    private String fromUserName;
    // 消息创建时间 （整型）
    private Integer createTime;
    // text
    private String msgType;

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
