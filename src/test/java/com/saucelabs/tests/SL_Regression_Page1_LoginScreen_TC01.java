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
import com.saucelabs.pages.CommonLocators;
import com.saucelabs.pages.LoginScreen;

import seleniumframeworksaucelabs.utils.ConfigManager;

public class SL_Regression_Page1_LoginScreen_TC01 extends WebDriverLib{
	WebDriverWait wait;
	
	String expectedHeading = "Swag Labs";

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
	public void TC01_Verify_LoginScreen_Heading() {
		Assert.assertEquals(getWebelementText(LoginScreen.heading), expectedHeading, "Incorrect heading is displayed.");
	}
	
	@Test(priority = 2)
	public void TC02_Verify_ErrorMessage_WhenUser_Performs_Login_With_BlankCredentials() throws InterruptedException {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GLOBAL_TIMEOUT));
		clickOnWebElement(LoginScreen.login_Button);
		wait.until(ExpectedConditions.elementToBeClickable(CommonLocators.errorMessage_CloseButton));
		verifyMessage(CommonLocators.expectedMessages.usernameIsRequired);
		clickOnWebElement(CommonLocators.errorMessage_CloseButton);
		Thread.sleep(1000);
		Assert.assertFalse(isElementDisplayed(CommonLocators.errorMessage), 
		"Error message is not disappearing after clicking on close button.");
	}
	
	@Test(priority = 3)
	public void TC03_Verify_ErrorMessage_WhenUserPerforms_Login_With_Blank_Password() throws IOException {
		ConfigManager config = new ConfigManager();
		sendKeysToElement(LoginScreen.userName_Field, config.getUsername());
		clickOnWebElement(LoginScreen.login_Button);
		wait.until(ExpectedConditions.elementToBeClickable(CommonLocators.errorMessage_CloseButton));
		verifyMessage(CommonLocators.expectedMessages.passwordIsRequired);
	}
	
	@Test(priority = 4)
	public void TC04_Verify_ErrorMessage_WhenUserPerforms_Login_With_Invalid_Username() throws IOException {
		ConfigManager config = new ConfigManager();
		refreshPage();
		sendKeysToElement(LoginScreen.userName_Field, CommonLocators.invalidValue);
		sendKeysToElement(LoginScreen.password_Field, config.getPassword());
		clickOnWebElement(LoginScreen.login_Button);
		wait.until(ExpectedConditions.elementToBeClickable(CommonLocators.errorMessage_CloseButton));
		verifyMessage(CommonLocators.expectedMessages.usernameAndpasswordDoNotMatchAnyUser);
	}
	
	@Test(priority = 5)
	public void TC05_Verify_ErrorMessage_WhenUserPerforms_Login_With_Invalid_Password() throws IOException {
		ConfigManager config = new ConfigManager();
		refreshPage();
		sendKeysToElement(LoginScreen.userName_Field, config.getUsername());
		sendKeysToElement(LoginScreen.password_Field, CommonLocators.invalidValue);
		clickOnWebElement(LoginScreen.login_Button);
		wait.until(ExpectedConditions.elementToBeClickable(CommonLocators.errorMessage_CloseButton));
		verifyMessage(CommonLocators.expectedMessages.usernameAndpasswordDoNotMatchAnyUser);
	}
	
	@Test(priority = 6)
	public void TC06_Verify_Succesful_Login_With_Valid_Credentials() throws IOException, InterruptedException {
		ConfigManager config = new ConfigManager();
		refreshPage();
		sendKeysToElement(LoginScreen.userName_Field, config.getUsername());
		sendKeysToElement(LoginScreen.password_Field, config.getPassword());
		clickOnWebElement(LoginScreen.login_Button);
		Thread.sleep(1000);
		Assert.assertFalse(isElementDisplayed(CommonLocators.errorMessage_CloseButton), 
		"Error message is not expected.");
	}
	
	
	
	
	
	
	
}
