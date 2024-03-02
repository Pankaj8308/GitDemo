package P1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class assingment2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Pankaj");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Pankaj@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticdropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio2"));
		System.out.println(driver.findElement(By.id("inlineRadio3")).isEnabled());
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("17-10-1992");
		driver.findElement(By.className("btn-success")).click();
		String success =driver.findElement(By.className("alert-dismissible")).getText();
		System.out.println(success.replace("×",""));

	}

}
