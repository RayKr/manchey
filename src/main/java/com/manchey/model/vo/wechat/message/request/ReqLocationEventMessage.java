package com.manchey.model.vo.wechat.message.request;

import com.manchey.model.vo.wechat.message.EventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 地理位置事件信息
 * Created by Ray on 2016/5/27.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLocationEventMessage extends EventMessage {

    @XmlElement(name = "Latitude")
    private String latitude; // 地理位置纬度


    @XmlElement(name = "Longitude")
    private String longitude; // 地理位置经度


    @XmlElement(name = "Precision")
    private String precision; // 地理位置精度

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
