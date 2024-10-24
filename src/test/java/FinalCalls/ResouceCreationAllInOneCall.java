package FinalCalls;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.naming.InsufficientResourcesException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resourceManagement.CreateNewPage;
import resourceManagement.HomePage;
import resourceManagement.Login;
import resourceManagementPageObjects.HomePagePageObjects;
import resources.Base;
import utilities.ExcelUtils;

public class ResouceCreationAllInOneCall extends Base {
	public WebDriver driver;
	private Login log;
	private HomePage Home;
	private HomePagePageObjects Hppo;
	private CreateNewPage CreateNew;
	private String StoragePathFromHome;
	private String RowNumber;
	
	@Parameters("ResourceName")
	@BeforeTest
 	public void intializeDriver(String ResourceName) throws IOException {
		driver = InitializeDriver();
		this.RowNumber=ResourceName;
	}
	@Test(priority = 1)
	public void LoginPage() throws IOException {
		log = new Login(driver);
		log.LoginPageActions();
		Hppo = new HomePagePageObjects(driver);
		Hppo.ResourceManagementOption().click();
	}
	@Test(priority = 2,dataProvider = "dataProvider",dependsOnMethods ="LoginPage",alwaysRun = false)
	public void HomeAndCreateNew(String ResourceName, String StoragePathName,String Location, String ProjectName, String StoragePath, String OS, String Iops,
			String ScalingType, String GivenOption, String TemplateName, String LThreshold, String UThreshold,
			String VcpuValue, String Ramvalue, String DiskSizeValue, String Value, String Condition, String Count,
			String VMBackUpState, String BackUpFrequency, String Retention, String SIEMOption, String SIEMName,
			String VlanName, String SelectAllUserCondition, String usernamesAndRoles, String NumberOfVirtualMachines,
			String VMName) throws InsufficientResourcesException
	{
		
		
		
		Home = new HomePage(driver);
//		System.out.println(ResourceName);
		StoragePathFromHome = Home.HomePageActions(ResourceName, StoragePathName,RowNumber);
		StoragePath = StoragePathFromHome;
		CreateNew = new CreateNewPage(driver);
		CreateNew.CreateNewPageActions(Location, ProjectName, StoragePath, OS, Iops, ScalingType, GivenOption,
				TemplateName, LThreshold, UThreshold, VcpuValue, Ramvalue, DiskSizeValue, Value, Condition, Count,
				VMBackUpState, BackUpFrequency, Retention, SIEMOption, SIEMName, VlanName, SelectAllUserCondition,
				usernamesAndRoles, NumberOfVirtualMachines, VMName);
		
	}
	@DataProvider
	public Object[][] dataProvider(Method method) throws IOException {
		if (method.getName().equals("HomeAndCreateNew")) {
			Object[][] Data = ExcelUtils.GetExcelData("AllInOne",
					System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\Data.xlsx",
					RowNumber);
			return Data;
		}
		else
			return null;
	}

}
