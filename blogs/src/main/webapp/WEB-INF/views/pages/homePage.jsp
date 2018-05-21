<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<title>博客功能展示</title>
	<link rel="icon" type="image/x-icon" href="http://f2.topitme.com/2/6a/bc/113109954583dbc6a2o.jpg">
</head>
	<frameset cols="200,*">
	  <frame src="${pageContext.request.contextPath}/catalog/page_dir">
	  <frameset rows="400,*">
	  	 <frame src="http://www.baidu.com" name="frame_name_new">
	  	 <frame src="${pageContext.request.contextPath}/catalog/frame_name" name="frame_name">
	  </frameset>
	</frameset>
</html>