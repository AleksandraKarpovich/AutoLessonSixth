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

public class VerifyCheckboxesTest {
    private WebDriver driver;
    private final String LINK_APP = "http://the-internet.herokuapp.com/checkboxes";
    private final String CHECKBOX = "[type=checkbox]";

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void verifyFirstCheckboxUncheckedTest(){
        driver.get(LINK_APP);
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX)).get(0).isSelected();
        Assert.assertFalse(isSelectedCheckbox, "Ошибка: Чекбокс выбран");
    }
    @Test
    public void verifyFirstCheckboxCheckedTest(){
        driver.get(LINK_APP);
        driver.findElements(By.cssSelector(CHECKBOX)).get(0).click();
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX)).get(0).isSelected();
        Assert.assertTrue(isSelectedCheckbox, "Ошибка: Чекбокс не выбран");
    }
    @Test
    public void verifySecondCheckboxCheckedTest(){
        driver.get(LINK_APP);
        boolean notCheckboxSelected = driver.findElements(By.cssSelector(CHECKBOX)).get(1).isSelected();
        //System.out.println(notCheckboxSelected);
        Assert.assertTrue(notCheckboxSelected, "Ошибка: Чекбокс не выбран");
    }
    @Test
    public void verifySecondCheckboxUnсheckedTest(){
        driver.get(LINK_APP);
        driver.findElements(By.cssSelector(CHECKBOX)).get(1).click();
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX)).get(1).isSelected();
        //System.out.println(notCheckboxSelected);
        Assert.assertFalse(isSelectedCheckbox, "Ошибка: Чекбокс выбран");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
