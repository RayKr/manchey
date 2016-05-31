package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.BaseMessage;
import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 回复文本消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResTextMessage extends BaseMessage {

    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
