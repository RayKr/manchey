package com.manchey.model.vo;

/**
 * 多媒体消息基类
 * Created by Ray on 2016/5/27.
 */
public abstract class MediaMessage extends NormalMessage {
    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
