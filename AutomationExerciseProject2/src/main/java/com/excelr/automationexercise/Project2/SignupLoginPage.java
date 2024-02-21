package com.excelr.automationexercise.Project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {

	public SignupLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Repository

	@FindBy(xpath="//div[@class='login-form']/h2") WebElement loginToYourAccount;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement loginEmailInput;
	@FindBy(xpath="//input[@data-qa='login-password']") WebElement loginPasswordInput;
	@FindBy(xpath="//button[@data-qa='login-button']") WebElement loginButton;
	@FindBy(xpath="//div[@class='login-form']/form/p") WebElement errorMessage;
	@FindBy(xpath="//div[@class='signup-form']/h2") WebElement NewUserSignUp;
	@FindBy(xpath="//input[@data-qa='signup-name']") WebElement signUpNameInput;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement signUpEmailInput;
	@FindBy(xpath="//button[@data-qa='signup-button']") WebElement signUpButton;
	@FindBy(xpath="//div[@class='signup-form']/form/p") WebElement emailAddressAlreadyExist;


	public String loginText() {
		return loginToYourAccount.getText();
	}

	public void signupCredentials(String name, String email) {
		signUpNameInput.sendKeys(name);
		signUpEmailInput.sendKeys(email);
		signUpButton.click();
	}

	public String wrongCredentialsError() {
		return errorMessage.getText();
	}

	public String signUpText() {
		return NewUserSignUp.getText();
	}

	public void loginCredentials(String email, String password ){
		loginEmailInput.sendKeys(email);
		loginPasswordInput.sendKeys(password);
		loginButton.click();
	}

	public String EmailexistError() {
		return emailAddressAlreadyExist.getText();
	}

}


