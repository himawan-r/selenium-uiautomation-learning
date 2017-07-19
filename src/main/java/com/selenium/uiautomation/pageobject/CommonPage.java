package com.selenium.uiautomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	
	@FindBy(linkText = "ABOUT")
	private WebElement aboutSection;
	
	@FindBy(linkText = "SOFTWARE DEVELOPMENT")
	private WebElement softwareDevelopmentSection;
	
	@FindBy(linkText = "MINING SOFTWARE")
	private WebElement miningSoftwareSection;
	
	@FindBy(linkText = "MEDICAL SOFTWARE")
	private WebElement medicalSoftwareSection;
	
	@FindBy(linkText = "CLIENTS")
	private WebElement clientsSection;
	
	@FindBy(linkText = "TEAM")
	private WebElement teamSection;
	
	@FindBy(linkText = "NEWS")
	private WebElement newsSection;	

	@FindBy(linkText = "CAREER")
	private WebElement careerLink;
	
	@FindBy(linkText = "BLOG")
	private WebElement blogLink;
	
	@FindBy(linkText = "CONTACT US")
	private WebElement contactUsSection;
	
	protected WebDriver mWebDriver;
	
	protected WebDriverWait mWebDriverWait;
	
	protected Actions action;
	
	public CommonPage(WebDriver webDriver) {
		mWebDriver = webDriver;
		action = new Actions(this.mWebDriver);
		mWebDriverWait = new WebDriverWait(mWebDriver, 10);
	}
	
	public String getPageTitle() {
		return mWebDriver.getTitle();
	}
	
	public WebElement findLanguageByLinkText(String linkText) {
		return mWebDriver.findElement(By.id("block-locale-language")).findElement(By.linkText(linkText));
	}

	public WebElement getAboutSection() {
		return aboutSection;
	}

	public WebElement getSoftwareDevelopmentSection() {
		return softwareDevelopmentSection;
	}

	public WebElement getMiningSoftwareSection() {
		return miningSoftwareSection;
	}

	public WebElement getMedicalSoftwareSection() {
		return medicalSoftwareSection;
	}

	public WebElement getClientsSection() {
		return clientsSection;
	}

	public WebElement getTeamSection() {
		return teamSection;
	}

	public WebElement getNewsSection() {
		return newsSection;
	}

	public WebElement getCareerLink() {
		return careerLink;
	}

	public WebElement getBlogLink() {
		return blogLink;
	}

	public WebElement getContactUsSection() {
		return contactUsSection;
	}
	
}
