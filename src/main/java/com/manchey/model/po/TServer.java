package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "server", schema = "manchey", catalog = "")
public class TServer {
    private int id;
    private int serverCode;
    private String serverName;
    private int regionCode;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "serverName", nullable = false, length = 20)
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Basic
    @Column(name = "regionCode", nullable = false)
    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TServer tServer = (TServer) o;

        if (id != tServer.id) return false;
        if (serverCode != tServer.serverCode) return false;
        if (regionCode != tServer.regionCode) return false;
        if (serverName != null ? !serverName.equals(tServer.serverName) : tServer.serverName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + serverCode;
        result = 31 * result + (serverName != null ? serverName.hashCode() : 0);
        result = 31 * result + regionCode;
        return result;
    }
}
