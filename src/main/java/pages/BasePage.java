package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import helper.Helper;
import reports.ExtentLogger;

public class BasePage {

	protected void click(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null) {
				Helper.scrollIntoView(element);
				ExtentLogger.pass(elementName + " is clicked", true);
				element.click();
			} else {
				ExtentLogger.fail("Unable to find the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while trying to click on the element " + elementName + ": " + e.getMessage(),
					true);
		}
	}
	
	protected void click(WebElement element, String elementName) {
		try {
			if (element != null) {
				Helper.scrollIntoView(element);
				ExtentLogger.pass(elementName + " is clicked", true);
				element.click();
			} else {
				ExtentLogger.fail("Unable to find the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while trying to click on the element " + elementName + ": " + e.getMessage(),
					true);
		}
	}

	protected void clickUsingJavaSciptExecutor(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null) {
				Helper.scrollIntoView(element);
				ExtentLogger.pass(elementName + " is clicked", true);
				Helper.clickUsingJSExecutor(element);
			} else {
				ExtentLogger.fail("Unable to find the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while trying to click on the element " + elementName + ": " + e.getMessage(),
					true);
		}
	}

	protected void sendKeys(By byElement, String elementName, String value, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null) {
				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				element.sendKeys(value);
				ExtentLogger.pass(value + " is entered successfully in " + elementName, true);
				Helper.unhighlightElement(element);
			} else {
				ExtentLogger.fail("Unable to find the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail(
					"Exception while trying to send keys to the element " + elementName + ": " + e.getMessage(), true);
		}
	}

	protected void clearTheField(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null) {
				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				element.clear();
				ExtentLogger.info("Clearing the input field : " + elementName);
				Helper.unhighlightElement(element);
			} else {
				ExtentLogger.fail("Unable to find the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while trying to clear the field " + elementName + ": " + e.getMessage(), true);
		}
	}

	protected void isElementDisplayed(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null && element.isDisplayed()) {
				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				ExtentLogger.pass(elementName + " is displayed as expected", true);
				Helper.unhighlightElement(element);
			} else {
				ExtentLogger.fail("Unable to find or display the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while checking element display status: " + e.getMessage(), true);
		}
	}
	
	protected void isWebElementDisplayed(WebElement element, String elementName) {
		try {
			Helper.waitForTwoSeconds();
			if (element != null && element.isDisplayed()) {
				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				ExtentLogger.pass(elementName + " is displayed as expected", true);
				Helper.unhighlightElement(element);
			} else {
				ExtentLogger.fail("Unable to find or display the element " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while checking element display status: " + e.getMessage(), true);
		}
	}

	protected void isElementDisplayedInList(WebElement byElement) {
		try {
			if (byElement != null && byElement.isDisplayed()) {
				Helper.scrollIntoView(byElement);
				Helper.highlightElement(byElement);
				ExtentLogger.pass(byElement.getText() + " is displayed as expected", true);
				Helper.unhighlightElement(byElement);
			} else {
				ExtentLogger.fail("Unable to find or display the element " + byElement.getText(), true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while checking element display status: " + e.getMessage(), true);
		}
	}

	protected void verifyTextMatch(By byElement, String elementName, String value, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null && element.isDisplayed() && element.getText().equalsIgnoreCase(value)) {
				System.out.println("Actual Text : " + element.getText() + " matches the expected text : " + value);

				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				ExtentLogger.pass("Actual Text : " + element.getText() + " matches the expected text : " + value);
				ExtentLogger.pass(elementName + " matches the text as expected successfully", true);
				Helper.unhighlightElement(element);
			} else {
				String errorMessage = "Unable to find the element : " + elementName;
				if (element != null && element.isDisplayed()) {
					errorMessage = "Text mismatch for element : " + elementName + ". Expected: " + value + ", Actual: "
							+ element.getText();
				}
				ExtentLogger.fail(errorMessage, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while verifying text match: " + e.getMessage(), true);
		}
	}

	protected void verifyTextContains(By byElement, String elementName, String expectedText, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null && element.isDisplayed() && element.getText().contains(expectedText)) {
				System.out.println("Actual Text : " + element.getText() + " contains the expected text : " + expectedText);
				Helper.scrollIntoView(element);
				Helper.highlightElement(element);
				ExtentLogger.pass("Actual Text : " + element.getText() + " contains the expected text : " + expectedText);
				ExtentLogger.pass(elementName + " contains the text as expected successfully", true);
				Helper.unhighlightElement(element);
			} else {
				String errorMessage = "Unable to find the element : " + elementName;
				if (element != null && element.isDisplayed()) {
					errorMessage = "Text not found or does not contain expected text for element : " + elementName
							+ ". Expected: " + expectedText + ", Actual: " + element.getText();
				}
				ExtentLogger.fail(errorMessage, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while verifying text containment: " + e.getMessage(), true);
		}
	}

	protected void moveToElement(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);

			if (element != null) {
				Actions action = new Actions(DriverManager.getDriver());
				action.moveToElement(element).build().perform();
				ExtentLogger.pass("Successfully moved to the element: " + elementName);
			} else {
				ExtentLogger.fail("Element not found within the specified wait time: " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while trying to move to the element " + elementName + ": " + e.getMessage(),
					true);
		}
	}

	public String getPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		ExtentLogger.pass("Title is - " + title);
		return title;
	}

	protected String getElementText(By byElement, String elementName, WaitStrategy waitType) {
		try {
			WebElement element = ExplicitWaitFactory.preformExplicitWait(byElement, waitType);
			if (element != null && element.isDisplayed()) {
				return element.getText();
			} else {
				ExtentLogger.fail("Unable to find the element : " + elementName, true);
			}
		} catch (Exception e) {
			ExtentLogger.fail("Exception while extracting the text from the element : " + elementName + e.getMessage(), true);
		}
		return null;
	}

}