package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;
import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 回复图片消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResImageMessage extends BaseMessage {

    @XmlElement(name = "Image")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Image {

        @XmlElement(name = "MediaId")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String mediaId; // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
