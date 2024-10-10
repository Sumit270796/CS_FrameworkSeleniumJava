package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
WebDriver ldriver;
  public SearchResultPage(WebDriver rdriver) {
	 ldriver = rdriver;
PageFactory.initElements(rdriver, this);
   }

@FindBy(xpath ="//*[@id='center_column']/ul/li/div/div[2]/h5/a")
WebElement searchResultPrroduct;

@FindBy(linkText = "More")
WebElement more;

public String getSearchResultProductName() {
	return(searchResultPrroduct.getText());
}
public void ClickOnMoreLink() {
more.click();
}
}