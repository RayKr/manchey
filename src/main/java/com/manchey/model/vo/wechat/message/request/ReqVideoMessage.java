package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.MediaMessage;

/**
 * 视频消息
 * Created by Ray on 2016/5/27.
 */
public class ReqVideoMessage extends MediaMessage {

    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String thumbMediaId;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
