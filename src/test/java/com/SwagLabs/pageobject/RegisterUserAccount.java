package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {
	WebDriver ldriver;
	public RegisterUserAccount(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;

	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	@FindBy(name ="search_query")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement submit_search;
	
	
	public void clickOnSignOut() {
		signOut.click();
	
	}
	
	public String getUserName() {
		String text = userName.getText();
		return text;

	}
 public void enterDataInSearchBox(String searchKey) {
	 searchBox.sendKeys(searchKey);
 }

public void clickOnSearchButton() {
	submit_search.click();
}

}
