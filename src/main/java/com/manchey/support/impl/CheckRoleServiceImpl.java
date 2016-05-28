package com.manchey.support.impl;

import com.manchey.dao.BaseDao;
import com.manchey.exception.RoleInfoException;
import com.manchey.model.po.TRegion;
import com.manchey.model.po.TServer;
import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.support.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验证角色信息实现类
 * Created by Ray on 2016/5/28.
 */
@Service("checkRoleService")
public class CheckRoleServiceImpl implements CheckRoleService {
    @Autowired
    private BaseDao<TRegion> regionDao;

    @Autowired
    private BaseDao<TServer> serverDao;

    @Override
    public RoleInfo checkRoleCorrect(RoleInfo roleInfo) throws RoleInfoException {
        // 验证大区是否存在
        String hql = "from TRegion where regionName = ?";
        TRegion tRegion = regionDao.get(hql, roleInfo.getRegionName());
        if (tRegion == null) {
            throw new RoleInfoException("您输入的大区名字有误，请确认后重试！");
        }
        roleInfo.setRegionCode(tRegion.getRegionCode());

        // 验证服务器是否存在
        hql = "from TServer where serverName = ? and regionCode = ?";
        TServer tServer = serverDao.get(hql, roleInfo.getServerName(), roleInfo.getRegionCode());
        if (tServer == null) {
            throw new RoleInfoException("该大区不存在此服务器，请确认后重试！");
        }
        roleInfo.setServerCode(tServer.getServerCode());

        // TODO 验证角色，需要讨论具体验证流程
        return roleInfo;
    }
}
