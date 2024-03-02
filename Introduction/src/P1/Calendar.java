package P1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		driver.findElement(By.id("first_date_picker")).click();
		// Selecting Month as April
		while (!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains("May")) {
			driver.findElement(By.className("ui-icon-circle-triangle-e")).click();
		}
		// Selecting day as 30th
		// Grab common attribute, Put in to list and iterate
		List<WebElement> day = driver.findElements(By.className("ui-state-default"));
		for (int i = 0; i < day.size(); i++) {
			String date = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (date.equalsIgnoreCase("1")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
		}

	}

}
