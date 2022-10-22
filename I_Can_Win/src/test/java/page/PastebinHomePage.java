package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;
import java.time.Duration;

import static waits.CustomConditions.waitForElementLocatedBy;

public class PastebinHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
    public PastebinHomePage createNewPaste(String pasteText, String pasteName) {
        waitForElementLocatedBy(driver, By.id("postform-text"))
                .sendKeys(pasteText);
        waitForElementLocatedBy(driver, By.id("select2-postform-expiration-container"))
                .click();
        waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"))
                .click();
        waitForElementLocatedBy(driver, By.id("postform-name"))
                .sendKeys(pasteName);
        waitForElementLocatedBy(driver, By.xpath("//button[text()='Create New Paste']"))
                .click();
        return this;
    }
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
