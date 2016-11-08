package com.lazite.assist.produce.jpa.pojo.ftl;

public class i_tag {
	
	private String id; //id
	
	private String iclass;//按钮的class 

	private String value;//按钮的value

	private String prompt; //提示
	
	private String url; //地址
	
	private String type; //选项为click、model 调用
	
	private String model_id;//如果为model,则存在model_id

	public i_tag(String id, String iclass, String value, String prompt,
			String url, String type, String model_id) {
		super();
		this.id = id;
		this.iclass = iclass;
		this.value = value;
		this.prompt = prompt;
		this.url = url;
		this.type = type;
		this.model_id = model_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIclass() {
		return iclass;
	}

	public void setIclass(String iclass) {
		this.iclass = iclass;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
