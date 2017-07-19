package com.selenium.uiautomation.test.news;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.selenium.uiautomation.pageobject.HomePage;
import com.selenium.uiautomation.pageobject.NewsLetterPage;
import com.selenium.uiautomation.test.WebDriverTestBase;

public class NewsPageTest extends WebDriverTestBase{
	
	private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
	
	@Test
	public void validateNavigateToNewsLetter() {
		HomePage homePage =  PageFactory.initElements(driver, HomePage.class);
		NewsLetterPage newLetterPage = homePage.clickOnNewsLetterLink();
		PageFactory.initElements(driver, newLetterPage);
		assertNotNull(newLetterPage.getNameInput());
		assertNotNull(newLetterPage.getCompanyNameInput());
		assertNotNull(newLetterPage.getEmailInput());
	}
	
	@Test
	public void  joinNewsLetterValidData() {
		validateNavigateToNewsLetter();
		NewsLetterPage newLetterPage =  PageFactory.initElements(driver, NewsLetterPage.class);
		newLetterPage.getNameInput().sendKeys("John");
		newLetterPage.getCompanyNameInput().sendKeys("Doe .ltd");
		newLetterPage.getEmailInput().sendKeys(randomEmail());
		newLetterPage.getCaptchaCheckBox().click();
	}
}
