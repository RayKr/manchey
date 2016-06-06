package com.manchey.service.impl;

import com.manchey.dao.BaseDao;
import com.manchey.mapper.OperatorMapper;
import com.manchey.mapper.UserMapper;
import com.manchey.model.po.Operator;
import com.manchey.model.po.TOperator;
import com.manchey.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ray on 2016/6/1.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BaseDao<TOperator> operatorDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public boolean checkLogin(String operno, String password) {

//        String hql = "from TOperator where operno=?0 and password=?1 ";
//        TOperator operator = operatorDao.get(hql, operno, password);
        Operator operator = operatorMapper.getOperator(operno, password);

        if (operator != null) {
            return true;
        }
        return false;
    }
}
