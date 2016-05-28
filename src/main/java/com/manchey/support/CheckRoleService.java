package com.manchey.support;

import com.manchey.exception.RoleInfoException;
import com.manchey.model.vo.wechat.RoleInfo;

/**
 * 角色信息验证
 * Created by Ray on 2016/5/28.
 */
public interface CheckRoleService {

    /**
     * 验证大区和服务器
     * @param roleInfo RoleInfo
     * @return true
     * @throws RoleInfoException
     */
    RoleInfo checkRoleCorrect(RoleInfo roleInfo) throws RoleInfoException;

}
