package NimapTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import NimapTest.bin.TestDataProvider;

public class CustomerTest extends LoginTest {
	@Test(dataProvider = "customerData", dataProviderClass = TestDataProvider.class, dependsOnMethods = "loginTest")
    public void addCustomerTest(String name, String email, String phone) {
        driver.findElement(By.linkText("Customer")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add Customer Xpath')]")).click();

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("mobile")).sendKeys(phone);
        driver.findElement(By.xpath("//button[contains(text(),'Submit Customer Xpath')]")).click();

        // Validation - search or check for success message
        boolean successToast = driver.findElements(By.className("Toastify__toast-body")).stream()
                .anyMatch(el -> el.getText().contains("success"));
        Assert.assertTrue(successToast, "Customer not added successfully");
    }
	
}
