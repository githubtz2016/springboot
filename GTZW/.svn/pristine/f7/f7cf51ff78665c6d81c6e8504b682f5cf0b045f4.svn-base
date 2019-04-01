package com.ztesoft.rail.utils;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {
    private XmlUtil() {
    }

    public static <T> T xml2Object(String xmlStr, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));
            return t;
        } catch (JAXBException var5) {
            System.out.println("xml 转换  Object 失败");
            var5.printStackTrace();
            return null;
        }
    }

    public static String object2Xml(Object object) {
        try {
            StringWriter writer = new StringWriter ();
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshal = context.createMarshaller();
            // 格式化输出
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // 编码格式,默认为utf-8
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 是否省略xml头信息
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshal.setProperty("jaxb.encoding", "utf-8");
            marshal.marshal(object, writer);
            return new String(writer.getBuffer());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Object 转换  xml 失败");
            return null;
        }
    }
}
