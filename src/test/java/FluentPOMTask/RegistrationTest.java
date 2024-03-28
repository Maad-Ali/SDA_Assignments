package FluentPOMTask;

import TestPackage.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test(description = "Successful Login")
    public void loginTest1(){
        WebDriver driver = new ChromeDriver();
        String actualText = new RegistrationPage(driver,bot).goTo().Register("Maad","Almubarak", "maad.ali299@gmail.com","123456789","MaadPass123","MaadPass123").readMessage();
        Assert.assertEquals(actualText, "Your Account Has Been Created!");
    }




}
