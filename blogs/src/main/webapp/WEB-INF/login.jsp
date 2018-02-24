<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/image/main1.jpg" rel="icon" type="image/x-icon" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<style type="text/css">
	form{
		margin-left: 400px;
		margin-top: 300px;
	}
</style>
<title>登陆页面</title>
</head>
<body background="${pageContext.request.contextPath}/static/image/main2.jpg">
	<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/blogs/login">
		<div class="form-group">
			<label for="name" class="col-md-2 control-label" style="color: white;">用户名</label>
			<div class="col-md-4">
				<input type="text" class="form-control" name="userName" placeholder="注册账号或者手机号码">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-2 control-label" style="color: white;">密码</label>
			<div class="col-md-4">
				<input type="password" class="form-control" name="password" placeholder="请输入姓">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-4">
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberMe" value="1"><font color="white">请记住我</font>
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<button type="submit" class="btn btn-default">登录</button>
				<button type="reset" class="btn btn-default">重置</button>
				<button type="button" class="btn btn-default" onclick="register()">注册</button>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<font color="red">
					${message}
				</font>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function register(){
		window.location.href="${pageContext.request.contextPath}/blogs/registerA";
	}
</script>
</html>