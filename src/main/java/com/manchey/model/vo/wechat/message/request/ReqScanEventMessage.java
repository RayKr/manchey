package com.manchey.model.vo.wechat.message.request;

/**
 * 二维码扫描事件消息
 * Created by Ray on 2016/5/27.
 */
public class ReqScanEventMessage extends ReqEventMessage {
    // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private long eventKey;

    // 二维码的ticket，可用来换取二维码图片
    private String ticket;

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
