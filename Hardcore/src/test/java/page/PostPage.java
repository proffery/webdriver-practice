package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PostPage extends AbstractPage{
    private static final String POST_PAGE_URL = "https://yopmail.com/en/";
    private static final String POST_FRAME = "ifmail";
    @FindBy (xpath = "//div[@class='txtlien']/b[contains(text(),'Random')]")
    private WebElement randomEmail;
    @FindBy (xpath = "//div[@id='egen']")
    private WebElement getEmail;

    @FindBy (xpath = "//button/span[text()='Check Inbox']")
    private WebElement checkInboxButton;

    @FindBy (xpath = "//button[@id='refresh']")
    private WebElement refreshButton;

    @FindBy (xpath = "//td/*[starts-with(text(),'USD')]")
    private WebElement costFromMail;

    private final By inboxIframe = By.xpath("//iframe[@id='ifinbox']");
    public PostPage(WebDriver driver) {
        super(driver);

    }
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
    public PostPage goToPostPage() {
        driver.navigate().to(POST_PAGE_URL);
        return this;
    }

    public String getPriceFromEmail() {
        checkInboxButton.click();
        refreshButton.click();
        while (true) {
            if (!driver.findElement(inboxIframe).isDisplayed()) {
                driver.switchTo().defaultContent();
                refreshButton.click();
            }
            else {
                driver.switchTo().defaultContent();
                break;
            }
        }
        return new FluentWait<>(driver.switchTo().frame(POST_FRAME))
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(costFromMail)).getText();
    }

    public String getEmail() {
        randomEmail.click();
        return getEmail.getText();
    }

    public CleanCalculatorPage switchToTab(String windowHandle) {
        driver.switchTo().window(windowHandle);
        return new CleanCalculatorPage(driver);
    }
}
