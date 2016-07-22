package com.lazite.assist.safety;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description  md5加密字符串   
 * @Author lazite 
 * @CreateTime 2016年7月8日 下午6:10:42   
 * @ModifyBy lazite 
 * @ModeifyTime 2016年7月8日 下午6:10:42   
 * @ModifyDescription
 * @Version   V1.0
 */
public class Md5Easier {
	/**
	 * 加密字符串,如果传入null则返回null
	 * @param s
	 * @return
	 */
	public static String encrypt(String s){
		String str = null;
		if(s !=null && !s.equals("")){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				BASE64Encoder base = new BASE64Encoder();
				//加密后的字符串
				str = base.encode(md.digest(s.getBytes("utf-8")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}
