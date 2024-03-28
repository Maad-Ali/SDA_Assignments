package CucumberTask;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    WebDriver driver;

    @Given("user goes to the {string}")
    public void GoTo(String URL) {
        driver= new ChromeDriver();
        driver.navigate().to(URL);
    }

    @Then("user waits for 5 seconds")
    public void WaitFor5() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("verifies that the page title contains the word {string}")
    public void Title(String word) {
        String PageTitle = driver.getTitle();
        assert PageTitle.contains(word) : "Page title does not contain the expected word.";
    }

    @And("closes the page")
    public void ClosePage() {
        driver.quit();
    }
}
