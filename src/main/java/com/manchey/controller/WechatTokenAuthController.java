package com.manchey.controller;

import com.manchey.utils.SHA1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by Ray on 2016/5/24.
 */
@Controller
public class WechatTokenAuthController {

    private static final String TOKEN = "manchey";

    @RequestMapping(value = "/tokenauth", method = RequestMethod.GET)
    public @ResponseBody
    String auth(
            @RequestParam String signature,
            @RequestParam String timestamp,
            @RequestParam String nonce,
            @RequestParam String echostr) {


        String[] str = { TOKEN, timestamp, nonce };

        Arrays.sort(str);

        String bigStr = str[0] + str[1] +str[2];

        String outStr = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
        System.out.println(outStr);

        if (outStr.equals(signature)) {
            return echostr;
        }

        return "no";
    }
}
