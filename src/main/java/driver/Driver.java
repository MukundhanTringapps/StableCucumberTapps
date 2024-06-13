package driver;

import java.net.MalformedURLException;
import java.util.Objects;

import enums.ProjectConfig;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import reports.ExtentLogger;
import utils.PropertyUtils;

/**
 * This class is responsible for managing the WebDriver instance.
 */
public final class Driver {

	private Driver() {
	}

	/**
     * Initializes the WebDriver instance.
     */
	public static void initDriver() {
		
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver());
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Check the browser capabilities & verify the driver configuration");
			}
			
			DriverManager.getDriver().get(PropertyUtils.getValueFromConfigMap(ProjectConfig.URL));
			DriverManager.getDriver().manage().window().maximize();
			ExtentLogger.logBrowserNameAndVersion();
			ExtentLogger.assignCategory();
		}
	}
	

    /**
     * Quits the WebDriver instance.
     */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unloadDriver();
		}
	}
}