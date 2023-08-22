package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String url; // = "https://www.saucedemo.com/";
    private String browser;
    private  int implicitWait;

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
        try (FileInputStream configFile = new FileInputStream("src/test/resources/users.config.properties ")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            browser = config.getProperty("browser");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
        }catch (IOException e){
            System.out.println("Cannot read configs");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void loadUrl(){
        driver.get(url);
    }
}
