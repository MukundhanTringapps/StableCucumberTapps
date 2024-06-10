package helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import reports.ExtentLogger;

public final class Helper {

	private Helper() {
	}

	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	}

	public static void unhighlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].style.border=''", element);
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView({behaviour: 'smooth', block: 'center', inline: 'nearest'})",
				element);
	}

	public static void clickUsingJSExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	public static void scrollHalfAPage() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		long viewportHeight = (long) js.executeScript("return window.innerHeight");
		js.executeScript("window.scrollBy(0, " + viewportHeight / 2 + ")");
		ExtentLogger.info("Scrolling past half a page");
	}

	public static void scrollToTheTopOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(0, 0)");
		ExtentLogger.info("Scrolling to the top of the page");
	}

	public static void verifyPageLoadStrategy() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest getRequest = HttpRequest.newBuilder().uri(URI.create(DriverManager.getDriver().getCurrentUrl()))
				.build();
		try {
			HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
			if (getResponse.statusCode() == 200) {
				ExtentLogger.info("Site is loaded as expected");
			}
		} catch (IOException e) {
			ExtentLogger.info("Unable to load the site as expected: " + e.getMessage());
		} catch (InterruptedException e) {
			ExtentLogger.info("Unable to load the URL as expected: " + e.getMessage());
		}
	}

	public static List<String> getCurrentWindowHandleID() {
		Set<String> allHandles = DriverManager.getDriver().getWindowHandles();
		return new ArrayList<>(allHandles);
	}

	public static void closeCurrentWindow() {
		ExtentLogger.info("Closing the current window");
		DriverManager.getDriver().close();
	}

	public static void goBackToPreviuosWindow() {
		ExtentLogger.info("Navigating back to the previous window");
		DriverManager.getDriver().navigate().back();
	}

	public static void waitForFewSeconds() {
		try {
			ExtentLogger.info("Waiting for few seconds");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			ExtentLogger.fail("Exception while waiting : " + e.getMessage());
		}
	}

	public static void waitForTwoSeconds() {
		try {
			ExtentLogger.info("Waiting for few seconds");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			ExtentLogger.fail("Exception while waiting : " + e.getMessage());
		}
	}
	
	public static void switchWindow() {
		Set<String> allHandles = DriverManager.getDriver().getWindowHandles();
		ArrayList<String> tab = new ArrayList<>(allHandles);
		switch (tab.size()) {
		case 1 -> DriverManager.getDriver().switchTo().window(tab.get(0));
		case 2 -> DriverManager.getDriver().switchTo().window(tab.get(1));
		default -> DriverManager.getDriver().switchTo().window(tab.get(tab.size() - 1));
		}
	}

	public static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
}