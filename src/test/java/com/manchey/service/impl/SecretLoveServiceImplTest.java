package com.manchey.service.impl;

import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.service.SecretLoveService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ray on 2016/5/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring*.xml")
public class SecretLoveServiceImplTest extends TestCase {

    @Autowired
    private SecretLoveService secretLoveService;

    @Test
    public void testBindMySelf() throws Exception {
        RoleInfo roleInfo = new RoleInfo("网通三区", "天鹅坪", "铁锅炖大鹅", 90, "纯阳");

        secretLoveService.bindMySelf(roleInfo);
    }

    public void testBindLover() throws Exception {

    }

    public void testPost() throws Exception {

    }

}