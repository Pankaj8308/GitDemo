package P1;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assingment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		// Capturing UserId and PassWord
		String[] userDetails = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText()
				.split("and ");
		String[] userid = userDetails[0].split("username is");
		String userId = userid[1].trim();
		String[] passwd = userDetails[1].split("Password is");
		String passwrd = passwd[1].trim();
		String passWord = passwrd.replace(")", "");
		System.out.println(userId);
		System.out.println(passWord);
		// Entering login ID and Password
		driver.findElement(By.id("username")).sendKeys(userId);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select sd = new Select(staticdropdown);
		sd.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-info']")));
		// int i = driver.findElements(By.cssSelector("button[class='btn
		// btn-info']")).size();
		List<WebElement> buttons = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for (int i = 0; i < buttons.size(); i++) {
			driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		// driver.quit();

	}

}
