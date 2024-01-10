package _tempTest;

import utils.Utils;

public class ExcelToFeature {
    public static void main(String[] args) {
        String fileExcel = "src/test/resources/datafiles/testCase.xlsx";
        String fileFeature = "src/test/resources/features/testCaseFromExcel.feature";


        Utils.createFeatureFileFromExcel(fileExcel,fileFeature);
    }
}
