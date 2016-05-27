package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.MediaMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 语音消息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqVoiceMessage extends MediaMessage {

    @XmlElement(name = "Format")
    private String format; // 语音格式，如amr，speex等

    @XmlElement(name = "Recognition")
    private String recognition; // 语音识别结果，UTF8编码

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
