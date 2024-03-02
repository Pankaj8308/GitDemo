package TestComp;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import POM2.Testproj2.LandingPage;

import java.io.File;

public class Base {
	public WebDriver driver;
	public LandingPage  lp;
	public WebDriver initDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\Global Data");
		prop.load(fis);
		String br =System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");
		if(br.contains("chrome"))
			
		{
			ChromeOptions option = new ChromeOptions();
			if(br.contains("headless"))
			{
				option.addArguments("headless");
				
			}
			option.addArguments("--window-size=1440,900");
			option.addArguments("--start-maximized");
{
}
			driver = new ChromeDriver(option);
		}
		else if(br.contains("firefox"))
				{
			System.out.println("FireFox");
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
		
	}	
	public String screenShot(String TestCaseName,WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\reports\\"+"TestCaseName"+".png"));
		return System.getProperty(("user.dir")+"\\reports\\"+"TestCaseName"+".png");
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage Launch() throws IOException
	{
		initDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	@AfterMethod(alwaysRun=true)
	public void Close() throws IOException
	{
		// driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		// Read Json to string
		String jsoncont =FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data  =mapper.readValue(jsoncont, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}


	
	}
