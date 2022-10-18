package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyInputsTest {

    private WebDriver driver;
    private final String LINK_APP = "http://the-internet.herokuapp.com/inputs";
    private final String INPUT = "input";

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void verifyInputNumbersTest(){
        driver.get(LINK_APP);
        driver.findElement(By.tagName(INPUT)).click();
        driver.findElement(By.tagName(INPUT)).sendKeys(Keys.ARROW_UP);
        String enteredNumbers = driver.findElement(By.tagName(INPUT)).getAttribute("value");
        Assert.assertEquals(enteredNumbers, "1");
    }

    @Test
    public void verifyInputSymbolsTest(){ // ! не дает возможности ввести текст
        driver.get(LINK_APP);
        driver.findElement(By.tagName(INPUT)).sendKeys("test");
        String enteredSymbols = driver.findElement(By.tagName(INPUT)).getAttribute("value");
        Assert.assertEquals(enteredSymbols, "");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
