package com.lazite.assist.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description  读取修改配置文件   
 * @Author lazite 
 * @CreateTime 2016年7月8日 下午6:10:42   
 * @ModifyBy lazite 
 * @ModeifyTime 2016年7月8日 下午6:10:42   
 * @ModifyDescription
 * @Version   V1.0
 */
public class PropertiesOperate {	
	//测试路径
	//private static final String PROPERTY_FILE = "src/config/extract.properties";
	//服务器启动路径
	//private static final String PROPERTY_FILE = PropertiesOperate.class.getClassLoader().getResource("config/extract.properties").getPath();
	
	public static String read(String PROPERTY_FILE,String key){
		String value = null;
		try {
		  Properties props = new PropertiesSort();
		  InputStream in= new FileInputStream(PROPERTY_FILE);
		  props.load(in);
		  in.close();
		  value = props.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	 }
	
	public static Map<String,String> read(String PROPERTY_FILE) {
		Map<String,String> map=null;
		try {
			Properties props = new PropertiesSort();
			InputStream in = new FileInputStream(PROPERTY_FILE);
			props.load(in);
			map=new LinkedHashMap<String, String>();
			Iterator<String> it=props.stringPropertyNames().iterator();
			while(it.hasNext()){
				String keys=it.next();
				String value = props.getProperty(keys);
				map.put(keys, value);
			}	
			in.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void write(String PROPERTY_FILE,String key,String value) {
		  Properties prop = new PropertiesSort();
		  try {  
			  InputStream fis = new FileInputStream(PROPERTY_FILE);
			  prop.load(fis);
			  fis.close();

			  prop.setProperty(key, value);

			  OutputStream fos = new FileOutputStream(PROPERTY_FILE);
			  prop.store(fos,"Update '" + key + "' value");
			  
			  fos.flush();
			  fos.close();  
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	  }
	 
	public static void write(String PROPERTY_FILE,Map<String,String> map){
		  Properties prop = new PropertiesSort();
		  try {  
			  InputStream fis = new FileInputStream(PROPERTY_FILE);
			  //InputStream fis = loadProp.getClass().getResourceAsStream(PROPERTY_FILE);
			  prop.load(fis);
			  fis.close();
		
			  for (Map.Entry<String, String> entry : map.entrySet()) {
				  prop.setProperty(entry.getKey(), entry.getValue());
			  }
		
			  OutputStream fos = new FileOutputStream(PROPERTY_FILE);
			  prop.store(fos,"Update value");  
		
			  fos.flush();
			  fos.close();  
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	 }
	
}
