package com.casino;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Casino extends Helper {

	@FindBy(xpath = "//*[@id='UserLogin_username']")
	WebElement loginField;

	@FindBy(xpath = "//*[@id='UserLogin_password']")
	WebElement passwordField;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='logo']")
	WebElement sandwichButton;

	@FindBy(xpath = "//*[@class='sort-link'][0]")
	WebElement userNameSortButton;

	public Casino(WebDriver driver) {
		super(driver);
		driver.get("http://test-app.d6.dev.devcaz.com/admin/login");
		PageFactory.initElements(driver, this);
	}

	public Casino fillLogin(String loginName) throws IOException, InterruptedException {
		waitUntilElementIsLoaded(loginField);
		setElementText(loginField, loginName);
		return this;
	}

	public Casino fillPassword(String password) throws IOException, InterruptedException {
		waitUntilElementIsLoaded(passwordField);
		setElementText(passwordField, password);
		return this;
	}

	public void clickSubmitLoginPage() throws IOException, InterruptedException {
		// waitUntilElementIsLoaded(submitButton);
		submitButton.click();
	}

	public void clickPlayButton() throws IOException, InterruptedException {
		waitUntilElementIsLoaded(driver.findElements(By.cssSelector(".box-info")).get(2));
		driver.findElements(By.cssSelector(".box-info")).get(2).click();
	}

	public void clickSortUserName() throws IOException, InterruptedException {
		waitUntilElementIsLoaded(driver.findElements(By.cssSelector(".sort-link")).get(0));
		driver.findElements(By.cssSelector(".sort-link")).get(0).click();
	}

	// Check that we have Label Casino on the screen
	public boolean checkConfirmLabel() {
		return exists(sandwichButton);
	}

	// Check that we have table Casino on the screen
	public boolean checkTableIsDisplayed() {
		return exists(driver.findElement(By.className("table")));
	}

	// Check that we have sorted table on the screen
	public void checkSortPlayersListTable() throws IOException, InterruptedException {
		sort();
	}
}
