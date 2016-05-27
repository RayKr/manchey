package com.manchey.model.vo.wechat.message.request;

/**
 * 文本消息
 * Created by Ray on 2016/5/27.
 */
public class ReqTextMessage extends NormalMessage {
    // 文本消息内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
