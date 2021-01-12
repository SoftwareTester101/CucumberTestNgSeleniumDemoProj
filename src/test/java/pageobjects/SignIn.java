package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

public class SignIn extends CucumberRunner {

    @FindBy(id = "onlineId1")
    private WebElement userIdField;

    @FindBy(id = "passcode1")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement signInBttn;

    @FindBy(css = ".error-message>li")
    private WebElement signInErrorMessage;

    public SignIn() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public void enterUserId(String value) {
        doSendKeys(userIdField, value);
        doSendTabKey(userIdField);
    }

    public void enterPassword(String value) {
        doSendKeys(passwordField, value);
    }

    public void clickSignInBttn() {
        doClick(signInBttn);
    }

    public String verifySignInErrorMessage() throws InterruptedException {
        Thread.sleep(5000);
        return doGetText(signInErrorMessage);
    }

}
