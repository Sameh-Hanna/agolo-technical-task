package Q02_Part01_XmlDeserialiser.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Q02_Part01_XmlDeserialiser.include.Website;

import java.io.IOException;
import java.util.List;

public class JsonConverter {
    public static String convertToJson(List<Website> websites) throws IOException {
        // Create an ObjectMapper and configure it for pretty printing
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convert the list of websites to JSON and return it as a string
        return mapper.writeValueAsString(websites);
    }
}
