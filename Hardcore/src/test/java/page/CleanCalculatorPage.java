package page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CleanCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//md-tab-item/div[@class='tab-holder compute' and @title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//md-input-container/input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-min ng-invalid ng-invalid-required' and @name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[contains(@aria-label,'Operating')]/md-select-value/span[@class='md-select-icon']")
    private WebElement softwareOpen;

    @FindBy(xpath = "//md-option/*[contains(text(),'Free: Debian,')]")
    private WebElement softwareChoose;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']/md-select-value/span[@class='md-select-icon']")
    private WebElement regularOpen;
    @FindBy(xpath = "//md-option/div[text()='Regular']")
    private WebElement regularChoose;

    @FindBy(xpath = "//md-select[@name='series']/md-select-value/span[@class='md-select-icon']")
    private WebElement seriesOpen;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesChoose;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']/md-select-value/span[@class='md-select-icon']")
    private WebElement machineTypeOpen;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div")
    private WebElement machineTypeChoose;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGpu;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'GPU type')]")
    private WebElement gpuTypeOpen;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P100']/div")
    private WebElement gpuTypeChoose;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Number of GPUs')]")
    private WebElement numberOfGpuOpen;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value ='1']")
    private WebElement numberOfGpuChoose;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Datacenter location')]//span[@class='md-select-icon']")
    private WebElement locationOpen;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']//md-option[@value='europe-west3']")
    private WebElement locationChoose;

    @FindBy(xpath = "//div[@ng-if=\"listingCtrl.checkLocalSsdAvailibility('computeServer')\"]//md-select[starts-with(@aria-label,'Local SSD')]//span[@class='md-select-icon']")
    private WebElement ssdOpen;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer']/div[contains(text(),'2x375 GB')]")
    private WebElement ssdChoose;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Committed usage')]//span[@class='md-select-icon']")
    private WebElement usageOpen;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'1 Year')]")
    private WebElement usageChoose;

    @FindBy(xpath = "//button[starts-with(@ng-disabled,'ComputeEngineForm.$invalid')]")
    private WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost')]")
    private WebElement priceResult;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public CleanCalculatorPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    public CleanCalculatorPage fillCalcForm(String instances) {
        computeEngineButton.click();
        numberOfInstances.sendKeys(instances);
        softwareOpen.click();
        softwareChoose.click();
        regularOpen.click();
        regularChoose.click();
        seriesOpen.click();
        seriesChoose.click();
        machineTypeOpen.click();
        machineTypeChoose.click();
        locationOpen.click();
        locationChoose.click();
        addGpu.click();
        gpuTypeOpen.click();
        gpuTypeChoose.click();
        numberOfGpuOpen.click();
        numberOfGpuChoose.click();
        ssdOpen.click();
        ssdChoose.click();
        usageOpen.click();
        usageChoose.click();
        addButton.click();
        return this;
    }
    public CleanCalculatorPage sendEmail(String email) {
        emailButton.click();
        emailField.sendKeys(email);
        sendEmailButton.click();
        return this;
    }

    public PostPage switchToTab(String windowHandle) {
        driver.switchTo().window(windowHandle);
        return new PostPage(driver);
    }
    public PostPage createPostTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new PostPage(driver);
    }
    public String getPrice() {
        return priceResult.getText();
    }
}
