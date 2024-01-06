package _tempTest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import static utils.Utils.*;
public class JsonReaderClass {
    public static void main(String[] args) throws FileNotFoundException {
        String jsonFile ="src/test/resources/datafiles/Elements.json";

        //json dosyasini ilk defa okuyoruz
        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));
//        System.out.println(object);

        //json icinde key okunur, value{} ler icinde ise bu da objectdir
        JSONObject myaccount  = (JSONObject) object.get("loginlink");


        String type = myaccount.get("type").toString();
        String locator = myaccount.get("locator").toString();
        System.out.println(getBy(type,locator));
    }
/*    public static By getBy(String type, String locator){
        switch (type.toLowerCase()){
            case "xpath" : return By.xpath(locator);
            case "css" : return By.cssSelector(locator);
            case "id" : return By.id(locator);
            case "class" : return By.id(locator);
            case "linktext" : return By.linkText(locator);
            case "partiallinktext" : return By.partialLinkText(locator);
            default : return null;
        }
    }*/
}
