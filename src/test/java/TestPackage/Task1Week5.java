package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task1Week5  extends TestBase{

/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/

@Test
    public void DragAndDropTest(){

driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
//Drag and drop the BANK button to the Account section in DEBIT SIDE
    WebElement Bank = driver.findElement(By.id("credit2"));
    WebElement AccountSectionDS = driver.findElement(By.id("bank"));
    new Actions(driver).dragAndDrop(Bank,  AccountSectionDS).perform();
//Drag and drop the SALES button to the Account section in CREDIT SIDE
    WebElement Sales = driver.findElement(By.id("credit1"));
    WebElement AccountSectionCD = driver.findElement(By.id("loan"));
    new Actions(driver).dragAndDrop(Sales, AccountSectionCD).perform();
//Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    WebElement Button5000 = driver.findElement(By.id("fourth"));
    WebElement AmountSectionDS = driver.findElement(By.id("amt7"));
    new Actions(driver).dragAndDrop(Button5000, AmountSectionDS).perform();
//Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
    WebElement Button50002= driver.findElement(By.id("fourth"));
    WebElement AmountSectionCS = driver.findElement(By.id("amt8"));
    new Actions(driver).dragAndDrop(Button50002,AmountSectionCS).perform();
// Verify the visibility of Perfect text.
    By Perfect= By.xpath("//a[text()='Perfect!']");
    WebElement perfectText = driver.findElement(Perfect);
    boolean isPerfectTextVisible = perfectText.isDisplayed();
    System.out.println("Is Perfect text visible in the website? " + isPerfectTextVisible);

}


}
