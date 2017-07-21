package com.selenium.uiautomation.jsonobject;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lookups {
	
	@SerializedName("lookupID")
	@Expose
	private String lookupID;
	@SerializedName("lookupData")
	@Expose
	private List<Lookup> lookupData = null;

	public String getLookupID() {
	return lookupID;
	}

	public void setLookupID(String lookupID) {
		this.lookupID = lookupID;
	}

	public List<Lookup> getLookupData() {
		return lookupData;
	}

	public void setLookupData(List<Lookup> lookupData) {
		this.lookupData = lookupData;
	}
}
