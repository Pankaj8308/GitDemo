package P1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wait {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String[] veggies = { "Cucumber", "Brocolli", "Beetroot" };
		// To find cucumber we will fetch all product on page by css
		//Wait i = new Wait();
		//i.additems(driver, veggies);
		// As additem is statis we can directly write as below
		additems(driver, veggies);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		// Explicit wait - WebDriverWait class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String codeMessage = (driver.findElement(By.cssSelector("span.promoInfo")).getText());
		System.out.println(codeMessage);
		Assert.assertEquals(codeMessage, "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}

	public static void additems(WebDriver driver, String[] veggies) {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		// Loop to iterate in to products
		for (int i = 0; i < product.size(); i++) {
			// Format vegetable name by splitting it and storing it in array
			String[] name = product.get(i).getText().split("-");
			String nameFormatted = name[0].trim();
			// converting array veggies in to array list
			List<String> veggieList = Arrays.asList(veggies);
			// Condition to check Products against Cucumber,Brocolli and Beetroot
			// Introducing j int as an counter so that we can exit for loop once condition
			int j = 0;
			if (veggieList.contains(nameFormatted)) {

				// Increasing j count
				j++;
				// Click on add to card
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// COndition to verify whether we have entered if loop 3 times
				if (j == veggies.length) {
					break;
				}

			}

		}

	}

}