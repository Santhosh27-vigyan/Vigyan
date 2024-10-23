package FinalCalls;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.naming.InsufficientResourcesException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resourceManagement.CreateNewPage;
import resourceManagement.HomePage;
import resourceManagement.Login;
import resources.Base;
import utilities.ExcelUtils;

public class ResourceCreationFinalCall extends Base {
	public WebDriver driver;
	private Login log;
	private HomePage Home;
	private CreateNewPage CreateNew;
	private String StoragePathFromHome;

	@BeforeTest
	public void intializeDriver() throws IOException {
		driver = InitializeDriver();
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException {
		log = new Login(driver);
		log.LoginPageActions();
	}

	@Test(priority = 2, dataProvider = "dataProvider", alwaysRun = false, dependsOnMethods = "LoginPage")
	public void Home(String ResourceName, String StoragePathName) {
		Home = new HomePage(driver);
		System.out.println(ResourceName);
		StoragePathFromHome = Home.HomePageActions(ResourceName, StoragePathName);
	}

	@Test(priority = 3, dataProvider = "dataProvider", alwaysRun = false, dependsOnMethods = "Home", enabled = true)
	public void CreateNew(String Location, String ProjectName, String StoragePath, String OS, String Iops,
			String ScalingType, String GivenOption, String TemplateName, String LThreshold, String UThreshold,
			String VcpuValue, String Ramvalue, String DiskSizeValue, String Value, String Condition, String Count,
			String VMBackUpState, String BackUpFrequency, String Retention, String SIEMOption,String SIEMName, String VlanName,
			String SelectAllUserCondition, String usernamesAndRoles, String NumberOfVirtualMachines, String VMName)
			throws InsufficientResourcesException {
		// StoragePath value in the "Details" Sheet from excel is not used its a dummy
		// data for the same variable, the value we fetched from the Storage page (Home
		// Test) for a storage
		// path is initialized. If you want to change storage path ,change it in the
		// "ResourceName" Sheet in the excel file not in Details Sheet.
		StoragePath = StoragePathFromHome;
		CreateNew = new CreateNewPage(driver);
		CreateNew.CreateNewPageActions(Location, ProjectName, StoragePath, OS, Iops, ScalingType, GivenOption,
				TemplateName, LThreshold, UThreshold, VcpuValue, Ramvalue, DiskSizeValue, Value, Condition, Count,
				VMBackUpState, BackUpFrequency, Retention, SIEMOption,SIEMName, VlanName, SelectAllUserCondition, usernamesAndRoles,
				NumberOfVirtualMachines, VMName);
	}

	@DataProvider
	public Object[][] dataProvider(Method method) throws IOException {
		if (method.getName().equals("Home")) {
			Object[][] Data = ExcelUtils.GetExcelData("ResourceName",
					System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\Data.xlsx");
			return Data;
		}
		if (method.getName().equals("CreateNew")) {
			Object[][] Data = ExcelUtils.GetExcelData("Details",
					System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\Data.xlsx");
			return Data;
		} else
			return null;
	}
}
