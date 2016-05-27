package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.NormalMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 链接消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLinkMessage extends NormalMessage {

    @XmlElement(name = "Title")
    private String title; // 消息标题

    @XmlElement(name = "Description")
    private String description; // 消息描述

    @XmlElement(name = "Url")
    private String url; // 消息链接

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
