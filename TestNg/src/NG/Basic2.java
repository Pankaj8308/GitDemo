package NG;

import org.testng.annotations.Test;

public class Basic2 {
	@Test
	public void OD() {
		System.out.println("OD");
	}
	@Test
	public void Loan() {
		System.out.println("Loan");
	}
	@Test(groups= {"smoke"})
	public void WM() {
		System.out.println("WM");
	}
}
