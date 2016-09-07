package com.lazite.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.lazite.assist.enums.DynamicEnum;


public class TestEnums {
	  private static enum TestEnum {
	       a,
	       b,
	       c;
	   };
	   
	   private static enum InfoPairEnum {
		   
		    TEST1("A001", "测试1"), TEST2("A002", "测试2");
		    private String code;
		    private String name;
		 
		    private InfoPairEnum(String code, String name) {
		        this.code = code;
		        this.name = name;
		    }
		     
		    @Override
		    public String toString(){
		        return "[" + code + " : " + name + "]"; 
		    }
		};
		
		public enum Hjqk {
			baro("大气压"),pm("PM2.5"),coo("二氧化碳含量"),humidity("景区湿度"),temp("温度");

			private String nCode;

			private Hjqk(String _nCode) {
				this.nCode = _nCode;
			}
			
			public static String[] getEnumsValues() {
				return new String[]{baro.value(),pm.value(),coo.value(),humidity.value(),temp.value()};
			}

			public static String[] getEnumsKeys() {
				return new String[]{"baro","pm","coo","humidity","temp"};
			}
			
			 //手写的从String到到单位的转换函数
			public static String[] getEnumsUnitValue(String nCode) {   
		        if("baro".equalsIgnoreCase(nCode))
		        	return new String[]{"pa","大气压"};
		        else if("pm".equalsIgnoreCase(nCode))
		        	return new String[]{"mg","PM2.5"};
		        else if("coo".equalsIgnoreCase(nCode))
		        	return new String[]{"ppm","二氧化碳含量"};
		        else if("humidity".equalsIgnoreCase(nCode))
		        	return new String[]{"%RH","景区湿度"};
		        else if("temp".equalsIgnoreCase(nCode))
		        	return new String[]{"℃","温度"};
		        return null;
		    }
			
			public String value() {
				return this.nCode;
			}
			
			@Override
			public String toString() {
				return String.valueOf(this.nCode);
			}

			public static char[] getwhole() {
				// TODO Auto-generated method stub
				return null;
			}
		}	
	   
	   public static void main(String[] args) {
	 
	       // Dynamically add 3 new enum instances d, e, f to TestEnum
		   DynamicEnum.add(TestEnum.class, "d");
		   DynamicEnum.add(TestEnum.class, "e");
		   
		   System.out.println(Arrays.deepToString(TestEnum.values()));
		   DynamicEnum.remove(TestEnum.class, "e");
		   System.out.println(Arrays.deepToString(TestEnum.values()));
		   
		   
		   System.out.println(Arrays.deepToString(Hjqk.values()));
		   DynamicEnum.remove(Hjqk.class, "coo");
		   System.out.println(Arrays.deepToString(Hjqk.values()));

		   
//	       // Run a few tests just to show it works OK.
//	       System.out.println(Arrays.deepToString(TestEnum.values()));
//	       // Shows : [a, b, c, d, e, f]
//	       
//	       System.out.println(Hjqk.getwhole());
//	       
//	       DynamicEnum.add(Hjqk.class, "TEST3", new Class[]{String.class}, new Object[]{"A003"});
//	       //InfoPairEnum e3 = InfoPairEnum.valueOf("TEST3");
//	       
//	       System.out.println(IEnums.Hjqk.getwhole());
//	       
//	       //System.out.println(Arrays.deepToString(InfoPairEnum.values()));
//	       
//	       // EnumMap的使用
//	       EnumMap<IEnums.Hjqk, String> weekMap =  new EnumMap(IEnums.Hjqk.class);
//	       List<IEnums.Hjqk> weekList=new ArrayList<>();
//	       
//	       weekMap.put(IEnums.Hjqk.baro, "星期一");
//	       weekMap.put(IEnums.Hjqk.coo, "星期二");
//	       // ... ...
//	       for (Iterator<Entry<IEnums.Hjqk, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
//	    	   Entry<IEnums.Hjqk, String> entry = iter.next();
//	    	   weekList.add(entry.getKey());
//	    	   System.out.println(entry.getKey().name() + ":" + entry.getValue());
//	       }
//	       
//	       
//		    // EnumSet的使用
//	        EnumSet<IEnums.Hjqk> weekSet = EnumSet.allOf(IEnums.Hjqk.class);
//	        weekSet.add(weekList.get(0));
//	        for (IEnums.Hjqk day : weekSet) {
//	            System.out.println(day);
//	        }
	   }
	   
	  
}
