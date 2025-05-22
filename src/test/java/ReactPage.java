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
    public void navigateReact() {
        driver.get("https://todomvc.com/");
        js.executeScript("window.scrollTo(0,411)");
        driver.findElement(By.cssSelector(".js-app-list:nth-child(1) li:nth-child(1) .link")).click();
    }

    // Navigate to the React Redux version
    public void navigateReactRedux() {
        driver.get("https://todomvc.com/");
        js.executeScript("window.scrollTo(0,411)");
        driver.findElement(By.cssSelector(".js-app-list:nth-child(1) li:nth-child(2) .link")).click();
    }

    // Navigate to the Vue.js version
    public void navigateVue() {
        driver.get("https://todomvc.com/");
        js.executeScript("window.scrollTo(0,411)");
        driver.findElement(By.cssSelector(".js-app-list:nth-child(1) li:nth-child(3) .link")).click();
    }

    //method for input...(empty string, special characters, single character input, 2,3,4)
    public void addItem(String item) {
        driver.findElement(By.id("todo-input")).click();
        driver.findElement(By.id("todo-input")).sendKeys(item);
        driver.findElement(By.id("todo-input")).sendKeys(Keys.ENTER);
    }
    //This method selects an item and marks it as complete.
    public void toggleComplete(String addedItem) {
        List<WebElement> items = driver.findElements(By.cssSelector("li[data-testid='todo-item']"));

        for (WebElement item : items) {
            WebElement label = item.findElement(By.cssSelector("label[data-testid='todo-item-label']"));
            if (label.getText().equals(addedItem)) {
                item.findElement(By.cssSelector("input.toggle")).click();
                break;
            }
        }

    }
    //Checking if the item is marked as completed.
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
    //This method clicks the clear completed.
    public void clearCompleted() {
        driver.findElement(By.className("clear-completed")).click();
    }

    public boolean checkAdded(String added) {
        List<WebElement> labels = driver.findElements(By.cssSelector("label[data-testid='todo-item-label']"));
        boolean found = false;
        for (WebElement label : labels) {
            if (label.getText().equals(added)) {

                found = true;
                break;

            }
        }
        return found;
    }
}