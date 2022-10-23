package page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class CloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchArea;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage searchPricingCalculator(String searchRequest) {
         new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(searchArea))
                .sendKeys(searchRequest, Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
