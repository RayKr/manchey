package com.manchey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ray on 2016/5/24.
 */
@Controller
@RequestMapping("test2")
public class WelcomeController {

    @RequestMapping("hello")
    public String showWelcom(ModelMap model){
        model.addAttribute("title", "Hello World!");
        model.put("message", "This is my first spring mvc webapp");
        return "welcome";
    }
}
