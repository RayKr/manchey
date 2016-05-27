package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.MediaMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 视频消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqVideoMessage extends MediaMessage {

    @XmlElement(name = "ThumbMediaId")
    protected String thumbMediaId; // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
