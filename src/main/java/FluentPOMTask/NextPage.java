package FluentPOMTask;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NextPage {
    private final WebDriver driver;
    private final ActionsBot bot;

    private final By MessageLabel = By.xpath("//h1[@class='page-title my-3'");


    public String readMessage(){
        return bot.getText(MessageLabel);
    }

    public NextPage(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }
}
