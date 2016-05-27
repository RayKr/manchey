package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.MediaMessage;

/**
 * 图片消息
 * Created by Ray on 2016/5/27.
 */
public class ReqImageMessage extends MediaMessage {

    // 图片链接（由系统生成）
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
