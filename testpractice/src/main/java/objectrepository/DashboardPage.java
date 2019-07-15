package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseClass;

public class DashboardPage extends BaseClass{
	
	By MyBillingWidgetTitle = By.xpath("//span[text()='My Billing']");

	public void waitTillDashboardLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MyBillingWidgetTitle));
	}
}
