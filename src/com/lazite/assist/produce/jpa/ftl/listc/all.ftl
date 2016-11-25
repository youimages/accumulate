<#if methods?exists>
	<#list methods as method>
@Autowired
${method.entity?cap_first}Service ${method.entity}Service;
	</#list>
</#if>	

<#if methods?exists>
	<#list methods as method>

/**
 * ${method.remark}列表查询
 */	
@RequestMapping(value="/${method.path?replace('/','_')}")
public String list${method.path?replace('/',"_")?cap_first}(Pagenation pagenation){
	pagenation.setSize(10);//每页查10条
	pagenation=pagenation.initControllerPagenation(pagenation);

	Page<${method.entity?cap_first}> pages=${method.entity}Service.find${method.entity?cap_first}4Page(pagenation);
	
	request.setAttribute("pages",new TranslationPage<${method.entity?cap_first}>(pages).getPagenation());
					
	return "${method.path}list";
}
	</#list>
</#if>