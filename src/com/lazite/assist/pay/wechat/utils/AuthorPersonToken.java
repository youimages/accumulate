package com.dirsir.common.pay.wechat.utils;


import com.alibaba.fastjson.JSONObject;
import com.dirsir.common.pay.wechat.config.WXPayConfig;
import com.dirsir.common.pay.wechat.utils.http.HttpUtil;

public class AuthorPersonToken {
	private static String Access_token_url = "https://api.weixin.qq.com/cgi-bin/token";
	private static String Author_Person_url = "https://api.weixin.qq.com/cgi-bin/user/info";
	private static String Author_Qrcode_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST";
	
	//private static String author_open_id="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb3f2223a71dac5a3&redirect_uri=http%3a%2f%2fm.wjxs77.com%2fdirsir%2fpay%2fperOpen%2f%3fgouId%3d"+data.obj+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	
	public static String getAccess_token() {
		String grant_type="grant_type:client_credential";
		String appid="appid:"+WXPayConfig.APPID;
		String secret="secret:"+WXPayConfig.APPSECRET;
		
		String result=HttpUtil.getRequest(Access_token_url,grant_type,appid,secret);
		
		JSONObject json = JSONObject.parseObject(result);
		
		return json.getString("access_token");
	}
	
	public static String getAuthor_Qrcode(String scene_id) {
		String tempBody ="{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+scene_id+"}}}";
		
		String access_token="access_token:"+getAccess_token();
		
		String body ="body:"+tempBody;
		
		System.out.println(access_token);
		
		String result=HttpUtil.getRequest(Author_Qrcode_url,access_token,body);
		
		JSONObject json = JSONObject.parseObject(result);
		
		
		return json.getString("ticket");
	}
	
	public static AuthorPersonPojo getAuthorPerson(String accessToken,String openId) {
		String access_token="access_token:"+accessToken;
		String openid="openid:"+openId;
		String lang="lang:zh_CN";
		
		String result=HttpUtil.getRequest(Author_Person_url,access_token,openid,lang);
		
		AuthorPersonPojo app=com.alibaba.fastjson.JSONObject.parseObject(result, AuthorPersonPojo.class);
		
		return app;
	}
	
//    public static void main(String[] args) {
//	   String accessToken =getAccess_token();
//	   
//    	System.out.println(accessToken);
//	   
//	   AuthorPersonPojo apj=getAuthorPerson(accessToken, "oAEd2t_2Gy7kug4Gf5bOkm8Aw8qo");
//	   
//   }
	
	public static void main(String[] args) {
		String ticket = getAuthor_Qrcode("1");
	}
}
