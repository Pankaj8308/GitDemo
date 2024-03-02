package MavenPracticeProject.PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ta-item")
	// Private is used to enusre Encapsulation so that other classes cannot directly use the variables
	private List<WebElement> countries;
	
	@FindBy(css="[placeholder='Select Country']")
	private WebElement countF;
	
	@FindBy(css=".action__submit")
	private WebElement submission;
	
	@FindBy(css=".hero-primary")
	private WebElement message;
	
	
	public void checkoutAction()
	{
		Actions a = new Actions(driver);
		a.sendKeys(countF, "Ind").build().perform();
		WebElement c = countries.stream().filter(s -> s.getText().equals("India")).findFirst().orElse(null);
		c.click();
		
	}
	
	public void SubmissionAndMessage()
	{
		submission.click();
		Assert.assertEquals(message.getText(), "THANKYOU FOR THE ORDER.");
		System.out.println(message.getText());
	}

}
