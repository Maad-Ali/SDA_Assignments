package TestNG;

import TestPackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FourthTask extends TestBase {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    WebDriver driver;
    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
    @Test(dataProvider = "searchData")
    public void DataProviderTest(String input){

    By EmailField= By.id("input-email");
    By PassWord= By.id("input-password");
    By LoginButton=By.xpath("//input[@class='btn btn-primary']");

    driver.findElement(EmailField).sendKeys("clarusway@gmail.com");
    driver.findElement(PassWord).sendKeys("123456789");
    driver.findElement(LoginButton).submit();

    By SearchField= By.xpath("//input[@class='form-control input-lg']");
    driver.findElement(SearchField).sendKeys(input);
    
    }
}
