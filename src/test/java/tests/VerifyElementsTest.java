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

public class VerifyElementsTest {
    private WebDriver driver;
    private final String LINK_APP = "http://the-internet.herokuapp.com/add_remove_elements/";
    private final String ADD_BUTTON = "//button[text()='Add Element']";
    private final String DELETE_BUTTON = "//button[text()='Delete']";
    private final int EXPECTED_COUNT = 1;

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);

    }
    @Test
    public void verifyElementsTest(){
        driver.get(LINK_APP);
        driver.findElement(By.xpath(ADD_BUTTON)).click();
        driver.findElement(By.xpath(ADD_BUTTON)).click();
        driver.findElement(By.xpath(DELETE_BUTTON)).click();
        int actualCount = driver.findElements(By.xpath(DELETE_BUTTON)).size();
        //System.out.println("Количество элементов: " + count);
        Assert.assertEquals(actualCount, EXPECTED_COUNT);

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
