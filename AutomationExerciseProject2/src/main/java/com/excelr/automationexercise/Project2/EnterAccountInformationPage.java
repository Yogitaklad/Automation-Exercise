package com.excelr.automationexercise.Project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class EnterAccountInformationPage {
	public EnterAccountInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}

	//Repository
	@FindBy(xpath="//div[@class='login-form']/h2/b") WebElement enterAccountInformation;
	@FindBy(id="id_gender2") WebElement titleMrsCheckbox;
	@FindBy(id="password") WebElement passwordInput;
	@FindBy(id="days") WebElement daySelect;
	@FindBy(id="months") WebElement monthSelect;
	@FindBy(id="years") WebElement yearSelect;
	@FindBy(id="newsletter") WebElement newsletterCheckbox;
	@FindBy(id="optin") WebElement specialOfferCheckbox;
	@FindBy(xpath="//h2[@class='title text-center']/b") WebElement addressInformation;
	@FindBy(id="first_name") WebElement firstNameInput;
	@FindBy(id="last_name") WebElement lastNameInput;
	@FindBy(id="company") WebElement companyInput;
	@FindBy(id="address1") WebElement address1Input;
	@FindBy(id="address2") WebElement address2Input;
	@FindBy(id="country") WebElement countrySelect;
	@FindBy(id="state") WebElement stateInput;
	@FindBy(id="city") WebElement cityInput;
	@FindBy(id="zipcode") WebElement zipcodeInput;
	@FindBy(id="mobile_number") WebElement mobileNumberInput;
	@FindBy(xpath="//button[@type='submit']") WebElement createAccountButton;

	public String enterAccountInformationText() {
		return enterAccountInformation.getText();
	}
	public void fillRegistrationForm() {
		BasePage.clickOnElement(titleMrsCheckbox);
		passwordInput.sendKeys("45124ase");
		BasePage.clickOnElement(newsletterCheckbox);
		BasePage.clickOnElement(specialOfferCheckbox);
		BasePage.selectDropDown(daySelect, "5");
		BasePage.selectDropDown(monthSelect, "January");
		BasePage.selectDropDown(yearSelect, "1987");
		firstNameInput.sendKeys("Sweety");
		lastNameInput.sendKeys("Test");
		companyInput.sendKeys("TestLauncher");
		address1Input.sendKeys("12, kirk Road");
		address2Input.sendKeys("Bingley");
		BasePage.selectDropDown(countrySelect, "India");// make string country & pass country instead of India
		stateInput.sendKeys("Bath");
		cityInput.sendKeys("Eldwick");
		zipcodeInput.sendKeys("BD163WS");
		mobileNumberInput.sendKeys("5465161845");
		BasePage.clickOnElement(createAccountButton);
	}
	public String addressInformationText() {
		return addressInformation.getText();
	}













}
