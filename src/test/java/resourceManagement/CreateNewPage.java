package resourceManagement;
import javax.naming.InsufficientResourcesException;
import org.openqa.selenium.WebDriver;
import resourceManagementPageObjects.CreateNewPageObjects;
public class CreateNewPage {
	public WebDriver driver;
	private CreateNewPageObjects Cnpo;
	public CreateNewPage(WebDriver driver) {
		this.driver = driver;
	}
	public void CreateNewPageActions(String Location, String ProjectName, String StoragePath, String OS, String Iops,
			String ScalingType, String GivenOption, String TemplateName, String LThreshold, String UThreshold,
			String VcpuValue, String Ramvalue, String DiskSizeValue, String Value, String Condition, String Count,
			String VMBackUpState, String BackUpFrequency, String Retention, String SIEMOption, String SIEMName,
			String VlanName, String SelectAllUserCondition, String usernamesAndRoles, String NumberOfVirtualMachines,
			String VMName) throws InsufficientResourcesException {
		Cnpo = new CreateNewPageObjects(driver);
		Cnpo.SelectLocation(Location);
		Cnpo.SelectProjectName(ProjectName);
		Cnpo.SelectStoragePath(StoragePath);
		Cnpo.SelectOS(OS);
		Cnpo.SelectIops(Iops);
		if (ScalingType.equalsIgnoreCase("Horizontal")) {
			Cnpo.ClickHorizontalScalingButton();
			Cnpo.SelectLowerThreshold(LThreshold);
			Cnpo.SelectUpperThreshold(UThreshold);
			Cnpo.SetVcpu(VcpuValue);
			Cnpo.SetRam(Ramvalue);
			Cnpo.SetDiskSize(DiskSizeValue);
			Cnpo.CheckOrUncheckLoadBalance(Value);
			Cnpo.ClickOnTemplateCheckBox(Condition);
			Cnpo.SetMaxGroupCount(Count);
			Cnpo.SetVMBackUp(VMBackUpState, BackUpFrequency, Retention);
			Cnpo.EnableOrDisableSIEMSwitch(SIEMOption);
			if (SIEMOption.equalsIgnoreCase("yes"))
				Cnpo.SelectSIEM(SIEMName);
			Cnpo.SelectVlan(VlanName);
			Cnpo.GiveVMName(VMName, "Horizontal");
		}
		if (ScalingType.equalsIgnoreCase("Vertical")) {
			Cnpo.ClickVerticalScalingButton();
			Cnpo.SelectLowerThreshold(LThreshold);
			Cnpo.SelectUpperThreshold(UThreshold);
			Cnpo.SetVcpuOfVerticalScaling(VcpuValue);
			Cnpo.SetRamOfVerticalScaling(Ramvalue);
			Cnpo.SetDiskSizeOfVerticalScaling(DiskSizeValue);
			Cnpo.SetVMBackUp(VMBackUpState, BackUpFrequency, Retention);
			Cnpo.EnableOrDisableSIEMSwitch(SIEMOption);
			if (SIEMOption.equalsIgnoreCase("yes"))
				Cnpo.SelectSIEM(SIEMName);
			Cnpo.SelectVlan(VlanName);
			Cnpo.SetNumberOfVirtualMachines(NumberOfVirtualMachines);
			Cnpo.GiveVMName(VMName, "Vertical");
		}
		if (ScalingType.equalsIgnoreCase("none")) {
			Cnpo.SelectCustomOrSavedTemplate(GivenOption);
			if (GivenOption.equalsIgnoreCase("saved templates"))
				Cnpo.SelectVMSizeTemplate(TemplateName);
			if (GivenOption.equalsIgnoreCase("custom")) {
				Cnpo.SetVcpu(VcpuValue);
				Cnpo.SetRam(Ramvalue);
				Cnpo.SetDiskSize(DiskSizeValue);
				Cnpo.ClickOnTemplateCheckBox(Condition);
			}
			Cnpo.SetVMBackUp(VMBackUpState, BackUpFrequency, Retention);
			Cnpo.EnableOrDisableSIEMSwitch(SIEMOption);
			if (SIEMOption.equalsIgnoreCase("yes"))
				Cnpo.SelectSIEM(SIEMName);
			Cnpo.SelectVlan(VlanName);
			Cnpo.SetNumberOfVirtualMachines(NumberOfVirtualMachines);
			Cnpo.GiveVMName(VMName, "none");
		}
		Cnpo.ClickOnAssignRemoteUser();
		Cnpo.AssignUserDetails(SelectAllUserCondition, usernamesAndRoles);
		Cnpo.ClickOnSaveRoles();
		//Cnpo.ClickonCreateButton();
	}
}
