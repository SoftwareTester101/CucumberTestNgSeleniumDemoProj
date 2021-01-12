package stepdefinitions;

import com.github.javafaker.Faker;
import helpers.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.ElementsList;
import runner.CucumberRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ElementsListStepDefs {
    private ElementsList elList;
    private WebDriver driver;
    private Faker faker;

    public ElementsListStepDefs() {
        this.driver = CucumberRunner.driver;
        this.elList = new ElementsList();
        this.faker = new Faker();
    }

    @Given("^I am on the homepage of Tools QA$")
    public void i_am_on_the_homepage_of_tools_qa() {
    }

    @Then("^I fill \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_something_with_something(String fieldName, String inputValue) {
        switch (fieldName) {
            case "Full Name":
                inputValue = this.faker.name().name();
                this.elList.inputUsername(inputValue);
                break;
            case "Current Address":
                inputValue = this.faker.address().fullAddress();
                this.elList.inputCurrentAddress(inputValue);
                break;
            case "Email":
                inputValue = this.faker.beer().name().replaceAll(" ", "") + "@gmail.com";
                this.elList.inputEmail(inputValue);
                break;
            case "Permanent Address":
                inputValue = this.faker.address().fullAddress();
                this.elList.inputAddress(inputValue);
                break;
        }
    }

    @Then("^I \"([^\"]*)\" the form$")
    public void i_something_the_form(String value) {
        this.elList.clickSubmit();
    }

    @When("^I click on the \"([^\"]*)\" from the main menu$")
    public void i_click_on_the_something_from_the_main_menu(String name) {
        this.elList.clickMainItemFromSideMenu(name);
    }

    @Then("^I click on the \"([^\"]*)\" from the sub menu$")
    public void i_click_on_the_something_from_the_sub_menu(String name) throws InterruptedException {
        Thread.sleep(2000);
        this.elList.clickSubMenu(name);
    }

    @Then("^I click on the Toggle of \"([^\"]*)\"$")
    public void i_click_on_the_toggle_of_something(String toggles) {
        String[] values = toggles.split(",");
        for (String value :
                values) {
            this.elList.clickToggle(value);
            System.out.println(value + " is clicked.");
        }
    }

    @Then("^I click on the checkbox for \"([^\"]*)\"$")
    public void i_click_on_the_checkbox_for_something(String str) {
        String[] list = str.split(",");
        for (String value : list
        ) {
            this.elList.clickCheckBoxes(value);
            System.out.println(value + " is checked.");
        }
    }

    @Then("^I verify the following message in the body of the Checkbox page$")
    public void i_verify_the_following_message_in_the_body_of_the_checkbox_page(String str) {
        String actual = this.elList.verifyMessage();
        assertThat(actual).isEqualTo(Constants.RESULT_MESSAGE);
    }

    @Then("^I verify the radio button \"([^\"]*)\" is (Enabled|Disabled)$")
    public void i_verify_the_radio_button_something_is_enabled(String str, String status) {
        String[] arr = str.split(",");
        boolean flag = this.elList.isRadioBttnEnabled();
        for (String li : arr) {
            if (status.equalsIgnoreCase("enabled")) {
                if (li.equalsIgnoreCase("Yes") || li.equalsIgnoreCase("Impressive")) {
                    assertThat(flag).isTrue();
                }
            } else {
                this.elList.isRadioBttnDisabled();
                assertThat(flag).isTrue();
            }

        }
    }

    @Then("^I click on the radio bttn \"([^\"]*)\"$")
    public void i_click_on_the_radio_bttn_something(String strArg1) throws InterruptedException {
        boolean flag = this.elList.clickRadioBttn();
        assertThat(flag).isTrue();
    }

    @Then("^I click on the \"([^\"]*)\" button$")
    public void i_click_on_the_something_button(String expectedText) {
        String message = this.elList.clickClickMeBttn(expectedText);
        expectedText = Constants.CLICK_MESSAGE;
        assertThat(message).isEqualTo(expectedText);
    }

    @Then("^I double click on the \"([^\"]*)\" button$")
    public void i_double_click_on_the_something_button(String expectedText) {
        String message = this.elList.doubleClickBttn();
        expectedText = Constants.DOUBLE_CLICK_MESSAGE;
        assertThat(message).isEqualTo(expectedText);
    }

    @Then("^I right click the \"([^\"]*)\" button$")
    public void i_right_click_the_something_button(String expectedText) {
        String message = this.elList.rightClickBttn();
        expectedText = Constants.RIGHT_CLICK_MESSAGE;
        assertThat(message).isEqualTo(expectedText);
    }

    @Then("^I click on the \"([^\"]*)\" link to open a new tab$")
    public void i_click_on_the_something_link_to_open_a_new_tab(String linkName) {
        String title = this.elList.clickLinkOpensNewTab(linkName);
        assertThat(title).isEqualTo(Constants.PAGE_TITLE1);
    }

    @Then("^I click on the \"([^\"]*)\" link and verify the status Code \"([^\"]*)\" and status text \"([^\"]*)\" in bold$")
    public void i_click_on_the_something_link_and_verify_the_status_code_something_and_status_text_something_in_bold(String linkName, String statusCode, String text) {
        String response = this.elList.clickLink(linkName, statusCode, text);
        assertThat(response).isEqualTo(text);
    }

    @Then("I return to the default tab")
    public void iReturnToTheDefaultTab() {
        driver.close();
        this.elList.switchToDefaultTab();
    }

    @Then("^I should see \"([^\"]*)\" button$")
    public void i_should_see_something_button(String strArg1) {
        boolean flag = this.elList.verifyBttnVisible();
        assertThat(flag).isTrue();
    }

    @Then("^I should see the \"([^\"]*)\" button text in red$")
    public void i_should_see_the_something_button_text_in_red(String strArg1) {
        String color = this.elList.verifyColorOfTextInBttn();
        assertThat(color).isEqualTo(Constants.COLOR_OF_THE_TEXT_IN_BTTN);
    }


    @Then("^I click on the valid link$")
    public void i_click_on_the_valid_link() {
        String actual = this.elList.clickOnValidLink();
        assertThat(actual).isEqualTo(Constants.PAGE_TITLE1);
    }

    @Then("^I click on the broken link$")
    public void i_click_on_the_broken_link() {
       String actual = this.elList.clickBrokenLink();
        assertThat(actual).isEqualTo(Constants.BROKEN_LINK_PAGE_TITLE);

    }

}
