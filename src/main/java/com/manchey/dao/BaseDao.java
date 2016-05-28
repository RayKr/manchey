package com.manchey.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DAO层泛型接口
 * Created by Ray on 2016/5/20.
 */
public interface BaseDao<T> {

    Serializable save(T o);

    void delete(T o);

    void update(T o);

    void saveOrUpdate(T o);

    T get(Class<T> c, Serializable id);

    T get(String hql, Object...param);

    T get(String hql, Map<String, Object> params);

    List<T> find(String hql);

    List<T> find(String hql, Object...param);

    List<T> find(String hql, Map<String, Object> params);

    /**
     * 按照分页查询结果
     * @param page
     *              要显示的页数
     * @param rows
     *              每页要显示的行数
     */
    List<T> find(String hql, Integer page, Integer rows, Object...param);

    List findSQL(String hql, Class T);

    List findSQL(String hql);

    /**
     * 执行sql语句
     * @return 返回值为执行的结果
     */
    Integer executeHql(String hql);

    Integer executeHql(String hql, Object...param);

}
