package com.manchey.service.impl;

import com.manchey.exception.RoleInfoException;
import com.manchey.exception.SecretLoveException;
import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.model.vo.wechat.message.request.ReqTextMessage;
import com.manchey.model.vo.wechat.message.response.ResTextMessage;
import com.manchey.service.SecretLoveService;
import com.manchey.service.WechatCoreService;
import com.manchey.utils.wechat.MessageUtil;
import com.manchey.utils.wechat.WechatConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    private String resXml;

    @Autowired
    private SecretLoveService secretLoveService;

    @Override
    public String processRequest(HttpServletRequest request) {

        try {
            Map<String, String> map = MessageUtil.convertToMap(request.getInputStream().toString());
            String msgType = map.get("msgType");

            return doBuss(request, msgType);

        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }

        return null;
    }

    private String doBuss(HttpServletRequest request, String msgType) {
        ReqTextMessage textMessage = null;

        if (WechatConstants.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {

            try {
                // x->o
                textMessage = MessageUtil.convertToObject(ReqTextMessage.class, request);

                // 验证消息头是否符合SecretLove格式
                String content = textMessage.getContent();
                // 以中/英文形式的冒号分割字符串
                String[] msgA = content.split(":");
                if (msgA.length < 1) {
                    msgA = content.split("：");
                }
                if (msgA.length < 1) {
                    throw new SecretLoveException(WechatConstants.EXCEPTION_DEFAULT);
                }
                // 获取头信息
                if (WechatConstants.MSG_TYPE_BIND.equals(msgA[0])) {
                    String[] roleStr = msgA[1].split("\\+");
                    if (roleStr.length != 2) {
                        throw new SecretLoveException("请输入正确的大区、服务器名、角色名，用\"\\+\"连接！");
                    }
                    RoleInfo roleInfo = new RoleInfo(roleStr[0], roleStr[1], roleStr[2]);

                    // 调用绑定方法
                    secretLoveService.bindMySelf(roleInfo);

                    respContent = "恭喜侠士，绑定成功！";
                } else if (WechatConstants.MSG_TYPE_TARGET.equals(msgA[0])) {

                } else {
                    throw new SecretLoveException("格式输入有误，请重新输入！");
                }

            } catch (RoleInfoException e) {
                e.printStackTrace();
                respContent = e.getMessage();
            } catch (SecretLoveException e) {
                e.printStackTrace();
                respContent = e.getMessage();
            }
        }

        // o->x
        ResTextMessage resTextMessage = new ResTextMessage();
        resTextMessage.setToUserName(textMessage.getFromUserName());
        resTextMessage.setFromUserName(textMessage.getToUserName());
        resTextMessage.setCreateTime(new Date().getTime());
        resTextMessage.setMsgType(textMessage.getMsgType());
        resTextMessage.setContent(respContent);

        return MessageUtil.convertToXML(resTextMessage);

    }
}
