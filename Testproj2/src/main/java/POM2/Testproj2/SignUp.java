package POM2.Testproj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends Abstract {

	WebDriver driver;

	public SignUp(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[name='name']")
	WebElement SignUpName;

	@FindBy(css = "input[data-qa='signup-email']")
	WebElement SignUpEmail;

	@FindBy(css = "button[data-qa='signup-button']")
	WebElement SignUpBtn;

	By singnUpForm = By.cssSelector(".signup-form");

	public AccountInfo signUpDetail(String name, String email) {
		waitFor(singnUpForm);
		SignUpName.sendKeys(name);
		SignUpEmail.sendKeys(email);
		SignUpBtn.click();
		AccountInfo aci = new AccountInfo(driver);
		return aci;
	}


}
