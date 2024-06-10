package factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}

	public static WebElement preformExplicitWait(By byElement, WaitStrategy waitType) {

		Duration waitDuration = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitDuration);

		return switch (waitType) {
		case CLICKABLE -> wait.until(ExpectedConditions.elementToBeClickable(byElement));
		case PRESENCE -> wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
		case VISIBLE -> wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		case NONE -> DriverManager.getDriver().findElement(byElement);
		};
	}
}