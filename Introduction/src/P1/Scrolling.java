package P1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Creating js Object using JavaScriptExecutor class
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Executing window.scrollBy("0,500") script we can write and verify this script
		// in chrome browser by console
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		// SCrolling inside the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// sum of values present on Table
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		int sum = 0;
		for (int i = 0; i < data.size(); i++) {
			String num = data.get(i).getText();
			int a = Integer.parseInt(num);
			sum = a + sum;

		}
		System.out.println(sum);
		String sumWeb = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		int sumWebi = Integer.parseInt(sumWeb);
		System.out.println(sumWebi);
		Assert.assertEquals(sum, sumWebi);
		if (sumWebi == sum) {
			System.out.println("Sum of values is correct");
		} else {
			System.out.println("Sum of values is incorrect");
		}

	}

}
