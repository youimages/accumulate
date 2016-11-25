//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓Attach实体类
//属性
private List<${midName?cap_first}> ${midName} = new ArrayList<${midName?cap_first}>();
//get set
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attach")
public List<${midName?cap_first}> get${midName?cap_first}() {
	return ${midName};
}
public void set${midName?cap_first}(List<${midName?cap_first}> ${midName}) {
	this.${midName} = ${midName};
}
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${name?cap_first}实体类
//属性
private List<${midName?cap_first}> ${midName} = new ArrayList<${midName?cap_first}>();
//get set
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "${name}")
public List<${midName?cap_first}> get${midName?cap_first}() {
	return ${midName};
}
public void set${midName?cap_first}(List<${midName?cap_first}> ${midName}) {
	this.${midName} = ${midName};
}

//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${midName?cap_first}实体类
package com.mis.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文件附件类
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description   
 * @Author lazite 
 * @CreateTime 2016年11月19日 下午2:06:16   
 * @ModifyBy lazite 
 * @ModeifyTime 2016年11月19日 下午2:06:16   
 * @ModifyDescription
 * @Version   V1.0
 */
@Entity
@Table(name = "${tableName}")
public class ${midName?cap_first} {
	private Integer id;
	private ${name?cap_first} ${name};
	private Attach attach;
	public ${midName?cap_first}() {
		super();
	}
	public ${midName?cap_first}(Integer id, ${name?cap_first} ${name}, Attach attach) {
		super();
		this.id = id;
		this.${name} = ${name};
		this.attach = attach;
	}
	public ${midName?cap_first}(${name?cap_first} ${name}, Attach attach) {
		super();
		this.${name} = ${name};
		this.attach = attach;
	}
	@Id
  	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ap_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="${tableId}")
	public ${name?cap_first} get${name?cap_first}() {
		return ${name};
	}
	public void set${name?cap_first}(${name?cap_first} ${name}) {
		this.${name} = ${name};
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="a_id")
	public Attach getAttach() {
		return attach;
	}
	public void setAttach(Attach attach) {
		this.attach = attach;
	}
}

//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${name?cap_first}Service实体类
/**
 * 查询${nameCN}对应的所有附件
 * @Title findAttachBy${name?cap_first}
 * @Description TODO
 * @param pid
 * @return
 * @throws TODO
 */
public List<Attach> findAttachBy${name?cap_first}(Integer pid);

/**
 * 保存${nameCN}附件
 * @Title save${name?cap_first}Attach
 * @Description TODO
 * @param pid
 * @param aids
 * @return 
 * @throws TODO
 */
public List<${midName?cap_first}> save${name?cap_first}Attach(Integer pid, List<Integer> aids);

/**
 * 删除${nameCN}附件
 * @Title del${name?cap_first}Attach
 * @Description TODO
 * @param pid
 * @param aid
 * @throws TODO
 */
public void del${name?cap_first}Attach(Integer pid, Integer aid);


//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${name?cap_first}ServiceImpl实体类

@Autowired
AttachDao attachDao;
@Autowired
${midName?cap_first}Dao ${midName}Dao;

@Override
public List<Attach> findAttachBy${name?cap_first}(Integer pid) {
	final Integer fpid=pid;
	
	List<Attach> sas= attachDao.findAll(
			new Specification<Attach>() {
				@Override
				public Predicate toPredicate(Root<Attach> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
						Join<Attach, ${midName?cap_first}> join=root.join(root.getModel().getList("${midName}",${midName?cap_first}.class),JoinType.LEFT);
						join.join("${name}",JoinType.LEFT);
					
						//查询条件
						Predicate p = cb.equal(join.get("${name}"),new ${name?cap_first}(fpid));//查询该项目的附件
						cq.where(p);
						return cq.getRestriction();
					}
			});
	
	return sas;
}

@Override
public List<${midName?cap_first}> save${name?cap_first}Attach(Integer pid, List<Integer> aids) {
	List<${midName?cap_first}> list=new ArrayList<>();
	${midName?cap_first} amp=null;
	for (Integer i : aids) {
		amp=new ${midName?cap_first}(${name}Dao.findOne(pid),attachDao.findOne(i));
		
		list.add(amp);
	}
	return ${midName}Dao.save(list);
}

@Override
public void del${name?cap_first}Attach(Integer pid, Integer aid) {
	${midName}Dao.delete(${midName}Dao.findBy${name?cap_first}AndAttach(new ${name?cap_first}(pid),new Attach(aid)));
}

//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${midName?cap_first}Dao实体类

package com.mis.dao.${name};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.mis.entity.Attach;
import com.mis.entity.${midName?cap_first};
import com.mis.entity.${name?cap_first};

public interface ${midName?cap_first}Dao extends JpaRepository<${midName?cap_first},Integer>,JpaSpecificationExecutor<${midName?cap_first}> {
	${midName?cap_first} findBy${name?cap_first}AndAttach(${name?cap_first} ${name}, Attach attach);
}

//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓${name?cap_first}Controller实体类
/**
 * 
 * @Title goAttachPage
 * @Description 跳转附件列表页面
 * @param pid
 * @return
 * @throws TODO
 */
@RequestMapping("attach")
String goAttachPage(Integer pid){
	List<Attach> list=${name}Service.findAttachBy${name?cap_first}(pid);
	request.setAttribute("data", list);
	request.setAttribute("pid", pid);
	return "${name}/attach";
}

/**
 * 新增附件
 * @Title saveAttach
 * @Description TODO
 * @param pid
 * @param aids
 * @return
 * @throws TODO
 */
@RequestMapping("attach/save")
String saveAttach(Integer pid,@RequestParam("aids")Integer[] aids){
	${name}Service.save${name?cap_first}Attach(pid,Arrays.asList(aids));
	return "forward:/${name}/attach?pid="+pid;
}

/**
 * 删除附件
 * @Title saveAttach
 * @Description TODO
 * @param pid
 * @param aid
 * @return
 * @throws TODO
 */
@RequestMapping("attach/del")
String saveAttach(Integer pid,Integer aid){
	${name}Service.del${name?cap_first}Attach(pid,aid);
	return "forward:/${name}/attach?pid="+pid;
}

