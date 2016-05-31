package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;
import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * 回复图文消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResArticleMessage extends BaseMessage {

    @XmlElement(name = "ArticleCount")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String articleCount; // 图文消息个数，限制为10条以内

    @XmlElement(name = "Articles")
    private Articles articles;

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Articles {

        @XmlElement(name = "item")
        private List<Article> item; // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应

        public List<Article> getItem() {
            return item;
        }

        public void setItem(List<Article> item) {
            this.item = item;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Article {

            @XmlElement(name = "Title")
            @XmlJavaTypeAdapter(AdapterCDATA.class)
            private String title; // 图文消息标题

            @XmlElement(name = "Description")
            @XmlJavaTypeAdapter(AdapterCDATA.class)
            private String description; // 	图文消息描述

            @XmlElement(name = "PicUrl")
            @XmlJavaTypeAdapter(AdapterCDATA.class)
            private String picUrl; // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200

            @XmlElement(name = "Url")
            @XmlJavaTypeAdapter(AdapterCDATA.class)
            private String url; // 点击图文消息跳转链接

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
    }
}
