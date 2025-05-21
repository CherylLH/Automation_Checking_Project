import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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
}