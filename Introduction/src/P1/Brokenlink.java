package P1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
public class Brokenlink {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Broken links means Broken URL
		// Step 1: Get all URLS tied to links using selenium
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        // Soft Assert
		SoftAssert a = new SoftAssert();
		for (int i = 0; i < links.size(); i++) {
			String add = links.get(i).getAttribute("href");
			// Java Method will call URLS and gets status codes
			HttpURLConnection conn = (HttpURLConnection) new URL(add).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int rescode = conn.getResponseCode();
			System.out.println(rescode);
			// If status code > 400 the that URL is not working
			a.assertTrue(rescode < 400, "The link with Text " + links.get(i).getText());
			driver.quit();
		}
		a.assertAll();

	}

}
