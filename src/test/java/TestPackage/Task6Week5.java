package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Task6Week5 extends TestBase{
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any specific WebElement ScreenShot

    @Test
    public void ScreenshotTest(){
driver.navigate().to("https://www.amazon.sa/");

// Take Full Page Screenshot.
File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
try {
            File FileDestination = new File("full_page_screenshot.png");
            ImageIO.write(ImageIO.read(fullPageScreenshot), "png", FileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Take any specific WebElement ScreenShot
WebElement BackToTopBar = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
File elementScreenshot = ((TakesScreenshot) BackToTopBar).getScreenshotAs(OutputType.FILE);
        try {
            File FileDestination = new File("element_screenshot.png");
            ImageIO.write(ImageIO.read(elementScreenshot), "png", FileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
