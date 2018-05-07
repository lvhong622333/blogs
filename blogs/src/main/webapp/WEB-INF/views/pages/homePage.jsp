<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<link href="${pageContext.request.contextPath}/static/image/main1.jpg"
	rel="icon" type="image/x-icon" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<title>博客功能主页</title>
</head>
<body style="width: 1200px; margin: 10px auto;">
	<ul style="text-align: right;">
		<span>欢迎您 <shiro:user>
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<shiro:principal
					property="userName" />!
				</shiro:user>
		</span> &nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/blogs/logout"> 注销 </a>
	</ul>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab"> 全文检索 </a></li>
		<li><a href="#ios" data-toggle="tab">爬虫</a></li>
		<li><a href="#log" data-toggle="tab">日志监控</a></li>
		<li><a href="#workflowTask" data-toggle="tab">流程任务</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">
			<p>菜鸟教程是一个提供最新的web技术站点，本站免费提供了建站相关的技术文档，帮助广大web技术爱好者快速入门并建立自己的网站。菜鸟先飞早入行——学的不仅是技术，更是梦想。</p>
		</div>
		<div class="tab-pane fade" id="ios">
			<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和
				Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
		</div>
		<div class="tab-pane fade" id="log">
			<p>日志监控</p>
		</div>
		<div class="tab-pane fade" id="workflowTask">
			<jsp:include page="workflowStart.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>