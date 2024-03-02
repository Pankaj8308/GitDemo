package P1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

public class AssingmentSelf1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("http://qatechhub.com");
		String title = driver.getTitle();
		Assert.assertTrue(title.equalsIgnoreCase("QA Automation Tools Trainings and Tutorials | QA Tech Hub"), "Pass");
		// Assert.assertEquals(title, "QA Automation Tools Trainings and Tutorials | QA
		// Tech Hub");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> win = driver.getWindowHandles();
		java.util.Iterator<String> it = win.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.get("https://www.facebook.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkCount = links.size();
		System.out.println(linkCount);
		for (int i = 0; i < linkCount; i++) {
			String url = links.get(i).getAttribute("href");
			// System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res = conn.getResponseCode();
			// System.out.println(res);
			Assert.assertTrue(res < 400, links.get(i).getText() + "Link is Broken");

		}
		driver.switchTo().window(parent);
		String u = driver.getCurrentUrl();
		System.out.println(u);
		driver.quit();

	}

}
