package com.saucelabs.pages;

import org.openqa.selenium.By;

public class CheckoutScreen {
	
	public static final By firstName_Field 		= By.cssSelector("input[placeholder='First Name']");
	public static final By lastName_Field 		= By.cssSelector("input[placeholder='Last Name']");
	public static final By zipPostalCode_Field  = By.cssSelector("input[placeholder='Zip/Postal Code']");
	public static final By finish_Button 		= By.cssSelector("#finish");
	public static final By continue_Button 		= By.cssSelector("#continue");
}
