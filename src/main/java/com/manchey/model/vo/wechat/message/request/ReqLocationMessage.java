package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.NormalMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 地址位置信息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLocationMessage extends NormalMessage {

    @XmlElement(name = "Location_X")
    private String location_X; // 地理位置维度

    @XmlElement(name = "Location_Y")
    private String location_Y; // 地理位置经度

    @XmlElement(name = "Scale")
    private String scale; // 地图缩放大小

    @XmlElement(name = "Label")
    private String label;  // 地理位置信息

    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
