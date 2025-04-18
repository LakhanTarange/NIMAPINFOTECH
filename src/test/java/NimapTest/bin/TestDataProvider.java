package NimapTest.bin;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	 @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        return new Object[][] {
	            {"siddiqshaikh1@nimapinfotech.com", "admin@123"}
	        };
	    }

	    @DataProvider(name = "customerData")
	    public Object[][] getCustomerData() {
	        return new Object[][] {
	            {"Test Customer1", "customer1@ex.com", "9176543210"}
	        };
	    }
}
