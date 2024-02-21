package com.excelr.automationexercise.Project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class AccountDeletedPage {

	public AccountDeletedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Repository
	@FindBy(xpath="//a[@href='/logout']")WebElement logoutButton;
	@FindBy(xpath="//a[@href='/delete_account']")WebElement deleteAccountButton;
	@FindBy(xpath="//h2[@data-qa='account-deleted']/b") WebElement accountDeleteded;
	@FindBy(xpath="//div[@class='pull-right']/a") WebElement continueButton;

	public void clickOnDeleteAccount() {
		BasePage.clickOnElement(deleteAccountButton);
	}
	public String accountDeledtedtext() {
		return accountDeleteded.getText();
	}
	public void clickOnLogout() {
		BasePage.clickUsingJavaScriptExec(logoutButton);
	}
	public void clickcontinue() {
		BasePage.clickOnElement(continueButton);
	}
}
