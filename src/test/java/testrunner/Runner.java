package testrunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import reports.ExtentReport;

@CucumberOptions(features = { "src/test/resources/features" }, 
				 monochrome = false,
				 dryRun = false,
				 snippets = SnippetType.CAMELCASE,
				 glue = "stepDefn")
public class Runner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
	@BeforeSuite
	public void ReportInit() {
		ExtentReport.startReport();
	}
	
	@AfterSuite
	public void ReportClose() {
		ExtentReport.endReport();
	}
}