package com.lazite.assist.produce.jpa.pojo.ftl.table;

import java.util.List;

import com.lazite.assist.produce.jpa.pojo.ftl.Attribute;
import com.lazite.assist.produce.jpa.pojo.ftl.i_tag;

//条状表
public class Table_striped extends Table{

	public Table_striped(String id, boolean hasChecked,
			List<Attribute> attributes, List<i_tag> itags) {
		super(id, hasChecked, attributes, itags);
	}
	
	
	
}
