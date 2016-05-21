package com.manchey.service;

import com.manchey.dao.IAccountDao;
import com.manchey.dao.IStockDao;
import com.manchey.model.po.StockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ray on 2016/5/17.
 */
@Service("stockService")
public class StockProcessServiceImpl implements IStockProcessService {

    private IAccountDao accountDao;
    private IStockDao stockDao;

    @Autowired
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public void openAccount(String aname, double money) {
        accountDao.insertAccount(aname, money);
    }

    @Override
    public void openStock(String sname, int amount) {
        stockDao.insertStock(sname, amount);
    }

    @Override
    public void buyStock(String aname, double money, String sname, int amount) throws StockException {
        boolean isBuy = true;
        accountDao.updateAccount(aname, money, isBuy);
        if (1 == 1) {
            throw new StockException("股票异常");
        }
        stockDao.updateStock(sname, amount, isBuy);
    }
}
