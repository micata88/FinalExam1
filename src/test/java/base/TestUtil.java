package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestUtil {
    public WebDriver driver;
    private String url = "https://www.saucedemo.com/";

    @BeforeMethod
    public void SetUp(){
        setupBrowserDriver();
        loadUrl();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    private void setupBrowserDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void loadUrl(){
        driver.get(url);
    }
}
