package com.lazite.assist.produce.jpa.pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.lazite.assist.freemarker.FreeMarkers;
import com.lazite.assist.produce.Pi;
import com.lazite.assist.produce.jpa.pojo.FilePo;

public class AttachProduce implements Pi{
	private FilePo filePo;
	
	@Test
	@Override
	public void produce() throws Exception {	
		String s=FreeMarkers.getFtlString(this.getResourceBufferedReader("/com/lazite/assist/produce/jpa/ftl/attach/all.ftl"),
				new String[]{"name","nameCN","midName","tableName","tableId"},
				new Object[]{"purchaseRecords","合同","attachMidPurchaseRecords","t_attach_purchase_records","pr_id"});
		
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
