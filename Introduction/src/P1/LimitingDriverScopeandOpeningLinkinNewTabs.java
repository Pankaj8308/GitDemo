package P1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingDriverScopeandOpeningLinkinNewTabs {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Give me the counts of the links on the page, a Tag
		int noLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(noLinks);
		// Count of link in footer
		// creating mini driver to restrict scope of web driver to footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		// Link count of first column from footer
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int linksColumn = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		// Open links in new tab
		String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 1; i < linksColumn; i++) {
			// Open links in new tab
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(click);
			Thread.sleep(2000);
		}
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		// Getting title of all page
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
