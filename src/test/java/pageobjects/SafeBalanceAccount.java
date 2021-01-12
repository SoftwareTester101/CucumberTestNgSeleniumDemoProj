package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.io.IOException;

public class SafeBalanceAccount extends CucumberRunner {

    @FindBy(xpath = "//a[@id='navChecking']")
    private WebElement navCheckingLink;
    @FindBy(id = "DCTAL13O")
    private WebElement offerImage;
    @FindBy(xpath = ".//h2[normalize-space()='SafeBalance Banking®']")
    private WebElement safeBlanceBankingCard;
    @FindBy(id = "ProductDetails_P3_Opt1_CTA")
    private WebElement openSafeBlanceBankingCardLink;
    @FindBy(id = "rb-savings-account-none")
    private WebElement onlyWantBOASafeBalanceCardRadioBttn;
    @FindBy(id = "go-to-application-mediumup")
    private WebElement goToApplicaionBttn;
    @FindBy(xpath = "//a[@name= 'btn_continue' and @href='javascript:;']")
    private WebElement continueBttn;
    @FindBy(id = "zipCodeModalInputField")
    private WebElement zipCodeModalInputField;
    @FindBy(id = "go-button-zip-modal")
    private WebElement goBttn;
    @FindBy(xpath = ".//label[normalize-space()='Check and fix errors to continue.']")
    private WebElement checkAndFixErrorsToContinueMessage;
    @FindBy(id = "zz_name_tb_fnm_v_1")
    private WebElement firstNameInputField;
    @FindBy(id = "zz_name_tb_lnm_v_1")
    private WebElement lastNameInputField;
    @FindBy(id = "zz_addr_tb_line1_v_1")
    private WebElement addressInputField;
    @FindBy(id = "zz_addr_tb_city_v_1")
    private WebElement cityInputField;
    @FindBy(id = "zz_addr_lb_state_v_1")
    private WebElement stateDropDownMenu;
    @FindBy(id = "zz_addr_tb_zip_v_1")
    private WebElement zipCodeInputField;
    @FindBy(id = "zz_phn_tb_ppno_v_1")
    private WebElement phoneNumberInputField;
    @FindBy(id = "zz_email_tb_addr_v_1")
    private WebElement emalInputField;
    @FindBy(id = "zz_citz_lb_uscit_yes_v_1-real")
    private WebElement yesCitizenshipRadioBttn;
    @FindBy(id = "zz_citz_lb_uscit_no_v_1-real")
    private WebElement noCitizenshipRadioBttn;
    @FindBy(id = "zz_citz_lb_dualcit_no_v_1-real")
    private WebElement noDualCitizenshipRadioBttn;
    @FindBy(id = "zz_citz_lb_dualcit_yes_v_1-real")
    private WebElement yesDualCitizenshipRadioBttn;
    @FindBy(id = "zz_addr_lb_rescty_v_1")
    private WebElement residenceCountryDropdown;
    @FindBy(id = "zz_citz_tb_dob_v_1")
    private WebElement dateOfBirthInputField;
    @FindBy(id = "zz_emp_lb_srcinc_v_1")
    private WebElement sourceOfIncomeDropdown;
    @FindBy(id = "zz_emp_lb_ssnocc_v_1")
    private WebElement occupationDropdown;
    @FindBy(id = "zz_email_tb_readdr_v_1")
    private WebElement reEnterEmailAddressField;
    @FindBy(id = "zz_citz_tb_ssn_v_1")
    private WebElement ssnInputField;
    @FindBy(id = "zz_citz_tb_ssn_2_v_1")
    private WebElement secondSSNInputField;
    @FindBy(xpath = ".//p[@class='c1']")
    private WebElement letsSetupYourAccountMessage;
    @FindBy(xpath = ".//h2")
    private WebElement accountSetUpHeader;

    public SafeBalanceAccount() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickNavCheckingLink() {
        doClick(navCheckingLink);
    }

