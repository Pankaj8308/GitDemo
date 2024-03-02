package P1;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Click on the column(which should sort out items)
				driver.findElement(By.xpath("//th[@aria-label='Veg/fruit name: activate to sort column ascending']")).click();
				// Capture all values in to list
				List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
				List<String> pr = list.stream().filter(s -> s.getText().contains("Rice"))
						.map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
				
				   do
				{
					   List<WebElement> elist = driver.findElements(By.xpath("//tr/td[1]"));
					List<String>pr1 = elist.stream().filter(s -> s.getText().contains("Rice"))
							.map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
					pr1.stream().forEach(a -> System.out.println(a));
					if(pr.size()<1)
					{
						driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
						Thread.sleep(2000);
					}
				}while((pr.size()<1));
			
				}
				
				
	
	}


