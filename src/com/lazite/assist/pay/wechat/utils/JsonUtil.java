package com.dirsir.common.pay.wechat.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonUtil {
	/**
	 * 将对象转化为JSON
	 * @param ob
	 * @return
	 */
	public static String objectToJson(Object ob){
		Gson gson=new Gson();		
		return gson.toJson(ob);
	}
	/**
	 * 输出json
	 * @param response
	 */
	public static void writeJson(HttpServletResponse  response,String  json){
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(json);
			System.out.println(json);
			pw.close();
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
