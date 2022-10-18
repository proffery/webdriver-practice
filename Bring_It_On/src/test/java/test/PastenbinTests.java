package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.PastebinHomePage;
import page.PastebinSavePastePage;

import java.lang.module.Configuration;

public class PastenbinTests {
    private WebDriver driver;
    private static final String PASTE_CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                             "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                             "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";

    @BeforeSuite
    public void browserSetup() {
        driver = new FirefoxDriver();
    }

    @Test (priority = 1)
    public void pasteTitleCompare() {
        Assert.assertEquals(new PastebinHomePage(driver)
                .openPage()
                .savePaste(PASTE_CODE, PASTE_NAME)
                .pasteTitle()
                .substring(0, PASTE_NAME.length()), PASTE_NAME);

    }
    @Test (priority = 2)
    public void pasteBashExistance() {
        Assert.assertEquals(new PastebinSavePastePage(driver).pasteBash(), "Bash");
    }

    @Test (priority = 3)
    public void pasteCodeCompare() {
        Assert.assertEquals(new PastebinSavePastePage(driver).pasteCode(), PASTE_CODE);
    }

    @AfterSuite()
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
