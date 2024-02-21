package com.excelr.automationexercise.Project2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class ProductsPage {

	public ProductsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//div[@class='features_items']/h2") WebElement TitleTextCenter;
	@FindBy (xpath = "//div[@class='features_items']//div[@class='productinfo text-center']/p") List <WebElement> AllproductsList;
	@FindBy (id="search_product") WebElement SearchInput;
	@FindBy (id="submit_search")WebElement SearchButton;
	@FindBy(xpath = "//div[@class='overlay-content']//a") List<WebElement> ListOfAllAddToCart;
	@FindBy (xpath="//div[@class='features_items']/h2") WebElement CenterText;
	@FindBy (xpath="//a[@href='/product_details/1']") WebElement ViewProductbtnoffirstproduct;
	@FindBy (xpath="//a[@href='/product_details/2']") WebElement ViewProductbtnofSecondproduct;
	@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]/p") WebElement FirstProductName;
	@FindBy(xpath = "(//div[@class=\"productinfo text-center\"])[2]/p") WebElement SecondProductName;
	@FindBy(xpath = "(//div[@class=\"productinfo text-center\"])[1]/h2") WebElement FirstProductPrice;
	@FindBy(xpath = "(//div[@class=\"productinfo text-center\"])[2]/h2") WebElement SecondProductPrice;

	
	@FindBy (xpath="//a[@data-product-id='1']") WebElement AddtoCartButtonproduct1;
	@FindBy (xpath="//a[@data-product-id='2']") WebElement AddtoCartButtonproduct2;
	@FindBy (xpath="//div[@id='cartModal']/following-sibling::div[@class='col-sm-4'][1]")WebElement firstProduct; 
	@FindBy (xpath="//div[@id='cartModal']/following-sibling::div[@class='col-sm-4'][2]")WebElement secondProduct;	

	@FindBy (xpath="//div[@class=\"modal-footer\"]/button") WebElement ContinueShoppingbutton;
	@FindBy (xpath="//a[@href='/view_cart']") WebElement ViewCartButton;
	@FindBy (xpath="//div[@class='brands_products']/h2") WebElement Brand;
	@FindBy (xpath="//a[@href='/brand_products/Polo']") WebElement Polo;
	@FindBy (xpath="//a[@href='/brand_products/H&M']") WebElement HAndM;
	@FindBy (xpath="//a[@href='/brand_products/Biba']") WebElement Biba;

	public String getAllProductsText() {
		return TitleTextCenter.getText();
	}

	public List<WebElement> listOfAllProducts(){
		for(int i = 0;i<AllproductsList.size();i++) {
			System.out.println(AllproductsList.get(i).getText());
		}
		return AllproductsList;
	}
	public List<String> firstSecondProductNames() {
		List<String> FirstSecondProductNames = new ArrayList<>();
		BasePage.elementwithWait(FirstProductName);
		FirstSecondProductNames.add(FirstProductName.getText()); // add first product name to list
		BasePage.elementwithWait(SecondProductName);
		FirstSecondProductNames.add(SecondProductName.getText()); // add first product price to list
		return FirstSecondProductNames;
	}
	public List<String> firstsecondProductPrices() {
		List<String> SecondProductAndPrice = new ArrayList<>();
		BasePage.elementwithWait(FirstProductPrice);
		SecondProductAndPrice.add(FirstProductPrice.getText()); // add second product name to list
		BasePage.elementwithWait(SecondProductPrice);
		SecondProductAndPrice.add(SecondProductPrice.getText());// add second product price to list
		return SecondProductAndPrice;
	}
	public void clickOnFirstProduct() {
		BasePage.scrollUsingJavaScriptExec(ViewProductbtnoffirstproduct);
		ViewProductbtnoffirstproduct.click();
	}
	public void searchProduct(String text) {
		SearchInput.sendKeys(text);
		BasePage.clickOnElement(SearchButton);
	}
	public String centerText() {
		return CenterText.getText();
	}
	public  void addToCartFirstProduct() {
		BasePage.scrollUsingJavaScriptExec(AddtoCartButtonproduct1);
		AddtoCartButtonproduct1.click();
	}
	public void addToCartSecondProduct() {
		BasePage.scrollUsingJavaScriptExec(AddtoCartButtonproduct2);
		AddtoCartButtonproduct2.click();
	}

	public void clickOnContinueShoppingButton() {
		BasePage.elementwithWait(ContinueShoppingbutton);
		BasePage.clickUsingJavaScriptExec(ContinueShoppingbutton);
	}
	public void ViewCart() {
		BasePage.elementwithWait(ContinueShoppingbutton);
		BasePage.clickUsingJavaScriptExec(ViewCartButton);
	}

	public WebElement hoverOnFirstProduct() {
		return firstProduct; 
	}

	public WebElement hoverOnSecondProduct() {
		return secondProduct; 
	}
	
	public void  ClickOnBiba() {
		BasePage.scrollUsingJavaScriptExec(Brand);
		BasePage.clickOnElement(Biba);
		BasePage.elementwithWait(TitleTextCenter);
	}
	
	public void  ClickOnHnM() {
		BasePage.elementwithWait(HAndM);
		BasePage.clickOnElement(HAndM);
	}
	public void clickOnEachProductAddToCart() {
		for(int i =0;i<AllproductsList.size();i++) {
			BasePage.elementwithWait(AllproductsList.get(i));
			BasePage.hoverOverElement(AllproductsList.get(i));
			BasePage.clickUsingJavaScriptExec(ListOfAllAddToCart.get(i));
			BasePage.elementwithWait(ContinueShoppingbutton);
			BasePage.clickUsingJavaScriptExec(ContinueShoppingbutton);
		}		
	}
	
}
