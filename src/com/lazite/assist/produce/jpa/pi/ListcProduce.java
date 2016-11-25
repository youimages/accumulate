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
import com.lazite.assist.produce.jpa.pi.listc.ListMethod;
import com.lazite.assist.produce.jpa.pojo.FilePo;
import com.lazite.assist.produce.util.EntityEnums;
import com.lazite.test.ExcelUtil;

public class ListcProduce implements Pi{
	private FilePo filePo;
	
	@Test
	@Override
	public void produce() throws Exception {
		List<ListMethod> methods=new ArrayList<ListMethod>(){{
			//人事行政
			add(new ListMethod("staff", "rsxz/ygda/","员工档案"));
			add(new ListMethod("position", "rsxz/gwgl/","岗位"));
			add(new ListMethod("position", "rsxz/gwgl/staff_","岗位员工"));
			add(new ListMethod("department", "rsxz/zzjg/","组织结构"));
			add(new ListMethod("staff", "rsxz/zzjg/staff_","组织结构员工"));
			
			//项目管理
			add(new ListMethod("project", "xmgl/xmxx/","项目"));
			add(new ListMethod("contract", "xmgl/xmxx/ht_","项目合同"));
			
			//销售管理
			add(new ListMethod("company", "xsgl/kh/","销售客户"));
			add(new ListMethod("customer", "xsgl/lxr/","联系人"));
			add(new ListMethod("contract", "xsgl/xsht/","销售合同"));
			
			//采购管理
			add(new ListMethod("company", "cggl/kh/","供应商"));
			add(new ListMethod("supplier", "cggl/lxr/","联系人"));
			add(new ListMethod("contract", "cggl/cght/","采购合同"));
			add(new ListMethod("purchaseRecords", "cggl/cgjl/","采购记录"));
			add(new ListMethod("invoicePost", "cggl/kpjl/","开票记录"));
			
			//报销管理
			add(new ListMethod("reimburseRecords", "bxgl/","报销"));
			
			//费用管理
			add(new ListMethod("fee", "fygl/","报销"));
			
		}};
		
		String s=FreeMarkers.getFtlString(this.getResourceBufferedReader("/com/lazite/assist/produce/jpa/ftl/listc/all.ftl"),
					new String[]{"methods"},
					new Object[]{methods});
		
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
