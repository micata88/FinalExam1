package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;

import java.io.IOException;

public class LoginTest extends TestUtil {

    @DataProvider(name = "wrongUserName")
    public Object [][] getWrongUsers(){
        return new  Object[][]{
                {"adriana22","secret_sauce"},
                {"standard_user","petya84"},
                {"blah","blah"},
                {"","secret_sauce"},
        };
    }

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/users.csv");
    }

    @Test(dataProvider = "wrongUserName" )
    public void unsuccessfullyLogin(String userName, String password){
 //       driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorLoginText = driver.findElement(By.xpath("//*[text()='Epic sad-face: Username and password do not match any user in this service']"));

        Assert.assertTrue(errorLoginText.isDisplayed());
    }
    @Test(dataProvider = "csvUserList")
    public void SuccessfullyLogin(String userName, String password){
  //    driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement userMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userMenuButton.isDisplayed(),"This shall be visible after successfully Login");
    }
}
