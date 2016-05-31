package com.manchey.controller;

import com.manchey.service.WechatCoreService;
import com.manchey.utils.HttpUtil;
import com.manchey.utils.wechat.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * 微信信息分发处理类
 * Created by Ray on 2016/5/27.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WechatCoreService coreService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String auth(
            @RequestParam String signature,
            @RequestParam String timestamp,
            @RequestParam String nonce,
            @RequestParam String echostr) {

        return AuthUtil.auth(signature, timestamp, nonce, echostr);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void resMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");

        String xml = HttpUtil.request(request);

        String resStr = coreService.processRequest(xml);

        OutputStream os = response.getOutputStream();
        os.write(resStr.getBytes("UTF-8"));
        os.flush();
        os.close();

    }
}
