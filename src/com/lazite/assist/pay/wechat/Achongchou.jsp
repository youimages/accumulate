<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>众筹影集</title>
    <meta name="keywords" content="HTML,ASP,PHP,SQL">
    <meta name="description" content="众筹款项">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="mobile/css/reset.css">
    <link rel="stylesheet" type="text/css" href="mobile/css/zhongchou.css">
</head>
<body>
<figure><img src="mobile/img/L--E--S--L--I--E.png"></figure>
<figure class="odd"><img src="mobile/img/pic_word.png"></figure>
<figure><img src="mobile/img/pic.png"></figure>
<figure class="odd"><img src="mobile/img/pic_slogan1.png"></figure>
<article>
    <p>为纪念哥哥六十岁，由部分陕西荣迷牵头，聚合江西、北京、浙江、海南、加拿大等地荣迷力量，从数千张哥哥图片中精选出150张左右，集结成册，以飨荣迷。<br><br>
        《见得张国荣》从设计、选图、文案到编辑，全部由荣迷担任。其中有相当数量的罕见图片，少量图片首次付印。<br><br>
        《见得张国荣》共计60页，高240mm，宽190mm，封面用130克白色细布纹特种纸，裱2.5mm纸板；标题文字部分烫银，激凸；内页用157克日本原浆进口特种纸，四色印刷，专色印刷。整册模切机压圆角处理。<br><br>
        本影集<del><font color="red"><b>定价339元</b></font></del>众筹价131.4元（包邮），不公开发售，专供荣迷，千册起印。如不足千册，所筹款项全部退回参与者。如众筹达千册，则最终印数视实际情况决定。
    </p>
    <ul id="list">
        <li>  • &nbsp;推荐他人参与本次众筹有返现奖励；凭付款人在众筹页面提供的推荐者微信号，在众筹结束后，向推荐人每本返现10元，上不封顶。</li>
        <li>  • &nbsp;推荐或购买《见得张国荣》60册及以上数量者，可在本书尾页印上自己想对哥哥说的话，不超过60字。</li>
    </ul>
    <p>已众筹数量：<font color="red">307册</font>（每天统计一次）<br />众筹截止时间：2016.04.15<br />张国荣60周年众筹影集QQ群：398306287</p>
</article>
<figure class="odd"><img src="mobile/img/pic_slogan2.png"></figure>
<form id="activityForm" action="" method="POST">
	<input type="hidden" name="openid" id="openid" value="${openid}" />
	<input type="hidden" name="orderNum" id="orderNum" value="" /> 
	<input type="hidden" name="payPrice" id="payPrice" value="" /> 
    <h4>姓名</h4>
    <input type="text" name="name" value="" id="name" placeholder="请填写你的姓名">
    <h4>手机号</h4>
    <input type="text" name="telNumber" value="" id="telNumber" placeholder="请填写你的手机号，保证填写无误">
    <h4>收货地址</h4>
    <input type="text" name="address" value="" id="address" placeholder="请准确填写你的地址，方便我们快递给你">
    <h4>推荐人微信号</h4>
    <input type="text" name="recomWeChat" value="" id="recomWeChat" placeholder="填写本次众筹推荐人微信号，为推荐人返还10元">
	<h4>想对哥哥说的话</h4>
	<textarea name="orderRemark" id="TextArea1" placeholder="写下你想对哥哥说的话。推荐或购买60册及以上者,你的思念会出现在影集尾页..."></textarea>
	<div id="limit"><span id="textCount">60</span>字</div>
</form>
<article id="shopping">
    <h4>购买数量</h4>
    <div class="clearfix">
        <span id="left"><img src="mobile/img/number_cancel.png"></span>
        <span id="mid-span">1</span>
        <span id="right"><img src="mobile/img/number_add.png"></span>
    </div>
</article>
<article id="money"class="clearfix">
        <div class="clearfix">
             <span>需支付：</span>
             <span id="rmb">131.40</span>
        </div>
        <div id="goumai">立即支付</div>
