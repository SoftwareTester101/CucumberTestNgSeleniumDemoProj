package runner;

import helpers.Constants;
import helpers.ReportHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.TAB;

@CucumberOptions(
        monochrome = true,
        features = "classpath:features",
        glue = {"stepdefinitions"},
        tags = "@selectBooks",
        publish = false,
        plugin = {"pretty", "html:target/cucumber.html"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final String currentDir = System.getProperty("user.dir");
    public static Properties prop;
    public static WebDriver driver;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        loadProperty();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (prop.getProperty("system").equalsIgnoreCase("mac")) {
            FileUtils.copyFile(scrFile,
                    new File(currentDir + "/screenshots/" + getPageTitleForScreenshots() + currentDateTime() + ".png"));

        } else {
            FileUtils.copyFile(scrFile,
                    new File(currentDir + "\\screenshots\\" + getPageTitleForScreenshots() + currentDateTime() + ".png"));
        }

    }

    public static Properties loadProperty() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
        prop.load(ip);
        return prop;
    }

    protected static void safeJavaScriptClick(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + Arrays.toString(e.getStackTrace()));
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + Arrays.toString(e.getStackTrace()));
        } catch (Exception e) {
            System.out.println("Unable to click on element " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static String doGetText(WebElement element) {
        return element.getText();
    }

    public static String currentDateTime() {
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmm");
        Date date = new Date();
        return df.format(date);
    }

    public static String getExactPageTitle() {
        return driver.getTitle();
    }

    public static String getPageTitleForScreenshots() {
        return driver.getTitle().replaceAll("[^0-9a-zA-Z]", "");
    }

    @BeforeClass
    public static void setup() {

    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }

    public void simpleDrag(WebElement element, int x, int y) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).moveToElement(element, x, y).build().perform();
    }

    protected void moveSlider(WebElement slide, int x, int y) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(slide).moveByOffset(x, y).release().build().perform();
    }

    protected void scrollToTheEndOfPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void doSelectOnDropDownAndSelectVisibleText(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    protected void selectRadioBttns(List<WebElement> radioBttns, String value) {
        String[] array = value.split(",");
        for (WebElement radioBttn : radioBttns) {
            for (String s : array) {
                if (radioBttn.isDisplayed() && !radioBttn.isSelected()) {
                    if (radioBttn.getText().equalsIgnoreCase(s)) {
                        doClick(radioBttn);
                    }
                }

            }

        }
    }

    protected void selectAllOptions(WebElement dropdown, String value) {
        String[] array = value.split(",");
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        Actions actions = new Actions(driver);
        for (WebElement we : options) {
            for (String str : array) {
                if (we.getText().equalsIgnoreCase(str)) {
                    actions.keyDown(Keys.LEFT_CONTROL)
                            .click(we)
                            .keyUp(Keys.LEFT_CONTROL)
                            .build()
                            .perform();
                }
            }
        }
    }

    protected void doSelectOnDropDownAndSelectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void doSendTabKey(WebElement element) {
        element.sendKeys(TAB);
    }

    public void doClick(WebElement element) {
        element.click();
    }

    public void doClear(WebElement element) {
        element.clear();
    }

    public void dragAndDropByOffset(WebElement target, WebElement dest) {
        Actions actions = new Actions(driver);
        actions.click(target).clickAndHold().moveToElement(dest).moveByOffset(0, 5).release().build().perform();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getColor(WebElement element, String propertyName) {
        String color = element.getCssValue(propertyName);
        String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);
        return String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
    }

    public void resizeElementByValues(WebElement element, int width, int height) {
        if (element.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.clickAndHold(element).moveByOffset(width, height).release().build().perform();
        }
    }

    public void simpleDragAndDrop(WebElement target, WebElement dest) {
        if (target.isDisplayed() && dest.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(target, dest).build().perform();
        }
    }

    public void dragAndDropUsingRobot(WebElement target, WebElement dest) throws AWTException {
        if (target.isDisplayed() && dest.isDisplayed()) {
            new Actions(driver).dragAndDrop(target, dest).release().build().perform();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }

    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isDisabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public void doSendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void DoRightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }

    public void doDoubleClick(WebElement element) {
        try {
            Actions action = new Actions(driver).doubleClick(element);
            action.build().perform();

            System.out.println("Double clicked the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + Arrays.toString(e.getStackTrace()));
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + Arrays.toString(e.getStackTrace()));
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + Arrays.toString(e.getStackTrace()));
        }
    }

    public void hoverOverLinkByListOfWebElem(List<WebElement> list, String linkName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(linkName)) {
                hoverOver(list.get(i));
            }
        }
    }

    public Boolean foundLinkFromListOfLinks(List<WebElement> list, String linkName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().contentEquals(linkName)) {
                return true;
            }
        }
        return false;
    }

    public void hoverOver(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).pause(1).perform();
            System.out.println("Done Mouse hover on " + doGetText(element) + " " + element.getTagName());
        }
    }

    public void waitUntilClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilSelectable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void switchToActiveTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToDefaultTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


    public void switchToChildWindow() {
        String mainWindow = driver.getWindowHandle();
        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    public String getTextUsingJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].text", element);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void switchToDefaultWindow() {
        driver.switchTo().defaultContent();
    }

    public void switchToFrameById(String id) {
        driver.switchTo().frame(id);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void scrollSideBarOnFrame() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public String getTextFromFrameByFrameNum(List<WebElement> list, int num) {
        String value = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == num - 1) {
                value = list.get(i).getText();
            }
        }

        return value;
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void waitTillAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void sendKeysToAlert(String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public void scrollTo(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public void scrollABitDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 450)");
    }

    public String openLinkOnANewTab(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        switchToActiveTab();
        return driver.getTitle();
    }

    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element);
    }

    public void driverPath() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            String chromeDriverPath = currentDir + "//Drivers//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
    }

    public void InitDriver() throws Exception {
        loadProperty();
        driverPath();
        if (prop.getProperty("browserType").equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browserType").equals("chrome")) {
            driver = new ChromeDriver();
        }
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void setEnv() throws IOException {
        loadProperty();
        driver.get(prop.getProperty("url"));
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        InitDriver();
        maximizeWindow();
        implicitWait(Constants.IMPLICITLY_WAIT);
        deleteAllCookies();
    }

    @BeforeMethod
    public void openBrowser() throws IOException {
        setEnv();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            loadProperty();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            if (prop.getProperty("system").equalsIgnoreCase("mac")) {
                FileUtils.copyFile(scrFile,
                        new File(currentDir + "/failure_images/" + getPageTitleForScreenshots() + currentDateTime()
                                + ".png"));

            } else {
                FileUtils.copyFile(scrFile,
                        new File(currentDir + "\\failure_images\\" + getPageTitleForScreenshots() + currentDateTime()
                                + ".png"));
            }

        }
    }

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() {
        ReportHelper.generateCucumberReport();
        driver.quit();
    }

    public void switchToFrameByNumber(List<WebElement> frames, int num) {
        for (int i = 0; i < frames.size(); i++) {
            if (i == num - 1) {
                driver.switchTo().frame(i);
            }
        }

    }

    public void switchToActiveElement() {
        driver.switchTo().activeElement();
    }
}


