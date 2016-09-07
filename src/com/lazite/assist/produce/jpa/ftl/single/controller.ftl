package com.${project}.controller.<#if sperate !="" >${sperate}</#if>;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.tray.common.exception.ProviderException;
import com.tray.common.web.BaseController;
import com.tray.entity.${name?cap_first};
import com.tray.service.<#if sperate !="" >${sperate}.</#if>${name}.${name?cap_first}Service;

@Controller
@RequestMapping("<#if sperate !="" >${sperate}</#if>/${name}?/")//"${name}?"此处映射地址根据前台调用修改，要求不重复，易书写易记忆有特征意义
public class ${name?cap_first}<#if sperate !="" >${sperate?cap_first}</#if>Controller extends BaseController {
	@Autowired
	${name?cap_first}Service ${name}<#if sperate !="" >${sperate?cap_first}</#if>Service;
	
	/**
	 * @Description 全查列表页面
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list${name?cap_first}(){
		try {
			List<${name?cap_first}> ${name}s=${name}<#if sperate !="" >${sperate?cap_first}</#if>Service.find${name?cap_first}Whole();
		
			request.setAttribute("values",${name}s);
			
			return "${name}/XXXXX";//XXXXX此处映射地址填写列表地址
		}catch (ProviderException e) {
			ProviderException ek=(ProviderException) e;
			switch (ek.getExceptionEnum().getValue()) {
				case 1:
					return "根据错误条件返回的提示页面";	
				//....	
			}
		}catch (RuntimeException e) {
			e.printStackTrace();			
		}
		
		return "运行时异常";
	}
	
	/**
	 * @Description 添加对象
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add${name?cap_first}(${name?cap_first} ${name}){
		try {
			${name}<#if sperate !="" >${sperate?cap_first}</#if>Service.add${name?cap_first}(${name});
								
			return "redirect:list";
		}catch (ProviderException e) {
			ProviderException ek=(ProviderException) e;
			switch (ek.getExceptionEnum().getValue()) {
				case 1:
					return "根据错误条件返回的提示页面";	
				//....	
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "运行时异常";
	}
	
	/**
	 * @Description ajax查询 ${name}对象，返回json串，注意调用此方法时，循环关联一定要去除
	 */
	@ResponseBody
	@RequestMapping(value="/update/ready",method=RequestMethod.POST)
	public ${name?cap_first} ready4Update(Integer ${name}Id){
		try {
			return ${name}<#if sperate !="" >${sperate?cap_first}</#if>Service.find${name?cap_first}(${name}Id);	
		
		}catch (ProviderException e) {
			ProviderException ek=(ProviderException) e;
			switch (ek.getExceptionEnum().getValue()) {
				case 1:
					return null;	
				//....	
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @Description 更新${name}对象
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update${name?cap_first}(${name?cap_first} ${name}){
		try {
			${name}<#if sperate !="" >${sperate?cap_first}</#if>Service.update${name?cap_first}(${name});
									
			return "redirect:list";
		}catch (ProviderException e) {
			ProviderException ek=(ProviderException) e;
			switch (ek.getExceptionEnum().getValue()) {
				case 1:
					return "根据错误条件返回的提示页面";	
				//....	
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "运行时异常";
	}
	
	/**
	 * @Description 根据id删除一个对象
	 */
	@RequestMapping(value="/del/{${name}Id}",method=RequestMethod.GET)
	public String del${name?cap_first}(@PathVariable Integer ${name}Id){
		try {
			${name}<#if sperate !="" >${sperate?cap_first}</#if>Service.del${name?cap_first}(${name}Id);
						
			return "redirect:/<#if sperate !="" >${sperate}.</#if>/${name}?/list";//${name}?根据情况修改。此处重定向到list方法
		}catch (ProviderException e) {
			ProviderException ek=(ProviderException) e;
			switch (ek.getExceptionEnum().getValue()) {
				case 1:
					return "根据错误条件返回的提示页面";	
				//....	
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "运行时异常";
	}
}