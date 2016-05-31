package com.manchey.utils.wechat;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    /**
     * 转换简单的xml to map
     *
     * @param xml xml
     * @return map
     */
    public static Map<String, String> convertToMap(String xml) {
        Map<String, String> map = new LinkedHashMap<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            if (root != null) {
                NodeList childNodes = root.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node node = childNodes.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            map.put(node.getNodeName(), node.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 转换简单的xml to map
     *
     * @param inputStream is
     * @return map
     */
    public static Map<String, String> convertToMap(InputStream inputStream) {
        Map<String, String> map = new LinkedHashMap<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(inputStream);

            Element root = document.getDocumentElement();
            if (root != null) {
                NodeList childNodes = root.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node node = childNodes.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            map.put(node.getNodeName(), node.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
