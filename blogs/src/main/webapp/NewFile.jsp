<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" />
 
<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.min.css" />
 
<script src="/js/jquery.js"></script>
 
<script src="/bootstrap/js/bootstrap.min.js"></script>
 
<style>
 #div1 {
	width: 600px;
	height: 500px
}
 
</style>
</head>
<body>
	 
	<div id="div1">
		 
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			 
			<!-- Indicators -->
			 
			<ol class="carousel-indicators">
				 
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>  
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				 
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				 
			</ol>
			   
			<!-- Wrapper for slides -->
			 
			<div class="carousel-inner" role="listbox">
				 
				<div class="item active">
					 <img src="/static/image/main1.jpg">  
				</div>
				 
				<div class="item">
					 <img src="/static/image/main2.jpg">  
				</div>
				 
				<div class="item">
					 <img src="/static/image/main3.jpg">  
				</div>
				 
			</div>
			   
			<!-- Controls -->
			 <a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev">  <span
				class="glyphicon glyphicon-chevron-left" id="aaron1"></span>  <span
				class="sr-only">Previous</span>  
			</a>  <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next">  <span
				class="glyphicon glyphicon-chevron-right" id="aaron2"></span>  <span
				class="sr-only">Next</span>  
			</a>  
		</div>
		 
	</div>
</body>
<html>