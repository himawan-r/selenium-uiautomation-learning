package com.selenium.uiautomation.test;

import static org.mockito.Matchers.anyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.selenium.uiautomation.jsonobject.Lookup;
import com.selenium.uiautomation.jsonobject.Lookups;

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
	
	public Lookups getLookupDataByID(String Id){
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("src/main/resources/json/lookup.json"));
			Lookups[] lookups = gson.fromJson(reader, Lookups[].class); 
			return Arrays.stream(lookups).filter(item -> item.getLookupID().equalsIgnoreCase(Id)).findFirst().orElse(null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
