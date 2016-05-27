package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.MediaMessage;

/**
 * 回复视频消息
 * Created by Ray on 2016/5/27.
 */
public class ResVideoMessage extends MediaMessage {

    // 视频消息的标题
    private String title;

    // 视频消息的描述
    private String description;

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
