package com.manchey.service;

import com.manchey.exception.RoleInfoException;
import com.manchey.exception.SecretLoveException;
import com.manchey.model.vo.wechat.message.request.ReqTextMessage;

/**
 * Created by Ray on 2016/5/31.
 */
public interface MessageService {

    String processText(ReqTextMessage textMessage) throws SecretLoveException, RoleInfoException;

    void processVoice();
}
