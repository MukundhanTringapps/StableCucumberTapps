package factories;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;

import enums.ProjectConfig;
import exceptions.BrowserSetupFailedException;
import utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver() throws MalformedURLException {

		String runMode = PropertyUtils.getValueFromConfigMap(ProjectConfig.RUNMODE);

		ITestContext context = Reporter.getCurrentTestResult().getTestContext();
		String browserValue = context.getCurrentXmlTest().getParameter("browser");
		System.err.println("Parameter browser = " + browserValue);

		if (runMode == null || browserValue == null) {
			throw new IllegalArgumentException("RunMode and Browser must be specified in the configuration file.");
		}

		switch (runMode.toLowerCase()) {
		case "local":
			return LocalDriverFactoryWeb.getDriver(browserValue);
		case "remote":
			return RemoteDriverFactoryWeb.getDriver(browserValue);
		default:
			throw new BrowserSetupFailedException(
					"Invalid runMode specified: " + runMode + ". Expected 'local' or 'remote'.");
		}
	}
}