package com.manchey.controller;

import com.manchey.service.CoreService;
import com.manchey.utils.wechat.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信信息分发处理类
 * Created by Ray on 2016/5/27.
 */
@Controller
@RequestMapping("wechat")
public class WechatController {

    @Autowired
    private CoreService coreService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String auth(
            @RequestParam String signature,
            @RequestParam String timestamp,
            @RequestParam String nonce,
            @RequestParam String echostr) {

        return AuthUtil.auth(signature, timestamp, nonce, echostr);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String resMessage(HttpServletRequest request) throws Exception {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");

        String resStr = coreService.processRequest(request);

        return resStr;
    }
}
