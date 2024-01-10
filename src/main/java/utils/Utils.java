package utils;

import Readers.json.myJsonPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;

import java.io.*;

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

        switch (type.toLowerCase()) {
            case "xpath":
                return By.xpath(locator);
            case "css":
                return By.cssSelector(locator);
            case "id":
                return By.id(locator);
            case "class":
                return By.id(locator);
            case "linktext":
                return By.linkText(locator);
            case "partiallinktext":
                return By.partialLinkText(locator);
            default:
                return null;
        }
    }

    public static String getValue(String main, String key) {
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
     *
     * @param file okunacak json file
     * @param pojo parent'i myJsonPojo olan pojo class'i
     * @return Object olarak return eder, islem sirasinda sub class'a cast edilmeli
     */
    public static Object getPojo(String file, myJsonPojo pojo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new FileReader(file), pojo.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createFeatureFileFromExcel(String excelFile, String featureFile) {
        final String ENTER = "\n";
        try {
            FileWriter fileWriter = new FileWriter(featureFile);

            FileInputStream fileInputStream = new FileInputStream(excelFile);

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int rowNums = sheet.getPhysicalNumberOfRows();

            String featureLine = "Feature: " +sheet.getRow(1).getCell(0).toString();
            fileWriter.write( featureLine + ENTER);

            String scenarioLine =sheet.getRow(1).getCell(1).toString();
            scenarioLine += ":";
            scenarioLine += sheet.getRow(1).getCell(2).toString();

            fileWriter.write(scenarioLine+ENTER);

            for (int i = 1; i < rowNums; i++) {
                Cell cell = sheet.getRow(i).getCell(3);
                String str = cell == null ? "" : cell.toString();
                fileWriter.write(str + ENTER);
            }
            workbook.close();
            fileWriter.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
