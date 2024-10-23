package resourceManagementPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoragePageObjects {
	public WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	public StoragePageObjects(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(id = "add_storage_menu_item")
private WebElement AddStorageButton;
@FindBy(xpath = "//h1[text()='Storage']")
private WebElement StorageTitle;
@FindBy(xpath = "//th[contains(@class,'sorting')]")
private List<WebElement> TableHeaderNames;
@FindBy(xpath = "//td[contains(@class,'dtr-control')]")
private List<WebElement> TableData;
private String AvailableSize;
private int	Strorageindex;
public String GetAvailableSize(String StoragePath)
{
	wait.until(ExpectedConditions.visibilityOf(AddStorageButton));
	AddStorageButton.click();
	wait.until(ExpectedConditions.visibilityOf(StorageTitle));
wait.until(ExpectedConditions.visibilityOfAllElements(TableHeaderNames));
	System.out.println(TableHeaderNames.size());
	mainloop:	for (int i=0;i<TableHeaderNames.size();i++) {
		System.out.println(TableHeaderNames.get(i).getText());
		if(TableHeaderNames.get(i).getText().equalsIgnoreCase("Storage"))
		{
			for (int j = 0; j < TableData.size(); j++) {
				if(TableData.get(j).findElement(By.xpath("./following-sibling::td["+i+"]")).getText().equalsIgnoreCase(StoragePath))
				{
					Strorageindex=j;
					break mainloop;
				}
					
				
			}
		}
		
	}
	for (int i=0;i<TableHeaderNames.size();i++) {
		if(TableHeaderNames.get(i).getText().equalsIgnoreCase("Available Size(GB)"))
		{
			AvailableSize=TableData.get(Strorageindex).findElement(By.xpath("./following-sibling::td["+i+"]")).getText();
			break ;
		}
	}
	//System.out.println("Avaialbe Size "+StoragePath+" - "+AvailableSize+"GB");
	return StoragePath+" - "+AvailableSize+"GB";
	
}
}
