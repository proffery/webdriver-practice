package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchResultsPage extends AbstractPage {

    @FindBy(css = ".left > .h_800")
    private WebElement bashText;

    @FindBy(xpath = "//li/div")
    private WebElement codeAreaOne;

    @FindBy(xpath = "//li[2]/div")
    private WebElement codeAreaTwo;

    @FindBy(xpath = "//li[3]/div")
    private WebElement codeAreaThree;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
    public String pasteTitle() {
        return driver.getTitle();
    }

    public String pasteCode() {
        return codeAreaOne.getText() + "\n" +
                codeAreaTwo.getText() + "\n" +
                codeAreaThree.getText();
    }

    public String pasteBash() {
        return bashText.getText();
    }
}
