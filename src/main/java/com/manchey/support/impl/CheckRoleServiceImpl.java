package com.manchey.support.impl;

import com.manchey.dao.BaseDao;
import com.manchey.exception.RoleInfoException;
import com.manchey.model.po.TRegion;
import com.manchey.model.po.TRole;
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

    @Autowired
    private BaseDao<TRole> roleDao;

    @Override
    public RoleInfo checkRoleCorrect(RoleInfo roleInfo) throws RoleInfoException {
        // 验证大区是否存在
        String hql = "from TRegion where regionName=?0 ";
        TRegion tRegion = regionDao.get(hql, roleInfo.getRegionName());
        if (tRegion == null) {
            throw new RoleInfoException("您输入的大区名字有误，请确认后重试！");
        }
        roleInfo.setRegionCode(tRegion.getRegionCode());

        // 验证服务器是否存在
        hql = "from TServer where serverName=?0 and regionCode=?1 ";
        TServer tServer = serverDao.get(hql, roleInfo.getServerName(), roleInfo.getRegionCode());
        if (tServer == null) {
            throw new RoleInfoException("该大区不存在此服务器，请确认后重试！");
        }
        roleInfo.setServerCode(tServer.getServerCode());

        // TODO 验证角色，需要讨论具体验证流程
        hql = "from TRole where serverCode=?0 and roleName=?1 ";
        TRole tRole = roleDao.get(hql, roleInfo.getServerCode(), roleInfo.getRoleName());
        if (tRole != null) {
            // TODO 有个问题，如果其他用户冒用此角色名，如何保证数据的准确性，所以必须有游戏端API或者手工验证。
            throw new RoleInfoException("该角色名已绑定，无需重复操作，如果信息有误，请联系管理员！");
        }

        return roleInfo;
    }
}
