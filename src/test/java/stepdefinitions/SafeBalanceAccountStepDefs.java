package stepdefinitions;

import helpers.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.SafeBalanceAccount;
import runner.CucumberRunner;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SafeBalanceAccountStepDefs{

    public WebDriver driver;
    public SafeBalanceAccount safeBalanceAccount;

    public SafeBalanceAccountStepDefs() {
        this.driver = CucumberRunner.driver;
        this.safeBalanceAccount = new SafeBalanceAccount();
    }


    @Given("^I am on the homepage of the Bank of America$")
    public void iAmOnThesafeBalanceAccountOfTheBankOfAmerica() {
        String pageTitle = this.safeBalanceAccount.getPageTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle.contains(Constants.HOME_PAGE_TITLE));
    }


    @Then("I click on the Checking link")
    public void iClickOnTheCheckingLink() {
        this.safeBalanceAccount.clickNavCheckingLink();
    }

    @Then("I click on the Open a Checking Account image Link")
    public void iClickOnTheOpenACheckingAccountImageLink() {
        String actualTitle = this.safeBalanceAccount.clickOfferImageLink();
        Assert.assertEquals(actualTitle, Constants.CHECKING_PAGE_TITLE);

    }

    @Then("I scroll to SafeBalance Banking link")
    public void iScrollToSafeBalanceBankingLink() throws InterruptedException {
        this.safeBalanceAccount.scrollToSafeBalanceBankingCard();
    }


    @Then("I select I only want a BOA SafeBalance card option")
    public void iSelectIOnlyWantABOASafeBalanceCardOption() {
        this.safeBalanceAccount.onlyWantBOASafeBalanceCardRadioBttn();
    }

    @Then("I scroll to the Go to Application button in blue")
    public void iScrollToTheGoToApplicationButtonInBlue() {
        String actualColor = this.safeBalanceAccount.scrollToGoToApplicationBttnAndGetColorOfBttn();
        assertThat(actualColor).isEqualTo(Constants.GO_TO_APLICATION_BTTN_COLOR);
    }

    @Then("I click on the Continue button")
    public void iClickOnTheContinueButton() throws Exception {
        this.safeBalanceAccount.clickContinueBttn();
    }

    @Then("I click on the open now link on the SafeBalance Banking link")
    public void iClickOnTheOpenNowButtonOnTheSafeBalanceBankingLink() {
        String actualTitle = this.safeBalanceAccount.openSafeBalanceBankingCardLink();
        Assert.assertEquals(actualTitle, Constants.SAFEBALANCE_BANKING_ACCOUNT_PAGE_TITLE);
    }

    @Then("^I enter the zip code with \"([^\"]*)\" and click Go button if it exists$")
    public void i_fill_the_zip_code_with_something_and_click_go_button_if_it_exists(String value) {
        try {
            this.safeBalanceAccount.typeZipCodetoPopup(value);
            this.safeBalanceAccount.clickGoBttn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I pause \"([^\"]*)\" seconds$")
    public void i_pause_something_seconds(int num) throws InterruptedException {
        Thread.sleep(num * 1000);
    }

    @Then("I capture a screenshot of the current page")
    public void iCaptureAScreenshotOfTheCurrentPage() throws IOException {
        this.safeBalanceAccount.screenshotOfCurrentPage();
    }

    @Then("I click on the Go to Application button")
    public void iClickOnTheGoToApplicationButton() {
        this.safeBalanceAccount.clickGoToApplicationBttn();
    }

    @Then("^I verify the warning message \"([^\"]*)\"`$")
    public void i_verify_the_warning_message_something(String expectedValue) {
        String actualMessage = this.safeBalanceAccount.verifycheckAndFixErrorsToContinueMessage().trim();
        Assert.assertEquals(actualMessage, expectedValue);
    }

    @Then("^I clear zip code field and enter \"([^\"]*)\"$")
    public void i_clear_zip_code_field_and_enter_something(String value) {
        this.safeBalanceAccount.clearAndEnterZip(value);
    }

    @Then("^I enter the phone number with \"([^\"]*)\"$")
    public void i_enter_the_phone_number_with_something(String value) {
        this.safeBalanceAccount.enterPhoneNumber(value);
    }

    @Then("^I enter the email address \"([^\"]*)\"$")
    public void i_enter_the_email_address_something(String value) {
        this.safeBalanceAccount.enterEmail(value);
    }

    @Then("^I reenter the email address \"([^\"]*)\"$")
    public void i_reenter_the_email_address_something(String value) {
        this.safeBalanceAccount.reenterEmail(value);
    }

    @Then("^I click \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_click_something_to_something(String value, String option) {
        if (option.contains("citizenship")) {
            this.safeBalanceAccount.clickDualCitizenshipRadioBttn(value);
        } else {
            this.safeBalanceAccount.clickUSCitizenshipRadioBttn(value);
        }

    }

    @Then("^I enter the date of birth as \"([^\"]*)\"$")
    public void i_enter_the_date_of_birth_as_something(String value) {
        this.safeBalanceAccount.enterDateOfBirth(value);
    }

    @Then("^I select \"([^\"]*)\" as \"([^\"]*)\"$")
    public void i_select_something_as_something(String options, String value) {
        if (options.equalsIgnoreCase("Country of Residence")) {
            this.safeBalanceAccount.selectCountry(value);
        } else if (options.equalsIgnoreCase("Occupation")) {
            this.safeBalanceAccount.selectOccupation(value);
        } else if (options.equalsIgnoreCase("State")) {
            this.safeBalanceAccount.selectState(value);
        } else {
            this.safeBalanceAccount.selectSourceOfIncome(value);
        }
    }

    @Then("^I enter the first the name with \"([^\"]*)\", last name with \"([^\"]*)\"$")
    public void i_enter_the_first_the_name_with_something_last_name_with_something(String firstName, String lastName) {
        this.safeBalanceAccount.enterFirstName(firstName);
        this.safeBalanceAccount.enterLastName(lastName);

    }

    @Then("^I enter address with \"([^\"]*)\" and city with \"([^\"]*)\"$")
    public void i_enter_address_with_something_and_city_with_something(String address, String city) {
        this.safeBalanceAccount.enterAddress(address);
        this.safeBalanceAccount.enterCity(city);
    }

    @Then("^I enter SSN with \"([^\"]*)\"$")
    public void i_enter_ssn_with_something(String value) {
        this.safeBalanceAccount.enterSSN(value);
    }

    @Then("^I re-enter SSN with \"([^\"]*)\"$")
    public void i_reenter_ssn_with_something(String value) {
        this.safeBalanceAccount.reenterSSN(value);
    }

    @Then("^I verify the message header as \"([^\"]*)\"$")
    public void i_verify_the_message_header_as_something(String expectedValue) {
        String actualValue = this.safeBalanceAccount.verifyAccountSetUpHeader();
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Then("^I verify the following message in the body$")
    public void i_verify_the_following_message_in_the_body(String expectedValue) {
        String actualValue = this.safeBalanceAccount.verifyletsSetupYourAccountMessage().trim();
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
