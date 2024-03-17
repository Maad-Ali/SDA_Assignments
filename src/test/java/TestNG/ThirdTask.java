package TestNG;

import TestPackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ThirdTask extends TestBase {

/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
WebDriver driver;
@Test
    public void SoftAssertionsTests(){
    bot.navigate("https://practicetestautomation.com/practice-test-login/");
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.id("submit");

    bot.type(usernameInput ,"student");
    bot.type(passwordInput,"incorrectPassword" );
    bot.click(submitButton);

    By error = By.id("error");

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(driver.findElement(error).isDisplayed(), " error is not displayed!");
    softAssert.assertEquals(driver.findElement(error).getText(),"Your password is invalid!");
    softAssert.assertAll();


}






}
