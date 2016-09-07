package com.${project}.service.<#if sperate !="" >${sperate}.</#if>${name}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.${project}.service.<#if sperate !="" >${sperate}.</#if>${name}.${name?cap_first}Service;

import com.${project}.common.exception.ProviderException;
import com.${project}.common.enums.ExceptionEnums;
import com.${project}.entity.${name?cap_first};
import com.${project}.dao.${name?cap_first}Dao;


@Transactional
@Service("${name}<#if sperate !="" >${sperate?cap_first}</#if>Service")
public class ${name?cap_first}ServiceImpl implements ${name?cap_first}Service{
	@Autowired
	${name?cap_first}Dao ${name}Dao;
	
	@Override
	public void add${name?cap_first}(${name?cap_first} ${name}) throws ProviderException{
		try {
			${name}Dao.saveAndFlush(${name});
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
				
	@Override
	public void del${name?cap_first}(${name?cap_first} ${name}) throws ProviderException{
		try {
			${name}Dao.delete(${name});
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
		
	@Override
	public void del${name?cap_first}(Integer id) throws ProviderException{
		try {
			${name}Dao.delete(id);
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
	
	@Override	
	public void update${name?cap_first}(${name?cap_first} ${name}) throws ProviderException{
		try {
			if(${name}.getId()==null){
				//XXXX需要修改。抛出自定义异常
				throw new ProviderException(ExceptionEnums.Exception.valueOf("XXXX"));
			}
		
			${name?cap_first} old=${name}Dao.findOne(${name}.getId());
		
			//以下根据实际情况set需要修改的值↓↓↓↓↓↓↓↓↓↓↓。
			
			
			//以上根据实际情况set需要修改的值↑↑↑↑↑↑↑↑↑↑↑。
	
			${name}Dao.saveAndFlush(old);
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
		
	@Override	
	public List<${name?cap_first}> find${name?cap_first}Whole() throws ProviderException{
		try {
			//排序根据实际情况修改排序规则及排序字段
			Sort sort=new Sort(Direction.ASC, "id");
		
			return ${name}Dao.findAll(sort);
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
	
	@Override	
	public ${name?cap_first} find${name?cap_first}(Integer id) throws ProviderException{
		try {
			if(id==null){
				//XXXX需要修改。抛出自定义异常
				throw new ProviderException(ExceptionEnums.Exception.valueOf("XXXX"));
			}
			
			return ${name}Dao.findOne(id);
		} catch (Exception e) {
			throw ProviderException.unchecked(e);
		}
	}
	
	@Override	
	public List<${name?cap_first}> find${name?cap_first}4Condition(${name?cap_first} ${name}) throws ProviderException{
		
		return null;
	}

}