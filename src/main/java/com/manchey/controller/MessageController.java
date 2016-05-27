package com.manchey.controller;

import com.manchey.utils.wechat.AuthUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 信息分发处理类
 * Created by Ray on 2016/5/27.
 */
@Controller
@RequestMapping("wechat")
public class MessageController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String auth(
            @RequestParam String signature,
            @RequestParam String timestamp,
            @RequestParam String nonce,
            @RequestParam String echostr) {

        return AuthUtil.auth(signature, timestamp, nonce, echostr);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void resMessage(HttpServletRequest request, HttpServletResponse response) {

        // 接受request流

        // 解析xml，封装成request vo对象

        // 处理业务逻辑，封装response vo对象

        // 序列化vo对象为xml

        // 返回xml
    }
}
