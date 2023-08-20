package qa.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    }
}
