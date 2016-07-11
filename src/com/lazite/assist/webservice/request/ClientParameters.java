package com.lazite.assist.webservice.request;

import java.util.Arrays;


public class ClientParameters {
	/**
	 * example:http://223.68.197.250:82/admin/services/ThirdPartyService?wsdl
	 */
	private String urlname;
	
	/**
	 * example:http://webservice.dhsoft.com
	 */
	private String urlspace;
	
	/**
	 * 方法名称
	 */
	private String methodname;
	
	/**
	 * 请求参数数组封装,需保证封装顺序与方法method方法的形参类型一致
	 */
	private Object[] objs;
	
	
	public ClientParameters() {
		super();
	}
	public ClientParameters(String urlname, String urlspace,String methodname, Object[] objs) {
		super();
		this.urlname = urlname;
		this.urlspace = urlspace;
		this.methodname = methodname;
		this.objs = objs;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getUrlspace() {
		return urlspace;
	}
	public void setUrlspace(String urlspace) {
		this.urlspace = urlspace;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public Object[] getObjs() {
		return objs;
	}
	public void setObjs(Object[] objs) {
		this.objs = objs;
	}
	@Override
	public String toString() {
		return "ClientParameters [urlname=" + urlname + ", urlspace="
				+ urlspace + ", objs=" + Arrays.toString(objs) + "]";
	}
	
}
