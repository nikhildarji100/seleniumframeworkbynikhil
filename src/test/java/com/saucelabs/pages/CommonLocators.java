package com.saucelabs.pages;

import org.openqa.selenium.By;

public class CommonLocators {
	
	public static final By errorMessage 			= By.cssSelector("h3[data-test='error']");
	public static final By errorMessage_CloseButton = By.cssSelector("button[class='error-button']");

	
	public static class expectedMessages{
		public static final String passwordIsRequired = "Epic sadface: Password is required";
		public static final String usernameIsRequired = "Epic sadface: Username is required";
		public static final String usernameAndpasswordDoNotMatchAnyUser = "Epic sadface: Username and password do not match any user in this service";
	}
	
	public static final String invalidValue = "@#!Invalid@";
	public static final By cart_Link = By.cssSelector(".shopping_cart_link");
	
	public static final By checkout_Button 		   = By.id("checkout");
	public static final By continueShopping_Button = By.id("continue-shopping");
	
	
}
