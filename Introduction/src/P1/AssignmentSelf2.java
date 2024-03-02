package P1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentSelf2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("http://www.fb.com");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		String curl = driver.getCurrentUrl();
		Assert.assertFalse(curl.equalsIgnoreCase("http://www.facebook.com"), "URL is not correct");
		Assert.assertFalse(
				!driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).isDisplayed(),
				"Button is not present");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pankaj");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Tiwari");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("pk@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("pk@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Qwerty@123");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		Select d = new Select(day);
		d.selectByValue("17");
		Select m = new Select(month);
		m.selectByValue("10");
		Select y = new Select(year);
		y.selectByValue("1992");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_error")));
		// Thread.sleep(5000);
		String error = driver.findElement(By.id("reg_error")).getText();
		System.out.println("The Error is " +error);
		// driver.close();

	}

}
