package com.SwagLabs.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
 ExtentSparkReporter htmlReporter;
 ExtentReports reports;
 ExtentTest  test;
public void configureReport () {
	ReadConfig readConfig= new ReadConfig();
	String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
    String reportName ="MyStoreTestReport" +timestamp +".html" ;
	htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" +reportName);
	 reports = new ExtentReports();       
	 reports.attachReporter(htmlReporter);
	 //add system information or enviironment information in report
	 reports.setSystemInfo("Machine", "testpc1");
     reports.setSystemInfo("OS", "Window10");
     reports.setSystemInfo("browser", readConfig.getBrowser());
      reports.setSystemInfo("username", "Sumit");
     
      //look and feel of report
      htmlReporter.config().setDocumentTitle("Extent listener report Demo");
      htmlReporter.config().setReportName("this is my first report");
      htmlReporter.config().setTheme(Theme.DARK);
}
					
	

    @Override		
    public void onFinish(ITestContext result ) {					
System.out.println("On finish invoked");				
 reports.flush();       
//it is mandatory  to represent the report 		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
    	configureReport ();
    	System.out.println("on start of test case");			
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
      System.out.println(result.getName());  		
     test =reports.createTest(result.getName())  ;	//create entry in report	
    test.log(Status.FAIL, MarkupHelper.createLabel("name of failed testcase is :"+result.getName(), ExtentColor.RED));
    String screenShotPath = System.getProperty("user.dir") + "\\Screenshot\\" +  result.getName() + ".png" ;
    File screenShotFile = new File (screenShotPath);
    if (screenShotFile.exists()) {
    	test.fail("capture screenshot is below "   +test.addScreenCaptureFromPath(screenShotPath));
    }
    
    // test.addScreenCaptureFromPath(null))
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
    	 System.out.println(result.getName());			
    	 test =reports.createTest(result.getName())  ;	//create entry in report	
    	    test.log(Status.SKIP, MarkupHelper.createLabel("name of skipped testcase is :"+result.getName(), ExtentColor.YELLOW));  		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
   	 System.out.println(result.getName());				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
   	 System.out.println(result.getName());					
   	 test =reports.createTest(result.getName())  ;	//create entry in report	
	    test.log(Status.PASS, MarkupHelper.createLabel("name of success testcase is :"+result.getName(), ExtentColor.GREEN));     		
    }		
}		


