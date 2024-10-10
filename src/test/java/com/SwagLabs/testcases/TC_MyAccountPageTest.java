package com.SwagLabs.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SwagLabs.pageobject.AccountCreationDetail;
import com.SwagLabs.pageobject.IndexPage;
import com.SwagLabs.pageobject.MYAccount;
import com.SwagLabs.pageobject.RegisterUserAccount;

import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass {
	@Test (enabled =false)
	public void verifyRegistrationAndLogin() {
	
		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignin();
		MYAccount pg1 = new MYAccount(driver);
		pg1.enterCreateEmailAddress("grhg123@gmail.com");
		logger.info("EnterEmail");
		pg1.clickSubmitCreate();
		logger.info("Click on submit button");
		AccountCreationDetail accCreationPg = new AccountCreationDetail(driver);
		accCreationPg.selectTitle();
		accCreationPg.enterCustomerFirstName("Sumit");
		accCreationPg.enterCustomerlastName("Verma");
		accCreationPg.enterPassword("abc125");

		logger.info("enter user detail on account creation page");
		accCreationPg.clickOnRegisterButton();
		logger.info("click on submit button");

		RegisterUserAccount regUser =  new  RegisterUserAccount(driver);
		String userName=  regUser.getUserName();
		Assert.assertEquals("Sumit Verma", userName); 

	}
    @Test
    public void verifyLogin() throws IOException {

		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignin();	
   logger.info("click on signin button");
    MYAccount myAcPg = new MYAccount(driver);
    myAcPg.enterEmailAddress("grhg123@gmail.com");
    myAcPg.enterPassword("abc125");
    myAcPg.clickSubmit();

	RegisterUserAccount regUser =  new  RegisterUserAccount(driver);
	String userName=  regUser.getUserName();
  if(userName.equals("Sumit Singh")) {
	  logger.info("verifyLogin - Passed");
	 Assert.assertTrue(true);
  }
  else { logger.info("verifyLogin- Failed");
    captureScreenshot(driver, "verifyLogin");
   Assert.assertTrue(false);
  }


}}
