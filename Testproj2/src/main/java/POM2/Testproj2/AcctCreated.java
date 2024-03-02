package POM2.Testproj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	public class AcctCreated extends Abstract{
		WebDriver driver;
		public AcctCreated(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}


		@FindBy(xpath=("//div/h2/b"))
		WebElement message;

		@FindBy(css=("a[data-qa='continue-button']"))
		WebElement continu;
		
		
		By mes = By.xpath("//div/h2/b");
		
		public String createVal()
		{
			waitFor(mes);
			String succMess = message.getText();
			return succMess;
		}
		
		public DeleteAcc cont()
		{
			continu.click();
			DeleteAcc da = new DeleteAcc(driver);
			return da;
			
		}

}
