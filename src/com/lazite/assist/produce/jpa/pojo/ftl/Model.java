package com.lazite.assist.produce.jpa.pojo.ftl;

import com.lazite.assist.produce.jpa.pojo.Module;

public class Model {
	
	private String id; //model的id
	
	private String type; //model类型,添加add修改update
	
	private String formUrl; //model的form的url
	
	public Model(String id, String type, String formUrl) {
		super();
		this.id = id;
		this.type = type;
		this.formUrl = formUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormUrl() {
		return formUrl;
	}

	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}

	
}
