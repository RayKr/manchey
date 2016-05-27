package com.manchey.model.vo;

/**
 * 地址位置信息
 * Created by Ray on 2016/5/27.
 */
public class LocationMessage extends NormalMessage {

    // 地理位置维度
    private String location_X;

    // 地理位置经度
    private String location_Y;

    // 	地图缩放大小
    private String scale;

    // 地理位置信息
    private String label;

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
