package P1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assingment5 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a [@href='/nested_frames']")).click();
		// using .frame(String name)
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		// System.out.println(driver.findElements(By.tagName("frameset")).size());
		// driver.switchTo().frame(0);
		// System.out.println(driver.findElements(By.tagName("frame")).size());
		// driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.quit();
		

	}

}
