package com.manchey.dao;

/**
 * Created by Ray on 2016/5/17.
 */
public interface IStockDao {
    void insertStock(String sname, int amount);

    void updateStock(String sname, int amount, boolean isBuy);
}
