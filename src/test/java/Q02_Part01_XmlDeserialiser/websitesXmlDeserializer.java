package Q02_Part01_XmlDeserialiser ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import Q02_Part01_XmlDeserialiser.include.Website;
import Q02_Part01_XmlDeserialiser.utils.XmlUtils;


public class websitesXmlDeserializer {

    public static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static void main(String[] args) {
        // Specify the relative path to the XML file
        String xmlFilePath = "src/test/java/Q02_Part01_XmlDeserialiser/xml_file/websites.xml";
        String updatedXmlFilePath = "src/test/java/Q02_Part01_XmlDeserialiser/xml_file/updated_websites.xml";

        try {
            XmlMapper xmlMapper = new XmlMapper();  

            // Read the XML file
            String xmlContent = XmlUtils.readXmlFile(xmlFilePath);

            // Deserialize the xml content
            List<Website> websites = xmlMapper.readValue(xmlContent, xmlMapper.getTypeFactory().constructCollectionType(List.class, Website.class));

            // Print deserilised website objects
            System.out.println("Deserilised Websites xml list:");
            for (int i = 0; i < websites.size(); i++) {
                Website website = websites.get(i);
                System.out.println("Website " + (i + 1) + ":");
                website.print();
            }
            System.out.println();

            // Add new attributes to XML file
            XmlUtils.addAttribute(xmlFilePath, "Category", "default_category", updatedXmlFilePath);
            XmlUtils.addAttribute(updatedXmlFilePath, "Owner", "default_owner", updatedXmlFilePath);

            // Read the updated XML file
            String updatedXmlContent = XmlUtils.readXmlFile(updatedXmlFilePath);
            
            // Print XML after adding the new attributes (Owner & Category)
            System.out.println("XML file Content with the new added attributes (Owner & Category):");
            System.out.println(updatedXmlContent);
            System.out.println();

            // Convert XML content to JSON
            JSONObject jsonObj = XmlUtils.convertXmlToJson(updatedXmlContent);
            String jsonPrettyPrintString = jsonObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            
            // Print Websites JSON object
            System.out.println("Print converted XML to JSON:");
            System.out.println(jsonPrettyPrintString);
            System.out.println();

            // Filter websites created after September 1
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date filterCreatedDate = dateFormat.parse("09/01/2019");
            
            List<Website> filteredWebsites = Website.filterWebsitesByCreatedDate(websites, filterCreatedDate);

            // Print the filtered websites' information
            System.out.println("Print filtered Websites list:");
            Website.printWebsites(filteredWebsites);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
