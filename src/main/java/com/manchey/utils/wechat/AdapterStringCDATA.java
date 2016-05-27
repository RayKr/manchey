package com.manchey.utils.wechat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 添加CDATA标签的适配器
 * 处理String类型
 * Created by Ray on 2016/5/27.
 */
public class AdapterStringCDATA extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }
}
