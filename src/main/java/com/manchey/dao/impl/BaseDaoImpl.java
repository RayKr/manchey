package com.manchey.dao.impl;

import com.manchey.dao.BaseDaoI;

import java.io.Serializable;

/**
 * DAO层使用泛型
 * Created by Ray on 2016/5/20.
 */
public class BaseDaoImpl<T> implements BaseDaoI<T> {
    public Serializable save(T o) {
        return null;
    }


}
