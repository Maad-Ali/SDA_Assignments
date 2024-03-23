package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task4Week6 {
    WebDriver driver;
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @BeforeClass
    public void BeforeClass(){
        driver=new ChromeDriver();
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    }
    @DataProvider(name = "searchData")
    public Object[][] dataProvider() {
        return new Object[][] {
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
    @Test(priority = 1)
    public void login() {
        By EmailField= By.id("input-email");
        By PassWord= By.id("input-password");
        By LoginButton=By.xpath("//input[@type='submit']");

        driver.findElement(EmailField).sendKeys("clarusway@gmail.com");
        driver.findElement(PassWord).sendKeys("123456789");
        driver.findElement(LoginButton).click();

    }

    @Test(priority = 2, dataProvider = "searchData")
    public void Search(String searchTerm) {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(searchTerm, Keys.ENTER);

    }

    @AfterClass
    public void After(){
        driver.quit();

    }


}
