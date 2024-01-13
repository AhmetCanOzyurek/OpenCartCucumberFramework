package diger._tempTest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import stepDefs.BaseSteps;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static utils.Utils.*;

public class JSONelementTest extends BaseSteps {

    @Test
    public void test1(){
        driver.get(getValue("application", "url"));
        click(getBy("topmenu","myaccount"));
        click(getBy("topmenu","loginlink"));
        sendKeys(getBy("login","username"), getValue("application","username"));
        sendKeys(getBy("login","password"),getValue("application","password"));
        click(getBy("login","submitbutton"));
        waitForVisibility(getBy("account","sitemapaccount"));
    }




 public By getBy(String main, String sub) {
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
/*    public static String getValue(String main, String key){
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = null;
        try {
            object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JSONObject mainNode = (JSONObject) object.get(main);
        return mainNode.get(key).toString();
    }*/
}
