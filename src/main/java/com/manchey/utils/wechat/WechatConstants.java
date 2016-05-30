package com.manchey.utils.wechat;

/**
 * 微信常量类
 * Created by Ray on 2016/5/27.
 */
public class WechatConstants {

    /**
     * TOKEN
     */
    public static final String TOKEN = "manchey";

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    public static final String MSG_TYPE_BIND = "绑定";

    public static final String MSG_TYPE_TARGET = "目标";

    public static final String EXCEPTION_DEFAULT = "您的输入有误！可使用如下格式：" +
            "”绑定:网通三区+天鹅坪+角色名“来绑定您的角色\n" +
            "”目标:网通三区+天鹅坪+角色名+自定义昵称“绑定您的悄悄话对象\n" +
            "”@目标角色名:输入您想说的话...“ 或 ”@自定义昵称:输入您想说的话...“\n" +
            "即可将您的悄悄话寄往月球，如果TA也同样关注此公众号，TA有可能看到哦~";

}
