package com.manchey.service.impl;

import com.manchey.exception.RoleInfoException;
import com.manchey.exception.SecretLoveException;
import com.manchey.model.vo.wechat.message.request.ReqTextMessage;
import com.manchey.model.vo.wechat.message.response.ResTextMessage;
import com.manchey.service.WechatCoreService;
import com.manchey.utils.wechat.MessageUtil;
import com.manchey.utils.wechat.WechatConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by Ray on 2016/5/28.
 */
@Service("coreService")
public class WechatCoreServiceImpl implements WechatCoreService {

    private static Logger logger = LogManager.getLogger(WechatCoreServiceImpl.class);

    // 默认返回的文本消息内容
    private String respContent = "请求处理异常，请稍候尝试！";

    @Autowired
    private MessageServiceImpl messageService;

    @Override
    public String processRequest(String xml) {
        System.out.println(xml);
        Map<String, String> map = MessageUtil.convertToMap(xml);
        String msgType = map.get("MsgType");

        if (WechatConstants.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {
            // x->o
            ReqTextMessage textMessage = MessageUtil.convertToObject(ReqTextMessage.class, xml);

            try {
                respContent = messageService.processText(textMessage);
            } catch (SecretLoveException e) {
                respContent = e.getMessage();
            } catch (RoleInfoException e) {
                respContent = e.getMessage();
            }
        }

        // 封装返回值
        ResTextMessage resTextMessage = new ResTextMessage();
        resTextMessage.setToUserName(map.get("FromUserName"));
        resTextMessage.setFromUserName(map.get("ToUserName"));
        resTextMessage.setCreateTime(new Date().getTime());
        resTextMessage.setMsgType(WechatConstants.REQ_MESSAGE_TYPE_TEXT);
        resTextMessage.setContent(respContent);

        return MessageUtil.convertToXML(resTextMessage);
    }

}
