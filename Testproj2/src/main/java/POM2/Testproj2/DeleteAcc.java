package POM2.Testproj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAcc extends Abstract {

	WebDriver driver;
	public DeleteAcc(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath=("//li/a[@href='/delete_account']"))
	WebElement del;
	
	@FindBy(xpath=("//div/h2/b"))
	WebElement delMess;
	//div/h2/b
	
	
	
	By de = By.xpath("//li/a[@href='/delete_account']");
	By delm = By.xpath("//div/h2/b");
	
	
	public String delete()
	{
		waitFor(de);
		del.click();
		waitFor(delm);
		String delmess=delMess.getText();
		return delmess;
		
	}

}