    public String clickOfferImageLink() {
        doClick(offerImage);
        return getPageTitle();
    }

    public void scrollToSafeBalanceBankingCard() throws InterruptedException {
        scrollTo(safeBlanceBankingCard);
    }

    public String openSafeBalanceBankingCardLink() {
        doClick(openSafeBlanceBankingCardLink);
        switchToActiveTab();
        return getPageTitle();
    }

    public void onlyWantBOASafeBalanceCardRadioBttn() {
        doClick(onlyWantBOASafeBalanceCardRadioBttn);
    }

    public String scrollToGoToApplicationBttnAndGetColorOfBttn() {
        scrollABitDown();
        return getColorOfGoToApplicationBttn();
    }

    public void clickGoToApplicationBttn() {
        doClick(goToApplicaionBttn);
    }


    public String getColorOfGoToApplicationBttn() {
        return getColor(goToApplicaionBttn, "background-color");
    }

    public void clickContinueBttn() throws Exception {
        scrollToTheEndOfPage();
        safeJavaScriptClick(continueBttn);
    }

    public void clickGoBttn() {
        doClick(goBttn);
    }

    public void typeZipCodetoPopup(String value) {
        doSendKeys(zipCodeModalInputField, value);
    }

    public void screenshotOfCurrentPage() throws IOException {
        takeScreenshotAtEndOfTest();
    }

    public String verifycheckAndFixErrorsToContinueMessage() {
        return doGetText(checkAndFixErrorsToContinueMessage);
    }


    public void enterFirstName(String value) {
        doSendKeys(firstNameInputField, value);
    }


    public void enterAddress(String value) {
        doSendKeys(addressInputField, value);
    }

    public void enterCity(String value) {
        doSendKeys(cityInputField, value);
    }

    public void enterPhoneNumber(String value) {
        doSendKeys(phoneNumberInputField, value);
    }

    public void reenterEmail(String value) {
        doSendKeys(reEnterEmailAddressField, value);
    }

    public void enterEmail(String value) {
        doSendKeys(emalInputField, value);
        doSendTabKey(emalInputField);
    }

    public void selectState(String value) {
        doSelectOnDropDownAndSelectByValue(stateDropDownMenu, value);
    }

    public void clearAndEnterZip(String value) {
        doClear(zipCodeInputField);
        doSendKeys(zipCodeInputField, value);
    }


    public void clickUSCitizenshipRadioBttn(String value) {
        if (value.equalsIgnoreCase("yes")) {
            doClick(yesCitizenshipRadioBttn);
        } else {
            doClick(yesCitizenshipRadioBttn);
        }

    }

    public void clickDualCitizenshipRadioBttn(String value) {
        if (value.equalsIgnoreCase("yes")) {
            doClick(yesDualCitizenshipRadioBttn);
        } else {
            doClick(noDualCitizenshipRadioBttn);
        }
    }

    public void selectCountry(String value) {
        doSelectOnDropDownAndSelectVisibleText(residenceCountryDropdown, value);
    }

    public void enterDateOfBirth(String value) {
        doSendKeys(dateOfBirthInputField, value);
    }

    public void selectSourceOfIncome(String value) {
        doSelectOnDropDownAndSelectVisibleText(sourceOfIncomeDropdown, value);
    }

    public void selectOccupation(String value) {
        doSelectOnDropDownAndSelectVisibleText(occupationDropdown, value);
    }

    public void enterLastName(String lastName) {
        doSendKeys(lastNameInputField, lastName);
    }

    public void enterSSN(String lastName) {
        doSendKeys(ssnInputField, lastName);
    }

    public void reenterSSN(String lastName) {
        doSendKeys(secondSSNInputField, lastName);
    }

    public String verifyAccountSetUpHeader() {
        waitUntilVisible(accountSetUpHeader, 30);
        return doGetText(accountSetUpHeader);
    }

    public String verifyletsSetupYourAccountMessage() {
        return doGetText(letsSetupYourAccountMessage);
    }
}
