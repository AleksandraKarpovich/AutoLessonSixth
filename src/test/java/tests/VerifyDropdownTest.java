package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyDropdownTest {
    private WebDriver driver;
    private final String LINK_APP = "http://the-internet.herokuapp.com/dropdown";
    private final String DROPDOWN_ID = "dropdown";
    private final String FIRST_OPTION = "Option 1";
    private final String SECOND_OPTION = "Option 2";

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void verifySelectedFirstOptionTest(){
        driver.get(LINK_APP);
        Select select = new Select(driver.findElement(By.id(DROPDOWN_ID)));
        select.selectByVisibleText(FIRST_OPTION);
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, FIRST_OPTION);
    }

    @Test
    public void verifySelectedSecondOptionTest(){
        driver.get(LINK_APP);
        Select select = new Select(driver.findElement(By.id(DROPDOWN_ID)));
        select.selectByVisibleText(SECOND_OPTION);
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, SECOND_OPTION);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
