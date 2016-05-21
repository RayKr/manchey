package com.manchey.dao;

/**
 * Created by Ray on 2016/5/17.
 */
public interface IAccountDao {
    void insertAccount(String aname, double money);

    void updateAccount(String aname, double money, boolean isBuy);
}
