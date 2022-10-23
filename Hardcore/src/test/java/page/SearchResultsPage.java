package page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator' and @class='gs-title']")
    private WebElement calcInResults;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
    public PricingCalculatorPage openCalcPage() {

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(calcInResults))
                .click();
        return new PricingCalculatorPage(driver);
    }

}
