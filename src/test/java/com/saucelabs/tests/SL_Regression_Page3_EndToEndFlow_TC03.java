package com.saucelabs.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucelabs.lib.WebDriverLib;
import com.saucelabs.pages.CheckoutCompleteScreen;
import com.saucelabs.pages.CheckoutScreen;
import com.saucelabs.pages.CommonLocators;
import com.saucelabs.pages.ProductScreen;
import com.saucelabs.utils.Excel_Utils;

public class SL_Regression_Page3_EndToEndFlow_TC03 extends WebDriverLib{
	WebDriverWait wait = null;
	
	String firstName 		= Excel_Utils.getInputdata("EndtoEndFlow", "firstName");
	String lastName 		= Excel_Utils.getInputdata("EndtoEndFlow", "lastName");
	String postalCode 		= Excel_Utils.getInputdata("EndtoEndFlow", "postalCode");
	
	String expectedConfirmationMessage = "Thank you for your order!";

	@BeforeClass
	public void beforeClass()  {
		application_Login();
	}
	
	@AfterClass
	public void afterClass() {
		if (getDriver() != null) {
	        getDriver().quit();
	    }
	}
	
	@Test(priority = 1)
	public void TC01_Verify_Succesful_Order_Placement() throws InterruptedException {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GLOBAL_TIMEOUT));
		clickOnWebElement(ProductScreen.addToCart_Button);
		Thread.sleep(1000);
		clickOnWebElement(CommonLocators.cart_Link);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CommonLocators.checkout_Button));
		clickOnWebElement(CommonLocators.checkout_Button);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutScreen.firstName_Field));
		sendKeysToElement(CheckoutScreen.firstName_Field, firstName);
		sendKeysToElement(CheckoutScreen.lastName_Field, lastName);
		sendKeysToElement(CheckoutScreen.zipPostalCode_Field, postalCode);
		clickOnWebElement(CheckoutScreen.continue_Button);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(CheckoutScreen.firstName_Field));
		clickOnWebElement(CheckoutScreen.finish_Button);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutCompleteScreen.backHome_button));
		Assert.assertEquals(getWebelementText(CheckoutCompleteScreen.confirmation_Message), expectedConfirmationMessage, 
		"Order is not placed succesfully.");
	}

}
