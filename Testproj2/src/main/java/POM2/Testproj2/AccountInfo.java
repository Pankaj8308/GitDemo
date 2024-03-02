package POM2.Testproj2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInfo extends Abstract{
WebDriver driver;
public AccountInfo(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}


@FindBy(xpath=("//div/h2/b"))
WebElement message;

@FindBy(id=("id_gender1"))
WebElement gen;

@FindBy(id=("name"))
WebElement nam;

@FindBy(id=("email_address"))
WebElement eml;

@FindBy(id=("password"))
WebElement pss;

@FindBy(id=("days"))
WebElement day;

@FindBy(id=("months"))
WebElement mnth;

@FindBy(id=("years"))
WebElement yr;

@FindBy(id=("first_name"))
WebElement fn;

@FindBy(id=("last_name"))
WebElement ln;

@FindBy(id=("company"))
WebElement cmp;

@FindBy(id=("address1"))
WebElement add;

@FindBy(id="country")
WebElement country;

@FindBy(id="state")
WebElement state;

@FindBy(id="city")
WebElement city;

@FindBy(id="zipcode")
WebElement zipcode;

@FindBy(id="mobile_number")
WebElement mobNo;

@FindBy(css="button[data-qa='create-account']")
WebElement sbmtbttn;




By mess = By.xpath("//div/h2/b");

public AcctCreated acctInfo()
{
	waitFor(mess);
	gen.click();
	//nam.sendKeys("PK");
	//eml.sendKeys("pkt@gmail.com");
	pss.sendKeys("Qwerty@123");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Select s = new Select(day);
	s.selectByValue("17");
	Select a = new Select(mnth);
	a.selectByValue("10");
	Select y = new Select(yr);
	y.selectByValue("1992");
	fn.sendKeys("PK");
	ln.sendKeys("Tiwari");
	cmp.sendKeys("WTW");
	add.sendKeys("DurgaNagar");
	Select c = new Select(country);
	c.selectByValue("India");
	state.sendKeys("Maharashtra");
	city.sendKeys("Mumbai");
	zipcode.sendKeys("400060");
	mobNo.sendKeys("9089089081");
	js.executeScript("window.scrollBy(0,500)");
	sbmtbttn.click();
	AcctCreated ac = new AcctCreated(driver);
	return ac;

}


}