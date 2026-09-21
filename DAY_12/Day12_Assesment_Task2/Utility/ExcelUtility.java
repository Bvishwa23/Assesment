package Day11_Assesment_Task2.Utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    public static String getData(
            int rowNumber,
            int columnNumber) throws IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/java/Day11_Assesment_Task2/Resc/Day12_Task2.xlsx"
                );

        Workbook workbook =
                WorkbookFactory.create(fis);

        Sheet sheet =
                workbook.getSheet("Sheet2");

        String data =
                sheet.getRow(rowNumber)
                        .getCell(columnNumber)
                        .toString();

        workbook.close();
        fis.close();

        return data;
    }
}