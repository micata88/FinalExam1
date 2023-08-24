package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String url; // = "https://www.saucedemo.com/";
    private String browser;
    private  int implicitWait;

    @BeforeMethod
    public void SetUp(){
        setupBrowserDriver();
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
        switch (browser){
            case "chrome":
                createChromeDriver(url,implicitWait);
                break;
            case "edge":
                createEdgeDriver(url,implicitWait);
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");

        }
    }

    private void loadUrl(String url){
        driver.get(url);
    }
    private void createChromeDriver(String url,int implicitWait){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);

    }
    private void createEdgeDriver(String url,int implicitWait){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);

    }
}
