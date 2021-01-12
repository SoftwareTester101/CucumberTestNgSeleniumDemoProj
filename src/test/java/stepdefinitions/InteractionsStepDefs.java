package stepdefinitions;

import io.cucumber.java.en.Then;
import pageobjects.Interactions;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InteractionsStepDefs {
    Interactions interactions;


    public InteractionsStepDefs() {
        this.interactions = new Interactions();
    }


    @Then("I move the item {string} to line {string}")
    public void iMoveTheItemToLine(String item, String num) {
        this.interactions.moveItemToLine(item, num);
    }


    @Then("I verify the items in the sorted table as {string}")
    public void iVerifyTheItemsInTheSortedTableAs(String str) {
        String[] array = str.split(",");
        List<String> sortedTableValues = this.interactions.getTableValues();
        assertThat(sortedTableValues.toArray()).isEqualTo(array);
    }

    @Then("I replace the item {string} with item {string}")
    public void iReplaceTheItemWithItem(String target, String dest) {
        this.interactions.replaceItemWithItem(target, dest);

    }

    @Then("I select the {string} from the list")
    public void iSelectTheFromTheList(String select) {
        String actual = this.interactions.selectFromList(select);
        assertThat(actual).isEqualTo("#007bff");
    }

    @Then("I resize the {string} box width to {string} and height to {string}")
    public void iResizeTheBoxWidthToAndHeightTo(String boxName, String width, String height) throws InterruptedException {
        int actual = this.interactions.resizeBoxByName(boxName, width, height);
        switch (boxName) {
            case "Restricted":
                assertThat(actual).isEqualTo(500);
                break;
            case "Resizable":
                assertThat(actual).isEqualTo(568);
                break;
        }
    }

    @Then("I drag the {string} to the {string}")
    public void iDragTheToThe(String target, String expected) throws AWTException {
        String status = this.interactions.performDragAndDrop(target);
        if (!target.contains("not")) {
            assertThat(status).isEqualTo(expected);
        } else {
            assertThat(status).isNotEqualTo(expected);
        }

    }

    @Then("I click on the {string} link on the droppable page")
    public void iClickOnTheLinkOnTheDroppablePage(String link) {
        this.interactions.clickLinkByLinkText(link);
    }

    @Then("I drag the {string} to the {string} on  the {string} tab")
    public void iDragTheToTheOnTheTab(String target, String expected, String arg2) throws AWTException {
        String status = this.interactions.performDragAndDrop(target);
        assertThat(status).isEqualTo(expected);
    }

    @Then("I drag the {string} on the {string} tab")
    public void iDragTheOnTheTab(String target, String tab) {
        String status = this.interactions.performDrag(tab);
        switch (tab) {
            case "Cursor":
                assertThat(status).isEqualTo("181px");
                break;
            case "Simple":
                assertThat(status).isEqualTo("181px");
                break;
            case "Axis":
                assertThat(status).isEqualTo("0px");
                break;
            case "Axis Restricted":
                assertThat(status).isEqualTo("131px");
                break;
            case "Container":
                assertThat(status).isEqualTo("252px 0px");
                break;
            case "Container2":
                assertThat(status).isEqualTo("0px 85px");
                break;

        }
    }
}
