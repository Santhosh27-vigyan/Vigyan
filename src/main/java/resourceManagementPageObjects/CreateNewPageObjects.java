package resourceManagementPageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.naming.InsufficientResourcesException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CreateNewPageObjects {
	public WebDriver driver;
	private WebDriverWait wait;
	private WebDriverWait wait2;
	private WebDriverWait wait3;
	private JavascriptExecutor js;
	private Actions a;

	public CreateNewPageObjects(WebDriver driver) {
		this.driver = driver;
		a = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(1));
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='add-form-title']")
	private WebElement Title;
	@FindBy(id = "location")
	private WebElement LocationOptions;
	@FindBy(id = "vmprojectname")
	private WebElement ProjectNames;
	@FindBy(id = "targetstoragepath")
	private WebElement StoragePathOptions;
	@FindBy(id = "vmos")
	private WebElement OSOptions;
	@FindBy(id = "iops")
	private WebElement IopsOptions;
	@FindBy(id = "customSwitches1")
	private WebElement HorizontalScalingButton;
	@FindBy(id = "customSwitches")
	private WebElement VerticalScalingButton;
	@FindBy(id = "vm_size_type_custom")
	private WebElement CustomRadioButton;
	@FindBy(id = "vm_size_type_favorite_template")
	private WebElement SavedTemplatesRadioButton;
	@FindBy(id = "vm-favorite-size-selector")
	private WebElement SavedTemplates;
	@FindBy(id = "lower_threshold_selector")
	private WebElement LowerThreshold;
	@FindBy(id = "upper_threshold_selector")
	private WebElement UpperThreshold;
	@FindBy(xpath = "//label[@for='vcpu']/parent::div //span[@class='irs-handle single']")
	private WebElement VcpuScalingButton;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[contains(@class,'irs-handle from')]")
	private WebElement VerticalVcpuScalingFromButton;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[contains(@class,'irs-handle to')]")
	private WebElement VerticalVcpuScalingToButton;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[contains(@class,'irs-min')]")
	private WebElement VerticalVcpuScalingMin;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[contains(@class,'irs-max')]")
	private WebElement VerticalVcpuScalingMax;
	@FindBy(xpath = "//label[@for='vcpu']/parent::div //span[@class='irs-single']")
	private WebElement VcpuValue;
	@FindBy(xpath = "//label[@for='vcpu']/parent::div //span[@class='irs-min']")
	private WebElement VcpuValueMin;
	@FindBy(xpath = "//label[@for='vcpu']/parent::div //span[@class='irs-max']")
	private WebElement VcpuValueMax;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[@class='irs-from']")
	private WebElement VerticalScalingVcpuFromValue;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[@class='irs-to']")
	private WebElement VerticalScalingVcpuToValue;
	@FindBy(xpath = "//label[@for='vcpu_range_1']/parent::div //span[@class='irs-single']")
	private WebElement VerticalScalingVcpuFromToValue;
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement Alert;
	@FindBy(xpath = "//button[contains(@class,'bootbox-accept')]")
	private WebElement AlertOkButton;
	@FindBy(className = "bootbox-body")
	private WebElement AlertMessage;
	@FindBy(xpath = "//label[@for='ram']/parent::div //span[@class='irs-handle single']")
	private WebElement RamScalingButton;
	@FindBy(xpath = "//label[@for='ram']/parent::div //span[@class='irs-single']")
	private WebElement RamValue;
	@FindBy(xpath = "//label[@for='ram']/parent::div //span[@class='irs-min']")
	private WebElement RamValueMin;
	@FindBy(xpath = "//label[@for='ram']/parent::div //span[@class='irs-max']")
	private WebElement RamValueMax;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[contains(@class,'irs-handle from')]")
	private WebElement VerticalRamScalingFromButton;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[contains(@class,'irs-handle to')]")
	private WebElement VerticalRamScalingToButton;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[@class='irs-from']")
	private WebElement VerticalScalingRamFromValue;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[@class='irs-to']")
	private WebElement VerticalScalingRamToValue;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[@class='irs-single']")
	private WebElement VerticalScalingRamFromToValue;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[@class='irs-min']")
	private WebElement VerticalScalingRamValueMin;
	@FindBy(xpath = "//label[@for='ram_range_1']/parent::div //span[@class='irs-max']")
	private WebElement VerticalScalingRamValueMax;
	@FindBy(xpath = "//label[@for='target_disk_size']/parent::div //span[@class='irs-handle single']")
	private WebElement DiskSizeScalingButton;
	@FindBy(xpath = "//label[@for='auto_target_disk_size']/parent::div //span[@class='irs-handle single']")
	private WebElement VerticalScalingDiskSizeScalingButton;
	@FindBy(xpath = "//label[@for='target_disk_size']/parent::div //span[@class='irs-single']")
	private WebElement DiskSizeValue;
	@FindBy(xpath = "//label[@for='target_disk_size']/parent::div //span[@class='irs-min']")
	private WebElement DiskSizeValueMin;
	@FindBy(xpath = "//label[@for='target_disk_size']/parent::div //span[@class='irs-max']")
	private WebElement DiskSizeValueMax;
	@FindBy(xpath = "//label[@for='auto_target_disk_size']/parent::div //span[@class='irs-single']")
	private WebElement VerticalScalingDiskSizeValue;
	@FindBy(xpath = "//label[@for='auto_target_disk_size']/parent::div //span[@class='irs-min']")
	private WebElement VerticalScalingDiskSizeValueMin;
	@FindBy(xpath = "//label[@for='auto_target_disk_size']/parent::div //span[@class='irs-max']")
	private WebElement VerticalScalingDiskSizeValueMax;
	@FindBy(xpath = "//span[@class='availability-status-resource']")
	private WebElement InsufficienterrorMessage;
	@FindBy(id = "vmHzSwitchesLB")
	private WebElement LoadBalancerButton;
	@FindBy(xpath = "//label[@for='favorite_checkbox']")
	private WebElement TemplateCheckBox;
	@FindBy(id = "decrease1")
	private WebElement decreaseButton;
	@FindBy(id = "increase1")
	private WebElement IncreaseButton;
	@FindBy(xpath = "//label[@for='vm_backup_interval']")
	private WebElement BackUpfrequencyLabel;
	@FindBy(id = "vmBackupSwitches")
	private WebElement VMBackupButton;
	@FindBy(id = "vm_backup_interval")
	private WebElement BackUpFrequencyOptions;
	@FindBy(id = "retention")
	private WebElement RetentionPeriodOptions;
	@FindBy(id = "SIEMcustomSwitches")
	private WebElement SIEMSwitch;
	@FindBy(className = "availability-status-siem")
	private WebElement SIEMErrorMessage;
	@FindBy(id = "siem-vm-list")
	private WebElement SIEMVmList;
	@FindBy(id = "vlanname")
	private WebElement VlanOptions;
	@FindBy(xpath = "//input[@class='form-control' and contains(@id,'new')]")
	private List<WebElement> VmNameTextBox;
	@FindBy(xpath = "//input[contains(@id,'new')]/following-sibling::span[contains(@class,'availability-status') and contains(@class,'available')]")
	private List<WebElement> AvailabityMessage;
	@FindBy(id = "assign_user")
	private WebElement AssignRemoteUserButton;
	@FindBy(id = "selectall")
	private WebElement SelectAllUsersButton;
	@FindBy(xpath = "//input[contains(@class,'singlecheck')]")
	private List<WebElement> UserNames;
	@FindBy(xpath = "//input[@type='radio' and @value='0']")
	private List<WebElement> AdminRadioButtons;
	@FindBy(xpath = "//input[@type='radio' and @value='1']")
	private List<WebElement> UserRadioButtons;
	@FindBy(className = "toast-message")
	private WebElement UserReatedErrorMessage;
	@FindBy(id = "save_roles")
	private WebElement SaverolesButton;
	@FindBy(id = "create_vm")
	private WebElement CreateButton;
	@FindBy(id = "number")
	private WebElement NumberOfVirtualMachines;
	@FindBy(xpath = "//div[@id='vmNumber'] //div[@id='decrease']")
	private WebElement VMDecreaseButton;
	@FindBy(xpath = "//div[@id='vmNumber'] //div[@id='increase']")
	private WebElement VMIncreaseButton;
	@FindBy(xpath = "//label[@class='error']")
	private List<WebElement> AllErrorMessage;

	public void SelectLocation(String Location) {
		// LocationOptions.click();
		wait.until(ExpectedConditions.visibilityOf(Title));
		Select Locations = new Select(LocationOptions);
		Locations.selectByVisibleText(Location);
	}

	public void SelectProjectName(String ProjectName) {
		wait.until(ExpectedConditions.elementToBeClickable(ProjectNames));
		Select Projects = new Select(ProjectNames);
		Projects.selectByVisibleText(ProjectName);
	}

	public void SelectStoragePath(String StoragePath) {
		wait.until(ExpectedConditions.elementToBeClickable(StoragePathOptions));
		Select Paths = new Select(StoragePathOptions);
		Paths.selectByVisibleText(StoragePath);
	}

	public void SelectOS(String OSType) {
		js.executeScript("arguments[0].scrollIntoView(true);", OSOptions);
		Select OS = new Select(OSOptions);
		OS.selectByVisibleText(OSType);
	}

	public void SelectIops(String IopsValue) {
		Select Iops = new Select(IopsOptions);
		Iops.selectByVisibleText(IopsValue);
	}

	public void ClickHorizontalScalingButton() {
		js.executeScript("arguments[0].click();", HorizontalScalingButton);
		if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
			throw new Error(InsufficienterrorMessage.getText());
	}

	public void ClickVerticalScalingButton() {
		js.executeScript("arguments[0].click();", VerticalScalingButton);
		if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
			throw new Error(InsufficienterrorMessage.getText());
	}

	public void SelectCustomOrSavedTemplate(String SelectedOption) {
		if (SelectedOption.equalsIgnoreCase("custom"))
			js.executeScript("arguments[0].click();", CustomRadioButton);
		if (SelectedOption.equalsIgnoreCase("Saved templates")) {
			js.executeScript("arguments[0].click();", SavedTemplatesRadioButton);
		}
		if (!SelectedOption.equalsIgnoreCase("custom") && !SelectedOption.equalsIgnoreCase("Saved templates"))
			throw new Error("Please give Proper option to select");
	}

	public void SelectVMSizeTemplate(String TemplateName) {
		Select VMSizeTemplate = new Select(SavedTemplates);
		VMSizeTemplate.selectByVisibleText(TemplateName);
	}

	public void SelectLowerThreshold(String ThresholdValue) {
		Select Lthreshold = new Select(LowerThreshold);
		Lthreshold.selectByValue(ThresholdValue);
	}

	public void SelectUpperThreshold(String ThresholdValue) {
		Select Uthreshold = new Select(UpperThreshold);
		Uthreshold.selectByValue(ThresholdValue);
	}

	public void SetVcpu(String value) throws InsufficientResourcesException {
		if (value.contains("-"))
			throw new Error("Cannot have values in " + value + " format");

		ConditionCheck(value, VcpuValueMin);
		if (Integer.parseInt(value) <= Integer.parseInt(VcpuValueMax.getText())) {
			VcpuScalingButton.click();
			mainloop: while (true) {
				// System.out.println(VcpuValue.getText() + " " + value);
				if (VcpuValue.getText().equals(value))
					break mainloop;
				else
					a.moveToElement(VcpuScalingButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (VcpuValue.getText() != "") {
					if (Integer.parseInt(VcpuValue.getText()) > Integer.parseInt(value))
						throw new Error("Script error");
				}
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + value + ") Should be less than " + VcpuValueMax.getText());
		}
	}

	public void SetVcpuOfVerticalScaling(String value) throws InsufficientResourcesException {
		String[] FromAndTo = value.split("-");
		if (FromAndTo.length <= 1)
			throw new Error("need From and Two value (ex: 2-6) for vertical scaling");
		String min = ConditionCheck(value, VerticalVcpuScalingMin);
		VerticalVcpuScalingToButton.click();
		// wait.until(ExpectedConditions.textToBePresentInElement(VerticalScalingVcpuToValue,"4"));
		if (Integer.parseInt(FromAndTo[1]) <= Integer.parseInt(VerticalVcpuScalingMax.getText())) {
			mainloop: while (true) { // System.out.println(VerticalScalingVcpuToValue.getText()+" "+FromAndTo[1]);
//				if (VerticalScalingVcpuToValue.getAttribute("style").contains("visible")) {
//					if (VerticalScalingVcpuToValue.getText().equals(FromAndTo[1]) || FromAndTo[1].equals("4"))
//						break mainloop;
//					else
//						a.moveToElement(VerticalVcpuScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//				} else if (VerticalScalingVcpuToValue.getAttribute("style").contains("hidden")) {
//					// System.out.println(VerticalScalingVcpuFromToValue.getText().contains(FromAndTo[1])
//					// || FromAndTo[1].equals("4"));
//					if (VerticalScalingVcpuFromToValue.getText().contains(FromAndTo[1]) || FromAndTo[1].equals("4"))
//						break mainloop;
//					else
//						a.moveToElement(VerticalVcpuScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				}
				String[] VerticalScalingVcpuToValueGettext = ((String) js
						.executeScript("return arguments[0].textContent;", VerticalScalingVcpuToValue)).split("\\s+G");
				if (VerticalScalingVcpuToValueGettext[0].equals(FromAndTo[1]) || FromAndTo[1].equals("4"))
					break mainloop;
				else
					a.moveToElement(VerticalVcpuScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (VerticalScalingVcpuToValueGettext[0] != "") {
					if (Integer.parseInt(String.valueOf(VerticalScalingVcpuToValueGettext[0])) > Integer
							.parseInt(FromAndTo[1]))
						throw new Error("Script error");
				}
			}
		} else {
			throw new Error(
					"Given Value(" + FromAndTo[1] + ") Should be less than " + VerticalVcpuScalingMax.getText());
		}
		// wait.until(ExpectedConditions.visibilityOf(VerticalVcpuScalingMin));
		if (Integer.parseInt(FromAndTo[0]) >= 2) {
			VerticalVcpuScalingFromButton.click();
			mainloop1: while (true) {
//				if (VerticalScalingVcpuFromValue.getAttribute("style").contains("visible")) {// System.out.println(VerticalScalingVcpuFromValue.getText()+"
//																								// "+FromAndTo[0]);
//					if (VerticalScalingVcpuFromValue.getText().equals(FromAndTo[0]))
//						break mainloop1;
//					else
//						a.moveToElement(VerticalVcpuScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				} else if (VerticalScalingVcpuFromValue.getAttribute("style").contains("hidden")) {
//
//					if (VerticalScalingVcpuFromToValue.getText().contains(FromAndTo[0]) || FromAndTo[0].equals("2"))
//						break mainloop1;
//					else
//						a.moveToElement(VerticalVcpuScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				}
				String[] VerticalScalingVcpuFromValueGettext = ((String) js
						.executeScript("return arguments[0].textContent;", VerticalScalingVcpuFromValue))
						.split("\\s+G");
				System.out.println(Integer.parseInt(VerticalScalingVcpuFromValueGettext[0].replace(" ", "").trim())
						+ "  " + FromAndTo[1]);
				if (!(Integer.parseInt(VerticalScalingVcpuFromValueGettext[0].replace(" ", "").trim()) < Integer
						.valueOf(FromAndTo[1]))) {
					try {
						if (Alert.isDisplayed()) {
							wait.until(ExpectedConditions.elementToBeClickable(AlertOkButton));
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// js.executeScript("arguments[0].click();", AlertOkButton);
							AlertOkButton.click();
							throw new Error(AlertMessage.getText());
						}
					} catch (NoSuchElementException e) {
						// TODO: handle exception
					}
				}
				if (VerticalScalingVcpuFromValueGettext[0].equals(FromAndTo[0]))
					break mainloop1;
				else
					a.moveToElement(VerticalVcpuScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + FromAndTo[0] + ") Should be greater than " + min);
		}
	}

	public void SetRam(String value) throws InsufficientResourcesException {
		a.moveToElement(RamScalingButton).click().build().perform();
		if (value.contains("-"))
			throw new Error("Cannot have values in " + value + " format");
		ConditionCheck(value, RamValueMin);
		String[] Max = RamValueMax.getText().split("\\s+G");
		if (Integer.parseInt(value) <= Integer.parseInt(Max[0].replace(" ", ""))) {
			mainloop: while (true) {
				// System.out.println(RamValue.getText() + " " + value + " " + "GB");
				if (RamValue.getText().equals(value + " " + "GB"))
					break mainloop;
				else
					a.moveToElement(RamScalingButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] RamValue2 = RamValue.getText().split("\\s+G");
				if (RamValue.getText() != "")
					if (Integer.parseInt(String.valueOf(RamValue2[0].replace(" ", "").trim())) > Integer
							.parseInt(value))
						throw new Error("Script error");
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + value + ") Should be less than " + Max[0]);
		}
	}

	public void SetRamOfVerticalScaling(String value) throws InsufficientResourcesException {
		String[] FromAndTo = value.split("-");
		if (FromAndTo.length <= 1)
			throw new Error("need From and Two value (ex: 2-6) for vertical scaling");
		String[] Max = VerticalScalingRamValueMax.getText().split("\\s+G");
		String min = ConditionCheck(value, VerticalScalingRamValueMin);
		VerticalRamScalingToButton.click();
		if (Integer.parseInt(FromAndTo[1]) <= Integer.parseInt(Max[0].replace(" ", ""))) {
			mainloop: while (true) {
//				if (VerticalScalingRamToValue.getAttribute("style").contains("visible")) {
//					// System.out.println(VerticalScalingRamToValue.getText()+" "+FromAndTo[1]);
//					if (VerticalScalingRamToValue.getText().equals(FromAndTo[1] + " " + "GB")
//							|| FromAndTo[1].equals("4" + " " + "GB"))
//						break mainloop;
//					else
//						a.moveToElement(VerticalRamScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				} else if (VerticalScalingRamToValue.getAttribute("style").contains("hidden")) {
//					// System.out.println(VerticalScalingRamFromToValue.getText()+"
//					// "+FromAndTo[1]+VerticalScalingRamFromToValue.getText().contains(FromAndTo[1]+
//					// " " + "GB"));
//					if (VerticalScalingRamFromToValue.getText().contains(FromAndTo[1] + " " + "GB")
//							|| FromAndTo[1].equals("4" + " " + "GB"))
//						break mainloop;
//					else
//						a.moveToElement(VerticalRamScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				}
				String[] RamToValueGettext = ((String) js.executeScript("return arguments[0].textContent;",
						VerticalScalingRamToValue)).split("\\s+G");
				if (RamToValueGettext[0].replace(" ", "").trim().equals(FromAndTo[1]) || FromAndTo[1].equals("4"))
					break mainloop;
				else
					a.moveToElement(VerticalRamScalingToButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (RamToValueGettext[0].replace(" ", "").trim() != "")
					if (Integer.parseInt(String.valueOf(RamToValueGettext[0].replace(" ", "").trim())) > Integer
							.parseInt(FromAndTo[1]))
						throw new Error("Script error");
			}
		} else {
			throw new Error("Given Value(" + FromAndTo[1] + ") Should be less than " + Max[0]);
		}
		VerticalRamScalingFromButton.click();
		if (Integer.parseInt(FromAndTo[0]) >= Integer.parseInt(min.replace(" ", ""))) {
			mainloop1: while (true) {// System.out.println(VerticalScalingRamFromValue.getText()+" "+FromAndTo[0]);
//				if (VerticalScalingRamFromValue.getAttribute("style").contains("visible")) {
//					if (VerticalScalingRamFromValue.getText().equals(FromAndTo[0] + " " + "GB")
//							|| FromAndTo[0].equals("2" + " " + "GB"))
//						break mainloop1;
//					else
//						a.moveToElement(VerticalRamScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				} else if (VerticalScalingRamFromValue.getAttribute("style").contains("hidden")) {
//					// System.out.println(VerticalScalingRamFromToValue.getText()+"
//					// "+FromAndTo[0]+VerticalScalingRamFromToValue.getText().contains(FromAndTo[0]+
//					// " " + "GB"));
//					if (VerticalScalingRamFromToValue.getText().contains(FromAndTo[0] + " " + "GB")
//							|| FromAndTo[0].equals("2" + " " + "GB"))
//						break mainloop1;
//					else
//						a.moveToElement(VerticalRamScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
//				}
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				String[] RamFromValueGettext = ((String) js.executeScript("return arguments[0].textContent;",
						VerticalScalingRamFromValue)).split("\\s+G");
				System.out.println(!(Integer.parseInt(RamFromValueGettext[0].replace(" ", "").trim()) < Integer
						.valueOf(FromAndTo[1])));
				if (!(Integer.parseInt(RamFromValueGettext[0].replace(" ", "").trim()) < Integer
						.valueOf(FromAndTo[1]))) {
					try {
						if (Alert.isDisplayed()) {
							wait.until(ExpectedConditions.elementToBeClickable(AlertOkButton));
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// js.executeScript("arguments[0].click();", AlertOkButton);
							AlertOkButton.click();
							throw new Error(AlertMessage.getText());
						}
					} catch (NoSuchElementException e) {
						// TODO: handle exception
					}
				}
				if (RamFromValueGettext[0].replace(" ", "").trim().equals(FromAndTo[0]) || FromAndTo[0].equals("2"))
					break mainloop1;
				else
					a.moveToElement(VerticalRamScalingFromButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + FromAndTo[0] + ") Should be greater than " + min);
		}
	}

	public void SetDiskSize(String value) throws InsufficientResourcesException {
		a.moveToElement(DiskSizeScalingButton).click().build().perform();
		ConditionCheck(value, DiskSizeValueMin);
		String[] Max = DiskSizeValueMax.getText().split("\\s+G");
		if (Integer.parseInt(value) <= Integer.parseInt(Max[0].replace(" ", ""))) {
			mainloop: while (true) {
				// System.out.println(DiskSizeValue.getText()+" "+value+" "+"GB");
				if (DiskSizeValue.getText().equals(value + " " + "GB"))
					break mainloop;
				else
					a.moveToElement(DiskSizeScalingButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] DiskValue = DiskSizeValue.getText().split("\\s+G");
				if (Integer.parseInt(String.valueOf(DiskValue[0].replace(" ", "").trim())) > Integer.parseInt(value))
					throw new Error("Script error");
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + value + ") Should be less than " + Max[0]);
		}
	}

	public void SetDiskSizeOfVerticalScaling(String value) throws InsufficientResourcesException {
		a.moveToElement(VerticalScalingDiskSizeScalingButton).click().build().perform();
		ConditionCheck(value, VerticalScalingDiskSizeValueMin);
		String[] Max = VerticalScalingDiskSizeValueMax.getText().split("\\s+G");
		if (Integer.parseInt(value) <= Integer.parseInt(Max[0].replace(" ", ""))) {
			mainloop: while (true) {
				// System.out.println(DiskSizeValue.getText()+" "+value+" "+"GB");
				if (VerticalScalingDiskSizeValue.getText().equals(value + " " + "GB"))
					break mainloop;
				else
					a.moveToElement(VerticalScalingDiskSizeScalingButton).sendKeys(Keys.ARROW_RIGHT).build().perform();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] DiskValue = VerticalScalingDiskSizeValue.getText().split("\\s+G");
				if (Integer.parseInt(String.valueOf(DiskValue[0].replace(" ", "").trim())) > Integer.parseInt(value))
					throw new Error("Script error");
			}
			if (InsufficienterrorMessage.getAttribute("style").contains("inline"))
				throw new InsufficientResourcesException(InsufficienterrorMessage.getText());
		} else {
			throw new Error("Given Value(" + value + ") Should be less than " + Max[0]);
		}
	}

	public void CheckOrUncheckLoadBalance(String Value) {
		if (Value.equalsIgnoreCase("yes"))
			js.executeScript("arguments[0].click();", LoadBalancerButton);
	}

	public void ClickOnTemplateCheckBox(String Condition) {
		if (Condition.equalsIgnoreCase("yes"))
			js.executeScript("arguments[0].click();", TemplateCheckBox);
	}

	public void SetMaxGroupCount(String Count) {
//		System.out.println(IncreaseButton.isDisplayed());
//		System.out.println(decreaseButton.isDisplayed());
		while (true) {
			String CurrentmaxCount1 = (String) js.executeScript("return document.getElementById('number1').value;");
			if (Integer.parseInt(CurrentmaxCount1) > Integer.parseInt(Count)) {
				decreaseButton.click();
			} else if (Integer.parseInt(CurrentmaxCount1) < Integer.parseInt(Count)) {
				IncreaseButton.click();
			} else if (Integer.parseInt(CurrentmaxCount1) == Integer.parseInt(Count)) {
				break;
			}
			String CurrentmaxCount2 = (String) js.executeScript("return document.getElementById('number1').value;");
			if (CurrentmaxCount1.equals(CurrentmaxCount2)) {
				throw new MaxCountExceededException(Integer.parseInt(CurrentmaxCount1));
			}
		}
	}

	public void SetVMBackUp(String Condition, String BackUpFrequency, String Retention) {
		js.executeScript("arguments[0].scrollIntoView(true);", BackUpfrequencyLabel);
		if (Condition.equalsIgnoreCase("yes")) {
			if (!BackUpfrequencyLabel.isDisplayed()) {
				js.executeScript("arguments[0].click();", VMBackupButton);
			}
			Select BackupFrequency = new Select(BackUpFrequencyOptions);
			BackupFrequency.selectByVisibleText(BackUpFrequency);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select RetentionPeriod = new Select(RetentionPeriodOptions);
			RetentionPeriod.selectByVisibleText(Retention);
		}
	}

	public void EnableOrDisableSIEMSwitch(String value) {
		if (value.equalsIgnoreCase("yes"))
			js.executeScript("arguments[0].click();", SIEMSwitch);
		if (SIEMErrorMessage.getAttribute("style").contains("inline"))
			throw new Error(SIEMErrorMessage.getText());
	}

	public void SelectSIEM(String SIEMName) {
		Select SIEM = new Select(SIEMVmList);
		SIEM.selectByVisibleText(SIEMName);
	}

	public void SelectVlan(String VlanName) {
		Select Vlan = new Select(VlanOptions);
		Vlan.selectByVisibleText(VlanName);
		try {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((Alert.isDisplayed()) + " Alert");
			if (Alert.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(AlertOkButton));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// js.executeScript("arguments[0].click();", AlertOkButton);
				AlertOkButton.click();
				throw new Error(AlertMessage.getText());
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
	}

	public void GiveVMName(String Name, String ScalingType) {
		String[] Names = Name.split(",");
		if (ScalingType.equalsIgnoreCase("Horizontal") && Names.length > 1) {
			throw new Error("VM Names Cannot be more than for one for Horizontal Scaling");
		}
		a.moveToElement(CreateButton).build().perform();
		for (int i = 0; i < Names.length; i++) {
//			System.out.println(Names.length + Names[i]);
//			System.out.println(VmNameTextBox.size() + "VmNameTextBox");
			VmNameTextBox.get(i).sendKeys(Names[i]);
			// System.out.println(AvailabityMessage.get(i).getText());
			if (AvailabityMessage.get(i).getText().contains("Taken"))
				throw new Error("Given VM Name " + Names[i] + " is " + AvailabityMessage.get(i).getText());
		}
	}

	public void ClickOnAssignRemoteUser() {
		js.executeScript("arguments[0].scrollIntoView(true);", AssignRemoteUserButton);
		js.executeScript("$('#display_modal').modal('show');");
		// System.out.println(driver.findElement(By.id("display_modal")).isDisplayed());
	}

	public void AssignUserDetails(String SelectAllUserCondition, String usernamesAndRoles) {
		String[] GetuserAndRole = usernamesAndRoles.split(",");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display_modal")));
		if (SelectAllUserCondition.equals("yes")) {
			if (!SelectAllUsersButton.isSelected()) {
				js.executeScript("arguments[0].click();", SelectAllUsersButton);
			}
		}
		for (int i = 0; i < GetuserAndRole.length; i++) {
			String[] GetuserAndItsRole = GetuserAndRole[i].split("=");
			if (SelectAllUserCondition.equals("no")) {
				for (int k = 0; i < UserNames.size(); k++) {
					if (UserNames.get(k).findElement(By.xpath("./following-sibling::label")).getText()
							.contains(GetuserAndItsRole[0])) {
						js.executeScript("arguments[0].scrollIntoView(true)", UserNames.get(k));
						js.executeScript("arguments[0].click();", UserNames.get(k));
						break;
					}
				}
			}
			if (GetuserAndItsRole[1].equalsIgnoreCase("Admin")) {
				for (int j = 0; j < AdminRadioButtons.size(); j++) {
					if (UserNames.get(j).findElement(By.xpath("./following-sibling::label")).getText()
							.contains(GetuserAndItsRole[0])) {
						js.executeScript("arguments[0].scrollIntoView(true)", AdminRadioButtons.get(j));
						js.executeScript("arguments[0].click();", AdminRadioButtons.get(j));
						break;
					}
				}
			}
			if (GetuserAndItsRole[1].equalsIgnoreCase("user")) {
				for (int j = 0; j < UserRadioButtons.size(); j++) {
					if (UserNames.get(j).findElement(By.xpath("./following-sibling::label")).getText()
							.contains(GetuserAndItsRole[0])) {
						js.executeScript("arguments[0].scrollIntoView(true)", UserRadioButtons.get(j));
						js.executeScript("arguments[0].click();", UserRadioButtons.get(j));
						break;
					}
				}
			}
		}
	}

	public void ClickOnSaveRoles() {
		js.executeScript("arguments[0].click();", SaverolesButton);
		try {
			if (UserReatedErrorMessage.isDisplayed())
				throw new Error(UserReatedErrorMessage.getText());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
	}

	public void ClickonCreateButton() {
		js.executeScript("arguments[0].click();", CreateButton);
		String Error = "";
		for (int i = 0; i < AllErrorMessage.size(); i++) {
			Error += AllErrorMessage.get(i).getText();
		}
		if (AllErrorMessage.size() > 0)
			throw new java.lang.Error(Error);
		else {
			wait.until(ExpectedConditions.visibilityOf(UserReatedErrorMessage));
			if (UserReatedErrorMessage.getText().contains("Error"))
				throw new java.lang.Error(UserReatedErrorMessage.getText());
			else
				System.out.println(UserReatedErrorMessage.getText());
		}
	}

	public void SetNumberOfVirtualMachines(String Count) {
		a.moveToElement(NumberOfVirtualMachines).build().perform();
		while (true) {
			String CurrentmaxCount1 = (String) js.executeScript("return document.getElementById('number').value;");
			if (Integer.parseInt(CurrentmaxCount1) > Integer.parseInt(Count)) {
				VMDecreaseButton.click();
			} else if (Integer.parseInt(CurrentmaxCount1) < Integer.parseInt(Count)) {
				VMIncreaseButton.click();
			} else if (Integer.parseInt(CurrentmaxCount1) == Integer.parseInt(Count)) {
				break;
			}
			String CurrentmaxCount2 = (String) js.executeScript("return document.getElementById('number').value;");
			if (CurrentmaxCount1.equals(CurrentmaxCount2)) {
				throw new MaxCountExceededException(Integer.parseInt(CurrentmaxCount1));
			}
		}
	}

	public String ConditionCheck(String value, WebElement MinElement) {
		String[] FromAndTo = value.split("-");
		String[] min = ((String) js.executeScript("return arguments[0].textContent;", MinElement)).split("\\s+G");
		// System.out.println(FromAndTo.length);
		if (FromAndTo.length > 1) {
			if (!(Integer.parseInt(FromAndTo[0]) % 2 == 0 && Integer.parseInt(FromAndTo[1]) % 2 == 0)) {
				throw new Error("Given Value (" + FromAndTo[0] + ") and (" + FromAndTo[1]
						+ ") either one of them is Not a even Number");
			}
		} else {
			if (!(Integer.parseInt(value) >= Integer.parseInt(min[0].replace(" ", ""))
					&& Integer.parseInt(value) % 2 == 0)) {
				throw new Error("Given Value(" + value + ") is either less than minimun value " + min[0]
						+ " or Not a even Number");
			}
		}
		return min[0];
	}
}
