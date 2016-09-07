package com.${project}.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.${project}.entity.${name?cap_first};


public interface ${name?cap_first}Dao extends JpaRepository<${name?cap_first}, Integer>,PagingAndSortingRepository<${name?cap_first}, Integer>{
	/**
	 * 
	 * @CopyRight：http://www.netrust.cn/
	 *
	 * @Description   条件查询，调用需要自己实现
	 * @Author lazite 
	 * @CreateTime 2016年9月5日 下午4:23:33   
	 * @ModifyBy lazite 
	 * @ModeifyTime 2016年9月5日 下午4:23:33   
	 * @ModifyDescription
	 * @Version   V1.0
	 */
	public List<${name?cap_first}> findByConditionSort(Sort sort,Object... objs);

}