package stepdefinitions;

import helpers.Constants;
import io.cucumber.java.en.Then;
import pageobjects.Widgets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WidgetsStepDefs {
    Widgets widgets;

    public WidgetsStepDefs() {
        this.widgets = new Widgets();
    }

    @Then("I click on the {string} option")
    public void iClickOnTheOption(String value) throws InterruptedException {
        String actual = this.widgets.clickOption(value);
        switch (value) {
            case "What is Lorem Ipsum?":
                assertThat(actual).isEqualTo(Constants.OPTION_ONE);
                break;
            case "Where does it come from?":
                assertThat(actual).isEqualTo(Constants.OPTION_TWO);
                break;
            case "Why do we use it?":
                assertThat(actual).isEqualTo(Constants.OPTION_THREE);
                break;
        }
    }

    @Then("I close the {string} option")
    public void iCloseTheOption(String value) {
        this.widgets.clickByValue(value);
    }

    @Then("I slide to {string}")
    public void iSlideTo(String value) {
        String actual = this.widgets.moveSlideBar(value);
        switch (value) {
            case "-50":
                assertThat(actual).isEqualTo("0");
                break;
            case "260":
                assertThat(actual).isEqualTo("100");
                break;

            default:
                break;
        }

    }

    @Then("I click on the {string} button on the widgets page")
    public void iClickOnTheButtonOnTheWidgetsPage(String arg0) throws InterruptedException {
        String actual = this.widgets.verifyProgressBar();
        assertThat(actual).isEqualTo("#28a745");
    }

    @Then("^I hover over \"([^\"]*)\" (button|link|textbox) on the widgets page$")
    public void iHoverOverLinkOnTheWidgetsPage(String value, String tagName) {
        String actual = this.widgets.hoverOverElement(tagName);
        switch (tagName) {
            case "button":
                assertThat(actual).isEqualTo("You hovered over the Button");
                break;
            case "link":
                assertThat(actual).isEqualTo("You hovered over the Contrary");
                break;
            case "textbox":
                assertThat(actual).isEqualTo("You hovered over the text field");
                break;

        }
    }

    @Then("^I hover over \"([^\"]*)\" (main|submenu|subsubmeu) on the menu page$")
    public void iHoverOverMenuOnTheMenuPage(String linkName, String menu) {
        Boolean flag = this.widgets.hoverOverLink(linkName, menu);
        if (linkName.equalsIgnoreCase("Sub Sub Item 2")) {
            assertThat(flag).isTrue();
        }
    }

    @Then("I select {string} under the Select Value")
    public void iSelectUnderTheSelectValue(String option) throws InterruptedException {
        this.widgets.selectFromSelectValue(option);
    }

    @Then("I click on the {string} dropdown on the Select Menu page")
    public void iClickOnTheDropdownOnTheSelectMenuPage(String option) throws InterruptedException {
        this.widgets.clickSelectDropDownHandle(option);
    }

    @Then("I select {string} from the Select Title dropdown")
    public void iSelectFromTheSelectTitleDropdown(String option) throws InterruptedException {
        this.widgets.selectFromSelectValue(option);
    }

    @Then("I click on the {string} label")
    public void iClickOnTheLabel(String label) {
        this.widgets.clickOnLabel(label);
    }

    @Then("I select {string} from the Standard multi Select dropdown")
    public void iSelectFromTheStandardMultiSelectDropdown(String options) throws InterruptedException {
        this.widgets.selectFromSelectValue(options);
    }

    @Then("I click on the {string} button on the Date Picker page")
    public void iClickOnTheButtonOnTheDatePickerPage(String field) {
        this.widgets.clickOnBttn(field);
    }

    @Then("I select the date and time as {string} button on the Date Picker page")
    public void iSelectTheDateAndTimeAsButtonOnTheDatePickerPage(String dateTime) throws InterruptedException {
       String actual =  this.widgets.clickOnDateTime(dateTime);
        assertThat(actual).isEqualTo("October 28, 2024 4:15 PM");
    }

    @Then("I select the date as {string} on the Date Picker page")
    public void iSelectTheDateAsOnTheDatePickerPage(String timeInput) {
       String actual =  this.widgets.selectDate(timeInput);
        assertThat(actual).isEqualTo(timeInput);
    }
}
