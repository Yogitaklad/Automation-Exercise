package com.excelr.automationexercise.Project2;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class ProductDetailsPage {
	WebDriver driver;JavascriptExecutor js;
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}



	// Repository
	@FindBy(xpath = "//div[@class=\"product-information\"]") private List<WebElement> ProductDetails;
	@FindBy(id="quantity") WebElement quantityInput;//Extra 
	@FindBy(xpath="//div[@class='product-information']/span/button") WebElement addToCartButton;
	@FindBy(xpath="//a[@href='#reviews']") WebElement writeYourReview;
	@FindBy(id="name") WebElement nameInput;
	@FindBy(id="email") WebElement emailInput;
	@FindBy(id="review") WebElement addReviewHere;
	@FindBy(id="button-review") WebElement submitButton;
	@FindBy(xpath="//div[@class='alert-success alert']/span") WebElement successMessage;
	
	public void getProductDetails() {
		for(WebElement eachElement: ProductDetails) {
			System.out.println(eachElement.getText());
		}
	}
	public void clearQuantity() {
		quantityInput.clear();
	}
	public void changeQuantity(String value) {
		quantityInput.sendKeys(value);
	}
	public Object getQuantity() {
		return js.executeScript("document.getElementById('quantity').value", "");
	}
	
	public void clickOnAddToCart() {
		addToCartButton.click();
	}
	
	public boolean isYourReviewvisible() {
			return writeYourReview.isDisplayed();
	}
	
	public void nameEmailInput(String Name,String Email) {
		nameInput.sendKeys(Name);
		emailInput.sendKeys(Email);
	}
	
	public void reviewInput(String review) {
		addReviewHere.sendKeys(review);
	}
	
	public void clickOnSubmit() {
		BasePage.clickUsingJavaScriptExec(submitButton);
	}
	
	public String isSuccessMessageVisible() {
		BasePage.elementwithWait(successMessage);
		return successMessage.getText();
	}
	
	
	
}
