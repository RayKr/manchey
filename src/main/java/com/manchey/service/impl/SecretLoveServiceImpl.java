package com.manchey.service.impl;

import com.manchey.dao.BaseDao;
import com.manchey.exception.RoleInfoException;
import com.manchey.model.po.TRole;
import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.service.SecretLoveService;
import com.manchey.service.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ray on 2016/5/28.
 */
@Service("secretLoveService")
public class SecretLoveServiceImpl implements SecretLoveService {

    @Autowired
    private CheckRoleService checkRoleService;

    @Autowired
    private BaseDao<TRole> tRoleDao;

    @Override
    public void bindMySelf(RoleInfo roleInfo) throws RoleInfoException {

        // 验证信息正确性
        roleInfo = checkRoleService.checkRoleCorrect(roleInfo);

        // 记录用户角色信息
        TRole role = new TRole();
        role.setWechatId(roleInfo.getWechatId());
        role.setRoleName(roleInfo.getRoleName());
        role.setServerCode(roleInfo.getServerCode());
        role.setLevel(roleInfo.getLevel());
        tRoleDao.save(role);

    }

    @Override
    public void bindLover(RoleInfo roleInfo) throws RoleInfoException {
        // 验证信息正确性
        roleInfo = checkRoleService.checkRoleCorrect(roleInfo);

        // 记录用户角色信息
        TRole role = new TRole();
        role.setRoleName(roleInfo.getRoleName());
        role.setServerCode(roleInfo.getServerCode());
        role.setLevel(roleInfo.getLevel());

        tRoleDao.save(role);
    }

    @Override
    public String post() {
        return null;
    }
}
