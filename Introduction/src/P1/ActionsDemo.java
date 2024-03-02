package P1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// Actions Demo
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Slider.html");
		driver.manage().window().maximize();
		// Thread.sleep(10000);
		Actions a = new Actions(driver);
		// WebElement move = driver.findElement(By.id("nav-link-accountList"));
		// Hovering Mouse and Right click
	 //    a.moveToElement(move).contextClick().build().perform();
		// Capital Letters and double click on text
	// 	a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		WebElement handle = driver.findElement(By.className("ui-slider-handle"));
		driver.navigate().to("https://demo.automationtesting.in/Slider.html");
		a.clickAndHold(handle).moveByOffset(0, 500);
	

	}

}
