package com.manchey.service.impl;

import com.manchey.dao.BaseDaoI;
import com.manchey.model.po.Tuser;
import com.manchey.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ray on 2016/5/20.
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    private BaseDaoI<Tuser> userDao;

    public BaseDaoI<Tuser> getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(BaseDaoI<Tuser> userDao) {
        this.userDao = userDao;
    }

    public void addUser(String name, int age) {
        userDao.save(new Tuser(name, age));
    }
}
