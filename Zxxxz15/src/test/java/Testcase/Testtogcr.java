package Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Baseclass;
import Pages.Loginpage;
import Utilities.Browserfactory;
import Utilities.Exceldataprovider;

public class Testtogcr  extends Baseclass{

	
	
	

@Test(priority=1)
public void launchapp(){
logger=report.createTest("Testtogcr1");
Loginpage login=PageFactory.initElements(driver, Loginpage.class);
logger.info("start application");
login.Testtogcr(excel.getString("login", 0, 0), excel.getString("login", 0, 1));
logger.pass("application is passed");
}
@Test(priority=2)
public void closeapp(){
logger=report.createTest("Testtogcritlogout");
logger.fail("application is failed");
}
}
