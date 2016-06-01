package com.manchey.service.impl;

import com.manchey.exception.RoleInfoException;
import com.manchey.exception.SecretLoveException;
import com.manchey.model.vo.wechat.RoleInfo;
import com.manchey.model.vo.wechat.message.request.ReqTextMessage;
import com.manchey.service.MessageService;
import com.manchey.service.SecretLoveService;
import com.manchey.utils.RegexUtil;
import com.manchey.utils.wechat.WechatConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息处理服务类
 * Created by Ray on 2016/5/31.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private SecretLoveService secretLoveService;

    @Override
    public String processText(ReqTextMessage textMessage) throws SecretLoveException, RoleInfoException {

        // 验证消息头是否符合SecretLove格式
        String content = textMessage.getContent();

        // 取出信息格式头
        String msgHead = content.substring(0, 3);
        String msgBody = content.substring(3, content.length());

        String regexBind = WechatConstants.MSG_TYPE_BIND + "[:|：]";
        String regexTarget = WechatConstants.MSG_TYPE_TARGET + "[:|：]";
        String regexNick = "@[\\u4E00-\\u9FA5]*[:|：]";
        String regexBodyBind = "([\\u4E00-\\u9FA5]*(\\+|-| )?){3}";
        String regexBodyTarget = "([\\u4E00-\\u9FA5]*(\\+|-| )?){3}[\\u4E00-\\u9FA5]*";
        String regexBody = "[\\u4E00-\\u9FA5]+";

        if (RegexUtil.matches(regexBind, msgHead)) { // 绑定自己

            if (!RegexUtil.matches(regexBodyBind, msgBody)) { // 绑定匹配
                throw new RoleInfoException("请输入正确的大区、服务器名、角色名，用\"\\+\"或\"\\-\"或空格连接！");
            }

            List<String> list = RegexUtil.find(regexBody, msgBody);

            if (list.get(2).length() > 6) {
                throw new RoleInfoException("角色名长度不符合系统规定！");
            }

            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setWechatId(textMessage.getFromUserName());
            roleInfo.setRegionName(list.get(0));
            roleInfo.setServerName(list.get(1));
            roleInfo.setRoleName(list.get(2));

            // 调用绑定方法
            secretLoveService.bindMySelf(roleInfo);

            return "恭喜您，绑定成功！";

        } else if (RegexUtil.matches(regexTarget, msgHead)) { // 指定目标

            if (!RegexUtil.matches(regexBodyTarget, msgBody)) {
                throw new RoleInfoException("请输入正确的大区、服务器名、角色名、目标昵称（可选），用\"\\+\"或\"\\-\"或空格连接！");
            }

            List<String> list = RegexUtil.find(regexBody, msgBody);

            if (list.get(2).length() > 6) {
                throw new RoleInfoException("角色名长度不符合系统规定！");
            }

            RoleInfo roleInfo = new RoleInfo(list.get(0), list.get(1), list.get(2), list.get(3));

            secretLoveService.bindLover(roleInfo);

            return "恭喜您，绑定目标成功！";

        } else if (RegexUtil.matches(regexNick, msgHead)) { // 发送悄悄话

        } else { // 普通消息
            return content;
        }
        return "恭喜您，操作成功！";
    }

    @Override
    public void processVoice() {

    }
}
