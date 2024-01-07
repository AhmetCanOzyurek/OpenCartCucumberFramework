package utils;

import Readers.json.myJsonPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static By getBy(String main, String sub) {
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = null;
        try {
            object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JSONObject mainNode = (JSONObject) object.get(main);
        JSONObject subNode = (JSONObject) mainNode.get(sub);


        String type = subNode.get("type").toString();
        String locator = subNode.get("locator").toString();

        switch (type.toLowerCase()){
            case "xpath" : return By.xpath(locator);
            case "css" : return By.cssSelector(locator);
            case "id" : return By.id(locator);
            case "class" : return By.id(locator);
            case "linktext" : return By.linkText(locator);
            case "partiallinktext" : return By.partialLinkText(locator);
            default : return null;
        }
    }
    public static String getValue(String main, String key){
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = null;
        try {
            object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JSONObject mainNode = (JSONObject) object.get(main);
        return mainNode.get(key).toString();
    }

    /**
     * bu method okunacak .json dosyasini pojo.class'a map eder
     * @param file okunacak json file
     * @param pojo parent'i myJsonPojo olan pojo class'i
     * @return Object olarak return eder, islem sirasinda sub class'a cast edilmeli
     */
    public static Object getPojo(String file, myJsonPojo pojo){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new FileReader(file),pojo.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
