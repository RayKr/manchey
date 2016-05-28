package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "rolerelation", schema = "manchey", catalog = "")
public class TRolerelation {
    private int id;
    private Integer roleId;
    private Integer targetRoleId;
    private String targetNickName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleId", nullable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "targetRoleId", nullable = true)
    public Integer getTargetRoleId() {
        return targetRoleId;
    }

    public void setTargetRoleId(Integer targetRoleId) {
        this.targetRoleId = targetRoleId;
    }

    @Basic
    @Column(name = "targetNickName", nullable = true, length = 20)
    public String getTargetNickName() {
        return targetNickName;
    }

    public void setTargetNickName(String targetNickName) {
        this.targetNickName = targetNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRolerelation that = (TRolerelation) o;

        if (id != that.id) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (targetRoleId != null ? !targetRoleId.equals(that.targetRoleId) : that.targetRoleId != null) return false;
        if (targetNickName != null ? !targetNickName.equals(that.targetNickName) : that.targetNickName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (targetRoleId != null ? targetRoleId.hashCode() : 0);
        result = 31 * result + (targetNickName != null ? targetNickName.hashCode() : 0);
        return result;
    }
}
