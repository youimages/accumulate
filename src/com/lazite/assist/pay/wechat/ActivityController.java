//package com.dirsir.common.pay.wechat;
//
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.SortedMap;
//import java.util.TreeMap;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.alibaba.fastjson.JSONObject;
//import com.photo.bean.Activity;
//import com.photo.exception.ServiceException;
//import com.photo.service.ActivityService;
//import com.photo.thirdUtil.GetCode;
//import com.photo.util.Const;
//import com.photo.util.DateUtil;
//import com.photo.util.HttpUtil;
//import com.photo.util.JsonUtil;
//import com.photo.wxPayUtil.GetWxOrderNo;
//import com.photo.wxPayUtil.RequestHandler;
//import com.photo.wxPayUtil.Sha1Util;
//import com.photo.wxPayUtil.TenpayUtil;
//import com.photo.wxPayUtil.XMLUtil;
//
////gc
////@Controller
////@RequestMapping("/activity")
//public class ActivityController {
//	//@Resource
//	private ActivityService activityServiceImpl;
//	
//	/**
//	 * 微信服务器授权登录后重定向到的接口
//	 * https://open.weixin.qq.com/connect/oauth2/authorize?
//	 * appid=APPID&redirect_uri=http://www.iseeiget.cn/(重定向授权的接口就写这个接口)
//	 * &response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
//	 * 统一授权跳转至
//	 * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE
//	 * 测试：
//	 * http://www.iseeiget.cn/activity/getOAuth.do?code=03187864bd50c8e43523c3389a0b660O&state=STATE
//	 */
//	@RequestMapping("/getOAuth.do")
//	public String getOAuth(HttpServletRequest request,HttpServletResponse response){
//		/**
//		 * 微信点击请求这个接口，然后获得用户的openId之后返回到 mobile/jsp/zhongchou.jsp页面，
//		 * 并且将用户的openId传回到zhongchou.jsp页面
//		 */
//		String code = request.getParameter("code");//获取微信服务器授权返回的code值
//		String state = request.getParameter("state");//验证是否来自微信重定向的请求
//		/**
//		 * 构造请求链接
//		 * https://api.weixin.qq.com/sns/oauth2/access_token?
//		 * appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
//		 */
//		String[] params = {"appid:" + Const.APPID,"secret:" + Const.APPSECRET,"code:" + code,"grant_type:authorization_code"};
//		String jsonStr = HttpUtil.getRequest(Const.ACCESS_TOKEN_URL, params);//返回json字符串
//		String openid = JSONObject.parseObject(jsonStr).getString("openid");
//		request.setAttribute("openid", openid);
//		return "mobile/jsp/zhongchou";
//	}
//	/**
//	 * 进入到众筹页面--->填写订单--->立即支付--->
//	 * 给后台数据库插入一条订单数据，插入成功并且返回订单号--->
//	 * 转发到请求微信支付系统的统一下单接口--->生成预支付订单--->
//	 * 回调查看支付状态，成功修改订单状态为已支付，失败订单状态是未支付
//	 * --->后台管理显示出来订单的情况--->已支付的订单进行发货操作
//	 * --->有微信推荐人的进行微信返现操作
//	 * 测试：
//	 * http://192.168.0.101:8888/photography/activity/submitActivity.do?name=高创&telNumber=15771720502&address=测试地址&orderNum=1&payPrice=131.40&openid=oAljCvzYkZp_emmJPPFwRN-JtTh0
//	 */
//	@RequestMapping("/submitActivity.do")
//	public String submitActivity(HttpServletRequest request,ModelMap model){
//		String name = request.getParameter("name");
//		String telNumber = request.getParameter("telNumber");
//		String address = request.getParameter("address");
//		String recomWeChat = request.getParameter("recomWeChat");
//		String orderNum = request.getParameter("orderNum");
//		String payPrice = request.getParameter("payPrice");
//		String orderRemark = request.getParameter("orderRemark");
//		String openid = request.getParameter("openid");
//		try {
//			if(name != null && !"".equals(name)
//					&& telNumber != null && !"".equals(telNumber)
//					&& address != null && !"".equals(address)
//					&& orderNum != null && !"".equals(orderNum)
//					&& payPrice != null && !"".equals(payPrice)
//					&& openid != null && !"".equals(openid)){
//				String orderNo = DateUtil.getOrderNo();//订单编号
//				//生成一个不重复的订单号
//				boolean log = true;
//				do{
//					Activity parame = new Activity();
//					parame.setOrderNo(orderNo);
//					Activity activity = activityServiceImpl.findActivity(parame);
//					if(activity != null && !"".equals(activity)){
//						orderNo = DateUtil.getOrderNo();//订单编号
//					}else{
//						log = false;
//					}
//				}while(log);
//				Activity activity = new Activity();
//				activity.setOrderNo(orderNo);
//				activity.setName(name);
//				activity.setTelNumber(telNumber);
//				activity.setAddress(address);
//				if(recomWeChat != null && !"".equals(recomWeChat)){
//					activity.setRecomWeChat(recomWeChat);
//				}
//				if(orderRemark != null && !"".equals(orderRemark)){
//					activity.setOrderRemark(orderRemark);
//				}
//				activity.setOrderNum(Integer.parseInt(orderNum));
//				activity.setPayPrice(Double.valueOf(payPrice));
//				activity.setPayStatus(1);//是否支付，1未支付，2已支付
//				activity.setIsShip(1);//是否发货，1未发货，2已发货
//				activity.setIsCash(1);//是否返现给推荐人微信号，1未返现，2已返现
//				activity.setOrderTime(String.valueOf(System.currentTimeMillis()/1000));
//				boolean flag = activityServiceImpl.insertActivity(activity);
//				if(flag){
//					//将订单编号转发
//					/*model.addAttribute("orderNo", orderNo);
//					model.addAttribute("openid", openid);
//					model.addAttribute("body", "参加众筹影集活动购买的张国荣影集");
//					model.addAttribute("totalFee", String.valueOf(Double.valueOf(payPrice)*100).split("\\.")[0]);*/
//					return "forward:/activity/doWeiXinRequest.do?orderNo="+orderNo+"&openid="+openid+"&body=参加众筹影集活动购买的张国荣影集"+"&totalFee="+String.valueOf(Double.valueOf(payPrice)*100).split("\\.")[0];
//				}else{
//					return "mobile/jsp/zhongchou";//下订单失败
//				}
//			}else{
//				return "mobile/jsp/zhongchou";//下订单失败
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			return "mobile/jsp/zhongchou";//下订单失败
//		}
//	}
//	/**
//	 * 请求微信支付系统的接口，商户后台系统调用统一下单接口在微信支付服务后台生成预支付交易单
//	 */
//	@RequestMapping("/doWeiXinRequest.do")
//	public void doWeiXinRequest(HttpServletRequest request,HttpServletResponse response){
//		Map<String,Object> map = new HashMap<String,Object>();
//		Map<String,Object> map1 = new HashMap<String,Object>();
//		Map<String,Object> map2 = new HashMap<String,Object>();
//		String body = request.getParameter("body");//商品描述
//		String outTradeNo = request.getParameter("orderNo");//交易的订单号
//		Integer totalFee = Integer.parseInt(request.getParameter("totalFee"));//订单总金额，以分为单位 
//		String openid = request.getParameter("openid");
//		try {
//			if(body != null && !"".equals(body)
//					&& outTradeNo != null && !"".equals(outTradeNo)
//					&& totalFee != null && !"".equals(totalFee)
//					&& openid != null && !"".equals(openid)){
//				Activity parame = new Activity();
//				parame.setOrderNo(outTradeNo);
//				Activity activity = activityServiceImpl.findActivity(parame);
//				if(activity != null && !"".equals(activity)){
//					if(activity.getPayStatus() == 1){
//						String currTime = TenpayUtil.getCurrTime();
//						//八位日期相关的字符串
//						String strTime = currTime.substring(8, currTime.length());
//						//四位随机数的字符串
//						String strRandom = TenpayUtil.buildRandom(4) + "";
//						//十位随机字符串
//						String nonceStr = strTime + strRandom; 
//						/**
//						 * 商品描述，订单号，订单总金额从转发的请求参数中获取
//						 */
//						String spbillCreateIp = request.getRemoteAddr();
//						SortedMap<String, String> requestParams = new TreeMap<String, String>();
//						requestParams.put("appid", Const.APPID);  
//						requestParams.put("mch_id", Const.PUBLIC_PARTNER);  
//						requestParams.put("nonce_str", nonceStr);  
//						requestParams.put("body", body);//商品描述  
//						requestParams.put("out_trade_no", outTradeNo);//订单号  
//						requestParams.put("total_fee", String.valueOf(totalFee));//订单总金额
//						requestParams.put("spbill_create_ip", spbillCreateIp);//APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器ip 
//						requestParams.put("notify_url", Const.NOTIFIYURL);//通知地址  
//						requestParams.put("trade_type", "JSAPI");//交易类型
//						requestParams.put("openid", openid);//trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
//						RequestHandler reqHandler = new RequestHandler(request, response);
//						reqHandler.init(Const.APPID, Const.APPSECRET, Const.PUBLIC_PARTNER_KEY);
//						String requestSign = reqHandler.createSign(requestParams);
//						//构造请求参数
//						String xml = "<xml>" 
//								+ "<appid>" + Const.APPID + "</appid>"
//								+ "<mch_id>" + Const.PUBLIC_PARTNER + "</mch_id>"
//								+ "<nonce_str>" + nonceStr + "</nonce_str>"
//								+ "<sign>" + requestSign + "</sign>"
//								+ "<body>" + body + "</body>"
//								+ "<out_trade_no>" + outTradeNo + "</out_trade_no>"
//								+ "<total_fee>" + totalFee + "</total_fee>"
//								+ "<spbill_create_ip>" + spbillCreateIp + "</spbill_create_ip>"
//								+ "<notify_url>" + Const.NOTIFIYURL + "</notify_url>"
//								+ "<trade_type>JSAPI</trade_type>"
//								+ "<openid>" + openid + "</openid>"
//								+ "</xml>";
//						String prepayId = new GetWxOrderNo().getPayNo(Const.PRE_URL, xml);//获得预支付单信息
//						/**
//						 * 统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给H5页面
//						 * 参与签名的字段名为appId，timeStamp，nonceStr，package，signType，paySign
//						 * 注意：package的值格式为统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
//						 */
//						SortedMap<String, String> getParams = new TreeMap<String, String>();
//						String timeStamp = Sha1Util.getTimeStamp();
//						getParams.put("appId", Const.APPID);
//						getParams.put("timeStamp", timeStamp);
//						getParams.put("nonceStr", nonceStr);
//						getParams.put("package", "prepay_id="+prepayId);
//						getParams.put("signType", "MD5");
//						String getSign = reqHandler.createSign(getParams);
//						map2.put("appId", Const.APPID);
//						map2.put("timeStamp", timeStamp);
//						map2.put("nonceStr", nonceStr);
//						map2.put("package", "prepay_id="+prepayId);
//						map2.put("signType", "MD5");
//						map2.put("paySign", getSign);
//						map1.put("msg", "成功");
//					}else{
//						map1.put("msg", "订单不存在");
//					}
//				}else{
//					map1.put("msg", "订单已支付");
//				}
//			}else{
//				map1.put("msg", "参数不全");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			map1.put("msg", "发生后台异常");
//		}
//		map1.put("data", map2);
//		map.put("result", map1);
//		JsonUtil.writeJson(response, JsonUtil.objectToJson(map));
//	}
//	
//	/**
//	 * 获取微信支付回调的接口
//	 * 测试：
//	 * http://192.168.0.101:8888/photography/activity/checkCallBack.do
//	 */
//	@RequestMapping("/checkCallBack.do")
//	public void checkCallBack(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		//APP后台服务器和微信服务器之间的交互，流操作
//	    InputStream is = request.getInputStream();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = is.read(buffer)) != -1) {
//        	baos.write(buffer, 0, len);
//        }
//        System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
//        baos.close();
//        is.close();
//        String result  = new String(baos.toByteArray(),"utf-8");//获取微信调用notify_url的返回信息
//        Map<Object, Object> resultMap = XMLUtil.doXMLParse(result);
//        if(resultMap.get("return_code").toString().equalsIgnoreCase("SUCCESS")){//支付成功
//        	//修改订单表中的订单数据为已支付状态
//        	String outOrderNo = (String) resultMap.get("out_trade_no");
//        	Activity parame = new Activity();
//			parame.setOrderNo(outOrderNo);
//			Activity activity = activityServiceImpl.findActivity(parame);
//        	if(activity != null && !"".equals(activity)){//订单存在
//        		/**
//        		 * 查看订单的状态是否为已支付状态，已支付状态直接返回，未支付状态进行支付并返回
//        		 */
//        		if(activity.getPayStatus()==2){
//        			GetCode.sendContent(activity.getTelNumber());
//        			response.getWriter().write(setXML("SUCCESS", ""));
//        		}else{
//        			parame.setPayStatus(2);//支付状态，1-未支付，2-已支付
//        			boolean flag = activityServiceImpl.updateActivity(parame);
//        			if(flag){//支付成功
//        				GetCode.sendContent(activity.getTelNumber());
//        				response.getWriter().write(setXML("SUCCESS", ""));
//        			}else{//支付失败
//        				response.getWriter().write(setXML("FAIL", "")); 
//        			}
//        		}
//        	}else{
//        		response.getWriter().write(setXML("FAIL", ""));
//        	}
//        }
//	}
//	
//	public static String setXML(String return_code, String return_msg) {
//		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
//				+ "]]></return_msg></xml>";
//	}
//}