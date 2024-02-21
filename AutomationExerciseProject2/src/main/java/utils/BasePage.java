package utils;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.excelr.automationexercise.Project2.AccountCreatedPage;
import com.excelr.automationexercise.Project2.AccountDeletedPage;
import com.excelr.automationexercise.Project2.CartPage;
import com.excelr.automationexercise.Project2.CheckoutPage;
import com.excelr.automationexercise.Project2.ContactusPage;
import com.excelr.automationexercise.Project2.EnterAccountInformationPage;
import com.excelr.automationexercise.Project2.HomePage;
import com.excelr.automationexercise.Project2.PaymentPage;
import com.excelr.automationexercise.Project2.ProductDetailsPage;
import com.excelr.automationexercise.Project2.ProductsPage;
import com.excelr.automationexercise.Project2.SignupLoginPage;
import com.excelr.automationexercise.Project2.TestcasesPage;

public class BasePage {
	public static WebDriver driver;static WebDriverWait wait; static JavascriptExecutor js;
	static Actions action; static Random rand; 
	public static Object hoverOverElement;
	public static void launchUrl() {
		ChromeOptions opt = new ChromeOptions();
//		Map<String, Object> chromePref = new HashMap<>();
//		chromePref.put("download.default_directory", ".\\Downloads\\");
//		chromePref.put("profile.password_manager_enabled", false);
//		opt.addExtensions(new File("./Extensions/AdBlocker.crx"));		
		//opt.addArguments("--remote-allow-origins=*");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//	   capabilities.setCapability(ChromeOptions.CAPABILITY, opt);
//		opt.merge(capabilities);
		opt.setExperimentalOption("prefs",
				new HashMap<String, Object>() {{
					put("autofill.profile_enabled", false);
				}});
		opt.addArguments("--disable-save-password-bubble");
		opt.addArguments("start-maximized");
		driver = new ChromeDriver(opt);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = LoadProperties.getProperty("url");
		driver.get(url); wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;
	}
	public static HomePage homePageInitialization() {
		HomePage homepage = new HomePage(driver);
		return homepage;
	}

	public static SignupLoginPage signupLoginPageInitialization() {
		SignupLoginPage signUpLogin = new SignupLoginPage(driver);
		return signUpLogin;
	}

	public static EnterAccountInformationPage enterAccountInformationPageInitialization() {
		EnterAccountInformationPage enterAccountInformationPage = new EnterAccountInformationPage(driver);
		return enterAccountInformationPage;
	}

	public static ProductsPage productsPageInitialization() {
		ProductsPage productsPage = new ProductsPage(driver);
		return productsPage;
	}


	public static ProductDetailsPage productDetailsPageInitialization() {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		return productDetailsPage;
	}


	public static AccountCreatedPage accountCreatedPageInitialization() {
		AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
		return accountCreatedPage;
	}

	public static AccountDeletedPage accountDeletedPageInitialization() {
		AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
		return accountDeletedPage;
	}

	public static CartPage cartPageInitialization() {
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public static CheckoutPage CheckoutPageInitialization() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

	public static PaymentPage paymentPageInitialization() {
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}

	public static ContactusPage ContactusPageInitialization() {
		ContactusPage contactusPage = new ContactusPage(driver);
		return contactusPage;
	}

	public static TestcasesPage testcasesPageInitialization() {
		TestcasesPage testcasesPage = new TestcasesPage(driver);
		return testcasesPage;

	}
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	public static String currentUrl() {
		return driver.getCurrentUrl();
	}
	public static void clickOnElement(WebElement element) {
		//wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	public static void elementwithWait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}	
	public static void waitUntillUrlContains(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}
	public static void clickUsingJavaScriptExec(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	public static void scrollUsingJavaScriptExec(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void selectDropDown(WebElement element, String visibletext) {
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}
	public static void handleAlerts() {
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
	}
	public static void windowHandles() throws InterruptedException {
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();//set will not have any duplicates{1,2,3}		
		System.out.println("handles"+handles.size());
		System.out.println(handles);
		String ParentWindow = null;
		Iterator<String> itr = handles.iterator();	
		if(handles.size()>1) {
			ParentWindow = itr.next();
			String ChildWindow = itr.next();
			System.out.println(ParentWindow);
			System.out.println(ChildWindow);
			driver.switchTo().window(ParentWindow);
			Thread.sleep(2000);
		}
		else {
			System.out.println("Handles size is only 1 cant switch");
		}		
	}
	public static String captureScreenShot(String testName) {
		File SrcScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destScreenshotPath = System.getProperty("user.dir")+LoadProperties.getProperty("ScreenShot")+testName+".jpg";
		try {
			FileHandler.copy(SrcScreenshot, SrcScreenshot);
		}catch (Exception e) {
			System.out.println("File Path is not present please check");
			e.printStackTrace();
		}
		return destScreenshotPath;
	}	
	public static void scrollToFooterUsingJS() {
		//int deltaY = element.getRect().y;
		action.scrollByAmount(0, 8000).perform();
	}	
	public static void hoverOverElement(WebElement element) {
		action.moveToElement(element).perform(); 
	}	
	public static void clickRandomely(List<WebElement> element) {
		Random rand = new Random();
		element.get(rand.nextInt(element.size())).click();
	}	
}