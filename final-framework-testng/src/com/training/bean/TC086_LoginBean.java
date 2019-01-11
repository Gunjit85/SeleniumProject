/* Test case RETC086 - To Verify whether application allows admin to Add New Region in the application & 
 * added details should get displayed in database.
 * The Bean to get the details from DB */

package com.training.bean;

public class TC086_LoginBean {
	private String regionName;
	private String slugName;
	private String description;

	public TC086_LoginBean() {
	}

	public TC086_LoginBean(String regionName, String slugName, String description) {
		super();
		this.regionName = regionName;
		this.slugName = slugName;
		this.description = description;
	}
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TC086_LoginBean [regionName=" + regionName + ", slugName=" + slugName + ", description=" + description + "]";
	}

}
