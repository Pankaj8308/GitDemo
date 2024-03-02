package P1;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class VerifyWebFilterUsingStreams {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
			// To check whether search field returns correct results
			driver.findElement(By.id("search-field")).sendKeys("Rice");
			List<WebElement> prodMatch =driver.findElements(By.xpath("//tr/td[1]"));
			List<WebElement> filteredProd =prodMatch.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
			Assert.assertEquals(prodMatch.size(), filteredProd.size());
			if(prodMatch.size()==filteredProd.size())
			{
				System.out.println("Product Exists");
			}
						}
						
					}
					
					
		



	


