package Q02_Part01_XmlDeserialiser.include;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;



public class Website {
    @JacksonXmlProperty(localName = "URL")
    private String url;
    @JacksonXmlProperty(localName = "Tile")
    private String title;
    @JacksonXmlProperty(localName = "Description")
    private String description;
    @JacksonXmlProperty(localName = "CreatedDate")
    private String createdDate;

    // Default constructor
    public Website() {
    }

    public Website(String url, String title, String description, String createdDate) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void print() {
        System.out.println("URL: " + getUrl());
        System.out.println("Title: " + getTitle());
        System.out.println("Description: " + getDescription());
        System.out.println("Created Date: " + getCreatedDate() + "\n");
    }

    public static List<Website> filterWebsitesByCreatedDate(List<Website> websites, Date filterCreatedDate) throws ParseException {
        List<Website> filteredWebsites = new ArrayList<>();

        // Iterate through the websites and filter those created after September 1
        for (Website website : websites) {
            Date createdDate = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse(website.getCreatedDate());
            if (createdDate.after(filterCreatedDate)) {
                filteredWebsites.add(website);
            }
        }

        return filteredWebsites;
    }

    public static void printWebsites(List<Website> websites) {
        // Iterate through the filtered websites and print information in the specified format
        for (int i = 0; i < websites.size(); i++) {
            Website website = websites.get(i);
            System.out.println("Website " + (i + 1) + ":");
            System.out.println("URL: " + website.getUrl());
            System.out.println("Title: " + website.getTitle());
            System.out.println("Description: " + website.getDescription());
            System.out.println("Created Date: " + website.getCreatedDate() + "\n");
        }
    }
}