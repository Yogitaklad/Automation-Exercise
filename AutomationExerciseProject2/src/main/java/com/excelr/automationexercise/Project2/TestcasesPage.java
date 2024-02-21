package com.excelr.automationexercise.Project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestcasesPage {
	public TestcasesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Repository

	@FindBy(xpath="//div[@class='panel-group']/div/div/h4/a/u") WebElement testCases ;
}
