package page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import waits.CustomConditions;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement outerFrame;

    @FindBy(css = ".devsite-wrapper")
    private WebElement outerFrame1;

    @FindBy(css = "#gc-wrapper>main")
    private WebElement outerFrame2;

    @FindBy(xpath = "//descendant::md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement mainFrame;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']")
    private WebElement computerEngineFrame;
    @FindBy(css = "input[ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    public PricingCalculatorPage fillCalcForm(String instances) {
//        new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
//                .ignoring(NoSuchElementException.class);
//
//        new FluentWait<>(driver.switchTo().frame(0))
//                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
//                .ignoring(NoSuchElementException.class);
//
//        new FluentWait<>(driver.switchTo().frame(outerFrame2))
//                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
//                .ignoring(NoSuchElementException.class);

//                .until(ExpectedConditions.visibilityOf(computeEngineButton))
//                .click();

        new FluentWait<>(driver.switchTo().frame(outerFrame))
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(outerFrame));

//        computeEngineButton.click();
//        numberOfInstances.click();
//        numberOfInstances.sendKeys(instances);

        return this;
    }
}
