package com.manchey.dao.impl;

import com.manchey.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * DAO层使用泛型
 * Created by Ray on 2016/5/20.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Serializable save(T o) {
        return getCurrentSession().save(o);
    }

    public void delete(T o) {
        getCurrentSession().delete(o);
    }

    public void update(T o) {
        getCurrentSession().update(o);
    }

    public void saveOrUpdate(T o) {
        getCurrentSession().saveOrUpdate(o);
    }

    public T get(Class<T> c, Serializable id) {
        return (T) getCurrentSession().get(c, id);
    }

    public T get(String hql, Object[] param) {
        List<T> lst = this.find(hql, param);
        if (lst != null && lst.size() > 0) {
            return lst.get(0);
        }
        return null;
    }

    public T get(String hql, List<Object> param) {
        // TODO T get(String hql, List<Object> param)
        return null;
    }

    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    public List<T> find(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        return null;
    }

    public List<T> find(String hql, List<Object> param) {
        return null;
    }

    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
        return null;
    }

    public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
        return null;
    }

    public List findSQL(String hql, Class T) {
        return null;
    }

    public List findSQL(String hql) {
        return null;
    }

    public Integer executeHql(String hql) {
        return null;
    }

    public Integer executeHql(String hql, Object[] param) {
        return null;
    }

    public Integer executeHql(String hql, List<Object> param) {
        return null;
    }
}
