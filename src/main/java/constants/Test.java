package constants;

import org.testng.Reporter;

public class Test {
	
	public static void main(String[] args) {
		String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
	    System.err.println("Browser value is" + value);
	}

}
