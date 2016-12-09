package com.lazite.assist.sys;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.lazite.assist.excel.ExcelUtils;

public class Initialization {
	ExcelUtils eu=new ExcelUtils("E:/DirsirWorkspace/accumulate/src/com/lazite/assist/sys/sk.xlsx");
	
	
	@Test
	public void initSecrity() throws Exception{
		Workbook wb=eu.getWorkBook("E:/DirsirWorkspace/accumulate/src/com/lazite/assist/sys/sk.xlsx");
		Sheet  sheet=wb.getSheetAt(0);
				
		//获取一级栏目
		List<Integer[]> menu_1=eu.getMergeRowsNum(0, sheet);
				
		for (int i = 0; i < menu_1.size(); i++) {
			Row row_1=eu.getRow(wb, menu_1.get(i)[0]);
			String menu_1_name=row_1.getCell(0).getStringCellValue();
			System.out.println("  "+menu_1_name);
			
			List<Integer[]> menu_2=eu.getMergeRowsNum(4,menu_1.get(i)[0],menu_1.get(i)[1],sheet);//获取二级栏目
						
			for (int j = 0; j < menu_2.size(); j++) {
				Row row_2=eu.getRow(wb, menu_2.get(j)[0]);
								
				String menu_2_name=row_2.getCell(4).getStringCellValue();
				System.out.println("  |----------"+menu_2_name);
								
				for(int k = menu_2.get(j)[0]; k < menu_2.get(j)[1]+1; k++){
					Row row_3=eu.getRow(wb,k);
					String resorce_name=row_3.getCell(8).getStringCellValue();
										
					System.out.println("             |---------"+resorce_name);
				}				
			}
		}
	}
	
	

}
