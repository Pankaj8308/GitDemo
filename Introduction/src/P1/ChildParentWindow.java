package P1;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildParentWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".blinkingText")).click();
		// Switching from parent to child
		// Getting Tab Ids
		Set<String> windows = driver.getWindowHandles(); //ParentID ChildID
		java.util.Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		// Switching to Child Window
		driver.switchTo().window(childID);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".im-para.red"))));
		String content = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(content);
		// Parsing of data in single line of code
		String email = content.split("at")[1].split("with")[0].trim();
		// String[] cont = contents[1].split("with");
		// String email = cont[0].trim();
		System.out.println(email);
		// Switching back to parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
		

	}

}
