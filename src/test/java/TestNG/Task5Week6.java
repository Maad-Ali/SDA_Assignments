package TestNG;

import TestPackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5Week6 extends TestBase {

//Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 3.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.

    @Test
    public void checkingBoxTest(){
        WebDriver driver;
        driver= new ChromeDriver();
        bot.navigate("http://crossbrowsertesting.github.io/");
        By ToDo=By.linkText("To-Do App");
        bot.click(ToDo);

        By Box4=By.name("todo-4");
        By Box5=By.name("todo-5");
        bot.click(Box4);
        bot.click(Box5);

        Assert.assertEquals("3 of 5 remaining", bot.getText(By.xpath("//span[@class='ng-binding']")));
        By archive= By.linkText("archive");
        bot.click(archive);

        Assert.assertEquals(3,driver.findElements(By.tagName("li")).size());

        By Text=By.id("todotext");
        bot.type(Text,"Do your Homework");
        By addButton=By.id("addbutton");
        bot.click(addButton);
        bot.click(archive);
        Assert.assertEquals(4, driver.findElements(By.tagName("li")).size());

    }


}
