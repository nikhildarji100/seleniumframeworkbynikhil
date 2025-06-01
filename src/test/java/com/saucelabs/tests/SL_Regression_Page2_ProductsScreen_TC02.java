package com.saucelabs.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucelabs.lib.WebDriverLib;
import com.saucelabs.pages.LoginScreen;
import com.saucelabs.pages.ProductScreen;

import seleniumframeworksaucelabs.utils.ConfigManager;

public class SL_Regression_Page2_ProductsScreen_TC02 extends WebDriverLib{
	String productsHeading = "Products";
	WebDriverWait wait = null ;

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		launchApplication();
	}
	
	@AfterClass
	public void afterClass() {
		if (getDriver() != null) {
	        getDriver().quit();
	    }
	}
	
	@Test(priority = 1)
	public void TC01_Verify_ProductScreen_Headig() {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GLOBAL_TIMEOUT));
		sendKeysToElement(LoginScreen.userName_Field, ConfigManager.getInstance().getUsername());
		sendKeysToElement(LoginScreen.password_Field, ConfigManager.getInstance().getPassword());
		clickOnWebElement(LoginScreen.login_Button);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductScreen.productSort_Dropdown));
		Assert.assertEquals(getWebelementText(ProductScreen.productsPage_heading), productsHeading, "Incorrect heading of the products page.");
	}
	
	@Test(priority = 2)
	public void TC02_Verify_Screen_Elements() {
		int numberOfproducts = getElements(ProductScreen.all_Products).size();
		Assert.assertTrue(numberOfproducts > 0, "Products are not displayed on the page.");
		Assert.assertEquals(getElementsCount(ProductScreen.addToCart_Button), numberOfproducts, 
		"Add to cart button is not present in all the product items.");
	}
	
	@Test(priority = 3)
	public void TC03_Verify_AddToCartButton_Functionality() throws InterruptedException {
		clickOnWebElement(ProductScreen.addToCart_Button);
		Thread.sleep(1000);
		Assert.assertTrue(isElementDisplayed(ProductScreen.cart_Badge), "Cart Badge is not displayed.");
		Assert.assertTrue(isElementDisplayed(ProductScreen.remove_button), 
		"Remove button is not displayed after clicking on Aa To Cart button.");
	}
	
	
	
	
	
	
	
}
