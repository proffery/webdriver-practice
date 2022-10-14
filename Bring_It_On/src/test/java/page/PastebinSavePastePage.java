package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinSavePastePage extends PastebinAbstractPage {

    @FindBy(css = ".left > .h_800")
    private WebElement bashText;

    @FindBy(xpath = "//li/div")
    private WebElement codeAreaOne;

    @FindBy(xpath = "//li[2]/div")
    private WebElement codeAreaTwo;

    @FindBy(xpath = "//li[3]/div")
    private WebElement codeAreaThree;

    public PastebinSavePastePage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected PastebinAbstractPage openPage() {
        throw new RuntimeException();
    }
    public String pasteTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(bashText));
        return driver.getTitle();
    }

    public String pasteCode() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(codeAreaThree));
        return codeAreaOne.getText() + "\n" +
                codeAreaTwo.getText() + "\n" +
                codeAreaThree.getText();
    }

    public String pasteBash() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(bashText));
        return bashText.getText();
    }
}
