package com.manchey.utils.wechat;

import com.manchey.utils.SHA1;

import java.util.Arrays;

/**
 * 微信验证类
 * Created by Ray on 2016/5/27.
 */
public class AuthUtil {

    public static String auth(String signature, String timestamp, String nonce, String echostr) {

        String[] str = { WechatConstants.TOKEN, timestamp, nonce };

        // 1. 字典排序
        Arrays.sort(str);

        // 2. 连接字符串后，SHA1加密
        String bigStr = str[0] + str[1] +str[2];
        String outStr = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

        // 3. 加密后的字符串与signature对比
        if (outStr.equals(signature)) {
            return echostr;
        }
        return "Auth Failure.";
    }
}
