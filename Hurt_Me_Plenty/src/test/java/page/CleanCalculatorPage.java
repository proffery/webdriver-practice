package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CleanCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//md-tab-item/div[@class='tab-holder compute' and @title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//md-input-container/input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-min ng-invalid ng-invalid-required' and @name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[contains(@aria-label,'Operating')]/md-select-value/span[@class='md-select-icon']")
    private WebElement softwareOpen;

    @FindBy(xpath = "//md-option/*[contains(text(),'Free: Debian,')]")
    private WebElement softwareChoise;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']/md-select-value/span[@class='md-select-icon']")
    private WebElement regularOpen;
    @FindBy(xpath = "//md-option/div[text()='Regular']")
    private WebElement regularChoise;

    @FindBy(xpath = "//md-select[@name='series']/md-select-value/span[@class='md-select-icon']")
    private WebElement seriesOpen;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesChoise;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']/md-select-value/span[@class='md-select-icon']")
    private WebElement machineTypeOpen;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div")
    private WebElement machineTypeChoise;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGpu;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'GPU type')]")
    private WebElement gpuTypeOpen;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P100']/div")
    private WebElement gpuTypeChoise;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Number of GPUs')]")
    private WebElement numberOfGpuOpen;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value ='1']")
    private WebElement numberOfGpuChoise;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Datacenter location')]//span[@class='md-select-icon']")
    private WebElement locationOpen;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']//md-option[@value='europe-west3']")
    private WebElement locationChoise;

    @FindBy(xpath = "//div[@ng-if=\"listingCtrl.checkLocalSsdAvailibility('computeServer')\"]//md-select[starts-with(@aria-label,'Local SSD')]//span[@class='md-select-icon']")
    private WebElement ssdOpen;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer']/div[contains(text(),'2x375 GB')]")
    private WebElement ssdChoise;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Committed usage')]//span[@class='md-select-icon']")
    private WebElement usageOpen;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'1 Year')]")
    private WebElement usageChoise;

    @FindBy(xpath = "//button[starts-with(@ng-disabled,'ComputeEngineForm.$invalid')]")
    private WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost')]")
    private WebElement priceResult;

    private static final String FIELDS_COMPARE_RESULT = "//md-list-item/div[starts-with(@class,'md-list-item-text ng-binding')]";

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
        softwareChoise.click();
        regularOpen.click();
        regularChoise.click();
        seriesOpen.click();
        seriesChoise.click();
        machineTypeOpen.click();
        machineTypeChoise.click();
        locationOpen.click();
        locationChoise.click();
        addGpu.click();
        gpuTypeOpen.click();
        gpuTypeChoise.click();
        numberOfGpuOpen.click();
        numberOfGpuChoise.click();
        ssdOpen.click();
        ssdChoise.click();
        usageOpen.click();
        usageChoise.click();
        addButton.click();
        return this;
    }
    public String getPrice() {
        return priceResult.getText();
    }
    public List<String> fieldsResults() {
        List<WebElement> resultElems = driver.findElements(By.xpath(FIELDS_COMPARE_RESULT));
        List<String> fields = new ArrayList<>();
        for (WebElement webElement : resultElems) {
            fields.add(webElement.getText());
        }
        return fields;
    }
}
