<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息界面</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
<style type="text/css">
.welcome{
	font-size:30px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="welcome text-primary">${sessionScope.msg } 欢迎进入新闻地图</div>
		用户名:<p class="muted">${sessionScope.user.username }</p>
		昵称:<p class="text-info">${sessionScope.user.name }</p>
		年龄:<p class="muted">${sessionScope.user.age }</p>
		性别:<p class="muted">${sessionScope.user.gender }</p>
		<a href="../esri/enterchange.action" class="btn btn-primary btn-lg active btn-sm glyphicon glyphicon-link" role="button">修改信息</a>
		<a href="../esri/map.action" class="btn btn-primary btn-lg active btn-sm glyphicon glyphicon-link" role="button">查看新闻</a>
	</div>
	
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>