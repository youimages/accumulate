package com.lazite.assist.produce.jpa.pojo.ftl;

public class Btn {
	
	private String id; //id
	
	private String btnClass;//按钮的class 

	private String value;//按钮的value

	private String icon; //按钮的icon
	
	private String type; //选项为click、model 调用
	
	private String model_id;//如果为model,则存在model_id
	
	

	public Btn(String id, String btnClass, String value, String icon,
			String type, String model_id) {
		super();
		this.id = id;
		this.btnClass = btnClass;
		this.value = value;
		this.icon = icon;
		this.type = type;
		this.model_id = model_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBtnClass() {
		return btnClass;
	}

	public void setBtnClass(String btnClass) {
		this.btnClass = btnClass;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}
	
	
}
