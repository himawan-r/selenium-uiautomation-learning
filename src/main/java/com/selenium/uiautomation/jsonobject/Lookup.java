package com.selenium.uiautomation.jsonobject;

import java.util.HashMap;
import java.util.Map;

public class Lookup {
	
	private String lookuptext;
	
	private String lookupvalue;
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getLookuptext() {
		return lookuptext;
	}

	public void setLookuptext(String lookuptext) {
		this.lookuptext = lookuptext;
	}

	public String getLookupvalue() {
		return lookupvalue;
	}

	public void setLookupvalue(String lookupvalue) {
		this.lookupvalue = lookupvalue;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
}
