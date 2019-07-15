package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import dataprovider.ConfigFileReader;

public class BaseClass {
	public static WebDriver driver;

	ConfigFileReader configFileReader = new ConfigFileReader();

	private void launchDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "C:/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:

		}
		
	}

	public void launchApplication() {
		launchDriver(configFileReader.getBrowserName());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeSession() {
		driver.quit();
	}

}
