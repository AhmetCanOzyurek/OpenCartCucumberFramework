package Readers.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    String file;
    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet;

    @Test
    public void read1() throws IOException {
        file = "src/test/resources/datafiles/ExcelB.xlsx";
        fileInputStream = new FileInputStream(file);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0);

        int numRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < numRows; i++) {
            Row row = sheet.getRow(i);

            int numCells = row.getPhysicalNumberOfCells();

            for (int j = 0; j < numCells; j++) {
                Cell cell = row.getCell(j);
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void getRowValues() {
        file = "src/test/resources/datafiles/ExcelB.xlsx";
        System.out.println(getRowValuesOf(file, "person", 1));
    }

    @Test
    public void getColValues1() {
        file = "src/test/resources/datafiles/ExcelB.xlsx";

        List<String> col = getColValuesOf(file, "person", 3);
        col.forEach(System.out::println);
    }

    @Test
    public void patchDatas(){
        file = "src/test/resources/datafiles/ExcelB.xlsx";
        patchData(file, "person","ahmet can ozyurek");
    }
    public List<String> getRowValuesOf(String fileName, String page, int rowNumber) {
        try {
            fileInputStream = new FileInputStream(fileName);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(page);

            List<String> datas = new ArrayList<>();
            int lastRow = sheet.getPhysicalNumberOfRows();


            int index = Math.min(Math.max(0, rowNumber - 1), lastRow - 1);
            Row row = sheet.getRow(index);

            int numCells = row.getPhysicalNumberOfCells();

            for (int j = 0; j < numCells; j++) {
                Cell cell = row.getCell(j);
                datas.add(String.valueOf(cell));
            }

            return datas;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<String> getColValuesOf(String fileName, String page, int columnNum) {
        try {
            List<String> myList = new ArrayList<>();
            fileInputStream = new FileInputStream(fileName);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(page);
            int index = Math.max(0, columnNum - 1);
            int lastRow = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < lastRow; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(columnNum - 1);
                String val = cell == null ? "" : cell.toString();
                myList.add(val);
            }
            return myList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<String> getColValuesOfByName(String fileName, String page, String columnName) {
        try {
            List<String> myList = new ArrayList<>();
            fileInputStream = new FileInputStream(fileName);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.createSheet("sayfa1");

            int lastRow = sheet.getPhysicalNumberOfRows();

            Row row = sheet.getRow(0);
            int indexOfColumn = -1;
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                if (row.getCell(i).toString().equalsIgnoreCase(columnName)) {
                    indexOfColumn = i;
                    break;
                }
            }
            if (indexOfColumn < 0) {
                throw new RuntimeException("column not found");
            }
            for (int i = 0; i < lastRow; i++) {
                row = sheet.getRow(i);
                Cell cell = row.getCell(indexOfColumn);
                String val = cell == null ? "" : cell.toString();
                myList.add(val);
            }
            return myList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void patchData(String file, String page, String data){
        try {
            List<String> myList = new ArrayList<>();
            fileInputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(page);

            int lastRow = sheet.getPhysicalNumberOfRows();

            Row row = sheet.createRow(lastRow);

            List<String> datas = new ArrayList<>(List.of(data.split("\\W")));

            for (int i = 0; i < datas.size(); i++) {
                row.createCell(i).setCellValue(datas.get(i));
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}