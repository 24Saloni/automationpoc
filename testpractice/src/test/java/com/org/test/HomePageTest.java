package com.org.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectrepository.DashboardPage;
import objectrepository.HomePage;
import utils.BaseClass;

public class HomePageTest extends BaseClass {

	HomePage hp;
	DashboardPage dashboardPage;

	@Test
	public void mytestmethod() throws InterruptedException {
		hp = new HomePage();
		dashboardPage = new DashboardPage();
		launchApplication();
		Assert.assertTrue(hp.waitTillLoaderDisappears(), "Pass");
		hp.clickMyWMButton();
		hp.enterEmail("testwmx@yopmail.com");
		hp.enterPassword("Waste2222");
		hp.clickSubmit();
		dashboardPage.waitTillDashboardLoad();
	}

}
