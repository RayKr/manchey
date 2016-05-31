package com.manchey.utils;

import com.manchey.utils.wechat.WechatConstants;
import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ray on 2016/5/30.
 */
public class HttpClientTest extends TestCase {
    public void testSendGet() throws Exception {
        String url = "http://localhost:8080/wechat";
        String param = "signature=fsadasdf&timestamp=231213&nonce=jsadf&echostr=asdfdsaf983";
        System.out.println(HttpClient.sendGet(url, param));
    }

    public void testSendPost() throws Exception {
        String url = "http://localhost:8080/wechat";
        String param = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[绑定：网通三区+天鹅坪+阿拉丁]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        System.out.println(HttpClient.sendPost(url, param));
    }

    public void testRegex() {
        String regexHead = WechatConstants.MSG_TYPE_BIND + "[:|：]([\\u4E00-\\u9FA5]*(\\+|-| )?){3}";
        Pattern patternHead = Pattern.compile(regexHead);
        Matcher matcher =patternHead.matcher("绑定：网通三区 天鹅坪 萧墨衣纳斯达克看 的");
        boolean matches = matcher.matches();
        System.out.println(matches);

        String regexNick = "@[\\u4E00-\\u9Fa5]*[:|：]";
        patternHead = Pattern.compile(regexNick);
        Matcher matcher1 = patternHead.matcher("@萧牡蛎：");
        System.out.println(matcher1.matches());
    }

}