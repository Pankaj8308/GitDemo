package MavenPracticeProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
WebDriver driver;
public CartPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
@FindBy(css="div[class='cartSection'] h3")
List<WebElement> prList;
@FindBy(css="li[class='totalRow'] button")
WebElement button;
	
	
	public List<WebElement> cartList()
	{
		return prList;
	}
	
	public void ismatch(String productName)
	{
		boolean match = prList.stream().anyMatch(s -> s.getText().contains(productName));
		Assert.assertTrue(match);
		button.click();
	}

}
