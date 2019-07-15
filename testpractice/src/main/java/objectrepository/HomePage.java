package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseClass;

public class HomePage extends BaseClass {

	By wmbutton = By.xpath("//button[text()='My WM']");
	By loader = By.id("loader");
	By Email_Field = By.xpath("//div[@class='Login  en_US']//input[@type='email']");
	By password = By.xpath("//div[@class='Login  en_US']//input[@type='password']");
	By submit = By.xpath("//div[@class='Login  en_US']//button[@type='submit']");

	public boolean waitTillLoaderDisappears() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}

	public void clickMyWMButton() {
		driver.findElement(wmbutton).click();
	}

	public void enterEmail(String email) {
		driver.findElement(Email_Field).sendKeys(email);
	}

	public void enterPassword(String Password) {
		driver.findElement(password).sendKeys(Password);
	}

	public void clickSubmit() {
		driver.findElement(submit).click();
	}
}
