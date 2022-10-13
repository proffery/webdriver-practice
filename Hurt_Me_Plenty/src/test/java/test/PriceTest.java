package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.CloudHomePage;

public class PriceTest {
    private WebDriver driver;
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String MANUAL_PRICE = "1,081.20";

    @BeforeSuite
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void priceCompare() {
        new CloudHomePage(driver).openPage()
                .searchPricingCalculator(SEARCH_REQUEST);
//        Assert.assertEquals(new CloudHomePage(driver)
//                .openPage()
//                .savePaste(SEARCH_REQUEST)
//                .pasteTitle()
//                .substring(0, MANUAL_PRICE.length()), MANUAL_PRICE);

    }

    @AfterSuite()
    public void browserTearDown() {
//        try {
//            Thread.sleep(5000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.quit();
        driver = null;
    }

}
