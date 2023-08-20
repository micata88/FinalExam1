package qa.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {
    private WebDriver driver;
    @BeforeTest
    public void initiallizeDriver(){
        driver = new ChromeDriver();

    }
    @Test
    public void successfullLoginTest(){
        driver.get("https://www.saucedemo.com/");

    }
}
