package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.CleanCalculatorPage;
import page.CloudHomePage;
import page.PostPage;

public class CalculatorTest {
    private WebDriver driver;
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String INSTANCES = "4";

    @BeforeSuite
    public void browserSetup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void price() {
        String calcPageWindow = driver.getWindowHandle();
        String postEmail = new CloudHomePage(driver)
                .openPage()
                .searchPricingCalculator(SEARCH_REQUEST)
                .openCalcPage()
                .redirectionToActualFrame()
                .fillCalcForm(INSTANCES)
                .createPostTab()
                .goToPostPage()
                .getEmail();
        String postPageWindow = driver.getWindowHandle();
        String costOnPage = new PostPage(driver).switchToTab(calcPageWindow).sendEmail(postEmail).getPrice();
        String costInMail = new CleanCalculatorPage(driver).switchToTab(postPageWindow).getPriceFromEmail();
        Assert.assertTrue(costOnPage.contains(costInMail));
    }

    @AfterSuite()
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
