package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class VerifyTyposTest {
    private WebDriver driver;
    private final String LINK_APP = "http://the-internet.herokuapp.com/typos";
    private final String TAG = "p";
    private final String PATTERN = "Sometimes you'll see a typo, other times you won't.";

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void verifyTyposTest(){
        driver.get(LINK_APP);
        for(int i = 0; i < 100; i++) {
            String actualText = driver.findElements(By.tagName(TAG)).get(1).getText();
            if (actualText.equals(PATTERN)){
                Assert.assertEquals(actualText, PATTERN);
                break;
            } else driver.navigate().refresh();
        }
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
