package com.lazite.assist.produce.jpa.pojo.ftl;

import java.util.List;

public class Body {
	
	private String container; 

	private String scrpitLabel; 
	
	private String scrpitDefined;
	
	private List<String> models;

	public Body(String container, String scrpitLabel, String scrpitDefined) {
		super();
		this.container = container;
		this.scrpitLabel = scrpitLabel;
		this.scrpitDefined = scrpitDefined;
	}
	
	public Body(String container, String scrpitLabel, String scrpitDefined,
			List<String> models) {
		super();
		this.container = container;
		this.scrpitLabel = scrpitLabel;
		this.scrpitDefined = scrpitDefined;
		this.models = models;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getScrpitLabel() {
		return scrpitLabel;
	}

	public void setScrpitLabel(String scrpitLabel) {
		this.scrpitLabel = scrpitLabel;
	}

	public String getScrpitDefined() {
		return scrpitDefined;
	}

	public void setScrpitDefined(String scrpitDefined) {
		this.scrpitDefined = scrpitDefined;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	} 
	
	
}
