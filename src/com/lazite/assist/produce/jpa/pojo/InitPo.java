package com.lazite.assist.produce.jpa.pojo;

public class InitPo {
	protected String projectName;
	
	protected String className;
	
	protected String sperate="";
	
	
	public InitPo() {
		super();
	}

	public InitPo(String projectName, String className, String sperate) {
		super();
		this.projectName = projectName;
		this.className = className;
		this.sperate = sperate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSperate() {
		return sperate;
	}

	public void setSperate(String sperate) {
		this.sperate = sperate;
	}
	
	
	
}
