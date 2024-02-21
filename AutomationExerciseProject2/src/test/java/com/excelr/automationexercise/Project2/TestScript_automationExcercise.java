package com.excelr.automationexercise.Project2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.BasePage;

public class TestScript_automationExcercise {
	HomePage homePage ; SignupLoginPage signUpLogin; AccountCreatedPage accountCreatedPage;
	EnterAccountInformationPage enterAccountInformationPage;AccountDeletedPage accountDeletedPage;
	ProductsPage productsPage; ProductDetailsPage productDetailsPage; CartPage cartPage;
	CheckoutPage checkoutPage; PaymentPage paymentPage; ContactusPage contactusPage; TestcasesPage testcasesPage;

	@BeforeTest
	public void launchUrl() throws InterruptedException {
		BasePage.launchUrl();
		homePage = BasePage.homePageInitialization();
		signUpLogin =BasePage.signupLoginPageInitialization();
		enterAccountInformationPage = BasePage.enterAccountInformationPageInitialization();
		accountCreatedPage = BasePage.accountCreatedPageInitialization();
		accountDeletedPage = BasePage.accountDeletedPageInitialization();
		productsPage = BasePage.productsPageInitialization();
		productDetailsPage =BasePage.productDetailsPageInitialization();
		cartPage = BasePage.cartPageInitialization();
		checkoutPage = BasePage.CheckoutPageInitialization();
		paymentPage = BasePage.paymentPageInitialization();
		contactusPage = BasePage.ContactusPageInitialization();
		testcasesPage = BasePage.testcasesPageInitialization();

	}
	@Test(priority = 1)
	public void registerUser() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signUpLogin.signUpText(), "New User Signup!");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationForm();
		Assert.assertEquals(accountCreatedPage.accountCreatedText(), "ACCOUNT CREATED!");
		accountCreatedPage.clickcontinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");
		accountDeletedPage.clickOnDeleteAccount();
		Assert.assertEquals(accountDeletedPage.accountDeledtedtext(), "ACCOUNT DELETED!");
		accountDeletedPage.clickcontinue();
	}
	@Test(priority = 2)
	public void validateSignupLoginbt() throws InterruptedException {
		homePage.clickOnHeaderElement("Signup / Login");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		enterAccountInformationPage.fillRegistrationForm();
		accountCreatedPage.clickcontinueButton();
		accountDeletedPage.clickOnLogout();
		signUpLogin.loginCredentials("sweety47@gmail.com", "12345");
		Assert.assertEquals(homePage.getUserName(), "Sweety");
		accountDeletedPage.clickOnDeleteAccount();
		Assert.assertEquals(accountDeletedPage.accountDeledtedtext(), "ACCOUNT DELETED!");
	}
	@Test(priority = 3)
	public void loginUserwithincorrectemailandpassword() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signUpLogin.loginText(), "Login to your account");
		signUpLogin.loginCredentials("girija@dcba.co.uk", "12345@abcd");
		Assert.assertEquals(signUpLogin.wrongCredentialsError(), "Your email or password is incorrect!");

	}
	@Test (priority = 4)
	public void  logoutUser() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signUpLogin.loginText(), "Login to your account");
		signUpLogin.loginCredentials("girija@gmail.com", "12345");
		Assert.assertEquals(homePage.getUserName(), "Girija");
		accountDeletedPage.clickOnLogout();
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/login");
	}
	@Test (priority = 5)
	public void  registerUserwithExistingEmail() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signUpLogin.signUpText(), "New User Signup!");
		signUpLogin.signupCredentials("Girija", "girija@gmail.com");
		Assert.assertEquals(signUpLogin.EmailexistError(), "Email Address already exist!");
	}
	@Test (priority = 6)
	public void  ContactUsForm() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Contact us");
		Assert.assertEquals(contactusPage.getInTouchText(), "GET IN TOUCH");
		contactusPage.nameEmailInput("Tejaswini", "Teju@testlauncher.com");
		contactusPage.subjectMessageInput("Parcel delivery", "Haven't got parcel yet.");
		contactusPage.uploadFile("C:\\Users\\ladyo\\Downloads\\PageObject.txt");
		contactusPage.ClicksubmitButton();
		BasePage.handleAlerts();
		Assert.assertEquals(contactusPage.getsuccessMessage(),"Success! Your details have been submitted successfully.");
		BasePage.clickOnElement(contactusPage.homeButton);
		BasePage.waitUntillUrlContains("https://automationexercise.com/");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	}
	@Test (priority = 7)
	public void  verifyTestCasesPage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Test Cases");
		BasePage.waitUntillUrlContains("https://automationexercise.com/test_cases");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/test_cases");
	}

	@Test (priority = 8)
	public void verifyAllProductsAndProductDetailPage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
		Assert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS");
		productsPage.clickOnFirstProduct();
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/product_details/1");
		productDetailsPage.getProductDetails(); 
	}

	@Test (priority = 9)
	public void  SearchProduct() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
		productsPage.searchProduct("Tops");
		Assert.assertEquals(productsPage.centerText(), "SEARCHED PRODUCTS");
		productsPage.listOfAllProducts();

	}

	@Test (priority = 10)
	public void  verifySubscriptionInHomePage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollToFooterUsingJS();
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		homePage.enterEmailForSubscription("y@yahoo.com");
		homePage.clickOnSubscriptionBtn();
		Assert.assertEquals(homePage.getSuccessSubscriptionText(), "You have been successfully subscribed!"); 
	}

	@Test (priority = 11)
	public void verifySubscriptionInCartPage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Cart");
		BasePage.scrollToFooterUsingJS();
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		homePage.enterEmailForSubscription("y@yahoo.com");
		homePage.clickOnSubscriptionBtn();
		Assert.assertEquals(homePage.getSuccessSubscriptionText(), "You have been successfully subscribed!");
	}

	@Test (priority = 12)
	public void  AddProductInCart() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		BasePage.hoverOverElement(productsPage.hoverOnFirstProduct()); 
		BasePage.clickUsingJavaScriptExec(productsPage.AddtoCartButtonproduct1);
		BasePage.clickUsingJavaScriptExec(productsPage.ContinueShoppingbutton);
		BasePage.hoverOverElement(productsPage.hoverOnSecondProduct());	
		BasePage.clickUsingJavaScriptExec(productsPage.AddtoCartButtonproduct2);
		BasePage.clickUsingJavaScriptExec(productsPage.ViewCartButton);
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		List<Integer>CalculatedTotal = cartPage.productTotalValidation();
		List<Integer>CartTotal = cartPage.cartTotalValues();
		for(int i =0;i<CalculatedTotal.size();i++) {
			Assert.assertEquals(CalculatedTotal, CartTotal);
		}
	}

	@Test (priority = 13)
	public void  verifyProductQuantityInCart() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		productsPage.clickOnFirstProduct();
		BasePage.waitUntillUrlContains("https://automationexercise.com/product_details/1");
		Assert.assertTrue(BasePage.currentUrl().contains("product_details"));
		productDetailsPage.clearQuantity();
		productDetailsPage.changeQuantity("4");
		productDetailsPage.clickOnAddToCart();
		productsPage.ViewCart();
		List<WebElement>CartQuantity = cartPage.getCartQunatity();
		for(int i=0; i<CartQuantity.size();i++) {
			Assert.assertEquals(CartQuantity.get(i).getText(), "4");
		}
	}

	@Test (priority = 14)
	public void  PlaceOrderRegisterWhileCheckout() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		cartPage.clickOnProceedToCheckOut();
		cartPage.clickOnRegisterLoginLink();
		Assert.assertEquals(signUpLogin.signUpText(), "New User Signup!");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationForm();
		Assert.assertEquals(accountCreatedPage.accountCreatedText(), "ACCOUNT CREATED!");
		accountCreatedPage.clickcontinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");
		homePage.clickOnHeaderElement("Cart"); 
		cartPage.clickOnProceedToCheckOut();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPayementDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickcontinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeledtedtext();
		accountDeletedPage.clickcontinue();
	}

	@Test (priority = 15)
	public void   PlaceOrderRegisterBeforeCheckout() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		enterAccountInformationPage.fillRegistrationForm();
		Assert.assertEquals(accountCreatedPage.accountCreatedText(), "ACCOUNT CREATED!");
		accountCreatedPage.clickcontinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");

		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		cartPage.clickOnProceedToCheckOut();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPayementDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickcontinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeledtedtext();
		accountDeletedPage.clickcontinue();
	}

	@Test (priority = 16)
	public void  PlaceOrderLoginBeforeCheckout () throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signUpLogin.loginText(), "Login to your account");
		signUpLogin.loginCredentials("ojas@gmail.com", "12345");// Existing account credentials
		Assert.assertEquals(homePage.getUserName(), "Ojas");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart");
		Assert.assertTrue(BasePage.currentUrl().contains("cart"));
		cartPage.clickOnProceedToCheckOut();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPayementDetails();
		paymentPage.paynConfirmOrder();
		//System.out.println(paymentPage.confirmationMessage());
		accountCreatedPage.clickcontinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeledtedtext();
		accountDeletedPage.clickcontinue();

	}

	@Test (priority = 17)
	public void  RemoveProductsFromCart () {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart"); 
		int BeforeDelete = cartPage.gettableSize();
		cartPage.clickonXbutton();
		BasePage.refreshPage();
		int AfterDelte = cartPage.gettableSize();
		Assert.assertNotEquals(BeforeDelete, AfterDelte);
	}
	@Test (priority = 18) 
	public void  ViewCategoryProducts() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.ClickOnWomenCategory();
		homePage.ClickOnWomenDressCategory();
		BasePage.waitUntillUrlContains("https://automationexercise.com/category_products/1");
		Assert.assertTrue(homePage.isCenterTextVisible());
		homePage.ClickOnMensategory();
		homePage.ClickOnMensTshirtCategory();
		Assert.assertTrue(homePage.isCenterTextVisible());
	}


	@Test (priority = 19) 
	public void  ViewnCaertBrandProdducts() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		List<WebElement> ListOfAllBrands = homePage.listOfAllBrands(); 
		for(int i=0;i<ListOfAllBrands.size();i++) {
			System.out.println(ListOfAllBrands.get(i).getText());
		}
		productsPage.ClickOnBiba();
		List <WebElement> AllProductsName = productsPage.listOfAllProducts();
		for(int i=0; i<AllProductsName.size();i++) {
			System.out.println(AllProductsName.get(i).getText());
		}
		Assert.assertEquals(productsPage.centerText(), "BRAND - BIBA PRODUCTS") ;
		productsPage.ClickOnHnM(); 
		Assert.assertEquals(productsPage.centerText(), "BRAND - H&M PRODUCTS") ;
	}

	@Test (priority = 20) 
	public void SearchProductsAndVerifyCartAfterLogin() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
		Assert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS");
		productsPage.searchProduct("SAREE".toLowerCase()); 
		Assert.assertEquals(productsPage.centerText(), "SEARCHED PRODUCTS");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products?search=saree");
		productsPage.clickOnEachProductAddToCart();
		homePage.clickOnHeaderElement("Cart");
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart");
		List<WebElement>CartProductNames = cartPage.getCartProductNames();
		for(int i = 0; i<CartProductNames.size();i++) {
			System.out.println(CartProductNames.get(i).getText());
		}
		homePage.clickOnHeaderElement("Signup / Login");
		signUpLogin.loginCredentials("Ojas@gmail.com", "12345");
		homePage.clickOnHeaderElement("Cart");
		for(int i = 0; i<CartProductNames.size();i++) {
			System.out.println(CartProductNames.get(i).getText());
		}
	}

	@Test (priority = 21)
	public void  AddReviewOnProduct() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(productsPage.centerText(), "ALL PRODUCTS");
		productsPage.clickOnFirstProduct();
		Assert.assertTrue(productDetailsPage.isYourReviewvisible());
		productDetailsPage.nameEmailInput("Ojas", "ojas@gmail.com");
		productDetailsPage.reviewInput("This website is terrible");
		productDetailsPage.clickOnSubmit();
		Assert.assertEquals(productDetailsPage.isSuccessMessageVisible(), "Thank you for your review.");

	}

	@Test (priority = 22)
	public void   AddToCarFromRecommendedItems() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExec(homePage.RecommendedItems); 
		Assert.assertTrue(homePage.isRecommendedItemsVisible());
		homePage.addproductFromRecommandationList();
		productsPage.ViewCart(); 
		Assert.assertTrue(homePage.isProductDisplayedInCart());

	}

	@Test (priority = 23) 
	public void  VerifyAddressDetailsIncheckoutPage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		enterAccountInformationPage.fillRegistrationForm();
		Assert.assertEquals(accountCreatedPage.accountCreatedText(), "ACCOUNT CREATED!");
		accountCreatedPage.clickcontinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");

		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		cartPage.clickOnProceedToCheckOut();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPayementDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickcontinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeledtedtext();
		accountDeletedPage.clickcontinue();
	}

	@Test (priority = 24) 
	public void   DownloadInvoiceAfterPurchaseOrder() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstsecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.ViewCart(); 
		cartPage.clickOnProceedToCheckOut();
		cartPage.clickOnRegisterLoginLink();
		Assert.assertEquals(signUpLogin.signUpText(), "New User Signup!");
		signUpLogin.signupCredentials("Sweety", "sweety47@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationForm();
		Assert.assertEquals(accountCreatedPage.accountCreatedText(), "ACCOUNT CREATED!");
		accountCreatedPage.clickcontinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");
		homePage.clickOnHeaderElement("Cart"); 
		cartPage.clickOnProceedToCheckOut();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPayementDetails();
		paymentPage.paynConfirmOrder();
		paymentPage.clickOnDownloadInvoice();
		paymentPage.clickOnContinue();
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.clickcontinue();
	}

	@Test (priority = 25)
	public void   VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExec(homePage.SubscriptionText); 
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		homePage.clickOnArrow();
		Assert.assertEquals(homePage.getFullFledgeWebsitetext(), "Full-Fledged practice website for Automation Engineers");
	}

	@Test (priority = 26)
	public void  VerifyScrollUpwithoutArrowButtonAndScrollDownFunctionality() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExec(homePage.SubscriptionText); 
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		BasePage.scrollUsingJavaScriptExec(homePage.FullFlegedWebsiteText);
		Assert.assertEquals(homePage.getFullFledgeWebsitetext(), "Full-Fledged practice website for Automation Engineers");
	}




}