package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTask {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    WebDriver driver;
    @BeforeClass
    public void BeforeClass () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }
    @Test
    public void FaceBook(){
        driver.navigate().to("https://www.facebook.com/");
    }

    @Test(dependsOnMethods ="FaceBook")
    public void Google(){
        driver.navigate().to("https://www.google.com/");
    }

    @Test(dependsOnMethods ="Google")
    public void Amazon(){
        driver.navigate().to("https://www.amazon.sa/");
    }

    @AfterClass
    public void afterclass() {
        //terminating the session
        driver.quit();
    }

}
