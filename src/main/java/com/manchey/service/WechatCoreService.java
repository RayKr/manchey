package com.manchey.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信消息处理
 * Created by Ray on 2016/5/28.
 */
public interface WechatCoreService {

    String processRequest(HttpServletRequest request);
}
