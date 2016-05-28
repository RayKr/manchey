package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "role", schema = "manchey", catalog = "")
public class TRole {
    private int id;
    private String roleName;
    private int serverCode;
    private Integer level;
    private String roleType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleName", nullable = false, length = 20)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "serverCode", nullable = false)
    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "roleType", nullable = true, length = 10)
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRole tRole = (TRole) o;

        if (id != tRole.id) return false;
        if (serverCode != tRole.serverCode) return false;
        if (roleName != null ? !roleName.equals(tRole.roleName) : tRole.roleName != null) return false;
        if (level != null ? !level.equals(tRole.level) : tRole.level != null) return false;
        if (roleType != null ? !roleType.equals(tRole.roleType) : tRole.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + serverCode;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        return result;
    }
}
