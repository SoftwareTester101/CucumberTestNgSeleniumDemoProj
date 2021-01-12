package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.CucumberRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Interactions extends CucumberRunner {

    @FindBy(xpath = "//div[contains(@class, 'vertical-list-container')]//div")
    private List<WebElement> demoList;


    @FindBy(xpath = "//ul[@id=\"verticalListContainer\"]//li")
    private List<WebElement> verticalList;

    @FindBy(id = "demo-tab-list")
    private WebElement listLink;

    @FindBy(id = "resizableBoxWithRestriction")
    private WebElement restrictedBox;

    @FindBy(css = "div[id=\"resizableBoxWithRestriction\"] span[class=\"react-resizable-handle react-resizable-handle-se\"]")
    private WebElement restrictedBoxHandle;

    @FindBy(id = "resizable")
    private WebElement resizableBox;

    @FindBy(css = "div[id=\"resizable\"] span[class=\"react-resizable-handle react-resizable-handle-se\"]")
    private WebElement resizableBoxHandle;
    @FindBy(id = "draggable")
    private WebElement dragMe;
    @FindBy(css = "#droppable")
    private WebElement dropMe;
    @FindBy(css = "#   Dropped!")
    private WebElement Dropped;
    @FindBy(css = "#acceptable")
    private WebElement acceptable;

    @FindBy(id = "notAcceptable")
    private WebElement notAcceptable;

    @FindBy(xpath = "//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]")
    private WebElement revertDroppable;
    @FindBy(css = "#revertable")
    private WebElement revertable;
    @FindBy(xpath = "//div[@id=\"notRevertable\"]")
    private WebElement notRevertable;
    @FindBy(id = "dragBox")
    private WebElement dragBox;
    @FindBy(id = "restrictedX")
    private WebElement dragX;
    @FindBy(id = "restrictedY")
    private WebElement dragY;
    @FindBy(css = ".draggable.ui-widget-content.ui-draggable.ui-draggable-handle")
    private WebElement containedBox;
    @FindBy(css = ".ui-widget-header.ui-draggable.ui-draggable-handle")
    private WebElement containedBox2;
//    @FindBy(css = "notAcceptable")
//    private WebElement notAcceptable;

    public Interactions() {
        PageFactory.initElements(CucumberRunner.driver, this);
    }

    public void moveItemToLine(String item, String rowNum) {
        int num = Integer.parseInt(rowNum);
        WebElement dest = driver.findElement(
                By.xpath("//div[contains(@class, 'vertical-list-container')]//div['" + num + "']"));
        if (num < demoList.size()) {
            for (int i = 0; i < demoList.size(); i++) {
                if (demoList.get(i).getText().equalsIgnoreCase(item)) {
                    dragAndDropByOffset(demoList.get(i), dest);
                    pageLoad(5);
                }
            }
        }
    }

    public List<String> getTableValues() {
        List<String> list = new ArrayList();
        for (int i = 0; i < demoList.size(); i++) {
            list.add(demoList.get(i).getText());
        }
        return list;
    }

    public void replaceItemWithItem(String target, String dest) {
        for (int i = 0; i < demoList.size(); i++) {
            if (demoList.get(i).getText().equalsIgnoreCase(target)) {
                for (int j = 0; j < demoList.size(); j++) {
                    if (demoList.get(j).getText().equalsIgnoreCase(dest)) {
                        dragAndDropByOffset(demoList.get(i), demoList.get(j));
                    }
                }

            }
        }
    }

    public String selectFromList(String select) {
        String color = "";
        for (int i = 0; i < verticalList.size(); i++) {
            if (verticalList.get(i).getText().contains(select)) {
                doClick(verticalList.get(i));
                color = getColor(verticalList.get(i), "background-color");
            }
        }

        return color;

    }

    public int resizeBoxByName(String boxName, String width, String height) throws InterruptedException {
        int w = Integer.parseInt(width);
        int h = Integer.parseInt(height);
        switch (boxName) {
            case "Restricted":
                scrollTo(restrictedBox);
                resizeElementByValues(restrictedBoxHandle, w, h);
                int value = restrictedBox.getSize().getWidth();
                return value;
            case "Resizable":
                scrollTo(resizableBox);
                System.out.println(resizableBox.getSize().getWidth() + " " + resizableBox.getSize().getWidth());
                resizeElementByValues(resizableBoxHandle, w, h);
                int height1 = resizableBox.getSize().getHeight();
                System.out.println("////////////");
                System.out.println(height1 + " " + resizableBox.getSize().getWidth());
                return height1;
        }

        return 0;
    }

    public String performDragAndDrop(String target) throws AWTException {
        switch (target) {
//            case "Drop me":
//                simpleDragAndDrop(dragMe, dropMe);
//                break;
//            case "Acceptable":
//                dragAndDropUsingRobot(acceptable, dropMe);
//                break;
//            case "not Acceptable":
//                simpleDragAndDrop(notAcceptable, dropMe);
//                break;
            case "revertable":
                dragAndDropUsingRobot(acceptable, revertDroppable);

            case "notRevertable":
                dragAndDropUsingRobot(notRevertable, revertDroppable);

        }

        return doGetText(dropMe);
    }

    public void clickLinkByLinkText(String link) {
        doClick(driver.findElement(By.linkText(link)));
    }

    public String performDrag(String tab) {

        switch (tab) {
            case "Cursor":
                break;

            case "Simple":
                simpleDrag(dragBox, 181, 59);
                return dragBox.getCssValue("left");

            case "Axis":
                simpleDrag(dragX, 177, 0);
                simpleDrag(dragX, -177, 0);
                return dragX.getCssValue("left");

            case "Axis Restricted":
                simpleDrag(dragY, 0, 131);
                return dragY.getCssValue("top");

            case "Container":
                simpleDrag(containedBox, 252, 0);
                String position = containedBox.getCssValue("left")
                        + " " + containedBox.getCssValue("top");
                return position;
            case "Container2":
                simpleDrag(containedBox2, 0, 85);
                String position2 = containedBox2.getCssValue("left")
                        + " " + containedBox2.getCssValue("top");
                return position2;

        }
        return "";
    }

}
