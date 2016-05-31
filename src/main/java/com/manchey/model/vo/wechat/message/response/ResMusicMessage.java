package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;
import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 回复音乐消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResMusicMessage extends BaseMessage {

    @XmlElement(name = "Music")
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Music {
        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String title; // 音乐标题

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String description; // 音乐描述

        @XmlElement(name = "MusicUrl")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String musicUrl; // 音乐链接

        @XmlElement
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String HQmusicUrl; // 高质量音乐链接，WIFI环境优先使用该链接播放音乐

        @XmlElement(name = "ThumbMediaId")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String thumbMediaId; // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id

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

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String getHQmusicUrl() {
            return HQmusicUrl;
        }

        public void setHQmusicUrl(String HQmusicUrl) {
            this.HQmusicUrl = HQmusicUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
