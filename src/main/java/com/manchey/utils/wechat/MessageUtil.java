package com.manchey.utils.wechat;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 信息处理工具类
 * Created by Ray on 2016/5/27.
 */
public class MessageUtil {

    private static final ThreadLocal<Map<Class<?>, Marshaller>> mMapLocal = new ThreadLocal<Map<Class<?>, Marshaller>>() {
        @Override
        protected Map<Class<?>, Marshaller> initialValue() {
            return new HashMap<>();
        }
    };

    private static final ThreadLocal<Map<Class<?>, Unmarshaller>> uMapLocal = new ThreadLocal<Map<Class<?>, Unmarshaller>>() {
        @Override
        protected Map<Class<?>, Unmarshaller> initialValue() {
            return new HashMap<>();
        }
    };

    public static <T> T convertToObject(Class<T> clazz, String xml) {
        return convertToObject(clazz, new StringReader(xml));
    }

    public static <T> T convertToObject(Class<T> clazz, InputStream inputStream) {
        return convertToObject(clazz, new InputStreamReader(inputStream));
    }

    public static <T> T convertToObject(Class<T> clazz, HttpServletRequest request) {
        try {
            return convertToObject(clazz, request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertToObject(Class<T> clazz, Reader reader) {
        try {
            Map<Class<?>, Unmarshaller> uMap = uMapLocal.get();
            if (!uMap.containsKey(clazz)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                uMap.put(clazz, unmarshaller);
            }
            return (T) uMap.get(clazz).unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object to XML
     *
     * @param object object
     * @return xml
     */
    public static String convertToXML(Object object) {
        try {
            Map<Class<?>, Marshaller> mMap = mMapLocal.get();
            if (!mMap.containsKey(object.getClass())) {
                JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                //去掉生成xml的默认报文头。
                marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
                marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                    public void escape(char[] ac, int i, int j, boolean flag, Writer writer) throws IOException {
                        writer.write(ac, i, j);
                    }
                });
                mMap.put(object.getClass(), marshaller);
            }
            StringWriter stringWriter = new StringWriter();
            mMap.get(object.getClass()).marshal(object, stringWriter);
            return stringWriter.getBuffer().toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
