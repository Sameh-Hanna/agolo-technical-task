package Q02_Part01_XmlDeserialiser.utils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
