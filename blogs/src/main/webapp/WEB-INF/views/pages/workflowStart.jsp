<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*"%>
<!DOCTYPE html/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<title>工作流启动页面</title>
<link href="${pageContext.request.contextPath}/static/image/main1.jpg"
	rel="icon" type="image/x-icon" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/customJs/customJs.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript">
	function submit() {
		var msg = $("#msg").val();
		$.get("${pageContext.request.contextPath}/workflows/startTask?msg="
				+ msg, function(data, status) {
			$.MsgBox.Alert("提示", data);
		});
	}
	function save() {

	}
	$(function() {
		$.get("${pageContext.request.contextPath}/workflows/findTaskList",function(data, status) {
				var str = $("#nowTask");
				str.append("<table>");
				str.append("<tr><td style='width:40px;'>序号</td><td style='width:120px;' >任务名称</td><td style='width:120px;'>任务执行人</td><td style='width:240px;'>执行时间</td></tr>");
				for(var i = 1 ; i <= data.length ; i++){
					str.append("<tr><td>" + i + "</td><td >" + data[i].taskName + "</td><td>" + data[i].owner + "</td><td>" + data[i].createTime + "</td></tr>");
				}
				str.append("</table>");
		});
		$.get("${pageContext.request.contextPath}/workflows/findHistoryTaskList",function(data, status) {				
			var str = $("#historyTask");
			str.append("<table>");
			str.append("<tr><td style='width:40px;'>序号</td><td style='width:120px;' >任务名称</td><td style='width:120px;'>任务执行人</td><td style='width:240px;'>执行时间</td></tr>");
			if(data != null){				
				for(var i = 1 ; i <= data.length ; i++){
					str.append("<tr><td>" + i + "</td><td >" + data[i].taskName + "</td><td>" + data[i].owner + "</td><td>" + data[i].createTime + "</td></tr>");
				}
			}
			str.append("</table>");
		});
	}) 
	
</script>
</head>
<body>
	<div>
		<div>
			<span>流程发起说明</span>&nbsp;&nbsp;&nbsp; <span><textarea
					style="width: 400px; height: 200px;" id="msg"></textarea></span>
		</div>
		<div>
			<input type="button" value="提交" onclick="submit()" /> <input
				type="button" value="保存" onclick="save()" />
		</div>
	</div>
	<div>当前执行任务</div>
	<div id="nowTask"></div>
	<div>任务流转记录</div>
	<div id="historyTask"></div>
</body>
</html>