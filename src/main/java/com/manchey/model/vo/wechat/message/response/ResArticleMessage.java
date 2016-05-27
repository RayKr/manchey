package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;

/**
 * 回复图文消息
 * Created by Ray on 2016/5/27.
 */
public class ResArticleMessage extends BaseMessage {

    // 图文消息个数，限制为10条以内
    private String articleCount;

    // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    private String articles;

    // 图文消息标题
    private String title;

    // 	图文消息描述
    private String description;

    // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String picUrl;

    // 点击图文消息跳转链接
    private String url;

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
