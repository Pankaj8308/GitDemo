package P1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssingmentAutoSuggDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		List<WebElement> uni = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for (int i = 0; i < uni.size(); i++) {
			String country = uni.get(i).getText();
			if (country.contains("United States")) {
				uni.get(i).click();
			}

		}

		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), "United States (USA)");
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}

}
