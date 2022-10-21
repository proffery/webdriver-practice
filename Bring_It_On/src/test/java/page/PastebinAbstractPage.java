package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PastebinAbstractPage {
    protected WebDriver driver;
    protected abstract PastebinAbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int POLLING_TIMEOUT_SECONDS = 2;
    public PastebinAbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
