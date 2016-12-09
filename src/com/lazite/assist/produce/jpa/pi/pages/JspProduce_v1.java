package com.lazite.assist.produce.jpa.pi.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.lazite.assist.freemarker.FreeMarkerUtil;
import com.lazite.assist.produce.Pi;
import com.lazite.assist.produce.jpa.pojo.FilePo;
import com.lazite.assist.produce.jpa.pojo.Module;
import com.lazite.assist.produce.jpa.pojo.ftl.Attribute;
import com.lazite.assist.produce.jpa.pojo.ftl.Attribute_Radio;
import com.lazite.assist.produce.jpa.pojo.ftl.Body;
import com.lazite.assist.produce.jpa.pojo.ftl.Btn;
import com.lazite.assist.produce.jpa.pojo.ftl.Caption;
import com.lazite.assist.produce.jpa.pojo.ftl.Form;
import com.lazite.assist.produce.jpa.pojo.ftl.Jsp;
import com.lazite.assist.produce.jpa.pojo.ftl.Model;
import com.lazite.assist.produce.jpa.pojo.ftl.i_tag;
import com.lazite.assist.produce.jpa.pojo.ftl.table.Table;

public class JspProduce_v1 implements Pi{	
	@Test
	@Override
	public void produce() throws Exception {
		Map<String,Object> rootMap = new HashMap<String,Object>();
		
		rootMap.put("module",new Module("网信管理信息系统","menu","栏目", null));

		rootMap.put("jsp",new Jsp("/page/common/tag.ftl", "/page/common/header.ftl", "/page/common/body.ftl"));
		
		//包含的子模块
		@SuppressWarnings("serial")
		List<String> models=new ArrayList<String>(){{
			add("/page/model_add.ftl");
			add("/page/model_update.ftl");
		}};
		
		
		List<Attribute_Radio> ars=new ArrayList<Attribute_Radio>(){{
			add(new Attribute_Radio("显示", "1"));
			add(new Attribute_Radio("不显示",  "0"));
			
		}};
		
		final  List<Attribute_Radio> fars=ars;
		rootMap.put("model_add", new Model("",
										"add", 
										null, 
										new Form("addTrayModel", "添加确认地址", "post", 
												new ArrayList<Attribute>(){{
													add(new Attribute("title", "名称", "15%","名称","text"));
													add(new Attribute("rent", "租金", "15%","名称","textarea"));
													add(new Attribute("rent", "租xx金", "租xx金","radio",fars));
												}})
											)
		);
		
		
		rootMap.put("body",new Body("/page/container.ftl", "/page/script_lable.ftl", "/page/script_defined.ftl",models));
		
		//导航
		@SuppressWarnings("serial")
		List<Caption> captions=new ArrayList<Caption>(){{
			add(new Caption("首页", "url地址", "fa-home"));
			add(new Caption("列表", "url地址", "fa-home"));
		}};
		rootMap.put("captions",captions);
		
		//按钮
		@SuppressWarnings("serial")
		List<Btn> btns=new ArrayList<Btn>(){{
			add(new Btn("openAddTrayModel", "btn green", "添加", "fa fa-plus", "model", "addTrayModel"));
			add(new Btn("delTrayd", "btn red", "删除", "fa fa-minus", "click", "addTrayModel"));
		}};
		rootMap.put("btns",btns);
		
		//列
		@SuppressWarnings("serial")
		List<Attribute> attributes=new ArrayList<Attribute>(){{
			add(new Attribute("title", "名称", "15%"));
			add(new Attribute("rent", "租金", "15%"));
		}};
		
		//选项操作
		@SuppressWarnings("serial")
		List<i_tag> itags=new ArrayList<i_tag>(){{
			add(new i_tag("openUpdateTrayModel", "fa fa-pencil", "", "编辑", "url地址", "model", "updateTrayModel"));
			add(new i_tag("delTray", "fa fa-trash-o", "", "编辑", "url地址", "click", "delTray"));
		}};
		
		Table table=new Table("tableid", true, attributes, itags);
		
		rootMap.put("table",table);
		
		
		
		//new FreeMarkerUtil().print("jsp.ftl", "/com/lazite/assist/produce/jpa/ftl/single", rootMap);
		new FreeMarkerUtil().printFile("jsp.ftl",
									"/com/lazite/assist/produce/jpa/ftl/single",
									rootMap, 
									new File("D:\\ftl\\my.jsp"));
		
		
//		String s=FreeMarkers.getFtlString(this.getResourceBufferedReader("/com/lazite/assist/produce/jpa/ftl/single/page/common/jsp.ftl"),
//				new String[]{"jsp"},
//				new Object[]{new Jsp("E:/DirsirWorkspace/accumulate/src/com/lazite/assist/produce/jpa/ftl/single/page/common/tag.ftl",
//						"/header.ftl", 
//						"/body.ftl")});
		
		//System.out.println(s);
		
		//FileUtils.createFile(this.filePo.getPath(),this.filePo.getFilename(EntityEnums.Controller));
		//FileUtils.writeFileContent(this.filePo.getPath()+this.filePo.getFilename(EntityEnums.Controller), s);
	}

}
