package com.lazite.assist.pay.alipay.config;

public class AlipayRequestParameter {
		//支付类型
		String payment_type = "1";
		//必填，不能修改
		
		//商户订单号
		//商户网站订单系统中唯一订单号，必填
		String out_trade_no ;

		//订单名称
		//必填
		String subject ;

		//付款金额
		//必填
		String total_fee ;

		//商品展示地址
		//必填，需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html
		String show_url = "http://m.wjxs77.com/dirsir/g/";
		//String show_url = "http://zfkjserver.vicp.cc:11442/dirsir/g/";

		//订单描述
		//选填
		String body ;

		//超时时间
		//选填
		String it_b_pay ="1d";

		//钱包token
		//选填
		String extern_token ;
		
		
		public AlipayRequestParameter() {
			super();
		}
		

		public AlipayRequestParameter(String out_trade_no, String subject,
				String total_fee) {
			super();
			this.out_trade_no = out_trade_no;
			this.subject = subject;
			this.total_fee = total_fee;
		}
		
		public AlipayRequestParameter(String out_trade_no, String subject,
				String total_fee, String show_url, String body,
				String it_b_pay, String extern_token) {
			super();
			this.out_trade_no = out_trade_no;
			this.subject = subject;
			this.total_fee = total_fee;
			this.show_url = show_url;
			this.body = body;
			this.it_b_pay = it_b_pay;
			this.extern_token = extern_token;
		}
		
		public AlipayRequestParameter(String payment_type, String out_trade_no, 
				String subject,	String total_fee, String show_url, String body,
				String it_b_pay, String extern_token) {
			super();
			this.payment_type = payment_type;
			this.out_trade_no = out_trade_no;
			this.subject = subject;
			this.total_fee = total_fee;
			this.show_url = show_url;
			this.body = body;
			this.it_b_pay = it_b_pay;
			this.extern_token = extern_token;
		}


		public String getPayment_type() {
			return payment_type;
		}


		public void setPayment_type(String payment_type) {
			this.payment_type = payment_type;
		}



		public String getOut_trade_no() {
			return out_trade_no;
		}


		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getTotal_fee() {
			return total_fee;
		}


		public void setTotal_fee(String total_fee) {
			this.total_fee = total_fee;
		}


		public String getShow_url() {
			return show_url;
		}


		public void setShow_url(String show_url) {
			this.show_url = show_url;
		}


		public String getBody() {
			return body;
		}


		public void setBody(String body) {
			this.body = body;
		}


		public String getIt_b_pay() {
			return it_b_pay;
		}


		public void setIt_b_pay(String it_b_pay) {
			this.it_b_pay = it_b_pay;
		}


		public String getExtern_token() {
			return extern_token;
		}


		public void setExtern_token(String extern_token) {
			this.extern_token = extern_token;
		}
		
		
		
}
