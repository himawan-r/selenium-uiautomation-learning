package com.selenium.uiautomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends CommonPage{

	@FindBy(className = "timeline")
	private WebElement timeLineUnorderedList;
	
	public AboutPage(WebDriver webDriver) {
		super(webDriver);
	}

	public WebElement getTimeLineUnorderedList() {
		return timeLineUnorderedList;
	}

	public void setTimeLineUnorderedList(WebElement timeLineUnorderedList) {
		this.timeLineUnorderedList = timeLineUnorderedList;
	}
	
	
}
