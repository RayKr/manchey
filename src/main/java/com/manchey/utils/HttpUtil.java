package com.manchey.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * http传输工具类
 * Created by Ray on 2016/5/31.
 */
public class HttpUtil {

    /**
     * 接受前端请求流，转换为字符串
     * @param request req
     * @return str
     * @throws IOException
     */
    public static String request(HttpServletRequest request) throws IOException {
        return StringUtil.convertStreamToString(request.getInputStream());
    }

    /**
     * 封装字符串为流返回给前端
     * @param response res
     * @param str str
     * @throws IOException
     */
    public static void response(HttpServletResponse response, String str) throws IOException {
        OutputStream os = response.getOutputStream();
        os.write(str.getBytes("UTF-8"));
        os.flush();
        os.close();
    }
}
