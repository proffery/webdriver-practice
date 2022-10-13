package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;
import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeArea;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[3]/div/span/span[1]/span/span[2]")
    private WebElement syntaxContainer;

    @FindBy(xpath = "/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]")
    private WebElement bashButton;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expContainer;

    @FindBy(xpath = "/html/body/span[2]/span/span[2]/ul/li[3]")
    private WebElement tenMinButton;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPage savePaste(String pasteCode, String pasteTitleName) {

        codeArea.sendKeys(pasteCode);
        syntaxContainer.click();
        bashButton.click();
        expContainer.click();
        tenMinButton.click();
        pasteName.sendKeys(pasteTitleName);
        submitButton.click();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SearchResultsPage(driver);
    }
}
