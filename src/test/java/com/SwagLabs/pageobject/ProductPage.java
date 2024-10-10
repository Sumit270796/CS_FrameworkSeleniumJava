 package com.SwagLabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
 WebDriver ldriver;
    public ProductPage(WebDriver rdriver) {
    ldriver =rdriver;
    PageFactory.initElements(rdriver,this);
}
@FindBy(id = "quantity_wanted")
WebElement quantityWanted;

@FindBy(id = "group_1")
WebElement size;

}