package com.manchey.dao.impl;

import org.springframework.stereotype.Repository;

/**
 * Created by Ray on 2016/5/27.
 */
@Repository("simpleBean")
public class SimpleBean {
    private String name;
    private String jobDescription;
    private int age;
    private boolean executive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isExecutive() {
        return executive;
    }

    public void setExecutive(boolean executive) {
        this.executive = executive;
    }
}
