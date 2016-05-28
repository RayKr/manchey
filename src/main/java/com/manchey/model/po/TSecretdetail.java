package com.manchey.model.po;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "secretdetail", schema = "manchey", catalog = "")
public class TSecretdetail {
    private int id;
    private int roleId;
    private int targetRoleId;
    private String content;
    private Byte targetExist;
    private Date postTime;
    private Byte isResponse;
    private Byte isPost;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleId", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "targetRoleId", nullable = false)
    public int getTargetRoleId() {
        return targetRoleId;
    }

    public void setTargetRoleId(int targetRoleId) {
        this.targetRoleId = targetRoleId;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "targetExist", nullable = true)
    public Byte getTargetExist() {
        return targetExist;
    }

    public void setTargetExist(Byte targetExist) {
        this.targetExist = targetExist;
    }

    @Basic
    @Column(name = "postTime", nullable = true)
    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "isResponse", nullable = true)
    public Byte getIsResponse() {
        return isResponse;
    }

    public void setIsResponse(Byte isResponse) {
        this.isResponse = isResponse;
    }

    @Basic
    @Column(name = "isPost", nullable = true)
    public Byte getIsPost() {
        return isPost;
    }

    public void setIsPost(Byte isPost) {
        this.isPost = isPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSecretdetail that = (TSecretdetail) o;

        if (id != that.id) return false;
        if (roleId != that.roleId) return false;
        if (targetRoleId != that.targetRoleId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (targetExist != null ? !targetExist.equals(that.targetExist) : that.targetExist != null) return false;
        if (postTime != null ? !postTime.equals(that.postTime) : that.postTime != null) return false;
        if (isResponse != null ? !isResponse.equals(that.isResponse) : that.isResponse != null) return false;
        if (isPost != null ? !isPost.equals(that.isPost) : that.isPost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roleId;
        result = 31 * result + targetRoleId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (targetExist != null ? targetExist.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (isResponse != null ? isResponse.hashCode() : 0);
        result = 31 * result + (isPost != null ? isPost.hashCode() : 0);
        return result;
    }
}
