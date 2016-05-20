package com.manchey.service;

import com.manchey.dao.BaseDaoI;

/**
 * Created by Ray on 2016/5/20.
 */
public class UserServiceImpl implements UserServiceI {

    private BaseDaoI userDao;

    public void setUserDao(BaseDaoI userDao) {
        this.userDao = userDao;
    }

    public void findUserByName(String name) {

    }
}
