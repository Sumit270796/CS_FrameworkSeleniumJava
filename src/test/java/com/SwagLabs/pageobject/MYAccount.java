package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MYAccount {
  WebDriver ldriver;
  public MYAccount(WebDriver rdriver) {
	  ldriver = rdriver;
    PageFactory.initElements(rdriver,this);
  }//create new account
 @FindBy(id = "email_create")
 WebElement createEmailId;

 @FindBy(id = "SubmitCreate")
WebElement SubmitCreate;

 //registered user
 
 @FindBy(id = "email")
WebElement registeredUserEmail;

 @FindBy(id ="passwd")
WebElement registeredUserPwd;
 
 @FindBy(id ="SubmitLogin")
 WebElement  submitLogin;
 
 public void enterCreateEmailAddress(String EmailAdd) {
	createEmailId.sendKeys(EmailAdd);
}
public void clickSubmitCreate() {
	SubmitCreate.click();
}

//Action for already registered user
public void enterEmailAddress(String emailAdd) {
	registeredUserEmail.sendKeys(emailAdd);
	}
public void enterPassword(String pwd) {
	registeredUserPwd.sendKeys(pwd);
}
public void clickSubmit() {
	submitLogin.click();
}}





