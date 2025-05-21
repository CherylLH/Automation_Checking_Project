import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReactPage {

    protected WebDriver driver;
    JavascriptExecutor js;

    public ReactPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Navigate to the React version
    public void navigate() {
        driver.get("https://todomvc.com/");
        js.executeScript("window.scrollTo(0,411)");
        driver.findElement(By.cssSelector(".js-app-list:nth-child(1) li:nth-child(1) .link")).click();
    }

    //method for input...(empty string, special characters, single character input, 2,3,4)
    public void AddItem(String item) {
        driver.findElement(By.id("todo-input")).click();
        driver.findElement(By.id("todo-input")).sendKeys(item);
        driver.findElement(By.id("todo-input")).sendKeys(Keys.ENTER);
    }

    public void MarkComplete(String addedItem) {
        // driver.findElement(By.cssSelector(".view")).click(); // Mark as complete
        List<WebElement> items = driver.findElements(By.cssSelector("li[data-testid='todo-item']"));

        for (WebElement item : items) {
            WebElement label = item.findElement(By.cssSelector("label[data-testid='todo-item-label']"));
            if (label.getText().equals(addedItem)) {
                item.findElement(By.cssSelector("input.toggle")).click();
                break;
            }
        }

    }

    public boolean isItemMarkedCompleted(String labelText) {
        List<WebElement> todoItems = driver.findElements(By.cssSelector("li[data-testid='todo-item']"));

        for (WebElement item : todoItems) {
            String label = item.findElement(By.cssSelector("label[data-testid='todo-item-label']")).getText();
            if (label.equals(labelText)) {
                String itemClass = item.getAttribute("class");
                return itemClass.contains("completed");
            }
        }
        return false;
    }
}