package MavenPracticeProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponent;

public class ProductCatPage extends AbstractComponent {
	WebDriver driver;
	
	public ProductCatPage(WebDriver driver) {
		super(driver);
		// Initialisation
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> prod = driver.findElements(By.cssSelector(".mb-3"));
	//Page Factory
	@FindBy(css=".mb-3")
	List <WebElement> products;
	
	// @FindBy(css=".ng-animating")
   //  WebElement anim;
   
	
	By productsBy = By.cssSelector(".mb-3");
	By toastMess = By.cssSelector("#toast-container");
	By anim = By.cssSelector(".ng-animating");
	public List<WebElement> getProductList()
	{
		waitforElementVisiblity(productsBy);
		return products;
	}
	
	
	
	public WebElement getProdByName(String productName)
	{
		WebElement pr = products.stream().filter(s -> s.findElement(By.cssSelector("h5")).getText().contains(productName))
				.findFirst().orElse(null);
		return pr;
	}
	
	public void addProd(String productName)
	{
		
		WebElement pr = getProdByName(productName);
		pr.findElement(By.cssSelector(".w-10")).click();
		waitforElementVisiblity(toastMess);
		waitforElementinVisiblity(anim);
		// driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
	}
	

	}