</article>
<script src="mobile/js/jquery-2.1.4.min.js"></script>
<script src="mobile/js/jquery.touch.js" ></script>
<script src="mobile/js/click.js"></script>
<script src="mobile/js/jquery.form.js" ></script>

<script>
	$(document).ready(function() {
		FastClick.attach(document.body);
		var $shu = 1;
		var b = "131.40";
		document.getElementById("orderNum").value = $shu;
		document.getElementById("payPrice").value = b;
		$("#right").on("click", function() {
			$shu++;
			var a = $shu * 131.40;
			var b = a.toFixed(2)
			$("#mid-span").html($shu);
			$("#rmb").html(b);
			document.getElementById("orderNum").value = $shu;
			document.getElementById("payPrice").value = b;
		});
		$("#left").on("click", function() {
			if ($shu == 1) {
				$("#mid-span").html("1");
				$("#rmb").html("131.40");
				document.getElementById("orderNum").value = $shu;
				document.getElementById("payPrice").value = b;
			} else {
				$shu--;
				a = $shu * 131.40;
				b = a.toFixed(2)
				$("#mid-span").html($shu);
				$("#rmb").html(b);
				document.getElementById("orderNum").value = $shu;
				document.getElementById("payPrice").value = b;
			}
		});
		/*字数减少*/
        $("#TextArea1").on("keyup",function(){
            var curLength=$("#TextArea1").val().length;
            if(curLength>60){
                var num=$("#TextArea1").val().substr(0,60);
                $("#TextArea1").val(num);
                alert("超过字数限制！" );
            }else{
                $("#textCount").text(60-$("#TextArea1").val().length);
            }
        });
        /*手机号验证*/
        $("#telNumber").on("blur",function(){
            var telphone = $("#telNumber").val();
            var myreg = /^1[34578]\d{9}$/;
            if(!telphone==""){
                if(!myreg.test(telphone)){
                    alert("请输入正确的手机号！")
                    $("#telNumber").val("");
                    $("#telNumber").focus();
                }
            }
        });
        /*立即支付的js效果*/
		$("#goumai").on("click", function(){
			//姓名、手机号、收货地址不填的时候不能提交，return false，这些都填了的话 return true，可以正常提交
			var name = $("#name").val();
			var telNumber = $("#telNumber").val();
			var address = $("#address").val();
			if(name != "" && telNumber != "" && address != ""){
				$.ajax({
					type : "POST",
					url : "http://www.iseeiget.cn/activity/submitActivity.do",
					data: $("#activityForm").serialize(),
					dataType: "json",
					success:function(data){
						payFun(data);
	                }
				});
			}else{
				alert("姓名、手机号、收货地址必须填写");
				return false;
			}
		});
	})
	//微信支付相关的js
	function payFun(data){
		var obj = eval(data); 
		var appId = obj.result.data.appId;
		var timeStamp = obj.result.data.timeStamp;
		var nonceStr = obj.result.data.nonceStr;
		var package = obj.result.data.package;
		var signType = obj.result.data.signType;
		var paySign = obj.result.data.paySign;
		var str = window.navigator.userAgent;
		var version = str.substring(8, 11);
		if (version != "5.0") {
			alert("微信浏览器系统版本过低，请将微信升级至5.0以上");
		} else {
			WeixinJSBridge.invoke('getBrandWCPayRequest', {
				"appId" : appId, //公众号名称，由商户传入     
				"timeStamp" : timeStamp, //时间戳，自1970年以来的秒数     
				"nonceStr" : nonceStr, //随机串     
				"package" : package,//统一支付接口返回的prepay_id 参数值，提交格式如：prepay_id=***
				"signType" : signType, //微信签名方式：     
				"paySign" : paySign //微信签名 
			}, function(res) {
				/* alert(res.err_code + res.err_desc);
				alert(res.err_msg); */
				if (res.err_msg == "get_brand_wcpay_request:ok") {
					alert("支付成功");
				} else if (res.err_msg === 'get_brand_wcpay_request:cancel') {
					alert("取消支付");
				}
			});
		}
	}
</script>
</body>
</html>