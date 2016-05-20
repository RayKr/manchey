package com.manchey.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Ray on 2016/5/20.
 */
@Entity
public class User {
    private Integer id;
    private String name;
    private int age;
    private String borthDate;

    public User(String name, int age, String borthDate) {
        this.name = name;
        this.age = age;
        this.borthDate = borthDate;
    }

    public User() {

    }

    @Id
    @GeneratedValue(generator = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBorthDate() {
        return borthDate;
    }

    public void setBorthDate(String borthDate) {
        this.borthDate = borthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", borthDate='" + borthDate + '\'' +
                '}';
    }
}
