package com.manchey.utils.wechat;

import com.manchey.model.vo.wechat.message.BaseMessage;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.List;
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
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(BaseMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }
//
//    /**
//     * 音乐消息对象转换成xml
//     *
//     * @param musicMessage 音乐消息对象
//     * @return xml
//     */
//    public static String musicMessageToXml(MusicMessage musicMessage) {
//        xstream.alias("xml", musicMessage.getClass());
//        return xstream.toXML(musicMessage);
//    }
//


    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}
