package MavenPracticeProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebElement prl;
	WebDriver driver;
public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
@FindBy(css="td:nth-child(3)")
List <WebElement> productsL;

By productsli = By.cssSelector("td:nth-child(3)");

public String getProdLByName(String productName)
{
	//waitforElementVisiblity(productsli);
	String prl =productsL.stream().map(s->s.getText()).findFirst().orElse(null);
	return prl;
}

public String ProdName(String productName)
{
	String prls=getProdLByName(productName);
	return prls;
}



}


