package com.manchey.controller;

import com.manchey.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ray on 2016/6/1.
 */
@Controller
public class MancheyController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String loginCheck(ModelMap map) {

        if (!loginService.checkLogin(request.getParameter("operno"), request.getParameter("password"))) {
            map.addAttribute("msg", "账号或密码错误，请重新输入");
            return "error";
        }

        return "home/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String loginCheck1(ModelMap map) {
        return "请登录后再操作！";
    }

}
