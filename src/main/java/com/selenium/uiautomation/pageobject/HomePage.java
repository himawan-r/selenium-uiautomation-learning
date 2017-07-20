package com.selenium.uiautomation.pageobject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

	// i tried to use the linkText learn more but can't be found for some reason, css is more accurate
	@FindBy(css="a[class*='btn-about']")
	private WebElement aboutLink;
	
	@FindBy(xpath="//div[contains(@class, 'news__swd news__teaser-column')]")
	private WebElement newsLetterLink;

	@FindBy(xpath="//div[contains(@class, 'owl-item') and contains(@class, 'active')]")
	private WebElement activeCarousel;
	
	@FindBy(xpath="//*[@id=\'owl-carousel-block-row6\']//div[contains(@class,'owl-dot')]")
	private List<WebElement> carouselNav;
	
	@FindBy(xpath="//p[contains(text(), 'Microsoft Windows Applications') and contains(@class, 'iconTitle')]/..")
	private WebElement swdMicrosoftWindowsApplicationsFigure;
	
	@FindBy(xpath="//p[contains(text(), 'Microsoft Web Solutions') and contains(@class, 'iconTitle')]/..")
	private WebElement swdMicrosoftWebSolutionsFigure;
	
	@FindBy(xpath="//p[contains(text(), 'Mobile Services') and contains(@class, 'iconTitle')]/..")
	private WebElement swdMobileServices;
	
	@FindBy(xpath="//p[contains(text(), 'Ellipse') and contains(@class, 'iconTitle')]/..")
	private WebElement swdEllipse;
	
	@FindBy(xpath="//p[contains(text(), 'Java Technologies') and contains(@class, 'iconTitle')]/..")
	private WebElement swdJavaTechnologies;

	@FindBy(xpath="//p[contains(text(), 'User Interaction Design') and contains(@class, 'iconTitle')]/..")
	private WebElement swdUserInteractionDesign;

	@FindBy(xpath="//p[contains(text(), 'Web Technologies') and contains(@class, 'iconTitle')]/..")
	private WebElement swdWebTechnologies;

	@FindBy(xpath="//p[contains(text(), 'Enterprise Integration') and contains(@class, 'iconTitle')]/..")
	private WebElement swdEnterpriseIntegration;

	@FindBy(xpath="//p[contains(text(), 'Business Intelligence') and contains(@class, 'iconTitle')]/..")
	private WebElement swdBusinessIntelligence;

	@FindBy(xpath="//p[contains(text(), 'Software Quality and Testing') and contains(@class, 'iconTitle')]/..")
	private WebElement swdSoftwareQualityandTesting;

	@FindBy(xpath="//p[contains(text(), 'Managed Services') and contains(@class, 'iconTitle')]/..")
	private WebElement swdManagedServices;
	
	@FindBy(xpath="//p[contains(text(), 'Software Development Tool') and contains(@class, 'iconTitle')]/..")
	private WebElement swdSoftwareDevelopmentTools;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public AboutPage clickOnAbout() {
		aboutLink.click();
		return new AboutPage(this.mWebDriver);
	}
	
	public NewsLetterPage clickOnNewsLetterLink() {
		action.moveToElement(newsLetterLink).build().perform();
		
		//adding this line will improve stability, since sometime the hover animation is not done and the img is not clickable
		this.mWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@class, 'hover-image')]")));
		
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

	public WebElement getNewsLetterLink() {
		return newsLetterLink;
	}

	public WebElement getSwdMobileServices() {
		return swdMobileServices;
	}

	public WebElement getSwdEllipse() {
		return swdEllipse;
	}

	public WebElement getSwdJavaTechnologies() {
		return swdJavaTechnologies;
	}

	public WebElement getSwdUserInteractionDesign() {
		return swdUserInteractionDesign;
	}

	public WebElement getSwdWebTechnologies() {
		return swdWebTechnologies;
	}

	public WebElement getSwdEnterpriseIntegration() {
		return swdEnterpriseIntegration;
	}

	public WebElement getSwdBusinessIntelligence() {
		return swdBusinessIntelligence;
	}

	public WebElement getSwdSoftwareQualityandTesting() {
		return swdSoftwareQualityandTesting;
	}

	public WebElement getSwdManagedServices() {
		return swdManagedServices;
	}

	public WebElement getSwdSoftwareDevelopmentTools() {
		return swdSoftwareDevelopmentTools;
	}
	
}
