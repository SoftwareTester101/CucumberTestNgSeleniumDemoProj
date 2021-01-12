package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.util.List;

public class Widgets extends CucumberRunner {
    @FindBy(id = "section1Heading")
    private WebElement option1;
    @FindBy(id = "section2Heading")
    private WebElement option2;
    @FindBy(id = "section3Heading")
    private WebElement option3;
    @FindBy(xpath = "//div[@id='section1Content']/p")
    private WebElement content1;
    @FindBy(xpath = "//div[@id='section2Content']/p")
    private WebElement content2;
    @FindBy(xpath = "//div[@id='section3Content']/p")
    private WebElement content3;


    @FindBy(xpath = "//div[@id='accordianContainer']")
    private List<WebElement> allOptions;
    @FindBy(css = ".range-slider.range-slider--primary")
    private WebElement slide;

    @FindBy(id = "sliderValue")
    private WebElement sliderValue;

    @FindBy(id = "startStopButton")
    private WebElement startBttn;

    @FindBy(id = "resetButton")
    private WebElement resetBttn;

    @FindBy(css = ".progress-bar.bg-success")
    private WebElement progressBar;

    @FindBy(id = "toolTipButton")
    private WebElement hoverOnBttn;
    @FindBy(linkText = "Contrary")
    private WebElement hoverOnLink;
    @FindBy(css = "#toolTipTextField")
    private WebElement hoverOnText;
    @FindBy(xpath = "//button[@aria-describedby='buttonToolTip']")
    private WebElement bttnToolTip;
    @FindBy(xpath = "//ul[@id=\"nav\"]/li")
    private List<WebElement> allLinks;
    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]/../../li")
    private List<WebElement> allSubLinks;
    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]/..//ul//li")
    private List<WebElement> allSubSubLinks;
    @FindBy(id = "withOptGroup")
    private WebElement withOptGroup;
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElement singleValue;

    @FindBy(id = "selectOne")
    private WebElement selectOne;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement singleTitle;
    @FindBy(id = "oldSelectMenu")
    private WebElement oldSelectOptions;
    @FindBy(xpath = "//div[contains(@class, ' css-1wa3eu0-placeholder') and contains(text(), \"Select...\")]")
    private WebElement multiSelect;
    @FindBy(xpath = "//input[@id='react-select-4-input']")
    private WebElement multiSelectValue;
    @FindBy(xpath = "//b[normalize-space()='Multiselect drop down']")
    private WebElement multiSelectLabel;
    @FindBy(id = "cars")
    private WebElement standardSelect;
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement selectDateField;
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateAndTimeField;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthPicker;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearPicker;
    @FindBy(className = "react-datepicker__month-read-view--down-arrow")
    private WebElement monthArrow;
    @FindBy(className = "react-datepicker__year-read-view--down-arrow")
    private WebElement yearArrow;
    
    public Widgets() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public String clickOption(String value) throws InterruptedException {
        switch (value) {
            case "What is Lorem Ipsum?":
                safeJavaScriptClick(option1);
                return doGetText(content1);
            case "Where does it come from?":
                safeJavaScriptClick(option2);
                return doGetText(content2);
            case "Why do we use it?":
                safeJavaScriptClick(option3);
                return doGetText(content3);
        }
        return "";
    }

    public void clickByValue(String value) {
        for (int i = 0; i < allOptions.size(); i++) {
            if (allOptions.get(i).getText().equalsIgnoreCase(value)) {
                doClick(allOptions.get(i));
                System.out.println("Clicked " + allOptions.get(i));
            }
        }
    }

    public String moveSlideBar(String value) {
        int x = Integer.parseInt(value);
        moveSlider(slide, x, 0);
        waitUntilVisible(sliderValue, 5);
        return sliderValue.getAttribute("value");
    }

    public String verifyProgressBar() throws InterruptedException {
        scrollTo(startBttn);
        doClick(startBttn);
        waitUntilVisible(resetBttn, 10);
        return getColor(progressBar, "background-color");
    }

    public String hoverOverElement(String tagName) {
        switch (tagName) {
            case "button":
                hoverOver(hoverOnBttn);
                return doGetText(bttnToolTip);
            case "link":
                hoverOver(hoverOnLink);
                return doGetText(hoverOnLink);
            case "textbox":
                hoverOver(hoverOnText);
                return doGetText(hoverOnText);
        }
        return tagName;
    }

    public Boolean hoverOverLink(String linkName, String name) {
        switch (name) {
            case "main":
                hoverOverLinkByListOfWebElem(allLinks, linkName);
                break;
            case "submenu":
                hoverOverLinkByListOfWebElem(allSubLinks, linkName);
                break;
            case "subsubmenu":
                hoverOverLinkByListOfWebElem(allSubSubLinks, linkName);

        }
        return foundLinkFromListOfLinks(allSubSubLinks, linkName);
    }

    public void clickSelectDropDownHandle(String option) throws InterruptedException {
        switch (option) {
            case "Select Option":
                doClick(withOptGroup);
                break;

            case "Select Title":
                doClick(selectOne);
                break;
            case "Old Select Menu":
                doClick(oldSelectOptions);
                doSelectOnDropDownAndSelectVisibleText(oldSelectOptions, "Indigo");

            case "Multi Select Menu":
                scrollTo(multiSelect);
                doClick(multiSelect);
                break;
            default:
                break;
        }
    }

    public void selectFromSelectValue(String option) throws InterruptedException {
        switch (option) {
            case "Group 1, Option 1":
            case "Group 2, Option 2":
            case "Another root option":
                doSendKeys(singleValue, option);
                break;
            case "Prof.":
                doSendKeys(singleTitle, option);
                break;
            case "Blue,Red":
                doSendKeys(multiSelectValue, "Blue");
                doSendTabKey(multiSelectValue);
                doSendKeys(multiSelectValue, "Red");
                doSendTabKey(multiSelectValue);
                doSendKeys(multiSelectValue, "Green");
                doSendTabKey(multiSelectValue);
                break;
            case "volvo,Opel":
                scrollTo(standardSelect);
                selectAllOptions(standardSelect, option);
                break;
        }
    }

    public void clickOnLabel(String label) {
        doClick(multiSelectLabel);
    }

    public void clickOnBttn(String fieldName) {
        switch (fieldName) {
            case "Select Date":
                doClick(selectDateField);
                break;
            case "Date And Time":
                doClick(dateAndTimeField);
                break;

            default:
                break;
        }
    }

    public String selectDate(String timeInput) {
        String[] array = timeInput.split("/");
        String month = String.valueOf(Integer.parseInt(array[0]) - 1);
        String day = array[1].replace("0", "");
        String year = array[2];
//        doClick(monthPicker);
        doSelectOnDropDownAndSelectByValue(monthPicker, month);
        doSelectOnDropDownAndSelectVisibleText(yearPicker, year);
        WebElement dayPicker =
                driver.findElement(By.xpath
                        ("(//div[@class=\"react-datepicker__week\"]//div[normalize-space()='" + day + "'])[1]"));

        doClick(dayPicker);
        return selectDateField.getAttribute("value");
    }

    public String clickOnDateTime(String dateTime) throws InterruptedException {
        String[] array = dateTime.split(" ");
        String month = array[0].trim();
        String day = array[1].replace(",", "").trim();
        String year = array[2].trim();
        String time = array[3].trim();
        doClick(monthArrow);
        WebElement monthPicker =
                driver.findElement(By.xpath("//div[normalize-space()='" + month + "']"));
        doClick(monthPicker);

        doClick(yearArrow);
        WebElement yearPicker =
                driver.findElement(By.xpath("//div[normalize-space()='" + year + "']"));
        doClick(yearPicker);
        WebElement dayPicker =
                driver.findElement(By.xpath("//div[normalize-space()='" + day + "']"));
        doClick(dayPicker);

        WebElement timePicker =
                driver.findElement(By.xpath("//li[normalize-space()='" + time + "']"));
        scrollTo(timePicker);
        doClick(timePicker);
        return dateAndTimeField.getAttribute("value");
    }
}
