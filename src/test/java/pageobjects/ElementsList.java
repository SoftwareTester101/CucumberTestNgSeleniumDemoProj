package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.util.List;

public class ElementsList extends CucumberRunner {
    @FindBy(xpath = "//h5[normalize-space()='Elements']")
    private WebElement elementBox;
    @FindBy(xpath = "//span[normalize-space()='Text Box']")
    private WebElement textBox;
    @FindBy(xpath = "//span[normalize-space()='Check Box']")
    private WebElement checkboxItem;
    @FindBy(xpath = "//span[normalize-space()='Radio Button']")
    private WebElement radioBttnItem;
    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    private WebElement alertsBttn;
    @FindBy(xpath = "//span[normalize-space()='Buttons']")
    private WebElement bttnsItem;
    @FindBy(xpath = "//span[normalize-space()='Links']")
    private WebElement linksItem;
    @FindBy(xpath = "//h5[normalize-space()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindows;
    @FindBy(id = "userName")
    private WebElement userName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;
    @FindBy(id = "submit")
    private WebElement submitBttn;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBttn;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBttn;

    @FindBy(xpath = "//button[normalize-space()='Click Me']")
    private WebElement clickBttn;

    @FindBy(id = "impressiveRadio")
    private WebElement impressiveRadio;

    @FindBy(id = "yesRadio")
    private WebElement yesRadioBttn;

    @FindBy(xpath = "//button[@title='Toggle']")
    private WebElement mainToggle;

    @FindBy(id = "doubleClickMessage")
    private WebElement dClickText;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterFiveSecBttn;


    @FindBy(id = "rightClickMessage")
    private WebElement rClickText;


    @FindBy(id = "dynamicClickMessage")
    private WebElement normalClickText;
    @FindBy(id = "noRadio")
    private WebElement noRadioBttn;
    @FindBy(xpath = "")
    private WebElement toggleDemoXpath;
    @FindBy(xpath = "")
    private WebElement checkBoxDemoXpath;
    @FindBy(id = "result")
    private WebElement resultMessage;
    @FindBy(id = "simpleLink")
    private WebElement homeLink;
    @FindBy(id = "dynamicLink")
    private WebElement homeNBCLink;
    @FindBy(xpath = "//div[@id='linkWrapper']//a")
    private List<WebElement> allLinks;
    @FindBy(id = "colorChange")
    private WebElement colorChangeBttn;
    @FindBy(css = "div:nth-child(1) > a:nth-child(10)")
    private WebElement validLink;
    @FindBy(xpath = ".//a[normalize-space()='Click Here for Broken Link']")
    private WebElement brokenLink;

    public ElementsList() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }


    public void inputUsername(String name) {
        doSendKeys(userName, name);
    }

    public void inputEmail(String email) {
        doSendKeys(userEmail, email);
    }

    public void inputCurrentAddress(String address) {
        doSendKeys(currentAddress, address);
    }

    public void inputAddress(String address) {
        doSendKeys(permanentAddress, address);
    }

    public void clickSubmit() {
        doClick(submitBttn);
    }

    public void clickMainItemFromSideMenu(String name) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath("//h5[normalize-space()='" + name + "']"));
        } catch (NoSuchElementException e) {
            element = driver.findElement(By.xpath("//span[normalize-space()='" + name + "']"));
        }
        waitUntilClickable(element, 15);
        safeJavaScriptClick(element);
    }

    public void clickSubMenu(String name) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='" + name + "']"));
        waitUntilClickable(element, 15);
        scrollTo(element);
        doClick(element);
    }

    public String rightClickBttn() {
        DoRightClick(rightClickBttn);
        return doGetText(rClickText);
    }

    public String doubleClickBttn() {
        doDoubleClick(doubleClickBttn);
        return doGetText(dClickText);
    }

    public String clickClickMeBttn(String buttnName) {
        doClick(clickBttn);
        return doGetText(normalClickText);

    }

    public boolean clickRadioBttn() {
        if (isEnabled(impressiveRadio)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", impressiveRadio);
        }
        return impressiveRadio.isSelected();
    }

    public boolean isRadioBttnEnabled() {
        return isEnabled(yesRadioBttn);
    }

    public boolean isRadioBttnDisabled() {
        return isEnabled(noRadioBttn);
    }

    public void clickCheckBox() {
        doClick(checkboxItem);
    }

    public void clickRadioBttnItem() {
        doClick(radioBttnItem);
    }

    public void clickBttns() {
        doClick(bttnsItem);
    }

    public void clickToggleMain() {
        doClick(mainToggle);
    }

    public void clickToggle(String toggleName) {
        doClick(driver
                .findElement(By.xpath("//span[normalize-space()='" + toggleName + "']//button")));
    }

    public String verifyMessage() {
        return doGetText(resultMessage);
    }

    public void clickCheckBoxes(String checkboxValue) {
        doClick(driver
                .findElement(By.xpath("//span[normalize-space()='" + checkboxValue + "']/..//span[@class='rct-checkbox']")));
    }

    public String clickLinkOpensNewTab(String linkName) {
        if (linkName.equalsIgnoreCase("home")) {
            doClick(homeLink);
            switchToActiveTab();
        } else {
            switchToDefaultTab();
            doClick(homeNBCLink);
            switchToActiveTab();
        }
        return driver.getTitle();
    }

    public void clickLinks() throws InterruptedException {
        scrollTo(linksItem);
        doClick(linksItem);
    }

    public String clickLink(String linkName, String statusCode, String text) {
        String response = "";
        for (WebElement we : allLinks
        ) {
            if (doGetText(we).equalsIgnoreCase(linkName)) {
                doClick(we);
                System.out.println(doGetText(we) + " is clicked");
                response = doGetText(driver.findElement(By.xpath("//p[@id='linkResponse']//b[contains(text(),'" + statusCode +
                        "')]/following::b[contains(text(),'" + text + "')]")));
                System.out.println(response);
            }
        }

        return response;
    }

    public void clickAlertFramesWindows() {
        safeJavaScriptClick(alertFrameWindows);
    }

    public void clickAlerts() {
        safeJavaScriptClick(alertsBttn);
    }

    public boolean verifyBttnVisible() {
        return visibleAfterFiveSecBttn.isDisplayed();
    }

    public String verifyColorOfTextInBttn() {
        return getColor(colorChangeBttn, "color");
    }

    public String clickOnValidLink() {
        return openLinkOnANewTab(validLink);
    }

    public String clickBrokenLink() {
        doClick(brokenLink);
        return getExactPageTitle();
    }
}
