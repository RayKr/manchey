package com.manchey.utils;

import java.io.*;

/**
 * 字符串转换工具类
 * Created by Ray on 2016/5/31.
 */
public class StringUtil {

    /**
     * InputSteam-->String
     *
     * @param is InputStream
     * @return String
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8 * 1024);

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            sb.delete(0, sb.length());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                return null;
            }
        }

        return sb.toString();
    }

    /**
     * Reader -> String
     *
     * @param reader Reader
     * @return String
     * @throws IOException
     */
    public static String covertToString(Reader reader) {
        BufferedReader r = new BufferedReader(reader);
        StringBuilder b = new StringBuilder();
        String line;
        try {
            while ((line = r.readLine()) != null) {
                b.append(line);
                b.append("\r\n");
            }
        } catch (IOException e) {
            b.delete(0, b.length());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                return null;
            }
        }
        return b.toString();
    }

    /**
     * String -> InputStream
     *
     * @param str String
     * @return InputStream
     * @throws IOException
     */
    public static InputStream covertToInputStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

}
