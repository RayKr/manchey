package com.manchey.utils.wechat;

import com.manchey.model.vo.wechat.message.request.ReqVideoMessage;
import com.manchey.model.vo.wechat.message.response.ResArticleMessage;
import com.manchey.model.vo.wechat.message.response.ResMusicMessage;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ray on 2016/5/27.
 */
public class MessageUtilTest extends TestCase {
    public void testTextMessageToXml() throws Exception {

        ResMusicMessage textMsg = new ResMusicMessage();
        textMsg.setToUserName("jzl");
        textMsg.setFromUserName("nut");
        textMsg.setCreateTime(32322434);
        textMsg.setMsgType("6");

        ResMusicMessage.Music music = new ResMusicMessage.Music();
        music.setTitle("米店");
        music.setDescription("好听");
        music.setHQmusicUrl("http://ddd");
        music.setMusicUrl("ffff");
        music.setThumbMediaId("343");

        textMsg.setMusic(music);

        String s1 = MessageUtil.convertToXML(textMsg);
        System.out.println(s1);

        ResArticleMessage articleMessage = new ResArticleMessage();
        articleMessage.setToUserName("jzl");
        articleMessage.setFromUserName("nut");
        articleMessage.setCreateTime(32322434);
        articleMessage.setMsgType("6");

        ResArticleMessage.Articles.Article article1 = new ResArticleMessage.Articles.Article();
        article1.setTitle("shaya");
        article1.setDescription("desc");
        article1.setUrl("url:ddd");
        article1.setPicUrl("picurl:ddddxcc");

        ResArticleMessage.Articles.Article article2 = new ResArticleMessage.Articles.Article();
        article2.setTitle("shaya");
        article2.setDescription("desc");
        article2.setUrl("url:ddd");
        article2.setPicUrl("picurl:ddddxcc");

        List<ResArticleMessage.Articles.Article> lst = new ArrayList<>();
        lst.add(article1);
        lst.add(article2);

        ResArticleMessage.Articles articles = new ResArticleMessage.Articles();
        articles.setItem(lst);

        articleMessage.setArticles(articles);
        articleMessage.setArticleCount("2");

        String s = MessageUtil.convertToXML(articleMessage);
        System.out.println(s);

    }

    public void testConvertToObject() {
        String xml = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>1357290913</CreateTime>\n" +
                "<MsgType><![CDATA[shortvideo]]></MsgType>\n" +
                "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n" +
                "<MsgId>1234567890123456</MsgId>\n" +
                "</xml>";

        ReqVideoMessage resArticleMessage = MessageUtil.convertToObject(ReqVideoMessage.class, xml);
        System.out.println(resArticleMessage.toString());

        Map<String, String> stringStringMap = MessageUtil.convertToMap(xml);
        System.out.println(stringStringMap);
    }

}