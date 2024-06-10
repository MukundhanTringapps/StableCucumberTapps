package stepDefn;

import org.testng.Assert;

import driver.Driver;
import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import reports.ExtentReport;

public class Steps {

	@Given("TC number (.*) and Title (.*)$")
	public void tc_number_and_title(String TC_num, String TC_title) {
		ExtentReport.createTest(TC_num + " - " + TC_title);
	}
	
	@Given("TC number {string} and title {string}")
	public void tc_num_and_title(String TC_num, String TC_title) {
		ExtentReport.createTest(TC_num + " - " + TC_title);
	}
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		Driver.initDriver();
	}

	@And("Fetch the URL")
	public void fetch_the_url() {
		DriverManager.getDriver().get("https://www.cleartheshelters.com/");
	}

	@Then("Verify the Page loading in site")
	public void verify_the_page_loading_in_site() {
		Assert.assertEquals(new HomePage().getWindowTitle(), "Clear the Shelters – Clear the Shelters");
	}

	@Then("Verify the home page title in site")
	public void verify_the_page_title_in_site() {
		new HomePage().verifyPageLoading();
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		Driver.quitDriver();
	}
}