package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;

/**
 * 回复音乐消息
 * Created by Ray on 2016/5/27.
 */
public class ResMusicMessage extends BaseMessage {

    // 音乐标题
    private String title;

    // 音乐描述
    private String description;

    // 音乐链接
    private String musicUrl;

    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQmusicUrl;

    // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    private String ThumbMediaId;

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
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
