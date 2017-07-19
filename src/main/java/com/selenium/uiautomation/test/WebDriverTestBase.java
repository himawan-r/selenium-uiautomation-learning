package com.selenium.uiautomation.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTestBase {
	
	protected WebDriver driver;
	private static final String BASE_URL = "http://www.mitrais.com";
	private static final String CHROME_DRIVER_URL = "C:/Selenium/chromedriver.exe";
	private static final String CHROME_DRIVER = "webdriver.chrome.driver";
	
	@Before
	public void setup() {
		File file = new File(CHROME_DRIVER_URL);
		System.setProperty(CHROME_DRIVER, file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get(BASE_URL);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
