package com.${project}.service.<#if sperate !="" >${sperate}.</#if>${name};

import java.util.List;

import com.${project}.entity.${name?cap_first};
import com.${project}.common.exception.ProviderException;


public interface ${name?cap_first}Service {
	/**
	 * @Title add${name?cap_first}
	 * @Description 添加(纯参数),需要先load出来
	 * @param ${name?cap_first}
	 * @return TODO
	 * @throws ProviderException
	 */
	public void add${name?cap_first}(${name?cap_first} ${name}) throws ProviderException;
		
	/**
	 * @Title del${name?cap_first}
	 * @Description 删除对象(该对象为游离态)
	 * @param ${name?cap_first}
	 * @return TODO
	 * @throws ProviderException
	 */	
	public void del${name?cap_first}(${name?cap_first} ${name}) throws ProviderException;
	
	/**
	 * @Title del${name?cap_first}
	 * @Description 删除对象
	 * @param Integer id 对象的主键id
	 * @return TODO
	 * @throws ProviderException
	 */	
	public void del${name?cap_first}(Integer id) throws ProviderException;
	
	/**
	 * @Title update${name?cap_first}
	 * @Description 更新对象(临时态对象)
	 * @param ${name?cap_first} ${name}
	 * @return TODO
	 * @throws ProviderException
	 */
	public void update${name?cap_first}(${name?cap_first} ${name}) throws ProviderException;
		
	/**
	 * @Title find${name?cap_first}Whole
	 * @Description 查询所有对象
	 * @return List<${name?cap_first}> 对象集合
	 * @throws ProviderException
	 */
	public List<${name?cap_first}> find${name?cap_first}Whole() throws ProviderException;
	
	/**
	 * @Title find${name?cap_first}
	 * @Description 查询所有对象
	 * @param ${name?cap_first} ${name}
	 * @return Integer id 对象的主键id
	 * @throws ProviderException
	 */
	public ${name?cap_first} find${name?cap_first}(Integer id) throws ProviderException;
	
	/**
	 * @Title  find${name?cap_first}4Condition
	 * @Description 条件查询所有对象
	 * @param ${name?cap_first} ${name} 对象条件
	 * @return List<${name?cap_first}> 对象集合
	 * @throws ProviderException
	 */
	public List<${name?cap_first}> find${name?cap_first}4Condition(${name?cap_first} ${name}) throws ProviderException;

}