package P1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
public class InvokingMultipleWidnowsandWebElemntSS {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// opening in new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		// opening in new window
		// driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> win =driver.getWindowHandles();
		Iterator<String> it =win.iterator();
		String parentId = it.next();
		String childId = it.next();
		System.out.println(parentId);
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		String course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentId);
		WebElement name =driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(course);
		// WebElement Scrrenshot
		File file  = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\panka\\OneDrive\\Desktop\\Screenshots\\name.png"));
		// Height and Width of WebElement
		long h = name.getRect().getDimension().getHeight();
		long w = name.getRect().getDimension().getWidth();
		System.out.println(h+" and "+w);
		
		
	
	}

}