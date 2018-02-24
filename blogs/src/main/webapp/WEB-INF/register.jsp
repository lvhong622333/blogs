<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="-1">
<link href="${pageContext.request.contextPath}/static/image/main1.jpg" rel="icon" type="image/x-icon" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<style type="text/css">
	form{
		margin-left: 400px;
		margin-top: 250px;
	}
	.errorInfo{
		display:block;
		width:100%;
		height:34px;
		padding:6px 12px;
		font-size:14px;
		line-height:1.75;
		color:red;
		box-shadow:inset 0 1px 1px rgba(0,0,0,.075);
		transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	}
</style>
<title>注册页面</title>
</head>
<body background="${pageContext.request.contextPath}/static/image/main2.jpg" onsubmit="return validate()">
	<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/blogs/register" method="post">
		<div class="form-group">
			<label for="name" class="col-md-2 control-label" style="color: white;">用户名</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="userName" name="userName" placeholder="请输入注册用户名" onblur="checkName()" >
			</div>
			<div class="col-md-4">
				<font class="errorInfo" id="nameInfo" ></font>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-md-2 control-label" style="color: white;">手机号码</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="telephone" name="telephone" placeholder="请填写手机号码" onblur="checkphone()">
			</div>
			<div class="col-md-4">
				<font class="errorInfo" id="phoneInfo">${info}</font>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-md-2 control-label" style="color: white;">邮箱</label>
			<div class="col-md-4">
				<input type="email" class="form-control" name="eMail" placeholder="请填写邮箱">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-2 control-label" style="color: white;">密码</label>
			<div class="col-md-4">
				<input type="password" class="form-control" name="password" placeholder="请输入密码" id="password" pattern="[A-z0-9]{6,}">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-2 control-label" style="color: white;" >确认密码</label>
			<div class="col-md-4">
				<input type="password" class="form-control"  placeholder="请输入确认密码" id="passwordConfirm" onblur="checkPassword()">
			</div>
			<div class="col-md-4">
				<font id="passwordInfo" class="errorInfo"></font>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-2 control-label" style="color: white;">输入验证码</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="verificationCode" placeholder="请输入验证码">
			</div>
			<div class="col-md-2">
				<img alt="验证码图片" id="img" src="${pageContext.request.contextPath}/blogs/verificationCode" onclick="this.src='${pageContext.request.contextPath}/blogs/verificationCode?d='+Math.random();" height="34px" width="100px">
			</div>
			<div class="col-md-2">
					<font class="errorInfo">
						${imageVeri}
					</font>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">注册</button>
				<button type="reset" class="btn btn-default">重置</button>
				<button type="button" class="btn btn-default" onclick="login()">登陆</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function checkName(){
			var userName = $("#userName").val();
			if(userName == ""){
				$("#nameInfo").text("用户名不能为空");
				return;
			}
			$.get("${pageContext.request.contextPath}/blogs/checkName", {name:userName},
				function(data){
					$("#nameInfo").text(data);
				}
			);
		}
		function checkphone(){
			var telephone = $("#telephone").val(); 
			if(telephone == ""){
				$("#phoneInfo").text("手机号码不能为空");
				return;
			}
			if(!(/^1[3|4|5|8][0-9]\d{8}$/.test(telephone))){
				$("#phoneInfo").text("手机号码格式不正确");
				return;
			}
			$.get("${pageContext.request.contextPath}/blogs/checkphone", {telephone:telephone},
				function(data){
					$("#phoneInfo").text(data);
				}
			);
		}
		//密码校验
		function checkPassword(){
			var passwordConfirm  =  $("#passwordConfirm").val();
			var password = $("#password").val();
			if(passwordConfirm != password){
				$("#passwordInfo").text("两次密码不一致");
			}else{
				$("#passwordInfo").text("");
			}
		}
		//表单提交到后台前做最后校验
		function validate(){
			var userName = $("#userName").val();
			if(userName == ""){
				$("#nameInfo").text("用户名不能为空");
				return false;
			}
			var telephone = $("#telephone").val();
			if(telephone == ""){
				$("#phoneInfo").text("电话号码不能为空");
				return false;
			}
			var passwordConfirm  =  $("#passwordConfirm").val();
			var password = $("#password").val();
			if(passwordConfirm != password){
				$("#passwordInfo").text("两次密码不一致");
				return false;
			}
			return true;
		}
		function login(){
			window.location.href = "${pageContext.request.contextPath}/blogs/loginA";
		}
	</script>
</body>
</html>