package com.SwagLabs.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.SwagLabs.utilities.ReadConfig;

public class BaseClass {
    WebDriver driver;
	 public static Logger logger;
    ReadConfig readConfig = new ReadConfig();
   String url= readConfig.getbasrUrl();
   String browser = readConfig.getBrowser();
   @BeforeClass
   public void setup() throws Exception {
	  
	   if (browser.equalsIgnoreCase("Firefox")) {
       driver = new FirefoxDriver();
	   }
   else  { throw new Exception("browser is not found");
   
}driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    logger = LogManager.getLogger("MyStoreV1");
	
    driver.get(url);
	logger.info("url opened");
   }
@AfterClass
   public void tearDown() {
	driver.quit();
}
  public void captureScreenshot(WebDriver driver ,String testName) throws IOException {
	  //convert webdriver object to takesscreenshot interface
  TakesScreenshot  screenshot = ((TakesScreenshot)driver);
  //call getscreenshot as method  to create image file
  File src = screenshot.getScreenshotAs(OutputType.FILE);
  File dest = new File (System.getProperty("user.dir" ) + "//Screenshot//" +testName  +".png");
   //copy file frm src to dest
  FileUtils.copyFile(src, dest);
  }
   }
