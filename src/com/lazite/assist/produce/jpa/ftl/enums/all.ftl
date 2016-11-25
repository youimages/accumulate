
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓以下为MisEnums类的新增${nameCN}枚举
/**
 * 
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description   ${nameCN}类
 * @Author lazite 
 * @CreateTime 2016年11月21日 下午5:28:35   
 * @ModifyBy lazite 
 * @ModeifyTime 2016年11月21日 下午5:28:35   
 * @ModifyDescription
 * @Version   V1.0
 */
public static enum ${name?cap_first}_Enum {   
    MIS_${name?cap_first}_DEMO(9999999, "例子勿使用","例子勿使用");
    private Integer value;
    private String name;
    public String description;
    private ${name?cap_first}_Enum(Integer value, String name,String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }
    public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
    public String toString(){
        return "[" + value + " : " + name + " : " + description + "]"; 
    }
};