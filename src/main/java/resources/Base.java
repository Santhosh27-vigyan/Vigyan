package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public String username;
	public String password;
public WebDriver InitializeDriver() throws IOException
{
	Properties prop=new Properties();
	FileInputStream Fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(Fis);
	WebDriver driver = new ChromeDriver();
	return driver;
}

}
