package com.lazite.assist.produce.jpa.pojo.ftl;

public class Toolbar {
	
	private String name; 
		
	private String icon;

	private String color;
	
	private String ifModel;

	public Toolbar(String name, String icon, String color, String ifModel) {
		super();
		this.name = name;
		this.icon = icon;
		this.color = color;
		this.ifModel = ifModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIfModel() {
		return ifModel;
	}

	public void setIfModel(String ifModel) {
		this.ifModel = ifModel;
	}
	
	
}
