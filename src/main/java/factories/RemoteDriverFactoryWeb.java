package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.ProjectConfig;
import utils.PropertyUtils;

public final class RemoteDriverFactoryWeb {

	private RemoteDriverFactoryWeb() {
	}
	
	static String URL = PropertyUtils.getValueFromConfigMap(ProjectConfig.REMOTEURL);

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		switch (browser) {
		case "chrome": {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--no-sandbox");
			return new RemoteWebDriver(new URL(URL), chromeOptions);
		}

		case "firefox": {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-gpu");
			firefoxOptions.addArguments("--no-sandbox");
			return new RemoteWebDriver(new URL(URL), firefoxOptions);
		}

		case "edge": {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-gpu");
			edgeOptions.addArguments("--no-sandbox");
			return new RemoteWebDriver(new URL(URL), edgeOptions);
		}

		default:
			throw new IllegalArgumentException("Unexpected browser value : " + browser);
		}
	}
}