package page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;
import java.time.Duration;
import java.util.function.Function;

public class CloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchArea;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
//        new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(5L))
//                .ignoring(NoSuchElementException.class)
//                .until(ExpectedConditions.visibilityOf(searchArea));

//        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .until(CustomConditions.jQueryAJAXsCompleted());
//        try {
//            Thread.sleep(5000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return this;
    }

    public SearchResultsPage searchPricingCalculator(String searchRequest) {
         new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                 .until(ExpectedConditions.visibilityOf(searchArea))
                 .sendKeys(searchRequest);

        searchArea.sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }
}
