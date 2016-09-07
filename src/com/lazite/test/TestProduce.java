package com.lazite.test;

import java.util.ArrayList;
import java.util.List;

import com.lazite.assist.produce.jpa.pi.ControllerProduce;
import com.lazite.assist.produce.jpa.pi.DaoProduce;
import com.lazite.assist.produce.jpa.pi.ServiceProduce;
import com.lazite.assist.produce.jpa.pojo.FilePo;

public class TestProduce {
	
	
	public static void main(String[] args) throws Exception {
		List<String> list=new ArrayList<String>(){{
			add("customer");
//			add("customerCashPool");
//			add("customerCashPoolDynamic");
//			add("customerMidTrayLessor");
//			add("customerReceiverAddress");
//			add("depositIndent");
//			add("depositOnce");
//			add("invoiceApplyDetail");
//			add("invoiceMessage");
//			add("invoicePostDetail");
//			add("payDepositDetail");
//			add("platformCashPool");
//			add("platformCashPoolDynamic");
//			add("rechargeRecord");
//			add("siteArticle");
//			add("siteCategories");
//			add("transferRecord");
//			add("trayClassification");
//			add("trayIndentCashPool");
//			add("trayIndentCashPoolDynamic");
//			add("trayIndent");
//			add("tray");
//			add("trayIndentDetail");
//			add("trayLessor");
//			add("trayMidTrayClassification");
//			add("traySpread");
//			add("trayTrolley");
		}};
		
		
//		for (String s : list) {
//			new DaoProduce().produceDao(s);
//		}
		
		
//		ServiceProduce sp=new ServiceProduce();
//		for (String s : list) {
//			FilePo fp=new FilePo("tray", s, "E:\\misWorkspace\\tray\\src\\com\\tray\\service\\site\\"+s+"\\");
//			fp.setSperate("site");
//			sp.setFilePo(fp);
//			
//			sp.produce();
//		}
		System.out.println(2);
		
		ControllerProduce cp=new ControllerProduce();
		for (String s : list) {
			FilePo fp=new FilePo("tray", s, "E:\\DirsirWorkspace\\accumulate\\src\\com\\lazite\\assist\\produce\\jpa\\ftl\\single\\");
			fp.setSperate("site");
			cp.setFilePo(fp);
			
			cp.produce();
		}
		
	}
	
	
	 
	 
}
