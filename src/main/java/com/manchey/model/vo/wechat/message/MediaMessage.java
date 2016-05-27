package com.manchey.model.vo.wechat.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 多媒体消息基类
 * Created by Ray on 2016/5/27.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class MediaMessage extends NormalMessage {

    @XmlElement(name = "MediaId")
    protected String mediaId; // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
