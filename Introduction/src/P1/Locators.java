package P1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		//Locator demonstration
		WebDriver driver = new ChromeDriver();
		//Implicit wait: This is wait for objects to be visible
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Creating object p to get method from class Locators2
		StringParse p = new StringParse();
		//Calling method from class stringParse and storing in string as the method returns password
		String passwd=p.getPasswrd(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//ID Locator
		driver.findElement(By.id("inputUsername")).sendKeys("Pankaj");
		//Name Locator
		driver.findElement(By.name("inputPassword")).sendKeys("Qwerty@123");
		//Class Name Locator
		driver.findElement(By.className("signInBtn")).click();
		//CSS Locator
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//Wait for view to get stable: This is for view to get stable so that we can initiate action
		Thread.sleep(1000);
		//Link Text Locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		//XPATH Locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Pankaj T");
		//Customized CSS Locator
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Pankaj@gmail.com");
		//XPATH With Indexation-This is done when we are not able to find unique locator
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//CSS With Indexation-This is done when we are not able to find unique locator
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("PankajT@gmail.com");
		//XPATH with Tags only(Parent Child)
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9004782202");
		//CSS tag.class can be also written as .class
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//CSS with tags only(Parent Child)
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//X path with Customized ,Parent child and Index methods combined
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		//Wait for view to get stable: This is for view to get stable so that we can initiate action
		Thread.sleep(1000);
		//Login
		driver.findElement(By.id("inputUsername")).sendKeys("Pankaj");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		//XPATH with regular Expression
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		//Login Flow Happy Path
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name ="Pankaj";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(passwd);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1500);
		//Check for success login message
		//Tag name locator
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//Assertion method from TestNG Dependencies mentioned in pom.xml file
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		// XPATH using text present on Button
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
		
		
		

	}

	private static void getPasswrd(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
