package com.selenium.uiautomation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

	// i tried to use the linkText learn more but can't be found for some reason, css is more accurate
	@FindBy(css="a[class*='btn-about']")
	private WebElement aboutLink;
	
	@FindBy(xpath="//div[contains(@class, 'news__swd news__teaser-column')]")
	private WebElement newsLetterLink;

	@FindBy(xpath="//div[contains(@class, 'owl-item') and contains(@class, 'active')]")
	private WebElement activeCarousel;
	
	@FindBy(xpath="//*[@id=\'owl-carousel-block-row6\']//div[@class=\'owl-dot\']")
	private List<WebElement> carouselNav;
	
	@FindBy(xpath="//p[contains(text(), 'Microsoft Windows Applications') and contains(@class, 'iconTitle')]")
	private WebElement swdMicrosoftWindowsApplicationsFigure;
	
	@FindBy(xpath="//p[contains(text(), 'Microsoft Web Solutions') and contains(@class, 'iconTitle')]/..")
	private WebElement swdMicrosoftWebSolutionsFigure;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public AboutPage clickOnAbout() {
		aboutLink.click();
		return new AboutPage(this.mWebDriver);
	}
	
	public NewsLetterPage clickOnNewsLetterLink() {
		action.moveToElement(newsLetterLink).build().perform();
		newsLetterLink.findElement(By.xpath("//img[contains(@class, 'hover-image')]")).click();
		return new NewsLetterPage(this.mWebDriver);
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement getCarouselNavigationByIndex(int index) {
		return carouselNav.get(index);
	}

	public WebElement getActiveCarousel() {
		return activeCarousel;
	}

	public WebElement getSwdMicrosoftWindowsApplicationsFigure() {
		return swdMicrosoftWindowsApplicationsFigure;
	}

	public WebElement getSwdMicrosoftWebSolutionsFigure() {
		return swdMicrosoftWebSolutionsFigure;
	}
	
	public void hoverSwdMicrosoftWindowsApplicationsFigure() {
		action.moveToElement(swdMicrosoftWindowsApplicationsFigure).build().perform();
	}
	
}
