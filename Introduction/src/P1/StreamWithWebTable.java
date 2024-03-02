package P1;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamWithWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Click on the column(which should sort out items)
		driver.findElement(By.xpath("//th[@aria-label='Veg/fruit name: activate to sort column ascending']")).click();
		// Capture all values in to list
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		// capture text of all webelements in to new list
		List<String> newList = list.stream().map(s -> s.getText()).collect(Collectors.toList());
		// Apply sort in step 3 and prepare new List
		List<String> sortedList = newList.stream().sorted().collect(Collectors.toList());
		sortedList.stream().forEach(s -> System.out.println(s));
		// Compare orignal and sorted list
		Assert.assertTrue(newList.equals(sortedList));
		// Get price of Beans
		// using stream methods
		List<String> pr = list.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
		pr.stream().forEach(a -> System.out.println(a));
		// Using customised stream method
		List<String> p = list.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPrice(s))
				.collect(Collectors.toList());
		p.stream().forEach(a -> System.out.println(a));
		
		// TRYING TO TEST SAME THING WITHOUT STREAMS
		for(int i =0;i<list.size();i++)
		{
			String v = list.get(i).getText();
			if(v.contains("Beans"))
			{
				String prod = driver.findElements(By.xpath("//tr/td[1]/following-sibling::td[1]")).get(i).getText();
				System.out.println(prod);
				break;
			}
		}
		
		// Suppose we have to find price for product which is not on first page without pagination method or streams
		System.out.println("Start");
		int k =1;
		for(int j=0;j<20;j++)
		{
			String v = list.get(j).getText();
			if(v.equalsIgnoreCase("Mango"))
			{
				String produ = driver.findElements(By.xpath("//tr/td[1]/following-sibling::td[1]")).get(j).getText();
				System.out.println(produ);
			}
			else 
			{
				k++;
				while(!v.equalsIgnoreCase("Mango"))
				{
					if(k%5==0)
					{
						driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
					}
				}
				
			}
			
		}
		
		driver.quit();
	}
	// Creating methods which can be called using customised streams

	private static String getPrice(WebElement s) {
		String pri = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pri;
	}
}
