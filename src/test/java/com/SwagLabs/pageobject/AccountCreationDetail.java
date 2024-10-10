package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetail {
WebDriver ldriver;
 public AccountCreationDetail(WebDriver rdriver) {
	 ldriver = rdriver;
 PageFactory.initElements(rdriver, this);
 }
@FindBy(xpath ="//input[@id='id_gender1']")
WebElement titleMr;
@FindBy(id ="customer_firstname")
WebElement firstName;
@FindBy(id = "customer_lastname")
WebElement lastName;
@FindBy(id = "passwd")
WebElement password;
@FindBy(xpath = "//span[normalize-space()='Register']")
WebElement RegisterButton;
public void selectTitle() {
	titleMr.click(); }
public void enterCustomerFirstName(String fname) {
 firstName.sendKeys(fname);
 }
public void enterCustomerlastName(String lname) {
lastName.sendKeys(lname);	
}
public void enterPassword(String pwd) {
password.sendKeys(pwd);
}
public void clickOnRegisterButton() {
	RegisterButton.click();
}
}
