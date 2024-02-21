package com.excelr.automationexercise.Project2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Repository
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr/td[@class='cart_description']//a")
	List<WebElement> CartProductNames;
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr/td[@class='cart_price']") 
	List<WebElement> CartProductPrices;
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr/td[@class='cart_quantity']") 
	List<WebElement> CartProductQuantity;
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr/td[@class='cart_total']") 
	List<WebElement> CartProductTotal;
	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr/td[@class='cart_delete']") 
	List<WebElement> CartProductDelete;
	@FindBy(xpath="//table[@class='table table-condensed']//tbody/tr") List<WebElement> TableSize;

	@FindBy (xpath="//a[@class='btn btn-default check_out']")WebElement proceedToCheckoutButton; 

	@FindBy(xpath = "(//a[@href='/login'])[2]") WebElement Register_Loginlink;
	@FindBy(xpath ="//tr[@id='product-2']//td[@class='cart_delete']/a") WebElement XButton;


	public List<WebElement> getCartProductNames() {
		return CartProductNames;
	}
	public List<WebElement> getCartProductPrices() {
		return CartProductPrices;
	}
	public List<Integer> productTotalValidation() {
		List<Integer> calculatedTotal =  new ArrayList<Integer>();
		for(int i = 0; i< CartProductPrices.size();i++) {
			String[] prices = CartProductPrices.get(i).getText().split(" ");
			int price = Integer.parseInt(prices[1]);//500
			int quantity = Integer.parseInt(CartProductQuantity.get(i).getText());//1
			calculatedTotal.add(price*quantity);
		}
		return calculatedTotal;
	}
	public List<Integer> cartTotalValues() {
		List<Integer> Total = new ArrayList<>();
		for(int i = 0; i< CartProductTotal.size();i++) {
			String[] prices = CartProductTotal.get(i).getText().split(" ");
			int total = Integer.parseInt(prices[1]);//500
			Total.add(total);
		}
		return Total;
	}
	public List<WebElement> getCartQunatity() {
		return CartProductQuantity;
	}
	public void clickOnProceedToCheckOut() {
		BasePage.clickUsingJavaScriptExec(proceedToCheckoutButton);
	}
	public void clickOnRegisterLoginLink() {
		BasePage.clickUsingJavaScriptExec(Register_Loginlink);
	}

	public List<WebElement> deleteProductsFromCart() {
		return CartProductDelete;
	}

	public void clickOnAProductDeleteIcon(int j) {
		for(int i=0;i<CartProductDelete.size();i++) {
			if(i==(j-1)) {
				CartProductDelete.get(i).click();	

			}


		}

	}

	public void clickonXbutton() {
		BasePage.clickUsingJavaScriptExec(XButton);
	}


	public int gettableSize() {
		return TableSize.size(); 
	}

} 
