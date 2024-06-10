package reports;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import driver.DriverManager;
import enums.ProjectConfig;
import utils.PropertyUtils;
import utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void info(String message, boolean isScreenShotNeeded) {
		if (PropertyUtils.getValueFromConfigMap(ProjectConfig.INFOSTEPSCREENSHOT).equals("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(message, ScreenshotUtils.attachScreenshot());
		} else {
			info(message);
		}
	}
	
	public static void pass(String message, boolean isScreenShotNeeded) {
		if (PropertyUtils.getValueFromConfigMap(ProjectConfig.PASSEDSTEPSCREENSHOT).equals("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message, ScreenshotUtils.attachScreenshot());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenShotNeeded) {
		if (PropertyUtils.getValueFromConfigMap(ProjectConfig.FAILEDSTEPSCREENSHOT).equals("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, ScreenshotUtils.attachScreenshot());
		} else {
			fail(message);
		}
	}
	
	public static void skip(String message, boolean isScreenShotNeeded) {
		if (PropertyUtils.getValueFromConfigMap(ProjectConfig.SKIPPEDSTEPSCREENSHOT).equals("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(message, ScreenshotUtils.attachScreenshot());
		} else {
			skip(message);
		}
	}
	

    private static ThreadLocal<Capabilities> cap = ThreadLocal.withInitial(() -> ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities());
    private static ThreadLocal<String> browser = ThreadLocal.withInitial(() -> cap.get().getBrowserName().toUpperCase());
    private static ThreadLocal<String> browserVersion = ThreadLocal.withInitial(() -> cap.get().getBrowserVersion().toUpperCase());

    public static void assignCategory() {
        ExtentManager.getExtentTest().assignCategory(browser.get() +"_"+ browserVersion.get());
    }

    public static void logBrowserNameAndVersion() {
        String message = String.format("Test is launched in %s with version %s ", browser.get(), browserVersion.get());
        ExtentManager.getExtentTest().info(MarkupHelper.createLabel(message, ExtentColor.TEAL));
    }
}