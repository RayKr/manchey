package com.manchey.service;

import com.manchey.model.po.Tuser;

/**
 * Created by Ray on 2016/5/20.
 */
public interface UserServiceI {
    void addUser(String name, int age);
    Tuser findUser(int id);
}
