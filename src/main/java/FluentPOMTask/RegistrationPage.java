package FluentPOMTask;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final ActionsBot bot;
    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By FirstNameTextArea = By.id("input-firstname");
    private final By LastNameTextArea = By.id("input-lastname");
    private final By EmailTextArea = By.id("input-email");
    private final By TelephoneTextArea = By.id("input-telephone");

    private final By PasswordTextArea = By.id("input-password");

    private final By PasswordConfirmTextArea = By.id("input-confirm");
    private final By radioButton = By.id("input-newsletter-yes");

    private final By Policy = By.id("input-agree");
    private final By ContinueButton = By.xpath("//input[@type='submit']");

    public RegistrationPage(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }


    public RegistrationPage goTo(){
        bot.navigate(url);
        return this;
    }


    public NextPage Register(String FirstName, String LastName,String Email, String Telephone ,String Password, String CPassword){
        bot.type(FirstNameTextArea, FirstName);
        bot.type(LastNameTextArea, LastName);
        bot.type(EmailTextArea,Email);
        bot.type(TelephoneTextArea, Telephone);
        bot.type( PasswordTextArea, Password);
        bot.type(PasswordConfirmTextArea, CPassword);
        bot.click(radioButton);
        bot.click(Policy);
        bot.click(ContinueButton);
        return new NextPage(driver,bot);
    }

}
