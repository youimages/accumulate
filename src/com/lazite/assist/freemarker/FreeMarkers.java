package com.lazite.assist.freemarker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description: FreeMarkers工具类  
 * @Author: lazite 
 * @CreateTime: 2015年12月15日 下午9:29:19   
 * @ModifyBy: lazite 
 * @ModeifyTime: 2015年12月15日 下午9:29:19   
 * @ModifyDescription:
 * @Version:   V1.0
 */
public class FreeMarkers {

	public static String renderString(String templateString, Map<String, ?> model) throws IOException, TemplateException {
		StringWriter result = new StringWriter();
		Template t = new Template("name", new StringReader(templateString), new Configuration());
		t.process(model, result);
		return result.toString();
		
	}

	public static String renderTemplate(Template template, Object model) throws TemplateException, IOException {
		StringWriter result = new StringWriter();
		template.process(model, result);
		return result.toString();
	}

	public static Configuration buildConfiguration(String directory) throws IOException {
		Configuration cfg = new Configuration();
		//Resource path = new DefaultResourceLoader()
		cfg.setDirectoryForTemplateLoading(new File(directory));
		
		cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);//遍历obj的类型key的Map
		
		return cfg;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map putMapRoot(String[] ss,Object[] objs){
		Map root = new HashMap();  //存储数据
		for (int i = 0; i < ss.length; i++) {
			root.put(ss[i], objs[i]);
		}
		return root;
	}
	
	@SuppressWarnings("rawtypes")
	public static String processFtl(Template t,Map root) throws Exception{
		Writer out = new StringWriter();
        t.process(root, out); 
        out.close();
        return out.toString();
	}
	
	public static String getFtlString(String url,String name,String[] ss,Object[] objs) throws Exception{
		Configuration cfg = FreeMarkers.buildConfiguration(url);
		cfg.clearTemplateCache();//项目部署时去除
		Template template = cfg.getTemplate(name,"utf-8");
		new Template("", new BufferedReader(null));
		return processFtl(template, putMapRoot(ss, objs));
	}
	
	public static String getFtlString(BufferedReader br,String[] ss,Object[] objs) throws Exception{
		Template template =new Template("", br);
		return processFtl(template, putMapRoot(ss, objs));
	}
	
	
//	public static void main(String[] args) throws IOException {
//		// renderString
//		Map<String, String> model = com.google.common.collect.Maps.newHashMap();
//		model.put("userName", "calvin");
//		String result = FreeMarkers.renderString("hello ${userName}", model);
//		System.out.println(result);
//		// renderTemplate
//		Configuration cfg = FreeMarkers.buildConfiguration("classpath:/");
//		Template template = cfg.getTemplate("testTemplate.ftl");
//		String result2 = FreeMarkers.renderTemplate(template, model);
//		System.out.println(result2);
		
//		Map<String, String> model = com.google.common.collect.Maps.newHashMap();
//		model.put("userName", "calvin");
//		String result = FreeMarkers.renderString("hello ${userName} ${r'${userName}'}", model);
//		System.out.println(result);
//	}
	
}
