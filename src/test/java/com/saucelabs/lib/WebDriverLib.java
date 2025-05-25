package com.saucelabs.lib;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.saucelabs.utils.BrowserManagerOptions;

import seleniumframeworksaucelabs.utils.ConfigManager;

public class WebDriverLib {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	static ConfigManager config = null ;
	
	public static void intiDriver() throws IOException {
		config = new ConfigManager();
		String browser = config.getBrowser();
		String path = config.getDriverPath();
		switch (browser) {
        case "chrome":
        	System.setProperty("webdriver.chrome.driver", path);
        	driver.set(new ChromeDriver(BrowserManagerOptions.getChromeOptions()));
            break;
        case "edge":
        	System.setProperty("webdriver.edge.driver", path);
        	driver.set(new EdgeDriver(BrowserManagerOptions.getEdgeOptions()));
            break;
        default:
            throw new RuntimeException("Unsupported browser:" + browser);
		}		
		
	}

	 public static WebDriver getDriver() {
	        return driver.get();
	 }
	
	 public static void launchApplication() throws IOException, InterruptedException {
		 intiDriver();
		 String url = config.getBaseUrl();
		 getDriver().get(url);
	}
	 
	 public static void clickOnWebElement(By by) {
		    try {
		        WebElement element = getDriver().findElement(by);
		        element.click();
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("Click failed", e);
		    }
		}
	 
	 public static void sendKeysToElement(By by, String text) {
		    try {
		        WebElement element = getDriver().findElement(by);
		        element.clear();
		        element.sendKeys(text);
		        System.out.println("Entered text: " + text + " into element: " + by.toString());
		    } catch (Exception e) {
		        System.out.println("Failed to enter text in element: " + by.toString());
		        e.printStackTrace();
		        throw new RuntimeException("SendKeys failed", e);
		    }
		}

	 public static void scrollToElement(By by) {
		    try {
		        WebElement element = getDriver().findElement(by);
		        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		    } catch (Exception e) {
		        System.out.println("Failed to scroll to element: " + by.toString());
		        e.printStackTrace();
		        throw new RuntimeException("Scroll failed", e);
		    }
		}

	 
	 public static void scrollToTop() {
		    try {
		        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("ScrollToTop failed", e);
		    }
		}

	 public static boolean isElementDisplayed(By by) {
		    try {
		        return getDriver().findElement(by).isDisplayed();
		    } catch (Exception e) {
		        System.out.println("Element not found/displayed: " + by.toString());
		        return false;
		    }
		}
	 
	 public static boolean isElementEnabled(By by) {
	        try {
	            return getDriver().findElement(by).isEnabled();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    public static boolean isElementDisabled(By by) {
	        return !isElementEnabled(by);
	    }

	    public static boolean isElementSelected(By by) {
	        try {
	            return getDriver().findElement(by).isSelected();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    public static void scrollToBottom() {
	        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    }

	    public static void jsClick(By by) {
	        WebElement element = getDriver().findElement(by);
	        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	    }

	    public static String getTextFieldValue(By by) {
	        return getDriver().findElement(by).getAttribute("value");
	    }

	    public static void selectDropdownByVisibleText(By by, String text) {
	        Select select = new Select(getDriver().findElement(by));
	        select.selectByVisibleText(text);
	    }

	    public static void selectDropdownByValue(By by, String value) {
	        Select select = new Select(getDriver().findElement(by));
	        select.selectByValue(value);
	    }

	    public static void selectDropdownByIndex(By by, int index) {
	        Select select = new Select(getDriver().findElement(by));
	        select.selectByIndex(index);
	    }

	    public static List<WebElement> getElements(By by) {
	        return getDriver().findElements(by);
	    }

	    public static int getElementsCount(By by) {
	        return getDriver().findElements(by).size();
	    }

	    public static void clearTextField(By by) {
	    	WebElement element = getDriver().findElement(by);
	        element.click(); 
	        element.sendKeys(Keys.chord(Keys.CONTROL, "A")); 
	        element.sendKeys(Keys.DELETE);
	    }

	    public static void navigateBack() {
	        getDriver().navigate().back();
	    }

	    public static void navigateForward() {
	        getDriver().navigate().forward();
	    }

	    public static void refreshPage() {
	        getDriver().navigate().refresh();
	    }

	    public static void acceptAlert() {
	        getDriver().switchTo().alert().accept();
	    }

	    public static void dismissAlert() {
	        getDriver().switchTo().alert().dismiss();
	    }

	    public static String getAlertText() {
	        return getDriver().switchTo().alert().getText();
	    }

	    public static void switchToFrameByIndex(int index) {
	        getDriver().switchTo().frame(index);
	    }

	    public static void switchToFrameByNameOrId(String nameOrId) {
	        getDriver().switchTo().frame(nameOrId);
	    }

	    public static void switchToDefaultContent() {
	        getDriver().switchTo().defaultContent();
	    }

	    public static String getCurrentUrl() {
	        return getDriver().getCurrentUrl();
	    }

	    public static String getPageTitle() {
	        return getDriver().getTitle();
	    }

	    public static void closeBrowser() {
	        getDriver().close();
	    }

	    public static void quitDriver() {
	        getDriver().quit();
	    }
	}
	






	 
	 
	 
	 

