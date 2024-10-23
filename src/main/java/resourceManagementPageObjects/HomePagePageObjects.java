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

public class HomePagePageObjects {
	public WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public HomePagePageObjects(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "create_resource_menu")
	private WebElement ResourceManagement;
	@FindBy(id = "add_virtual_machine_menu_item")
	private WebElement CreateResource;
	@FindBy(xpath = "//h1[contains(text(),'Explore')]")
	private WebElement ExploreTitle;
	@FindBy(xpath = "//h5[@class='mt-3']")
	private List< WebElement> CreateButtons;
	private WebElement CreateButton;
	By ResourceCreateButton=By.xpath("./parent::div/parent::div/following-sibling::div/button/b[contains(text(),'Create')]");
	public WebElement ResourceManagementOption()
	{
		wait.until(ExpectedConditions.visibilityOf(ResourceManagement));
		return ResourceManagement;
	}
	public WebElement CreateResourceOption()
	{
		return CreateResource;
	}
	public void ClickOnCreate(String ResourceName)
	{
		wait.until(ExpectedConditions.visibilityOf(ExploreTitle));
		for (int i = 0; i < CreateButtons.size(); i++) {
			if(CreateButtons.get(i).getText().equalsIgnoreCase(ResourceName))
			{
				CreateButton=CreateButtons.get(i).findElement(ResourceCreateButton);
				break;
			}
		}
		
		try {
			CreateButton.click();
		} catch (Exception e) {
			js.executeScript("window.scrollBy(0,500)");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
