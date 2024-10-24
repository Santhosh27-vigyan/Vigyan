package resourceManagement;

import org.openqa.selenium.WebDriver;

import resourceManagementPageObjects.HomePagePageObjects;
import resourceManagementPageObjects.StoragePageObjects;

public class HomePage {
	public WebDriver driver;
	private HomePagePageObjects Hppo;
	private StoragePageObjects Spo;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String  HomePageActions(String ResourceName,String StoragePathName,String RowNumber) {
		Hppo = new HomePagePageObjects(driver);
		if(!RowNumber.equalsIgnoreCase("All"))
		Hppo.ResourceManagementOption().click();
		Spo=new StoragePageObjects(driver);
		String StroragePathName=Spo.GetAvailableSize(StoragePathName);
		Hppo.CreateResourceOption().click();
		Hppo.ClickOnCreate(ResourceName);
		return StroragePathName;
	}

}
