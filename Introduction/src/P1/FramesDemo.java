package P1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		// Switching to Frame by webelement
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		// Switching to frame by Index
		// System.out.println(driver.findElements(By.tagName("iframe")).size());
		// driver.switchTo().frame(0);
		driver.findElement(By.id("draggable")).click();
		// Drag and Drop
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		// Switching back to Main page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//li/a[@href='/resources/demos/droppable/accepted-elements.html']")).click();
	

	}

}
