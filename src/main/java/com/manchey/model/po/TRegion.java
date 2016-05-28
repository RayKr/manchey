package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/5/28.
 */
@Entity
@Table(name = "region", schema = "manchey")
public class TRegion {
    private int regionCode;
    private String regionName;
    private String regionType;

    @Id
    @Column(name = "regionCode", nullable = false)
    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "regionName", nullable = false, length = 20)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "regionType", nullable = true, length = 20)
    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRegion tRegion = (TRegion) o;

        if (regionCode != tRegion.regionCode) return false;
        if (regionName != null ? !regionName.equals(tRegion.regionName) : tRegion.regionName != null) return false;
        if (regionType != null ? !regionType.equals(tRegion.regionType) : tRegion.regionType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionCode;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (regionType != null ? regionType.hashCode() : 0);
        return result;
    }
}
