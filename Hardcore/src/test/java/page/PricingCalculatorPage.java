package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class PricingCalculatorPage extends AbstractPage {
    private static final String IFRAME_LINKS = "//iframe[@src]";
    private static final String FRAME_PATTERN_ONE = "https://cloud.google.com/products/calculator/";
    private static final String FRAME_PATTERN_TWO = "https://cloudpricingcalculator.appspot.com";
    private static final String LINC_ATTRIBUTE = "src";


    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    public CleanCalculatorPage redirectionToActualFrame() {
        new WebDriverWait(driver, Duration.ofSeconds( WAIT_TIMEOUT_SECONDS));
        driver.navigate().to(actualLincFrame(FRAME_PATTERN_ONE));
        new WebDriverWait(driver, Duration.ofSeconds( WAIT_TIMEOUT_SECONDS));
        driver.navigate().to(actualLincFrame(FRAME_PATTERN_TWO));
        return new CleanCalculatorPage(driver);
    }
    private String actualLincFrame(String pattern) {
        String url = null;
        List<WebElement> src = driver.findElements(By.xpath(IFRAME_LINKS));
        List<String> links = new ArrayList<>();
        for (WebElement webElement : src) {
            links.add(webElement.getAttribute(LINC_ATTRIBUTE));
        }
        for (String link : links) {
            if (link.startsWith(pattern)) {
                url = link;
            }
        }
        return url;
    }
}
