package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task3Week5 extends TestBase {
    /*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/

   @Test
   public void AmazonTest() throws AWTException {
       driver.navigate().to("https://www.amazon.sa/");
// Scroll to the bottom of the page using a robot
       Robot robot=new Robot();
       robot.keyPress(KeyEvent.VK_PAGE_DOWN);
       robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
       robot.delay(6000);
 //  Click on the "Back to top" web element
       WebElement BackToTop = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
       BackToTop.click();
//Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
       JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement AmazonLogo = driver.findElement(By.xpath("//span[@class='nav-logo-base nav-sprite']"));
       js.executeScript("arguments[0].click();", AmazonLogo);

//Use Actions to type "ClarusWay" in the search box and perform the search
       WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
       Actions actions = new Actions(driver);
       actions.sendKeys(searchBox, "ClarusWay").sendKeys(Keys.RETURN).perform();

   }
}
