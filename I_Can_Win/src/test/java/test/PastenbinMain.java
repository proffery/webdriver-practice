package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastenbinMain {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        WebElement pastTextForm = waitForElementLocatedBy(driver, By.id("postform-text"));
        pastTextForm.sendKeys("Hello from WebDriver");

        WebElement formExpiration = waitForElementLocatedBy(driver, By.id("select2-postform-expiration-container"));
        formExpiration.click();

        WebElement tenMin = waitForElementLocatedBy(driver, By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
        tenMin.click();

        WebElement title = waitForElementLocatedBy(driver, By.id("postform-name"));
        title.sendKeys("helloweb");

        WebElement newPaste = waitForElementLocatedBy(driver, By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"));
        newPaste.click();

        driver.quit();
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By id) {
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.presenceOfElementLocated(id));
    }
}
