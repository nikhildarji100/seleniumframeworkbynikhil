package com.saucelabs.pages;

import org.openqa.selenium.By;

public class LoginScreen {
	public static final By userName_Field = By.id("user-name");
	public static final By password_Field = By.id("password");
	public static final By login_Button   = By.id("login-button");
	public static final By heading 		  = By.cssSelector(".login_logo");
}
