package com.dirsir.common.pay.wechat.utils;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.dirsir.common.global.Constant;
import com.dirsir.common.pay.wechat.config.WXPayConfig;
import com.dirsir.common.pay.wechat.utils.http.HttpUtil;

public class OpenIdUtil {
	public String getOpenIdInWeChat(HttpServletRequest request) {
		String code = request.getParameter("code");//获取微信服务器授权返回的code值
//		String state = request.getParameter("state");//验证是否来自微信重定向的请求
		
		String[] params = {"appid:" + WXPayConfig.APPID,"secret:" + WXPayConfig.APPSECRET,"code:" + code,"grant_type:authorization_code"};
		String jsonStr = HttpUtil.getRequest(WXPayConfig.ACCESS_TOKEN_URL, params);//返回json字符串
		String openid = JSONObject.parseObject(jsonStr).getString(Constant.openid);
		
		return openid;
	}
}
