package com.manchey.dao;

import java.io.Serializable;

/**
 * DAO层泛型接口
 * Created by Ray on 2016/5/20.
 */
public interface BaseDaoI<T> {
    Serializable save(T o);
}
