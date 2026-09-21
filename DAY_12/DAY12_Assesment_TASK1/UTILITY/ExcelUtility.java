package DAY11_Assesment.UTILITY;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    public static String getData(
            int rowNumber,
            int columnNumber) throws IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/java/DAY11_Assesment/Resc/Day12.xlsx"
                );

        Workbook workbook =
                WorkbookFactory.create(fis);

        Sheet sheet =
                workbook.getSheetAt(0);

        DataFormatter formatter =
                new DataFormatter();

        String data =
                formatter.formatCellValue(
                        sheet.getRow(rowNumber)
                                .getCell(columnNumber)
                );

        workbook.close();

        fis.close();

        return data;
    }
}