package resourceManagement;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import resourceManagementPageObjects.LoginPageObjects;

public class Login {
public WebDriver driver;
public LoginPageObjects LPO;
public Login(WebDriver driver)
{
	this.driver=driver;
}
public void LoginPageActions() throws IOException
{
	Properties prop=new Properties();
	FileInputStream Fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(Fis);
	LPO=new LoginPageObjects(driver);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	LPO.cert();	
	assertTrue(LPO.UsernameDisplayed().isDisplayed());
	LPO.PassUsername().sendKeys(prop.getProperty("username"));
	LPO.PassPassword().sendKeys(prop.getProperty("password"));
	LPO.ClickOnLogin().click();
}
}
