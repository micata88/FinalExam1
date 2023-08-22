package qa.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {
    private WebDriver driver;
    @BeforeTest
    public void initiallizeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void successfullLoginTest(){
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement userMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userMenuButton.isDisplayed(),"This shall be visible after successfull Login");



    }
}
