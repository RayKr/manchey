package com.manchey.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Ray on 2016/5/17.
 */
@Entity
public class Stock {
    private Integer sid;
    private String sname;
    private int count;

    public Stock() {
    }

    public Stock(String sname, int count) {
        this.sname = sname;
        this.count = count;
    }

    @Id
    @GeneratedValue()
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", count=" + count +
                '}';
    }
}
