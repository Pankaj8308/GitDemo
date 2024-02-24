package MavenPracticeProject.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComp.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
public LandingPage(WebDriver driver) {
		// Initialisation
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement Email = driver.findElement(By.id("userEmail"));
	//Page Factory
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="userPassword")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement submit;
	
	@FindBy(css="div[role='alert']")
	private WebElement errMess;

	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatPage loginApp(String email,String passwrd)
	{
		userEmail.sendKeys(email);
		password.sendKeys(passwrd);
		submit.click();
		ProductCatPage prd = new ProductCatPage(driver);
		return prd;
	}
	
	public String getErr()
	{
		waitforElementVisible(errMess);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(errMess));
		String error = errMess.getText();
		return error;
	}

	}

