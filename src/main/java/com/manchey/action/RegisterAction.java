package com.manchey.action;

import com.manchey.service.UserServiceI;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Ray on 2016/5/23.
 */
@Component
@Scope("prototype")
@Namespace("/test")
@ParentPackage("struts-default")
public class RegisterAction {
    private UserServiceI userService;
    private String name;
    private int age;

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Action(value = "register", results = @Result(location = "/userinfo.jsp"))
    public String execute() {
        userService.addUser(name, age);

//        Tuser user = userService.findUser(age);
//        System.out.println(user.toString());
        return "success";
    }
}
