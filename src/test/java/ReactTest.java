import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ReactTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    // TC-001: Add a new todo item with valid text.
    // Verify the item appears in the todo list.
    @Test

    public void test1AddValidTodo() {
        ReactPage reactPage = new ReactPage(driver);
        reactPage.navigate();
        reactPage.AddItem("Buy Milk");
        List<WebElement> labels = driver.findElements(By.cssSelector("label[data-testid='todo-item-label']"));
        boolean found = false;
        for (WebElement label : labels) {
            if (label.getText().equals("Buy Milk")) {

                found = true;
                break;

            }


        }
        assertTrue(found);


    }
    // TC-002: Reject empty input.
    // Verify that submitting an empty input does not add a todo item.
    @Test

    public void test2RejectEmpty() {
        ReactPage reactPage = new ReactPage(driver);
        reactPage.navigate();
        reactPage.AddItem("");
        List<WebElement> labels = driver.findElements(By.cssSelector("label[data-testid='todo-item-label']"));
        boolean found = false;
        for (WebElement label : labels) {
            if (label.getText().isEmpty()) {

                found = true;
                break;

            }


        }
        assertFalse(found);
    }
    // TC-003: Accept special characters.
    // Verify that a todo with special characters (e.g., @, #, $, %) can be added.
    @Test

    public void test3SpecialChars() {
        ReactPage reactPage = new ReactPage(driver);
        reactPage.navigate();
        reactPage.AddItem("!!@£$");
        List<WebElement> labels = driver.findElements(By.cssSelector("label[data-testid='todo-item-label']"));
        boolean found = false;
        for (WebElement label : labels) {
            if (label.getText().equals("!!@£$")) {

                found = true;
                break;

            }


        }
        assertTrue(found);
    }

    // TC-004: Accept single-character input.
    // Verify that a todo item with a single character is accepted and displayed.
    @Test

    public void test4SingleChar() {
        ReactPage reactPage = new ReactPage(driver);
        reactPage.navigate();
        reactPage.AddItem("C");
        List<WebElement> labels = driver.findElements(By.cssSelector("label[data-testid='todo-item-label']"));
        boolean found = false;
        for (WebElement label : labels) {
            if (label.getText().equals("C")) {

                found = true;
                break;

            }


        }
        assertFalse(found);
    }

    @Test
    public void test5MarkComplete() {
        ReactPage reactPage = new ReactPage(driver);
        reactPage.navigate();
        String addedItem = "Buy milk";
        reactPage.AddItem(addedItem);
        reactPage.MarkComplete(addedItem);
        boolean found = reactPage.isItemMarkedCompleted("Buy milk");
        assertTrue(found);
    }
}


    // TC-002: Reject empty input.
    // Verify that submitting an empty input does not add a todo item.

    // TC-003: Accept special characters.
    // Verify that a todo with special characters (e.g., @, #, $, %) can be added.

    // TC-004: Accept single-character input.
    // Verify that a todo item with a single character is accepted and displayed.

    // TC-008: Mark single item as complete.
    // Add a new item, then mark it as completed, and verify it shows as completed.

    // TC-009: Unmark completed item.
    // Mark an item as completed, then unmark it, and verify it's shown as active again.

    // TC-011: Clear completed items.
    // Add and complete one or more items, then clear them and verify they are removed from the list.

    // TC-018: Verify framework isolation.
    // Ensure that the data created or manipulated in the React version is not shared with or affecting any other framework version (e.g., Vue).



