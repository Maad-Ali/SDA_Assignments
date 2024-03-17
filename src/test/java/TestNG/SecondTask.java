package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class SecondTask  {
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

    @DataProvider(name = "notesData")
    public Object[][] notesDataProvider() {
        return new Object[][] {
                {"Title1", "Note 1"},
                {"Title2", "Note 2"},
                {"Title3", "Note 3"},
                {"Title4", "Note 4"},
                {"Title5", "Note 5"},
                {"Title6", "Note 6"},
                {"Title7", "Note 7"},
                {"Title8", "Note 8"},
                {"Title9", "Note 9"},
                {"Title10", "Note 10"},
        };
    }

    @Test(dataProvider = "notesData")
    public void DataTest(String title, String note){
        driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        By TitleField= By.id("note-title-input");
        By NoteField= By.id("note-details-input");
        By Button= By.id("add-note");

        driver.findElement(TitleField).sendKeys(title);
        driver.findElement(NoteField).sendKeys(note);
        driver.findElement(Button).click();


    }

    @AfterMethod
    public void after(){
        driver.quit();
    }


}