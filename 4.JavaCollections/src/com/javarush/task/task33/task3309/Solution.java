package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        BufferedReader reader = new BufferedReader(new StringReader(writer.toString()));
        String line;
        StringBuilder result = new StringBuilder();
        boolean skipTags = false;
        while ((line = reader.readLine()) != null) {
            if ((line.trim().startsWith('<' + tagName + ' ') || line.trim().startsWith('<' + tagName + '>')) && !skipTags)
                result.append(line.substring(0, line.length() - line.trim().length()))
                        .append("<!--").append(comment).append("-->\n");
            if (line.contains("<![CDATA["))
                skipTags = true;
            if (line.contains("]]>"))
                skipTags = false;
            result.append(line).append('\n');
        }
        return result.toString();
    }


    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException {
        toXmlWithComment(new Solution.First(), "second", "comment");
    }



    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "fourth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }


    private static String documentToString(Document doc) {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transfObject;
        try {
            transfObject = tFactory.newTransformer();
            // здесь мы указываем, что хотим убрать XML declaration:
            // тег <?xml ... ?> и его содержимое
            transfObject.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "CDATA");
            StringWriter writer = new StringWriter();
            transfObject.transform(new DOMSource(doc), new StreamResult(writer));

            // возвращаем преобразованный  в строку XML Document
            return writer.getBuffer().toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return null;
    }
}
