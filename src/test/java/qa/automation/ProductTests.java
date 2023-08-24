package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductTests extends TestUtil {
    @Test
    public void selectDifferentOrder(){
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement dropDownSortingOptions = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        dropDownSortingOptions.click();

        WebElement lowToHighPriceOptions = driver.findElement(By.cssSelector("[value='lohi']"));
        lowToHighPriceOptions.click();

    }

}