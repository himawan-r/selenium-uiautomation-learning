package com.selenium.uiautomation.test.home;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.uiautomation.pageobject.AboutPage;
import com.selenium.uiautomation.pageobject.HomePage;
import com.selenium.uiautomation.test.WebDriverTestBase;

public class HomePageTest extends WebDriverTestBase{
	
	@Test
	public void validateNavigateToAbout() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		AboutPage aboutPage = homePage.clickOnAbout();
		PageFactory.initElements(driver, aboutPage);
		assertEquals("About title is match", aboutPage.getPageTitle(), driver.getTitle());
		assertTrue("Time Line is displayed", aboutPage.getTimeLineUnorderedList().isDisplayed());
	}
	
	@Test
	public void clickChangeLanguage() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		WebElement bahasaLink = homePage.findLanguageByLinkText("Bahasa Indonesia");
		WebElement englishLink = homePage.findLanguageByLinkText("English");
		assertNotNull("Bahasa Indonesia Language Link is avaliable", bahasaLink);
		assertNotNull("English Language Link is avaliable", englishLink);
		
		bahasaLink.click();
		assertTrue("URL contains /id", driver.getCurrentUrl().contains("/id"));
		
		//since the page reload after changing language, we need to get new reference to the element
		englishLink = homePage.findLanguageByLinkText("English");
		englishLink.click();
		assertTrue("URL contains /en", driver.getCurrentUrl().contains("/en"));
	}
	
	@Test
	public void checkCarousel() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.getCarouselNavigationByIndex(0).click();
		assertNotNull("Carousel item 1 is currently active", homePage.getActiveCarousel().findElement(By.xpath("//div[@id='node-231']")));
		homePage.getCarouselNavigationByIndex(1).click();
		assertNotNull("Carousel item 2 is currently active", homePage.getActiveCarousel().findElement(By.xpath("//div[@id='node-232']")));
		homePage.getCarouselNavigationByIndex(2).click();
		assertNotNull("Carousel item 3 is currently active", homePage.getActiveCarousel().findElement(By.xpath("//div[@id='node-233']")));
	}
	
	@Test
	public void checkSWDHover() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.hoverSwdMicrosoftWindowsApplicationsFigure();
		assertEquals("figure cursor will be pointer : ", homePage.getSwdMicrosoftWindowsApplicationsFigure().getCssValue("cursor"), "pointer");
		assertEquals("opacity : ", homePage.getSwdMicrosoftWindowsApplicationsFigure().findElement(By.xpath("//figcaption")).getCssValue("opacity"), "0.95");
	}

}
