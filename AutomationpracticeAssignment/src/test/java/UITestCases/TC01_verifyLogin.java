package UITestCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.ProductDetails;
import testBase.TestBase;

public class TC01_verifyLogin extends TestBase {

	HomePage homepage;
	ProductDetails productDetails;

	@BeforeTest
	public void setUp() throws IOException {
		init();
	}

	@Test(priority = 1)
	public void VerifyRegistration() throws InterruptedException {
		homepage = new HomePage(driver);
		try {
			homepage.register("zxzxff24334122@gmail.com", "shivaji", "ghadage", "12345", "Abc Street", "Vashi", "Texas",
					"12345", "9876543210");
			Assert.assertEquals("shivaji ghadage", homepage.sucessfulUser());
		} catch (AssertionError e) {
			getScreenShot("VerifyRegistration");
		}
	}

	@Test(priority = 2)
	public void VerifySignIn() throws InterruptedException {
		try {
			homepage.login("zxzxff24334122@gmail.com", "12345");
			Assert.assertEquals("shivaji ghadage", homepage.sucessfulUser());
		} catch (AssertionError e) {
			getScreenShot("VerifySignIn");
		}
	}

	@Test(priority = 3)
	public void selectProduct() {
		productDetails = new ProductDetails(driver);
		productDetails.clickOnWomenSection();
		productDetails.selectProduct();
	}
}
