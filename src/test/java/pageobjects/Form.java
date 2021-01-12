package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.util.List;

public class Form extends CucumberRunner {
    @FindBy(css = "#lastName")
    WebElement lastNameField;
    @FindBy(css = "#firstName")
    private WebElement fistNameField;
    @FindBy(css = "#userEmail")
    private WebElement emailField;
    @FindBy(css = "#gender-radio-2")
    private WebElement genderBttn;
    @FindBy(css = "#userNumber")
    private WebElement mobileNum;
    @FindBy(css = "#currentAddress")
    private WebElement addressField;
    @FindBy(css = ".subjects-auto-complete__placeholder.css-1wa3eu0-placeholder")
    private WebElement subjectsField;
    @FindBy(xpath = "//div[@class=\"custom-control custom-checkbox custom-control-inline\"]//label")
    private List<WebElement> hobbyRadioBttn;
    @FindBy(css = "#uploadPicture")
    private WebElement imgField;
    @FindBy(css = "#submit")
    private WebElement submitBttn;
    @FindBy(css = "#dateOfBirthInput")
    private WebElement birthDateField;
    @FindBy(xpath = "//div[contains(@class,'css-yk16xz-control')]")
    private WebElement stateArror;
    @FindBy(css = "#city")
    private WebElement cityField;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthPicker;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearPicker;
    @FindBy(css = "#react-select-3-input")
    private WebElement stateInput;
    @FindBy(css = "#react-select-4-input")
    private WebElement cityIput;


    public Form() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public void fillLastName(String name) {
        doSendKeys(lastNameField, name);
    }

    public void fillFirstName(String firstName) {
        doSendKeys(fistNameField, firstName);
    }

    public void fillEmail(String email) {
        doSendKeys(emailField, email);
    }

    public void selectGender(String value) {
        if(genderBttn.isDisplayed()&&genderBttn.isEnabled()){
            doClick(genderBttn);
        }
    }

    public void fillMobileNum(String num) {
        doSendKeys(mobileNum, num);
    }

    public void fillAddress(String address) {
        doSendKeys(addressField, address);
    }

    public void fillSubject(String subject) {
        doSendKeys(subjectsField, subject);
    }

    public void fillHobby(String hobby) {
        selectRadioBttns(hobbyRadioBttn, hobby);
    }

    public void selectImg(String path) {
        doSendKeys(imgField, path);
    }

    public void selectState(String state) throws InterruptedException {
        scrollTo(stateArror);
        doSendKeys(stateInput, state);
        doSendTabKey(stateInput);
    }

    public void selectCity(String city) {
        doSendKeys(cityIput, city);
        doSendTabKey(cityIput);

    }

    public void clickSubmit() {
        submitBttn.submit();
    }

    public void fillDateOfBirth(String dateOfBirth) {
        String[] array = dateOfBirth.split("/");
        String day = array[0];
        String month = String.valueOf(Integer.parseInt(array[1]) -1);
        String year = array[2];
        doClick(birthDateField);
        doClick(monthPicker);
        doSelectOnDropDownAndSelectByValue(monthPicker, month);
        doClick(yearPicker);
        doSelectOnDropDownAndSelectByValue(yearPicker, year);
        doClick(driver.findElement(By.xpath("//div[normalize-space()='"+day+"']")));
    }
}
