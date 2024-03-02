package P1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartProject {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String[] veggies = { "Cucumber","Brocolli","Beetroot","Brinjal", "Beans"};
		// converting array veggies in to array list
	    List<String> veggieList = Arrays.asList(veggies);
		// To find cucumber we will fetch all product on page by css
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		// Loop to iterate in to products
		for (int i = 0; i < product.size(); i++) {
			// Format vegetable name by splitting it and storing it in array
			String[] name = product.get(i).getText().split("-");
			String nameFormatted = name[0].trim();
			
			// Condition to check Products against Cucumber,Brocolli  and Beetroot
		 // Introducing j int as an counter so that we can exit for loop once condition
			int j = 0;
			if (veggieList.contains(nameFormatted)) {
				
				// Increasing j count
				j++;
				// Click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// COndition to verify whether we have entered if loop 3 times
				if (j == veggies.length)
				{
					break;
				}
					
			}
			
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

	}

}
