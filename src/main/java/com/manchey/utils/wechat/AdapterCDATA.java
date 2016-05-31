package com.manchey.utils.wechat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 添加CDATA标签的适配器
 * 处理String类型
 * Created by Ray on 2016/5/27.
 */
public class AdapterCDATA extends XmlAdapter<String, Object> {

    @Override
    public Object unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(Object v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }
}
