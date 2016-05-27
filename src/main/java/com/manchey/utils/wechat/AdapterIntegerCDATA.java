package com.manchey.utils.wechat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 添加CDATA标签的适配器
 * 处理Integer类型
 * Created by Ray on 2016/5/27.
 */
public class AdapterIntegerCDATA extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(Integer v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }
}
