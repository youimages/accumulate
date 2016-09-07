package com.lazite.assist.produce.util;

public enum EntityEnums {
    Dao("d",1), Service("s",2),Controller("c",3),
    DaoImpl("di",4), ServiceImpl("si",5);
    
    private String name;
    private Integer code;
 
    private EntityEnums( String name,Integer code) {
        this.name = name;
        this.code = code;
    }
     
    
    
    public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	@Override
    public String toString(){
        return "[" + code + " : " + name + "]"; 
    }
}
