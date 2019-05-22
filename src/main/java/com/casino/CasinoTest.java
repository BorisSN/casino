package com.casino;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CasinoTest {
	String loginName = "admin1";
	String password = "[9k<k8^z!+$$GkuP";
	Casino casino;
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Boris\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		casino = new Casino(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void FillFieldsPositive() throws IOException, InterruptedException {
		casino.fillLogin(loginName).fillPassword(password).clickSubmitLoginPage();
		assertTrue(casino.checkConfirmLabel());
		casino.clickPlayButton();
		assertTrue(casino.checkTableIsDisplayed());
		casino.clickSortUserName();
		// Sleep for alphabetical sort.
		Thread.sleep(1000);
		casino.checkSortPlayersListTable();
	}
}
