package com.lazite.assist.produce.jpa.pi.listc;

public class ListMethod {	
	private String entity;//返回实体类
	
	private String path;//返回路径
	
	private String remark;//备注
	
	public ListMethod() {
		super();
	}

	public ListMethod(String entity, String path) {
		super();
		this.entity = entity;
		this.path = path;
	}
	
	public ListMethod(String entity, String path, String remark) {
		super();
		this.entity = entity;
		this.path = path;
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
