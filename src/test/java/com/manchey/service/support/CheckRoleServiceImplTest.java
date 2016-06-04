package com.manchey.service.support;

import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.service.UserServiceI;
import com.manchey.service.CheckRoleService;
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
public class CheckRoleServiceImplTest extends TestCase {

    @Autowired
    private CheckRoleService checkRoleService;

    @Test
    public void testCheckRoleCorrect() throws Exception {

        RoleInfo roleInfo = new RoleInfo("网通三区", "天鹅坪", "铁锅炖大鹅", 90, "纯阳");

        checkRoleService.checkRoleCorrect(roleInfo);

    }

    @Autowired
    private UserServiceI userService;

    @Test
    public void test01() {
        userService.addUser("zhanan", 33);
    }

}