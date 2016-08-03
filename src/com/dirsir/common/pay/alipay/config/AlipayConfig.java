package com.dirsir.common.pay.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
//	public static String partner = "2088021483793928";//wx
	public static String partner = "2088221564990343";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
//	public static String seller_id = "2088021483793928";//wx
	public static String seller_id = "2088221564990343";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
// wxde	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK8pu7yL1cWbfZPvujLhI8FckvMJzZCeXXjxU+nVxCb3qz/tuk5RQM/TDCskvlnVMK7ua97GLRa9RSlOMmUC0AF3AlIYwPA0qoLIDQEFZHzMTPekJU7gljNbHGCls0dHh3AMWbkt+EfFXeR3ixh/Xd96+WVqRaC15heVxdLES+JFAgMBAAECgYB7C3DymLQ5VOnZAtykoxyv1uzvRyKdBXIZ5ESTDXP1/6LPjJqEK3XAx7tTj0Mb7bN+HsOtwT6pK5mq02B5LomYY3X1CXrdtODE8aqX00Iy1RZnvlekBmxFJ5Mi8vKEgacohzHm3L3DRNmsxfT07PwosHKpBJBoWpsPp+jIcf0ogQJBAOSReg4euMAzAMRjxF4MeDXTurKhs0/F+nq50nMkWY5M9qIarF01HG3fceeG0EIuml87+h+i8E5TcXeu9uVNVKECQQDEL2+HzQ45NA0s0ZgVkwctcOAp7mfBgGlBfwd0YkGyBgemvqs4iJTMQj5Q2/qC4IJmrLCWmqHL4ulGWioF5kclAkBmpc6iuLlP15fomsV9VyxFQCkAQA4/LTIoG3ufqhtuBLJeaowt78Qss8R7rdepYTSCwHS78HjrNB4pGbJXmDsBAkEAnbZ4lZZeAdR7ZvVTqrxYv8oHGw5h8KfXdeS1zHUU1RWN3xlWsgrye8YhLIW7PK1Zh0r6ZwgGW86ds4XWVInL1QJATlmHgV3/NaBCIoTT5hO54hAjHM0aBcTL/E9jMgqY1q9UCziHR6Q+vDOmCl9u5TTEkKS3V4D4UwEZ31uQN2H6TA==";
	public static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANvgb2LgqsYIX3ZL5QrIJghF8IeOnc9vvFdzyMfvQevgEEdjRvDcX/759JqfkDQ1EkpeCnsbLBfAWzpukd2Th6UGiYeOAEbxcjEFgSAbVVFWJBGZhXUtqYJHdAuv7ynldwrIUAmlIfArx4mUeAI3iPr2RbLXBu766/28anP2UNtTAgMBAAECgYEApKBlJaZLltx8BUmL40e6WiVrk0Nv2vmxDdVuNmxociAgcCLf4cVOxs0FnKPtx3kZCb9hn4zXtazbYWOaKUmlm8DsIH7cE3erNnvFlABWPys1w7vFuh2yfyEPlo27BseujkF6o1cnG9eQ3W2fF2Ta925gMFczxsMMsA86ukHbtqkCQQD7VhgRw03XSJhQL4sy1B0XfbHn6SxbN91aUsTkpugB+9Q203iiiNKTt/9kT8wpES9tc/0rpiQCIM3hfOZhsls9AkEA3/Tmj7tN8diYJ8ROzlA3ujaLbSIReJ3+/1LaEoZIBTAAzjL0GGCZKz+O9DxIC6YYgE0zbo5YC1fwjldlWnK5zwJAJgY5b/6HOUnPWVpICfGTUSmAD+D0B/zkrTSWey1RLnOmAIFv388pZJXSup9j+NaTwVBp/f+NtRC3dSTLSf6M1QJBAL0WQ9hU94FbM1RYDYVp+zMwvFV/LysckuC17kM3tvUSS4vNP4SZgpkeR690egvDx+oDxInyiunA7OzxYzSTqscCQQDzKV5KM+4ygvb7XjF5LV94iK0JaZOmrfwcNgDMXjIhwKRr4sgaGU/D0jPRTMDlzUD/nw+OfkSgT9fsXqu5l7NA";
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
// wxde public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "";
	public static String notify_url = "http://m.wjxs77.com/dirsir/pay/alipay/return";
//	public static String notify_url = "http://192.168.0.223:8888/dirsir/app/pay/alipay/return";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://m.wjxs77.com/dirsir/pay/alipay/return";
	//public static String return_url = "http://192.168.0.209:8888/dirsir/pay/alipay/return";
	//public static String return_url = "http://zfkjserver.vicp.cc:35456/dirsir/pay/alipay/return";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "E:\\";
	
		
	// 字符编码格式 目前支持utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改   从
	public static String service = "alipay.wap.create.direct.pay.by.user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

