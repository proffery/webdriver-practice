package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CleanCalculatorPage;
import page.CloudHomePage;
import page.PostPage;

import java.time.Duration;

public class CalculatorTest {
    private WebDriver driver;
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String INSTANCES = "4";

    @BeforeTest
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
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

    @AfterTest()
    public void browserTearDown() {
        driver.close();
        driver.quit();
    }

}
