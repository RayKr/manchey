package com.manchey.service;

import com.manchey.exception.RoleInfoException;
import com.manchey.model.vo.wechat.RoleInfo;

/**
 * 暗恋系统业务处理接口
 * Created by Ray on 2016/5/28.
 */
public interface SecretLoveService {

    // 绑定自己角色信息
    void bindMySelf(RoleInfo roleInfo) throws RoleInfoException;

    // 绑定暗恋目标信息
    void bindLover(RoleInfo roleInfo) throws RoleInfoException;

    // 接受密语并处理，返回处理结果
    String post();

}
