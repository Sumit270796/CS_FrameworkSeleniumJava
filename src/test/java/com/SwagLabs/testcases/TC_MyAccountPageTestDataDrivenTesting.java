package com.SwagLabs.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SwagLabs.pageobject.AccountCreationDetail;
import com.SwagLabs.pageobject.IndexPage;
import com.SwagLabs.pageobject.MYAccount;
import com.SwagLabs.pageobject.RegisterUserAccount;
import com.SwagLabs.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {
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
    @Test(dataProvider = "LoginDataPrrovider")
    public void verifyLogin(String userEmail, String userPWD, String expectedUserName) throws IOException {

		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignin();	
   logger.info("click on signin button");
    MYAccount myAcPg = new MYAccount(driver);
    myAcPg.enterEmailAddress(userEmail);
    myAcPg.enterPassword(userPWD);
    myAcPg.clickSubmit();

	RegisterUserAccount regUser =  new  RegisterUserAccount(driver);
	String userName=  regUser.getUserName();
  if(userName.equals(expectedUserName)) {
	  logger.info("verifyLogin - Passed");
	 Assert.assertTrue(true);
     regUser.clickOnSignOut();
  }
  else { logger.info("verifyLogin- Failed");
    captureScreenshot(driver, "verifyLogin");
   Assert.assertTrue(false);
  }}
@DataProvider (name = "LoginDataPrrovider")
    public String[][] LoginDataProvider() {
	String fileName = System.getProperty("user.dir") +"\\TestData\\data.xlsx";
	int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
   int ttlColumn =  ReadExcelFile.getColCount(fileName, "LoginTestData");
   String data[][] = new String[ttlRows-1][ttlColumn];
   for (int i=1;i<ttlRows; i++) {
	   for (int j=0; j<ttlColumn; j++) {
		   data[i-1][j] =ReadExcelFile.getCellValue(fileName, "LoginTestData",i, j);
	   }}
   return data;
	
	
}}
