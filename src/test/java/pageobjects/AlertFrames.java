package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.util.List;

public class AlertFrames extends CucumberRunner {

    @FindBy(id = "alertButton")
    private WebElement displayBttn;

    @FindBy(id = "timerAlertButton")
    private WebElement timedBttn;

    @FindBy(id = "confirmButton")
    private WebElement confirmBttn;

    @FindBy(id = "promtButton")
    private WebElement promptBttn;

    @FindBy(id = "frame1")
    private WebElement firstFrame;

    @FindBy(id = "frame2")
    private WebElement smallFrame;

    @FindBy(xpath = "//body")
    private WebElement textOnFrame;
    @FindBy(id = "tabButton")
    private WebElement newTabBttn;

    @FindBy(id = "windowButton")
    private WebElement newWindowBttn;

    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMsgBttn;

    @FindBy(xpath = "//body")
    private WebElement newTabColor;

    @FindBy(xpath = "//*[contains(text(),'Knowledge increases by sharing but not by saving.')]")
    private WebElement msgWindow;

    @FindBy(tagName = "iframe")
    private List<WebElement> allFrames;


    public AlertFrames() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public void clickAlertBttn(String bttnName) {
        switch (bttnName) {
            case "Alert Bttn":
                doClick(displayBttn);
                break;
            case "Timer Alert":
                doClick(timedBttn);
                waitTillAlertPresent();
                break;
            case "Confirm Alert":
                doClick(confirmBttn);
                break;
            case "Promt Alert":
                doClick(promptBttn);
                break;
        }
    }

    public String getTextFromFrame(String frame) {
        String text = "";
        switch (frame) {
            case "1":
                switchToFrame(firstFrame);
                break;
            case "2":
                switchToDefaultWindow();
                switchToFrameById("frame2");
                break;
        }
        return doGetText(textOnFrame);
    }

    public void clickBttn(String bttnName) {
        switch (bttnName.toLowerCase()) {
            case "new tab":
                doClick(newTabBttn);
                break;
            case "new window":
                switchToDefaultTab();
                doClick(newWindowBttn);
                switchToActiveTab();
                break;
            case "message":
                switchToDefaultTab();
                doClick(newWindowMsgBttn);
                break;
        }
    }

    public String getBackgroundColorOfNewTab() {
        switchToActiveTab();
        return getColor(newTabColor, "background-color");
    }

    public void switchInNestedFramesByNumber(int num) {
        switchToFrameByNumber(allFrames, num);
    }

    public String getTextFromFrame() {
        return doGetText(newTabColor);
    }

    public void clickById(String id) {
        doClick(driver.findElement(By.id(id)));
    }
}
