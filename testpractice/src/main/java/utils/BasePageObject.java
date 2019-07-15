package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 50, 5);
		PageFactory.initElements(driver, this);
	}

	protected WebElement getElement(final By by) {
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}

	protected void setInputValue(By by, String value) {
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(value);
	}

	protected void setInputValue(String locator, String value) {
		setInputValue(By.xpath(locator), value);
	}

	protected void clickElement(By by) {
		WebElement element = getElement(by);
		element.click();
	}

	protected void clickElement(String locator) {
		clickElement(By.xpath(locator));
	}

}
