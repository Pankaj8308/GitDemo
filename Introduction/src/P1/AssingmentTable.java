package P1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AssingmentTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		int row = driver.findElements(By.xpath("//table[@name='courses'] //tr")).size();
		int column = driver.findElements(By.xpath("//table[@name='courses'] //th")).size();
		System.out.println("The numbers of rows is " + row + " and the number of columns is " + column);
		System.out.println(
				"Values in column 3 is: " + driver.findElement(By.xpath("//table[@name='courses'] //tr[3]")).getText());

	}

}
