package com.manchey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ray on 2016/5/24.
 */
@Controller
@RequestMapping("test2")
public class WelcomeController {

    @RequestMapping("hello")
    public String showWelcom(ModelMap model){
        model.addAttribute("title", "Hello World!");
        model.addAttribute("message", "This is my first spring mvc webapp");
        return "welcome";
    }

    @RequestMapping(value = "{name}/{age}", method = RequestMethod.GET)
    public String getName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") String age) {

        map.addAttribute("name", name);
        map.addAttribute("age", age);

        return "showinfo";
    }

    @RequestMapping(value = "result", method = RequestMethod.GET)
    public String result(ModelMap map, @RequestParam String name, @RequestParam int age) {

        map.addAttribute("name", name);
        map.addAttribute("age", age);

        return "result";
    }
}
