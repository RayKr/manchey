package com.manchey.dao.impl;

import com.manchey.dao.IAccountDao;
import com.manchey.model.po.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Ray on 2016/5/17.
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    private SessionFactory sessionFactory;

    @Override
    public void insertAccount(String aname, double money) {
//        String sql = "insert into account(aname, balance) values(?,?)";
        this.getSessionFactory().getCurrentSession().save(new Account(aname, money));
    }

    @Override
    public void updateAccount(String aname, double money, boolean isBuy) {
        String sql = "update account set balance = balance + ? where aname = ?";
        if (isBuy) {
            sql = "update account set balance = balance - ? where aname = ?";
        }

//        this.getJdbcTemplate().update(sql, money, aname);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
