package com.manchey.model.vo.wechat.message.response;

import com.manchey.model.vo.wechat.message.MediaMessage;
import com.manchey.utils.wechat.AdapterCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * ResMusicMessage
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResVoiceMessage extends MediaMessage {

    @XmlElement(name = "Voice")
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Voice {

        @XmlElement(name = "MediaId")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
