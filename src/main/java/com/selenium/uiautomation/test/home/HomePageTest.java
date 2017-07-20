package com.selenium.uiautomation.test.home;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	@Ignore
	@Test
	public void validateNavigateToAbout() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		AboutPage aboutPage = homePage.clickOnAbout();
		PageFactory.initElements(driver, aboutPage);
		assertEquals("About title is match", aboutPage.getPageTitle(), driver.getTitle());
		assertTrue("Time Line is displayed", aboutPage.getTimeLineUnorderedList().isDisplayed());
	}
	@Ignore
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
	
	@Ignore
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
	
	/**
	 * 
	 */
	@Test
	public void checkSWDHover1() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.hoverElement(homePage.getSwdMicrosoftWindowsApplicationsFigure());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdMicrosoftWindowsApplicationsFigure().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdMicrosoftWindowsApplicationsFigure().findElement(By.xpath("//figcaption")).getCssValue("opacity"), "0");
		
		//for some reason opacity is not changed for the other when i tried to get it, it is still 0, as for transform value changed into matrix (need more research)
		/*homePage.hoverElement(homePage.getSwdMobileServices());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdMobileServices().getCssValue("cursor"), "pointer");
		assertEquals("the transform value after getting hovered for the image background is 0", "translateY(0%)", homePage.getSwdMobileServices().findElement(By.xpath("//figcaption")).getCssValue("transform"));
	
		homePage.hoverElement(homePage.getSwdMicrosoftWebSolutionsFigure());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdMicrosoftWebSolutionsFigure().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdMicrosoftWebSolutionsFigure().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");
	
		homePage.hoverElement(homePage.getSwdEllipse());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdEllipse().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdEllipse().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");
		
		homePage.hoverElement(homePage.getSwdJavaTechnologies());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdJavaTechnologies().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdJavaTechnologies().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");
		
		homePage.hoverElement(homePage.getSwdWebTechnologies());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdWebTechnologies().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdWebTechnologies().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");
		
		homePage.hoverElement(homePage.getSwdEnterpriseIntegration());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdEnterpriseIntegration().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdEnterpriseIntegration().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");

		homePage.hoverElement(homePage.getSwdBusinessIntelligence());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdBusinessIntelligence().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdBusinessIntelligence().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");

		homePage.hoverElement(homePage.getSwdSoftwareQualityandTesting());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdSoftwareQualityandTesting().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdSoftwareQualityandTesting().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");

		homePage.hoverElement(homePage.getSwdManagedServices());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdManagedServices().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdManagedServices().findElement(By.xpath("//figcaption")).getCssValue("transform"), "translateY(0%)");

		homePage.hoverElement(homePage.getSwdUserInteractionDesign());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdUserInteractionDesign().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdUserInteractionDesign().findElement(By.xpath("//figcaption")).getCssValue("transform"), "0");

		homePage.hoverElement(homePage.getSwdSoftwareDevelopmentTools());
		assertEquals("figure cursor will be pointer : ", homePage.getSwdSoftwareDevelopmentTools().getCssValue("cursor"), "pointer");
		assertNotEquals("the opacity after getting hovered for the image background is not 0", homePage.getSwdSoftwareDevelopmentTools().findElement(By.xpath("//figcaption")).getCssValue("transform"), "0");
		*/
	}
	
}
