package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.PastebinHomePage;

public class PastenbinMain {

    private static final String PASTE_TEXT = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        new PastebinHomePage(driver)
                .openPage()
                .createNewPaste(PASTE_TEXT,PASTE_NAME)
                .browserTearDown();
    }


}
