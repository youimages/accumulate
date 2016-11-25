package com.lazite.assist.produce.jpa.pojo.ftl;

public class Model {
	
	private String id; //model的id
	
	private String type; //model类型,添加add修改update
	
	private String formUrl; //model的form的url
	
	private Form form; //model的form相关属性参数
	
	public Model(String id, String type, String formUrl) {
		super();
		this.id = id;
		this.type = type;
		this.formUrl = formUrl;
	}
	
	public Model(String id, String type, String formUrl, Form form) {
		super();
		this.id = id;
		this.type = type;
		this.formUrl = formUrl;
		this.form = form;
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
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	
	
}
