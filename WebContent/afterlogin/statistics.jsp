<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>The Statistics</title>
<meta charset="utf-8">
<style type="text/css">
* {
	height: 100%;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/outerjs/echarts.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/afterlogin/css/normalize.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/afterlogin/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Mono:300,500,700"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/afterlogin/css2/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/afterlogin/css2/demo.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/outerjs/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="container-fluid">
		<nav class="menu-activea">
		<h1>MENU</h1>
		<ul>
			<li>条形图</li>
			<li>柱状图</li>
		</ul>
		</nav>
		<div class="statistics"></div>
		<div class="statistics2"></div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/myjs/statistics.js"></script>
</body>
</html>