package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class Task2Week5  extends TestBase {
    //( This task should be managed with keyboard actions )
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object

@Test
    public void KeyboardActionTest(){
    // go to https://www.google.com/
driver.navigate().to("https://www.google.com/");
// search for "Scroll Methods" by using an Actions object
    By SearchField=By.name("q");
    WebElement SearchBar = driver.findElement(SearchField);
    Actions actions = new Actions(driver);
    actions.moveToElement(SearchBar).click().perform();
    actions.sendKeys("Scroll Methods").sendKeys(Keys.ENTER).perform();

}

}
