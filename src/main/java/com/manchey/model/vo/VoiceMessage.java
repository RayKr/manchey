package com.manchey.model.vo;

/**
 * 语音消息
 * Created by Ray on 2016/5/27.
 */
public class VoiceMessage extends MediaMessage {

    // 语音格式，如amr，speex等
    private String format;

    // 语音识别结果，UTF8编码
    private String recognition;

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
