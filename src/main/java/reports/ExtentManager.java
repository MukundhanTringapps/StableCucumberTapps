package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

	static void setExtentTest(ExtentTest testCaseName) {
		extentTestThreadLocal.set(testCaseName);
	}

	static ExtentTest getExtentTest() {
		return extentTestThreadLocal.get();
	}

	static void unloadExtentTest() {
		extentTestThreadLocal.remove();
	}
}