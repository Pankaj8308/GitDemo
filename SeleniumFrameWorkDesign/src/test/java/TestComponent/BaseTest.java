package TestComponent;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MavenPracticeProject.PageObject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage LP;
	
	public WebDriver initTest() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
		prop.load(fi);
		String brname =System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		if(brname.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			if(brname.contains("headless"))
			{
				option.addArguments("headless");
			}
			option.addArguments("--window-size=1440,900");
			option.addArguments("--start-maximized");
			driver = new ChromeDriver(option);
			//driver.manage().window().setSize(Dimension(1440,900));
		}
		else if(brname.equalsIgnoreCase("firefox"))
		{
		// Firefox
		}
		else if(brname.equalsIgnoreCase("edge"))
		{
		// edge
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		// Read Json to string
		String jsoncont =FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		// convert string to HashMap, we will have to get Jackson databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data  =mapper.readValue(jsoncont, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
		
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException
	{
		driver=initTest();
		LP=new LandingPage(driver);
		LP.goTo();
		return LP;
	}
	@AfterMethod(alwaysRun=true)
	public void closeBr()
	{
		driver.close();
	
	}
	
	public String screenShot(String testCaseName,WebDriver driver) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"));
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
	}

}
