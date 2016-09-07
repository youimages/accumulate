package com.tray.controller.site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.tray.common.exception.ProviderException;
import com.tray.common.web.BaseController;
import com.tray.entity.Customer;
import com.tray.service.site.customer.CustomerService;

@Controller
@RequestMapping("site/customer?/")//"customer?"此处映射地址根据前台调用修改，要求不重复，易书写易记忆有特征意义
public class CustomerSiteController extends BaseController {
	@Autowired
	CustomerService customerSiteService;
	
	/**
	 * @Description 全查列表页面
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listCustomer(){
		try {
			List<Customer> customers=customerSiteService.findCustomerWhole();
		
			request.setAttribute("values",customers);
			
			return "customer/XXXXX";//XXXXX此处映射地址填写列表地址
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
	public String addCustomer(Customer customer){
		try {
			customerSiteService.addCustomer(customer);
								
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
	 * @Description ajax查询 customer对象，返回json串，注意调用此方法时，循环关联一定要去除
	 */
	@ResponseBody
	@RequestMapping(value="/update/ready",method=RequestMethod.POST)
	public Customer ready4Update(Integer customerId){
		try {
			return customerSiteService.findCustomer(customerId);	
		
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
	 * @Description 更新customer对象
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateCustomer(Customer customer){
		try {
			customerSiteService.updateCustomer(customer);
									
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
	@RequestMapping(value="/del/{customerId}",method=RequestMethod.GET)
	public String delCustomer(@PathVariable Integer customerId){
		try {
			customerSiteService.delCustomer(customerId);
						
			return "redirect:/site./customer?/list";//customer?根据情况修改。此处重定向到list方法
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
