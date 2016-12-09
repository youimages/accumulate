package com.lazite.assist.produce.jpa.pojo.ftl.pages.jsp.v1;

import com.lazite.assist.produce.jpa.pojo.ftl.pages.jsp.v1.jsp.Jsp_body;
import com.lazite.assist.produce.jpa.pojo.ftl.pages.jsp.v1.jsp.Jsp_header;
import com.lazite.assist.produce.jpa.pojo.ftl.pages.jsp.v1.jsp.Jsp_tags;

public class Main {
	
	private Jsp_tags jsp_tags;
	
	private Jsp_header jsp_header;
	
	private Jsp_body jsp_body;

	public Jsp_tags getJsp_tags() {
		return jsp_tags;
	}
	public void setJsp_tags(Jsp_tags jsp_tags) {
		this.jsp_tags = jsp_tags;
	}
	public Jsp_header getJsp_header() {
		return jsp_header;
	}
	public void setJsp_header(Jsp_header jsp_header) {
		this.jsp_header = jsp_header;
	}
	public Jsp_body getJsp_body() {
		return jsp_body;
	}
	public void setJsp_body(Jsp_body jsp_body) {
		this.jsp_body = jsp_body;
	}
	
}
