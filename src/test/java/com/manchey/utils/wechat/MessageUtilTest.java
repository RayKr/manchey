package com.manchey.utils.wechat;

import com.manchey.model.vo.wechat.message.request.ReqVideoMessage;
import com.manchey.model.vo.wechat.message.request.ReqVoiceMessage;
import junit.framework.TestCase;

/**
 * Created by Ray on 2016/5/27.
 */
public class MessageUtilTest extends TestCase {
    public void testTextMessageToXml() throws Exception {

        ReqVoiceMessage textMsg = new ReqVoiceMessage();
        textMsg.setToUserName("jzl");
        textMsg.setFromUserName("nut");
        textMsg.setCreateTime(32322434);
        textMsg.setMsgType("6");
        textMsg.setMsgId(7878765);
        textMsg.setMediaId("43434343");
        textMsg.setFormat("的方式");
        textMsg.setRecognition("nutk");

        String s = MessageUtil.textMessageToXml(textMsg);
        System.out.println(s);

        String s1 = MessageUtil.convertToXML(textMsg);
        System.out.println(s1);
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
    }

}