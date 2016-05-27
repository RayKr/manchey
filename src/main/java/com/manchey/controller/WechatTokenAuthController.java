package com.manchey.controller;

import com.manchey.utils.wechat.AuthUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ray on 2016/5/24.
 */
@Controller
public class WechatTokenAuthController {

    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public @ResponseBody String auth(
            @RequestParam String signature,
            @RequestParam String timestamp,
            @RequestParam String nonce,
            @RequestParam String echostr) {

        return AuthUtil.auth(signature, timestamp, nonce, echostr);
    }
}
