package TestNG;

import TestPackage.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class Task2Week6  extends TestBase {
    /*
   Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
   Add 10 notes using data provider with excel
   Run it with 3 different browsers using XML file
   Run it parallel with 3 threads
    */
    WebDriver driver;
    @Parameters({"target-browser"})
    @BeforeMethod
    public void before(@Optional("chrome") String browser){
        switch (browser){
            case"chrome" -> driver= new ChromeDriver();
            case"firefox" -> driver = new FirefoxDriver();
            case"safari"-> driver= new SafariDriver();
            case"edge"-> driver= new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] notesData() throws IOException, InvalidFormatException {
        File ExcelFile = new File("src/test/resources/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(ExcelFile));
        Object[][] data = null;
        try {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRows = 10;
            data = new Object[1][1];
            String[][] notes = new String[numRows][2];

            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                String cellValue1 = cell1.getStringCellValue();
                String cellValue2 = cell2.getStringCellValue();
                notes[i][0] = cellValue1;
                notes[i][1] = cellValue2;
            }
            data[0][0] = notes;
        } finally {
            workbook.close();
        }

        return data;
    }
    @Test(dataProvider ="notesData")
    public void DataTest(String[][] notesData){
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        By TitleField= By.id("note-title-input");
        By NoteField= By.id("note-details-input");
        By Button= By.id("add-note");
        for (String[] note :notesData) {
            bot.type(TitleField,note[0]);
            bot.type(NoteField,note[1]);
            bot.click(Button);
        }
    }
}