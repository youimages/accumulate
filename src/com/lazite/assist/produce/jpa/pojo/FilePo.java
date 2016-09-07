package com.lazite.assist.produce.jpa.pojo;

import com.lazite.assist.produce.util.EntityEnums;

public class FilePo extends InitPo{
	
	private String path;
	
	private String filename;
	
	/**
	 * 
	* <p>Title: </p>
	* <p>Description: </p>
	* @param projectName 项目名称
	* @param className 类名称
	* @param path 保存生成文件的路径
	 */
	public FilePo(String projectName, String className, String path) {
		super();
		this.projectName = projectName;
		this.className = className;
		this.path = path;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename(EntityEnums ee) {
		switch (ee.getCode()) {
			case 1:
				return className.substring(0,1).toUpperCase()+className.substring(1)+"Dao.java";
			case 2:
				return className.substring(0,1).toUpperCase()+className.substring(1)+"Service.java";
			case 3:
				return className.substring(0,1).toUpperCase()+className.substring(1)+"Controller.java";
			case 4:
				return className.substring(0,1).toUpperCase()+className.substring(1)+"DaoImp.java";
			case 5:
				return className.substring(0,1).toUpperCase()+className.substring(1)+"ServiceImpl.java";
		}
		
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
}
