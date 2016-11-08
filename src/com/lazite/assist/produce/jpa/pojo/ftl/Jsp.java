package com.lazite.assist.produce.jpa.pojo.ftl;

public class Jsp {
	private String tag; //引入
	
	private String header; //header
	
	private String body; //body

	public Jsp(String tag, String header, String body) {
		super();
		this.tag = tag;
		this.header = header;
		this.body = body;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
