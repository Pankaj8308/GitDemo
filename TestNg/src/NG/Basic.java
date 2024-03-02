package NG;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic {
	@BeforeClass
	// Executing before start of Execution of methods present inparticular class
		public void BeforeClass() {
			System.out.println("Execute this before class");
	}
	@BeforeTest
	// Prequisite like delete data etc
	public void Pre() {
		System.out.println("Execute this first");
	}
	@BeforeMethod
	// Execute before each test case(Methods)
	public void BefEveryTestMethod() {
		System.out.println("Execute before each test");
	}
	@AfterMethod
	// Execute After each test case(Methods)
	public void AfterTestcase() {
		System.out.println("Execute after each test");
	}
	@Parameters({"URL","User"})
	// Parametisation of URL Varaiable
	@Test(groups= {"smoke"})
	// Group(Smoke) created this will help us execute particular cases from each class as a group
	public void FDLogin(String UrlName,String userId) {
		System.out.println(UrlName);
		System.out.println(userId);
	}
	@AfterTest
	// Step to be executed at last
	public void RDLogin() {
		System.out.println("RD");
	}
	@Test(dataProvider="getData")
	public void CASALogin(String user, String pass) {
		System.out.println(user);
		System.out.println(pass);
	}

	@Test(dependsOnMethods={"CASALogin"})
	// This test case depends on CASALogin and will be executed after that
	public void mWebLogin() {
		System.out.println("mWebLogin");
	}
	@BeforeSuite
	// Execute before starting execution of files(Modules which consits test cases)
	public void BeforeS() {
		System.out.println("Execute before any thing else");
	}
	@Test(timeOut=40000)
	// This test case will wait for 4 seconds before failing and proceeding to next test execution
	public void APILogin() {
		System.out.println("mWebLogin");
	}
	@AfterSuite
	// Execute After execution of files(Modules which consits test cases)
	public void AfterS() {
		System.out.println("Execute after everything is executed");
	}
	@AfterClass
	// Executing After Execution of methods present inparticular class
		public void AfterClass() {
			System.out.println("Execute this before class");
	}
	@DataProvider
	public Object[][] getData() {
		//Multi data
		Object[][] data=new Object[3][2];
		// 1st Data set
		data[0][0]="username";
		data[0][1]="password";
		// 2nd Data set
		data[1][0]="username1";
		data[1][1]="password1";
		//3rd Data set
		data[2][0]="username2";
		data[2][1]="password3";
		return data;
		
	}
	
}
