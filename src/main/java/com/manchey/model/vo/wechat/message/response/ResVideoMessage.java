package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.MediaMessage;
import com.manchey.utils.wechat.AdapterStringCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 回复视频消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResVideoMessage extends MediaMessage {

    @XmlElement(name = "Video")
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Video {

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(AdapterStringCDATA.class)
        private String title; // 视频消息的标题

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(AdapterStringCDATA.class)
        private String description; // 视频消息的描述

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
