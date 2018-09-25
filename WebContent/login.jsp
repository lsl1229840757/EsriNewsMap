<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新闻地图登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="particles/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="particles/css/default.css">
<link rel="stylesheet" media="screen" href="particles/css/style.css">
<link rel="stylesheet" href="mycss/login.css">
<script src="particles/js/particles.js"></script>
<script type="text/javascript" src="myjs/validate.js"></script>
<script type="text/javascript" src="outerjs/jquery-3.3.1.js"></script>
<script type="text/javascript" src="outerjs/MD5.js"></script>

</head>
<body>
	<div id="particles-js" style="height: 100%; width: 100%">
		<div class="container">
			<div class="welcome text-primary">欢迎登录新闻地图</div>
			<form action="pict/login" method="post" name="loginForm"
				class="col-xs-6" id="loginForm">
				<div class="form-group has-feedback">
					<label class="input_sty">用户名</label> <input type="text"
						class="form-control" AUTOCOMPLETE="off" name="user.username" id="username"
						placeholder="用户名" />
					<div class="error_sty">
						<label id="userblank">${fieldErrors.username[0] }</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<label class="input_sty2">密码</label> <input type="password"
						class="form-control" AUTOCOMPLETE="off" name="user.password" id="pwd"
						placeholder="密码" />
					<div class="error_sty">
						<label id="pwdblank">${fieldErrors.password[0] }</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<label class="checkLabel">验证码</label> <input type="text"
						class="form-control" name="checkCode" AUTOCOMPLETE="off" id="checkCode" maxlength="4"
						placeholder="验证码"> <img src="pict/draw.action" id="image"
						alt="验证码" /> <a class="changeimage" onclick="refresh()"
						href="javascript:void(0)">看不清，换一张</a>
					<div class="error_sty">
						<label id="identblank">${fieldErrors.checkCode[0] }</label>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-success" value=立即登录 id="sub" />
					<a href="pict/RegisterPage.action"
						class="btn btn-primary btn-lg active btn-sm glyphicon glyphicon-link"
						role="button">还没有账号？立即注册</a><br> <span id="msg"></span>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="myjs/login.js"></script>
</body>
</html>

