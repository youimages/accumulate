package com.lazite.assist.produce.jpa.pojo.ftl.table;

import java.util.List;

import com.lazite.assist.produce.jpa.pojo.ftl.Attribute;
import com.lazite.assist.produce.jpa.pojo.ftl.i_tag;

public class Table {
	private String id;
	
	private boolean hasChecked;
	
	private List<Attribute> attributes;
	
	private List<i_tag> itags;

	
	
	public Table() {
		super();
	}
	public Table(String id, boolean hasChecked, List<Attribute> attributes,
			List<i_tag> itags) {
		super();
		this.id = id;
		this.hasChecked = hasChecked;
		this.attributes = attributes;
		this.itags = itags;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isHasChecked() {
		return hasChecked;
	}
	public void setHasChecked(boolean hasChecked) {
		this.hasChecked = hasChecked;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<i_tag> getItags() {
		return itags;
	}

	public void setItags(List<i_tag> itags) {
		this.itags = itags;
	}
	
	
}
