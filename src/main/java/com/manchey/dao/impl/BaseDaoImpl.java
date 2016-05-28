package com.manchey.dao.impl;

import com.manchey.dao.BaseDao;
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
public class BaseDaoImpl<T> implements BaseDao<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(T o) {
        return getCurrentSession().save(o);
    }

    @Override
    public void delete(T o) {
        getCurrentSession().delete(o);
    }

    @Override
    public void update(T o) {
        getCurrentSession().update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        return  getCurrentSession().get(c, id);
    }

    @Override
    public T get(String hql, Object...param) {
        List<T> lst = this.find(hql, param);
        if (lst != null && lst.size() > 0) {
            return lst.get(0);
        }
        return null;
    }

    @Override
    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    public List<T> find(String hql, Object...params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
        return q.list();
    }

    @Override
    public List<T> find(String hql, Integer page, Integer rows, Object...param) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public List findSQL(String hql, Class T) {
        return this.getCurrentSession().createSQLQuery(hql).addEntity(T).list();
    }

    @Override
    public List findSQL(String hql) {
        return this.getCurrentSession().createSQLQuery(hql).list();
    }

    @Override
    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }

}
