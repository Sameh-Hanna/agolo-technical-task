package Q02_Part01_XmlDeserialiser.utils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;

import org.w3c.dom.Document;
import java.io.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils {
    public static String readXmlFile(String filePath) throws IOException {
        StringBuilder xmlContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line);
            }
        }
        return xmlContent.toString();
    }

    public static JSONObject convertXmlToJson(String xmlContent) throws JSONException {
        return XML.toJSONObject(xmlContent);
    }

    public static void addAttribute(String filePath, String elementName, String elementValue, String updatedFilePath) throws IOException {
        try {
            // Create a document builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file into a document
            Document document = builder.parse(new File(filePath));

            // Get the root element of the document
            Element rootElement = document.getDocumentElement();

            // Get a NodeList of all <Website> elements
            NodeList websiteList = rootElement.getElementsByTagName("Website");

            // Iterate through each <Website> element
            for (int i = 0; i < websiteList.getLength(); i++) {
                // Access the item at index i
                Node websiteNode = websiteList.item(i);
                if (websiteNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element websiteElement = (Element) websiteNode;
                    
                    // Create new <Category> and <Owner> elements
                    Element newElement = document.createElement(elementName);
                    newElement.setTextContent(elementValue);

                    websiteElement.appendChild(newElement);
                }
            }

            // Save the modified document back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = (Transformer) transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(updatedFilePath));
            transformer.transform(source, result);
        }
        catch(Exception e) {}
    }
}
