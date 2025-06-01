package com.saucelabs.pages;

import org.openqa.selenium.By;

public class ProductScreen {
	public static final By all_Products = By.cssSelector(".inventory_item");
	public static final By addToCart_Button = By.xpath("//button[contains(.,'Add to cart')]");
	public static final By remove_button = By.xpath("//button[contains(.,'Remove')]");
	public static final By item_price = By.cssSelector(".inventory_item_price");
	public static final By productSort_Dropdown = By.cssSelector(".product_sort_container");
	public static final By productsPage_heading = By.cssSelector("span[data-test='title']");
	
	public static final By cart_Badge = By.cssSelector(".shopping_cart_badge");
}
