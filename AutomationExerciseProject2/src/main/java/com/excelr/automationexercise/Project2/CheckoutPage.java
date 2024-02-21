package com.excelr.automationexercise.Project2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class CheckoutPage {
	public CheckoutPage (WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Repository
	@FindBy(xpath="//ul[@id='address_delivery']/li")List<WebElement> deliveryAddress;
	@FindBy(xpath="//ul[@id='address_invoice']/li") List<WebElement> InvoiceAddress;
	@FindBy(xpath="//dicv[@id=\"cart_info\"]/table/tbody/tr[2]/td[4]/p") WebElement totalAmount;
	@FindBy(xpath="//div[@id='ordermsg']/textarea") WebElement comment;
	@FindBy(xpath="//a[@href='/payment']") WebElement PlaceOrderButton;
	 
	public List<WebElement> getDeliveryAddress(){
		return deliveryAddress;
	}
	public List<WebElement> getBillingAddress(){
		return InvoiceAddress;
	}
	public void enterComment() {
		comment.sendKeys("dfsgfkdjg sdnosfv nasdoghdvn snvdondvoi DSKvv");
	}
	public void clickOnPlaceOrder() {
		BasePage.clickOnElement(PlaceOrderButton);
	}
}
