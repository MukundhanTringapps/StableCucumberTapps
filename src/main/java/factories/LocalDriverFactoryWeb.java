package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class LocalDriverFactoryWeb {

	private LocalDriverFactoryWeb() {
	}

	public static WebDriver getDriver(String browser){
		switch (browser) {
		case "chrome": {
			return new ChromeDriver();
		}
		case "firefox": {
			return new FirefoxDriver();
		}
		case "edge": {
			return new EdgeDriver();
		}
		default:
			throw new IllegalArgumentException("Unexpected browser value : " + browser);
		}
	}
}