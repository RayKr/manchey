package com.manchey.servlets;

import com.manchey.model.po.Tuser;
import com.manchey.service.UserServiceI;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Ray on 2016/5/20.
 */
public class RegisterServlet extends javax.servlet.http.HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

//        // 从Spring容器中获取service
//        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//        System.out.println("ac = " + ac);
//
//        // 调用service的方法
//        UserServiceI userService = (UserServiceI) ac.getBean("userService");
//        Tuser user = userService.findUserByName(name);
//        System.out.println(user.toString());

        // 跳转到保存成功的页面
        request.getRequestDispatcher("/userinfo.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
