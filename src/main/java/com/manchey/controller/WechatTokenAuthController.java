package com.manchey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ray on 2016/5/24.
 */
@Controller
@RequestMapping("/")
public class WechatTokenAuthController {

    private final String token = "manchey";

    @RequestMapping(value = "tokenauth", method = RequestMethod.GET)
    public String auth(ModelMap map,
                       @RequestParam String signature,
                       @RequestParam String timestamp,
                       @RequestParam String nonce,
                       @RequestParam String echostr) {

        List<String> list = new ArrayList<String>();
        list.add(token);
        list.add(timestamp);
        list.add(nonce);

        Collections.sort(list);

        String lstr = "";
        for (String str :
                list) {
            lstr += str;
        }

        String outStr = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(lstr.getBytes());
            outStr = digest.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (outStr.equals(signature)) {
            map.addAttribute("message", echostr);
        } else {
            map.addAttribute("message", echostr);
        }

        return "tokenauth";
    }
}
