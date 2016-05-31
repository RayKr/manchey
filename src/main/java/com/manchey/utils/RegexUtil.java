package com.manchey.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * Created by Ray on 2016/5/31.
 */
public class RegexUtil {

    /**
     * 使用正则表达式验证字符串是否相同
     * @param regex 正则表达式
     * @param str 要验证的字符串
     * @return 布尔类型
     */
    public static boolean matches(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 将匹配的数据查询并返回
     * @param regex 正则表达式
     * @param str 要查询的字符串
     * @return list
     */
    public static List<String> find(String regex, String str) {
        List<String> lst = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(str);
        while (matcher.find()) {
            lst.add(matcher.group());
        }
        return lst;
    }
}
