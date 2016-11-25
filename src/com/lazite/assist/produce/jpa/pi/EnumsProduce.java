package com.lazite.assist.produce.jpa.pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.lazite.assist.excel.ExcelUtils;
import com.lazite.assist.file.FileUtils;
import com.lazite.assist.freemarker.FreeMarkers;
import com.lazite.assist.produce.Pi;
import com.lazite.assist.produce.jpa.pojo.FilePo;
import com.lazite.assist.produce.util.EntityEnums;
import com.lazite.test.ExcelUtil;

public class EnumsProduce implements Pi{
	private FilePo filePo;
	
	@Test
	@Override
	public void produce() throws Exception {
//		ExcelUtils eu=new ExcelUtils();
//		eu.setSelectedSheetIdx(0);
//		eu.setOnlyReadOneSheet(true);
//		Workbook wb=eu.loadTemplate(this.getClass().getResourceAsStream("/com/lazite/assist/produce/jpa/ftl/enums/all.xls"));
//				
//		System.out.println(wb);
//		
//		List<String> names=new ExcelUtils().getColumnData(wb, 0);
//		List<String> nameCNs=new ExcelUtils().getColumnData(wb, 1);
		List<String> names=new ArrayList<String>(){{
			add("STAFF_SEX");
			add("STAFF_EDUCATION");
			add("STAFF_MARITAL_STATUS");
			add("STAFF_HOUSEHOLD");
			add("STAFF_PROFESSION");
			add("STAFF_POST");
			add("PROJECT_TYPE");
			add("PROJECT_TYPE_STATUS");
			add("COMPANY_TYPE");
			add("COMTRACT_TYPE");
			add("COMTRACT_KIND");
			add("COMTRACT_PAYMENT_PLAN");
			add("CUSTOMER_IMPORTANCE");
			add("PURCHASE_RECORDS_TYPE");
		}};
		List<String> nameCNs=new ArrayList<String>(){{
			add("性别");
			add("学历");
			add("婚姻");
			add("户口性质");
			add("专业");
			add("岗位");
			add("项目类型");
			add("项目类型状态");
			add("公司类型");
			add("合同种类");
			add("销售合同类型");
			add("销售合同收款计划");
			add("销售客户重要度");
			add("采购类型");
		}};
		
		
		String s="";
		for (int i = 0; i < names.size(); i++) {
			s+=FreeMarkers.getFtlString(this.getResourceBufferedReader("/com/lazite/assist/produce/jpa/ftl/enums/fns.ftl"),
					new String[]{"name","nameCN",},
					new Object[]{names.get(i).toUpperCase().trim(),nameCNs.get(i).trim()});
		}
		
		System.out.println(s);
		
	}

	//"/resource/res.txt"===url 例
	public BufferedReader getResourceBufferedReader(String url) throws IOException{    
        //返回读取指定资源的输入流    
        InputStream is=this.getClass().getResourceAsStream(url);      
        BufferedReader br=new BufferedReader(new InputStreamReader(is));    
        return br;
    } 

	public FilePo getFilePo() {
		return filePo;
	}
	public void setFilePo(FilePo filePo) {
		this.filePo = filePo;
	}
	
}
