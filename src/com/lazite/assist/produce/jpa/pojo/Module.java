package com.lazite.assist.produce.jpa.pojo;

public class Module {
	
	private String projectNameCN;//项目名
		
	private String name;//模块名
	
	private String nameCN;//中文模块名称
	
	private String extend;//对name的扩展

	
	
	public Module(String projectNameCN, String name, String nameCN,
			String extend) {
		super();
		this.projectNameCN = projectNameCN;
		this.name = name;
		this.nameCN = nameCN;
		this.extend = extend;
	}
	
	public String getProjectNameCN() {
		return projectNameCN;
	}

	public void setProjectNameCN(String projectNameCN) {
		this.projectNameCN = projectNameCN;
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

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}
	
	
	
}
