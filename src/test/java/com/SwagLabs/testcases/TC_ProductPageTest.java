package com.SwagLabs.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.SwagLabs.pageobject.IndexPage;
import com.SwagLabs.pageobject.MYAccount;
import com.SwagLabs.pageobject.RegisterUserAccount;
import com.SwagLabs.pageobject.SearchResultPage;

public class TC_ProductPageTest extends BaseClass {

 public void VerifySearchProduct() throws IOException {
	 String searchKey ="T-Shirt";
   IndexPage pg = new IndexPage(driver);
   pg.clickOnSignin();
    
   MYAccount pg1 =new MYAccount(driver);
   pg1.enterEmailAddress("emailAddrress");
   pg1.enterPassword("password");
   pg1.clickSubmit();
   
   RegisterUserAccount productPg = new RegisterUserAccount(driver);
   productPg.enterDataInSearchBox(searchKey);
   productPg.clickOnSearchButton();
   
   SearchResultPage resultPg=  new SearchResultPage(driver);
   String searchResultProductName =resultPg.getSearchResultProductName();
   if (searchResultProductName.contains(searchKey)) {
	   assertTrue(true);
	   productPg.clickOnSignOut();
   }
   else {
	   captureScreenshot(driver,"VerifySearchProduct");
     assertTrue(false);
   }
   
 
 
 
 
 }


}
