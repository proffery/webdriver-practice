package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.CleanCalculatorPage;
import page.CloudHomePage;

public class CalculatorTest {
    private WebDriver driver;
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String MANUAL_PRICE = "4,024.56";
    private static final String INSTANCES = "4";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String REGION = "Frankfurt";
    private static final String LOCAL_SSD = "2x375 GiB";
    private static final String COMMITMENT_TERM = "1 Year";
    @BeforeSuite
    public void browserSetup() {
        driver = new FirefoxDriver();
    }

    @Test (priority = 1)
    public void price() {
        Assert.assertTrue(new CloudHomePage(driver)
                .openPage()
                 .searchPricingCalculator(SEARCH_REQUEST)
                 .openCalcPage()
                 .redirectionToActualFrame()
                 .fillCalcForm(INSTANCES)
                .getPrice()
                .contains(MANUAL_PRICE));
    }

    @Test (priority = 2)
    public void vmClass() {
        Assert.assertTrue(fieldCompare(VM_CLASS));
    }
    @Test (priority = 3)
    public void instanceType() {
        Assert.assertTrue(fieldCompare(INSTANCE_TYPE));
    }
    @Test (priority = 4)
    public void region() {
        Assert.assertTrue(fieldCompare(REGION));
    }
    @Test (priority = 5)
    public void localSsd() {
        Assert.assertTrue(fieldCompare(LOCAL_SSD));
    }
    @Test (priority = 6)
    public void commitmentTerm() {
        Assert.assertTrue(fieldCompare(COMMITMENT_TERM));
    }
    private boolean fieldCompare(String param) {
        for (String value:new CleanCalculatorPage(driver).fieldsResults()) {
           if (value.contains(param)) {
               return true;
           }
        }
        return false;
    }

    @AfterSuite()
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
