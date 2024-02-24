package AbstractComp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenPracticeProject.PageObject.CartPage;
import MavenPracticeProject.PageObject.OrderPage;
import MavenPracticeProject.PageObject.ProductCatPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement addcart;
	@FindBy(css="div[role='alert']")
	WebElement ele;
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement ordC;
	
	public void waitforElementVisiblity(By findBy)
	{

	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforElementVisible(WebElement ele)
	{

	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitforElementinVisiblity(By findBy)
	{

	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage addCartclick()
	{
		addcart.click();
		CartPage crt = new CartPage(driver);
		return crt;
	
	}
	
	public OrderPage orderClick()
	{
		waitforElementVisible(ordC);
		ordC.click();
		OrderPage op = new OrderPage(driver);
		return op;
		
	}
	
}

