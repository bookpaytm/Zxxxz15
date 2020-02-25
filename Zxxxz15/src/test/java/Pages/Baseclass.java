package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.Browserfactory;
import Utilities.Configuredataprovider;
import Utilities.Exceldataprovider;
import Utilities.Helper;

public class Baseclass {

	
	
	
public WebDriver driver;
public Exceldataprovider excel;
public Configuredataprovider config;
public ExtentReports report;
public ExtentTest logger;
@BeforeSuite
public void setSuite(){
	Reporter.log("application is ready to launch");
 excel=new Exceldataprovider();	
 config=new Configuredataprovider();
 
 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/shabnam"+Helper.getDateTime()+".html"));
 report=new ExtentReports();
 report.attachReporter(extent);
 Reporter.log("application is run");
}
@BeforeClass
public void setup(){
	Reporter.log("browser is launching");
driver=Browserfactory.startapplication(driver, config.getbrowser(), config.getURL());
Reporter.log("browser is running");
}
@AfterClass
public void setdown(){
	Reporter.log("Test is about to end");
	Browserfactory.quitbrowser(driver);
}
@AfterMethod
public void getDateTime(ITestResult result) throws IOException{
	if(result.getStatus()==ITestResult.SUCCESS){
	
logger.pass("test case is passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.FAILURE){
logger.fail("test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
	}
	else {
		System.out.println("unsucessfully failed");
	}
report.flush();	
Reporter.log("test is completed");
}

}
