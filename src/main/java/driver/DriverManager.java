package driver;

import org.openqa.selenium.WebDriver;

/**
 * This class provides methods to get and set the WebDriver instance.
 */
public final class DriverManager {
	
	private DriverManager() {
	}

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	
    /**
     * Sets the WebDriver instance.
     * 
     * @param driver the WebDriver instance to set
     */
    public static void setDriver(WebDriver driver) {
		driverThreadLocal.set(driver);
	}
    
    /**
     * Gets the WebDriver instance.
     * 
     * @return the WebDriver instance
     */
	public static WebDriver getDriver(){
		return driverThreadLocal.get();
	}
	
	public static void unloadDriver() {
		driverThreadLocal.remove();
	}
}