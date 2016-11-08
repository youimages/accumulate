package com.lazite.assist.produce.jpa.pojo.ftl;

import java.util.List;


public class Attribute{
	
	private String name;
	
	private String nameCN;
	
	private String width;
	
	private String placeholder;//作为form表单时的提示
	
	private String inputType;//作为form表单时input类型,text/textarea/radio
	
	private List<Attribute_Radio> ars;//type为radio时的radio属性
	
	public Attribute(String name, String nameCN, String width) {
		super();
		this.name = name;
		this.nameCN = nameCN;
		this.width = width;
	}

	
	public Attribute(String name, String nameCN, String width,
			String placeholder) {
		super();
		this.name = name;
		this.nameCN = nameCN;
		this.width = width;
		this.placeholder = placeholder;
	}
	

	public Attribute(String name, String nameCN, String width,
			String placeholder, String inputType) {
		super();
		this.name = name;
		this.nameCN = nameCN;
		this.width = width;
		this.placeholder = placeholder;
		this.inputType = inputType;
	}

	
	public Attribute(String name, String nameCN, String placeholder,
			String inputType, List<Attribute_Radio> ars) {
		super();
		this.name = name;
		this.nameCN = nameCN;
		this.placeholder = placeholder;
		this.inputType = inputType;
		this.ars = ars;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}


	public String getPlaceholder() {
		return placeholder;
	}


	public void setPlaceholder(String placeHolder) {
		this.placeholder = placeHolder;
	}


	public String getInputType() {
		return inputType;
	}


	public void setInputType(String inputType) {
		this.inputType = inputType;
	}


	public List<Attribute_Radio> getArs() {
		return ars;
	}


	public void setArs(List<Attribute_Radio> ars) {
		this.ars = ars;
	}
	
	
	
}
