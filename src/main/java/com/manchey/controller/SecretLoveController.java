package com.manchey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 密语系统控制层
 * Created by Ray on 2016/6/8.
 */
@Controller
public class SecretLoveController {


    @RequestMapping(value = "/serverManager", method = RequestMethod.GET)
    public String actionServerManager() {

        return "serverManager";
    }


}
