package com.excelr.automationexercise.Project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class AccountCreatedPage {
	public AccountCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy(xpath="//h2[@data-qa='account-created']/b") WebElement accountCreated;
	@FindBy(xpath="//a[@data-qa='continue-button']") WebElement continueButton;


	public  String accountCreatedText() {
		return accountCreated.getText();

	 }
	public void clickcontinueButton() {
		BasePage.clickUsingJavaScriptExec(continueButton);
	}
 }


