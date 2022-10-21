package page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PastebinHomePage extends PastebinAbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeArea;

    @FindBy(xpath = "//label[text()='Syntax Highlighting:']/..//span[@role='presentation']")
    private WebElement bashOpen;

    @FindBy(xpath = "//strong[text()='------ POPULAR LANGUAGES -------']/..//li[text()='Bash']")
    private WebElement bashChoose;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement tenMinOpen;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinChoose;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }

    public PastebinSavePastePage savePaste(String pasteCode, String pasteTitleName) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(codeArea))
                .sendKeys(pasteCode);

        bashOpen.click();
        bashChoose.click();
        tenMinOpen.click();
        tenMinChoose.click();
        pasteName.sendKeys(pasteTitleName);
        submitButton.click();

        return new PastebinSavePastePage(driver);
    }
}
