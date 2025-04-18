package NimapTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import NimapTest.bin.TestDataProvider;

public class LoginTest extends BaseTest {
	 @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	    public void loginTest(String email, String password) {
	        driver.get("https://testffc.nimapinfotech.com/");
	        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(email);
	        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys(password);
	        driver.findElement(By.xpath("//*[@id=\"kt_login_signin_submit\"]")).click();

	        // Validation - Check for Dashboard or Logout element
	        boolean isLoggedIn = driver.findElements(By.xpath("//*[contains(text(),'Dashboard Xpath')]")).size() > 0;
	        Assert.assertTrue(isLoggedIn, "Login failed!");
	    }
}
