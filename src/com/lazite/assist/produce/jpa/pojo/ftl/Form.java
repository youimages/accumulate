package com.lazite.assist.produce.jpa.pojo.ftl;

import java.util.List;

public class Form {
	
	private String id; //id
	
	private String url; //地址

	private String method;//按钮的class 

	private List<Attribute> attributes;//按钮的value

	public Form(String id, String url, String method, List<Attribute> attributes) {
		super();
		this.id = id;
		this.url = url;
		this.method = method;
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	
	
	
	
}
