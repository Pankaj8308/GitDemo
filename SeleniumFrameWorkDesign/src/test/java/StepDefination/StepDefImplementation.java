package StepDefination;

import java.io.IOException;

import org.testng.Assert;

import MavenPracticeProject.PageObject.CartPage;
import MavenPracticeProject.PageObject.CheckOutPage;
import MavenPracticeProject.PageObject.LandingPage;
import MavenPracticeProject.PageObject.ProductCatPage;
import TestComponent.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefImplementation extends BaseTest {
public LandingPage LP;
public ProductCatPage prd;
public CartPage crt;
public CheckOutPage ckp;
	@Given("I landed on Login page")
	public void I_landed_on_Login_page() throws IOException
	{
		LP = launchApp();
	}
	
	@Given ("^I Logged in with (.+) and (.+)$")
	// "^I Logged in with username (.+) and password (.+)$"
	public void logged_in_username_password (String username, String password)
	{
		prd = LP.loginApp(username,password);
	}
	@When ("^I add the (.+) to cart$")
	public void addCart(String productName)
	{
		prd.getProductList();
		prd.addProd(productName);
		prd.addCartclick();
	}
	@And ("^Checkout (.+) and submit the order$")
	public void checkOut(String productName)
	{
		CartPage crt = new CartPage(driver);
		crt.cartList();
		crt.ismatch(productName);
		CheckOutPage ckp =new CheckOutPage(driver);
		ckp.checkoutAction();
	}
	
	@Then ("{string} is displayed on confirmation page")
	public void message(String message)
	{
		CheckOutPage ckp =new CheckOutPage(driver);
		ckp.SubmissionAndMessage();
		driver.close();
	}
	@Then ("{string} error message is displayed")
	public void errmessage(String errmessage)
	{
		Assert.assertEquals(errmessage, LP.getErr());
		driver.close();
	}
}
