package Readers.excel;

import org.apache.hc.core5.http2.impl.nio.ServerH2PrefaceHandler;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReadWriteAppend {

    @Test
    public void readExcel() throws IOException {
        // okunacak excel dosyasi
        String file ="src/test/resources/datafiles/ExcelA.xlsx";

        //javanin dosyayi okumasi icin
        FileInputStream fileInputStream = new FileInputStream(file);

        // okunan dosya excel sayfasi olarak belirlendi
        Workbook  workbook = WorkbookFactory.create(fileInputStream);


        // okunacak sayfa belirlendi
        //Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet = workbook.getSheet("Sheet1");

        //sheet icindeki olusturulmus row sayisini verir
        int lastRow = sheet.getPhysicalNumberOfRows();

        // sheet icindeki row okunur
        Row row = sheet.getRow(0);

        //row icindeki hücre sayisini verir
        int lastCell = row.getPhysicalNumberOfCells();

        //row icindeki cell okunur
        Cell cell = row.getCell(0);
        System.out.println(cell);

        Cell cell1 = row.getCell(1);
        System.out.println(cell1);

        Cell cell2 = row.getCell(2);
        System.out.println(cell2);

        workbook.close();
    }

    @Test
    public void writeNewExcelFile() throws IOException {
        //ramde bir excel workbook olusturuldu
        XSSFWorkbook workbook = new XSSFWorkbook();//xlsx icin
        //HSSFWorkbook workbook1 = new HSSFWorkbook();//xls icin

        //workbook'da bir sheet acildi
        XSSFSheet sheet = workbook.createSheet("sayfam");

        // sheet icine ilk (index = 0) row olusturuldu
        Row row = sheet.createRow(0);

        //row icine ilk (index = 0) cell olusturuldu
        Cell cell = row.createCell(0);

        //cell'e deger atandi
        cell.setCellValue("GuiderSoft");

        //dosyanin yolunu ve xlsx uzantılı olarak adını tanımlar
        String file ="src/test/resources/datafiles/ExcelNew.xlsx";

        //olusturulan workbook'un diske java ile yazdirilmasi icin
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // apache poi, ramde olusturulan xlsx dosyasini java araciligi ile diske yazdirir
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
    } @Test
    public void writeNewExcelFile1() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sayfam");
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Adi");

        cell = row.createCell(1);
        cell.setCellValue(":");

        cell = row.createCell(2);
        cell.setCellValue("Ahmet");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Soyadi");
        row1.createCell(1).setCellValue(":");
        row1.createCell(2).setCellValue("Can");

        String file ="src/test/resources/datafiles/ExcelAdSoyad.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }

}
