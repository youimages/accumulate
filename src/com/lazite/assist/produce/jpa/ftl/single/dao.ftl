package com.${project}.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.${project}.entity.${name?cap_first};


public interface ${name?cap_first}Dao extends JpaRepository<${name?cap_first}, Integer>,PagingAndSortingRepository<${name?cap_first}, Integer>{

}