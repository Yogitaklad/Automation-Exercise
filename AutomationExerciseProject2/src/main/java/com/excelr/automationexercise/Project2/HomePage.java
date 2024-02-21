package com.excelr.automationexercise.Project2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;


public class HomePage {
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	//Repository
	
	@FindBy (xpath="//div[@class='col-sm-6']/h2") WebElement FullFlegedWebsiteText;
	@FindBy (xpath="//div[@class='single-widget']/h2") WebElement SubscriptionText;
	@FindBy(xpath = "//footer[@id='footer']")  WebElement footer;
	@FindBy (xpath="//form[@class='searchform']/input[2]")WebElement SubscribeEmailInput;
	@FindBy (id="subscribe")WebElement SubscribeButton;
	@FindBy (xpath="//div[@class='form-row']/child::div/child::div")WebElement SubscriptionSuccessText; 
	@FindBy (xpath="//ul[@class='nav navbar-nav']/li/a") List <WebElement> HeaderElements;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[10]/a/b")WebElement usename;
	@FindBy(xpath="//a[@id='scrollUp']")WebElement ScrollArrow;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='choose']/ul/li/a")List <WebElement> viewProdcutbtnList; 
	
	@FindBy (xpath="//a[@href='#Women']") WebElement WomenCategory;
	@FindBy (xpath="//a[@href='/category_products/1']") WebElement WomenDressCategory;
	@FindBy (xpath="//div[@class='features_items']/h2") WebElement WomenDressText; 
	@FindBy(xpath="//div[@class='features_items']/h2") WebElement CenterText; 
	
	@FindBy (xpath="//a[@href='/category_products/2']") WebElement WomenTopsCategory;
	@FindBy (xpath="//a[@href='/category_products/7']") WebElement WomenSareeCategory;
	@FindBy (xpath="//a[@href='#Men']") WebElement MenCategory;
	@FindBy (xpath="//a[@href='/category_products/3']") WebElement TshirtsCategory;
	@FindBy (xpath="//a[@href='/category_products/6']") WebElement JeansCategory;
	
	@FindBy (xpath="//div[@class='recommended_items']") WebElement RecommendedItems;
	@FindBy(xpath="//a[@data-product-id='3']")WebElement RecommendedListProduct;	
	@FindBy (xpath="//div[@class='brands-name']/ul/li")List <WebElement> ListOfBrands;

	public void headerElementsText() {
		for (WebElement headerElement : HeaderElements) {
			System.out.println(headerElement.getText());
		}
	}

	public void clickOnHeaderElement(String text) throws InterruptedException {		
		for (int i =0;i<HeaderElements.size();i++) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HeaderElements));
			if(HeaderElements.get(i).getText().equals(text)) {
				HeaderElements.get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
	}

	public String getSubscriptiontext() {
		wait.until(ExpectedConditions.visibilityOf(SubscriptionText));
		return SubscriptionText.getText();
	}
	
	public String getFullFledgeWebsitetext() {
		wait.until(ExpectedConditions.visibilityOf(FullFlegedWebsiteText));
		return FullFlegedWebsiteText.getText();
	}
	

	public void enterEmailForSubscription(String email) {
		wait.until(ExpectedConditions.visibilityOf(SubscribeEmailInput));
		SubscribeEmailInput.sendKeys(email);
	}

	public void clickOnSubscriptionBtn() {
		wait.until(ExpectedConditions.visibilityOf(SubscribeButton));
		BasePage.clickOnElement(SubscribeButton);
	}
	
	public String getSuccessSubscriptionText() {
		return SubscriptionSuccessText.getText();
	}
	
	public String getUserName() {
		return usename.getText();
	}
	
	public void ClickOnWomenCategory() {
		BasePage.clickOnElement(WomenCategory);
	}
	
	public void ClickOnWomenDressCategory() {
		BasePage.clickOnElement(WomenDressCategory);
	}
		
	public String getWomenDressText() {
		return WomenDressText.getText(); 
	}
	
	public void ClickOnMensategory() {
		BasePage.elementwithWait(MenCategory);
		BasePage.clickUsingJavaScriptExec(MenCategory);
	}
	public void ClickOnMensTshirtCategory() {
		BasePage.elementwithWait(TshirtsCategory);
		BasePage.clickOnElement(TshirtsCategory);
	}
	
	public void clickOnArrow() {
		BasePage.clickUsingJavaScriptExec(ScrollArrow);
	}
	
	public boolean isRecommendedItemsVisible() {
		return RecommendedItems.isDisplayed();
	}
	
	public void addproductFromRecommandationList() {
		BasePage.clickUsingJavaScriptExec(RecommendedListProduct);
	}
	
	public boolean isCenterTextVisible(){
		return CenterText.isDisplayed();
		
	}
	
	public boolean isProductDisplayedInCart() {
        return RecommendedListProduct.isDisplayed();
    }
	public List<WebElement> listOfAllBrands() {
		return ListOfBrands; 
	}

}
