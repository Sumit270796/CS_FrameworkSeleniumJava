package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
WebDriver ldriver;
public  IndexPage(WebDriver rdriver) {
	ldriver =rdriver;
  PageFactory.initElements(rdriver,this);
}
@FindBy(linkText = "Sign in")
WebElement Signin;
	
public void clickOnSignin() {
	Signin.click();
}}