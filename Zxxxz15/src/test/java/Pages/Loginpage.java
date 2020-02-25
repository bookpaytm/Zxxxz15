package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	
	
	
	
WebDriver driver;
public Loginpage(WebDriver driver){
	this.driver=driver;
}
@FindBy(name="username") WebElement user;
@FindBy(name="password") WebElement pass;
@FindBy(id="tdb1") WebElement button;
public void Testtogcr(String uname,String upass){
	user.sendKeys(uname);
	pass.sendKeys(upass);
	button.click();
	
}
}
