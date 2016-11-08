package com.lazite.assist.produce.jpa.pojo.ftl;

public class Caption {
	
	private String caption_name; 
	
	private String script_url; 
	
	private String icon;

	public Caption(String caption_name, String script_url, String icon) {
		super();
		this.caption_name = caption_name;
		this.script_url = script_url;
		this.icon = icon;
	}

	public String getCaption_name() {
		return caption_name;
	}

	public void setCaption_name(String caption_name) {
		this.caption_name = caption_name;
	}

	public String getScript_url() {
		return script_url;
	}

	public void setScript_url(String script_url) {
		this.script_url = script_url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	} 

		
}
