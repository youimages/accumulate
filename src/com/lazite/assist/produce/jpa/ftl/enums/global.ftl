/**
 * @Title find${name}Property
 * @Description 获取${nameCN}的属性类型
 * @return
 * @throws TODO
 */
public static Map<Integer,String> find${name}Property() {
	Map<Integer,String> temp=new LinkedHashMap<Integer,String>();
	
	EnumSet<MisEnums.${name}_Enum> sexSet = EnumSet.allOf(MisEnums.${name}_Enum.class);
	
	temp.put(-1, "-请选择-");

	for (MisEnums.${name}_Enum se : sexSet) {
		if(!se.getValue().equals(9999999)){
			temp.put(se.getValue(), se.getName());				
		}
	}
	return temp;
}