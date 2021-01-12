package stepdefinitions;


import helpers.Constants;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.AlertFrames;
import runner.CucumberRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertFramesWindowsStepDefs {

    private AlertFrames alertFrames;
    private WebDriver driver;

    public AlertFramesWindowsStepDefs() {
        this.alertFrames = new AlertFrames();
        this.driver = CucumberRunner.driver;
    }

    @Then("^I click on the \"([^\"]*)\" button on the Alerts page$")
    public void i_click_on_the_something_button_on_the_alerts_page(String bttnName) throws InterruptedException {
        this.alertFrames.clickAlertBttn(bttnName);
    }

    @Then("^I confirm the alert$")
    public void i_confirm_the_alert() {
        this.alertFrames.acceptAlert();
    }

    @Then("^I verify the \"([^\"]*)\" on the alert$")
    public void i_verify_the_something_on_the_alert(String expected) {
        String actual = this.alertFrames.getTextFromAlert();
        assertThat(actual).isEqualTo(expected);
    }

    @Then("^I input \"([^\"]*)\" in the textbox on the alert$")
    public void i_input_something_in_the_textbox_on_the_alert(String value) {
        this.alertFrames.sendKeysToAlert(value);
    }

    @Then("^I cancel the alert$")
    public void i_cancel_the_alert() {
        this.alertFrames.dismissAlert();
    }

    @Then("I scroll the side bar on the second frame")
    public void iScrollTheSideBarOnTheSecondFrame() {
        this.alertFrames.scrollSideBarOnFrame();
    }

    @Then("^I get the value from the (1|2) frame$")
    public void iGetTheValueFromTheFirstSecondFrame(String frame) {
        String acutal = this.alertFrames.getTextFromFrame(frame);
        assertThat(acutal).isEqualTo(Constants.TEXT_ON_FRAME);
    }

    @Then("^I click on the \"([^\"]*)\" button on the Browser Windows page$")
    public void i_click_on_the_something_button_on_the_browser_windows_page(String bttnName) {
        switch (bttnName.toLowerCase()) {
            case "new tab":
                this.alertFrames.clickBttn(bttnName);
                String actual = this.alertFrames.getBackgroundColorOfNewTab();
                assertThat(actual).isEqualTo("#a9a9a9");
                break;

            case "new window":
                this.alertFrames.clickBttn(bttnName);
                String url = this.alertFrames.getCurrentUrl();
                assertThat(url).isEqualTo("https://demoqa.com/sample");
                break;
            case "message":
                this.alertFrames.clickBttn(bttnName);
                break;
        }
    }

    @Then("^I get the value from the (parent|child) frame$")
    public void iGetTheValueFromTheChildFrame(String frame) {
        switch (frame) {
            case "parent":
                this.alertFrames.switchToFrameById("frame1");
                String prntMsg = this.alertFrames.getTextFromFrame();
                assertThat(prntMsg).isEqualTo("Parent frame");
                break;
            case "child":
                this.alertFrames.switchInNestedFramesByNumber(1);
                String childMsg = this.alertFrames.getTextFromFrame();
                assertThat(childMsg).isEqualTo("Child Iframe");
                break;
        }
    }

    @Then("^I click on the \"([^\"]*)\" button on the Modal diaglog$")
    public void i_click_on_the_something_button_on_the_modal_diaglog(String id) {
        this.alertFrames.clickById(id);
    }

    @Then("^I close the \"([^\"]*)\" modal$")                                    
    public void i_close_the_something_modal(String id) throws InterruptedException {
        this.alertFrames.switchToActiveElement();
        Thread.sleep(5000);
        this.alertFrames.clickById(id);
    }
}
