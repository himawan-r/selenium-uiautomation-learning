package com.selenium.uiautomation.pageobject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLetterPage extends CommonPage{

	@FindBy(id="edit-submitted-name")
	private WebElement nameInput;

	@FindBy(id="edit-submitted-company-name")
	private WebElement companyNameInput;

	@FindBy(id="edit-submitted-email-address")
	private WebElement emailInput;
	
	@FindBy(xpath = "//span[contains(@class, 'recaptcha-checkbox')]")
	private WebElement captchaCheckBox;
	
	public NewsLetterPage(WebDriver webDriver) {
		super(webDriver);
	}


	public WebElement getNameInput() {
		return nameInput;
	}


	public WebElement getCompanyNameInput() {
		return companyNameInput;
	}


	public WebElement getEmailInput() {
		return emailInput;
	}


	public WebElement getCaptchaCheckBox() {
		 mWebDriverWait.until(ExpectedConditions.visibilityOf(captchaCheckBox));
		 return captchaCheckBox;
	}

}
