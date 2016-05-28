package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "roletype", schema = "manchey", catalog = "")
public class TRoletype {
    private String roleType;
    private String unit;
    private String bodyType;
    private String roleNick;

    @Id
    @Column(name = "roleType", nullable = false, length = 10)
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "unit", nullable = false, length = 20)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "bodyType", nullable = false, length = 10)
    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Basic
    @Column(name = "roleNick", nullable = true, length = 20)
    public String getRoleNick() {
        return roleNick;
    }

    public void setRoleNick(String roleNick) {
        this.roleNick = roleNick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRoletype tRoletype = (TRoletype) o;

        if (roleType != null ? !roleType.equals(tRoletype.roleType) : tRoletype.roleType != null) return false;
        if (unit != null ? !unit.equals(tRoletype.unit) : tRoletype.unit != null) return false;
        if (bodyType != null ? !bodyType.equals(tRoletype.bodyType) : tRoletype.bodyType != null) return false;
        if (roleNick != null ? !roleNick.equals(tRoletype.roleNick) : tRoletype.roleNick != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleType != null ? roleType.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
        result = 31 * result + (roleNick != null ? roleNick.hashCode() : 0);
        return result;
    }
}
