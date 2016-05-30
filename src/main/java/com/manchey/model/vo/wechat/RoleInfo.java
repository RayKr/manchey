package com.manchey.model.vo.wechat;

/**
 * 微信接受角色消息VO类
 * Created by Ray on 2016/5/28.
 */
public class RoleInfo {

    private Integer regionCode; // 大区代码

    private String regionName; // 大区

    private Integer serverCode; // 服务器代码

    private String serverName; // 服务器

    private String roleName; // 角色名

    private Integer level; // 级别

    private String unit; // 门派

    public RoleInfo() {
    }

    public RoleInfo(String regionName, String serverName, String roleName) {
        this.regionName = regionName;
        this.serverName = serverName;
        this.roleName = roleName;
    }

    public RoleInfo(String regionName, String serverName, String roleName, Integer level, String unit) {
        this.regionName = regionName;
        this.serverName = serverName;
        this.roleName = roleName;
        this.level = level;
        this.unit = unit;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getServerCode() {
        return serverCode;
    }

    public void setServerCode(Integer serverCode) {
        this.serverCode = serverCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "regionName='" + regionName + '\'' +
                ", serverName='" + serverName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", level='" + level + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
