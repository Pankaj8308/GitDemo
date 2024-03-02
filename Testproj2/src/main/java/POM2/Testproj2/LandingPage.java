package POM2.Testproj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Abstract {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='login']")
	WebElement cart;
	
	By car = By.cssSelector("a[href*='login']");

	public void goTo()
	{
		driver.get("https://automationexercise.com/");
	}
	public SignUp clikCart()
	{
		waitFor(car);
		cart.click();
		SignUp su = new SignUp(driver);
		return su;
		
	}
	

}
