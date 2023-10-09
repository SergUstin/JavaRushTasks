package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {

    private static String[] escapeSymbols = {"<", ">", "'", "\"", "&"};

    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        try {
            return addCommentToTag(convertObjectToXML(obj), tagName, comment);
        } catch (Exception ignored) {
            ignored.toString();
        }
        return null;
    }

    private static String addCommentToTag(String xml, String tagName, String comment) throws Exception {
        Document document = getDocument(xml);
        document.normalizeDocument();

        addCdataBlocks(document, document.getDocumentElement());
        addComments(tagName, comment, document);

        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.toString();
    }

    private static void addCdataBlocks(Document document, Node rootElement) {
        if (rootElement.hasChildNodes()) {
            NodeList childNodes = rootElement.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                addCdataBlocks(document, childNodes.item(i));
            }
        } else {
            String textContent = rootElement.getTextContent();
            if (containsEscapeSymbols(textContent)) {
                rootElement.setTextContent("");
                rootElement.getParentNode().appendChild(document.createCDATASection(textContent));
            }
        }
    }


    private static void addComments(String tagName, String comment, Document document) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Comment documentComment = document.createComment(comment);
            documentComment.normalize();
            Node item = nodeList.item(i);
            item.getParentNode().insertBefore(documentComment, item);
        }
    }

    private static Document getDocument(String xml) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
    }


    private static String convertObjectToXML(Object o) throws Exception {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(o.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(o, writer);
        return writer.toString();
    }

    private static boolean containsEscapeSymbols(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        } else {
            for (String character : escapeSymbols) {
                if (s.contains(character))
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        AnExample obj = new AnExample();
        System.out.println(toXmlWithComment(obj, "needCDATA", "comment"));
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        @XmlElement(name = "needCDATA", type = String.class)
        public String[] needCDATA = new String[]{"<needCDATA><![CDATA[need CDATA because of < <>& and >]]></needCDATA>", ""};

        public List<String> characters = new ArrayList<>();
    }

}
