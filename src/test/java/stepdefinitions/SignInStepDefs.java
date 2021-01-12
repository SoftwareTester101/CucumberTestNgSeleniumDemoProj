package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.SignIn;
import runner.CucumberRunner;

import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static runner.CucumberRunner.loadProperty;

public class SignInStepDefs {

    private Faker faker;
    private WebDriver driver;
    private SignIn signIn;
    private Properties prop;

    public SignInStepDefs() {
        this.driver = CucumberRunner.driver;
        this.signIn = new SignIn();
        this.faker = new Faker();
    }

    @Given("I go to the home page of Bank Of America")
    public void iGoToTheHomePageOfBankOfAmerica() throws IOException {
        prop = loadProperty();
        this.driver.get(prop.getProperty("url"));
    }

    @Then("^I enter invalid username$")
    public void i_enter_invalid_username() {
        String randomUserId = faker.animal().name();
        this.signIn.enterUserId(randomUserId);
    }

    @Then("^I enter invalid password$")
    public void i_enter_invalid_password() {
        String randomPassword = faker.beer().name();
        this.signIn.enterPassword(randomPassword);
    }

    @Then("^I click on the Sign In button$")
    public void i_click_on_the_sign_in_button() {
        this.signIn.clickSignInBttn();
    }


    @Then("^I verify the following error message \"([^\"]*)\"$")
    public void i_verify_the_following_error_message_something(String expectedValue) throws InterruptedException {
        String actualValue = this.signIn.verifySignInErrorMessage().trim();
        assertThat(actualValue.contains(expectedValue));
    }
}
