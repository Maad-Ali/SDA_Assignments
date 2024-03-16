package TestPackage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task5Week5 extends TestBase {
    //Store the path of the file as string and open the file.
    //Open the workbook.
    //Open the first worksheet.
    //Go to the first row.
    //Create a cell on the 3rd column (2nd index) on the first row.
    //Write “POPULATION” on that cell.
    //Create a cell on the 2nd row 3rd cell(index2), and write data.
    //Create a cell on the 3rd row 3rd cell(index2), and write data.
    //Create a cell on the 4th row 3rd cell(index2), and write data.
    //Write and save the workbook.
    //Close the file.
    //Close the workbook.

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data
    @Test
    public void FileTest() throws IOException {
        //Store the path of the file as string and open the file.
        String FilePath = "C:\\excelfile.xlsx";
        FileInputStream File= new FileInputStream(FilePath);
        //Open the workbook.
        XSSFWorkbook Workbook= new XSSFWorkbook(File);

        try {
            //Open the first worksheet.
            XSSFSheet sheet = Workbook.getSheetAt(0);
            //Go to the first row.
            Row FirstRow= sheet.getRow(0);

            Row RowNum1=sheet.createRow(0);
            //Create a cell on the 3rd column (2nd index) on the first row.
            Cell cell1 = RowNum1.createCell(2);
            //Write “POPULATION” on that cell.
            cell1.setCellValue("POPULATION");

            //Create a cell on the 2nd row 3rd cell(index2), and write data.
            Row RowNum2=sheet.createRow(1);
            Cell cell2 = RowNum2.createCell(2);
            cell2.setCellValue("Data");

            //Create a cell on the 3rd row 3rd cell(index2), and write data.
            Row RowNum3=sheet.createRow(2);
            Cell cell3 = RowNum2.createCell(2);
            cell3.setCellValue("Data");

            //Create a cell on the 4th row 3rd cell(index2), and write data.
            Row RowNum4=sheet.createRow(3);
            Cell cell4 = RowNum2.createCell(2);
            cell4.setCellValue("Data");

            //Write and save the workbook.
            FileOutputStream outputStream = new FileOutputStream("C:\\excelfile.xlsx");
            Workbook.write(outputStream);
            outputStream.close();

            //Close the file.
            File.close();
            //Close the workbook.
            Workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }


