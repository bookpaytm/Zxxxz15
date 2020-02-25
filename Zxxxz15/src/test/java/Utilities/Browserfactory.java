package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {
	
	
	
	
	
public static WebDriver startapplication(WebDriver driver,String browsername,String appurl){
if(browsername.equals("Chrome")){
System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
driver=new ChromeDriver();
System.out.println("passed");
}
else {
	System.out.println("unsucessfully");
}
driver.manage().window().maximize();
driver.get(appurl);
return driver;
}
public static void quitbrowser(WebDriver driver){
	driver.quit();
}







}