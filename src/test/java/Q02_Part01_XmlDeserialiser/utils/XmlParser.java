package Q02_Part01_XmlDeserialiser.utils;
import org.w3c.dom.*;

import Q02_Part01_XmlDeserialiser.include.Website;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class XmlParser {
    public static List<Website> parseXml(String filePath) throws Exception {
        List<Website> websites = new ArrayList<>();

        // Create DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file and obtain the root element
        Document document = builder.parse(new File(filePath));
        Element root = document.getDocumentElement();

        // Get all website nodes
        NodeList websiteNodes = root.getElementsByTagName("Website");

        // Iterate through each website node and create Website objects
        for (int i = 0; i < websiteNodes.getLength(); i++) {
            Node node = websiteNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element websiteElement = (Element) node;

                // Retrieve website information
                String url = websiteElement.getElementsByTagName("URL").item(0).getTextContent();
                String title = websiteElement.getElementsByTagName("Tile").item(0).getTextContent();
                String description = websiteElement.getElementsByTagName("Description").item(0).getTextContent();
                String createdDate = websiteElement.getElementsByTagName("CreatedDate").item(0).getTextContent();

                // Create a Website object and add it to the list
                websites.add(new Website(url, title, description, createdDate));
            }
        }

        return websites;
    }
}
