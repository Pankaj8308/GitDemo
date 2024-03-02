package P1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement s = driver.findElement(By.xpath("//input[@name='name']"));
		// Above
		System.out.println(driver.findElement(with(By.tagName("label")).above(s)).getText());
		WebElement f = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		// Below
		driver.findElement(with(By.tagName("input")).below(f)).click();
		// left
		driver.findElement(
				with(By.tagName("input")).toLeftOf(By.xpath("//label[text()='Check me out if you Love IceCreams!']")))
				.click();
		// Right
		System.out.println(driver
				.findElement(with(By.tagName("label")).toRightOf(By.xpath("//input[@id='inlineRadio1']"))).getText());
	}

}
