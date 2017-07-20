package com.selenium.uiautomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.uiautomation.utils.UserInteractionUtil;

public class CommonPage implements UserInteractionUtil{
	
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

	@Override
	public void hoverElement(WebElement webElement) {
		action.moveToElement(webElement).build().perform();
		//mWebDriverWait.until(isCssTransitionsEnd(getElementXPath(webElement.findElement(By.xpath("//figcaption")))));
	}
	
	//Check if transitions end
	public static ExpectedCondition<Boolean> isCssTransitionsEnd(String xpath) {
	    return new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	    	String test =  String.format(LISTEN_CSS_TRANSITION_END, xpath);
	        return (Boolean) ((JavascriptExecutor) driver)
	          .executeScript(test);
	      }
	    };
	  }
	
	//get xpath
	private String getElementXPath(WebElement element) {
	    return (String)((JavascriptExecutor)mWebDriver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
	}
	
	//string to js function
	private static String LISTEN_CSS_TRANSITION_END = 
	"(function () {\r\n" + 
	"    function getElementByXpath(path) {\r\n" + 
	"  		return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\r\n" + 
	"  		}\r\n"+
	"var e = getElementByXpath('%s')[0];\r\n" + 
	"\r\n" + 
	"    function whichTransitionEvent() {\r\n" + 
	"        var t;\r\n" + 
	"        var el = document.createElement('fakeelement');\r\n" + 
	"        var transitions = {\r\n" + 
	"            'transition': 'transitionend',\r\n" + 
	"            'OTransition': 'oTransitionEnd',\r\n" + 
	"            'MozTransition': 'transitionend',\r\n" + 
	"            'WebkitTransition': 'webkitTransitionEnd'\r\n" + 
	"        };\r\n" + 
	"        var i;\r\n" + 
	"        for (i=0; i<transitions.length; transitions) {\r\n" + 
	"            if (el.style[t] !== undefined) {\r\n" + 
	"                return transitions[t];\r\n" + 
	"            }\r\n" + 
	"        }\r\n" + 
	"    }\r\n" + 
	"    var transitionEvent = whichTransitionEvent();\r\n" + 
	"    transitionEvent && e.addEventListener(transitionEvent, function() {\r\n" + 
	"        return true;\r\n" + 
	"    });\r\n" + 
	"})();";
	
}
