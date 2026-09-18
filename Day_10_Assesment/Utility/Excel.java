package Day_10_Assesment.Utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    public static String getData(int row, int cell) throws IOException {

        FileInputStream excel = new FileInputStream(
                "src/test/java/Day_10_Assesment/Resc/Day10.xlsx"
        );

        Workbook wb = WorkbookFactory.create(excel);

        DataFormatter df = new DataFormatter();

        String data = df.formatCellValue(
                wb.getSheet("Sheet1")
                        .getRow(row)
                        .getCell(cell)
        );

        wb.close();
        excel.close();

        return data;
    }
}