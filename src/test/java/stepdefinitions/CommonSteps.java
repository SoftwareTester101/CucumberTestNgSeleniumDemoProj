package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import runner.CucumberRunner;

public class CommonSteps {

    public WebDriver driver;
    CucumberRunner cucumberRunner;

    public CommonSteps() {
        this.driver = CucumberRunner.driver;
        cucumberRunner = new CucumberRunner();
    }

    @Then("I refresh the page")
    public void iRefreshThePage() {
        this.driver.navigate().refresh();
    }

    @Then("^I return to the default page$")
    public void iReturnToTheDefaultPage() {
        cucumberRunner.switchToDefaultTab();
    }
}
