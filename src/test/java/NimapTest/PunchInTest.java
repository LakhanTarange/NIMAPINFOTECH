package NimapTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PunchInTest extends LoginTest {
	 @Test(dependsOnMethods = "loginTest")
	    public void punchInTest() throws InterruptedException {
	        driver.findElement(By.xpath("//button[contains(text(),'Punch In XPath')]")).click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));

	        String toastMessage = toast.getText();
	        Assert.assertTrue(toastMessage.contains("success") || toastMessage.contains("punched"), "PunchIn toast not shown properly");
	    }
}
