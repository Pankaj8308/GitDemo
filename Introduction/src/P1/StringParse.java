package P1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StringParse {

	public static void main(String[] args) {
		
	}
public String getPasswrd(WebDriver driver) throws InterruptedException
{
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	Thread.sleep(1000);
	//Storing the text in String
	String passwordText= driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
	//Split Please use temporary password 'rahulshettyacademy' to Login.
	String[] psswrd = passwordText.split("'");
	//spilt will create array with 0th Index: Please use temporary password 
	//1st Index rahulshettyacademy' to Login.
	String password = psswrd[1].split("'")[0];
	return password;
	
}
}
