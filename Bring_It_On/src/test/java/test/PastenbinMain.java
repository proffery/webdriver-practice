package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PastebinHomePage;
import java.time.Duration;

public class PastenbinMain {



    public static void main(String[] args) {

        PastebinHomePage pastebinHomePage = new PastebinHomePage(new ChromeDriver())
                .openPage();
        waitForElementLocatedBy(pastebinHomePage.getDriver(), By.id("postform-text"))
                .sendKeys("Hello from WebDriver");
        waitForElementLocatedBy(pastebinHomePage.getDriver(), By.id("select2-postform-expiration-container"))
                .click();
        waitForElementLocatedBy(pastebinHomePage.getDriver(), By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"))
                .click();
        waitForElementLocatedBy(pastebinHomePage.getDriver(), By.id("postform-name"))
                .sendKeys("helloweb");
        waitForElementLocatedBy(pastebinHomePage.getDriver(), By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"))
              .click();
        pastebinHomePage.browserTearDown();

    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
