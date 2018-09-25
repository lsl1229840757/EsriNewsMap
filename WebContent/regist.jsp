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

<title>CartoNewsRegist</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="particles/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="particles/css/default.css">
<link rel="stylesheet" media="screen" href="particles/css/style.css">
<script src="particles/js/particles.js"></script>
<script type="text/javascript" src="outerjs/jquery-3.3.1.js"></script>
<script type="text/javascript" src="myjs/validate.js"></script>
<script type="text/javascript" src="outerjs/MD5.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="mycss/regist.css">

</head>
<body id="particles-js">
	<div class="register-container container">
		<div class="row">
			<div class="register span6">
				<form action="pict/regist.action" method="post">
					<h2>
						JOIN <span class="red"><strong>US</strong></span>
					</h2>
					<div class="form-group has-feedback">
						<label class="userLabel">用户名</label> <input type="text"
							class="form-control"  AUTOCOMPLETE="off" name="user.username" id="username"
							placeholder="用户名" />
						<div class="error_sty">
							<label id="userblank">${fieldErrors.username[0] }</label>
						</div>
					</div>
					<div class="form-group has-feedback">
						<label class="nickLabel">昵称</label> <input type="text"
							class="form-control" name="user.name" AUTOCOMPLETE="off" id="name" placeholder="昵称" />
						<div class="error_sty">
							<label id="nameblank">${fieldErrors.name[0] }</label>
						</div>
					</div>
					<div class="form-group has-feedback">
						<label class="ageLabel">年龄</label> <input type="text"
							class="form-control" name="age" AUTOCOMPLETE="off" id="age" placeholder="年龄"
							maxlength="3" />
						<div class="error_sty">
							<label id="ageblank">${fieldErrors.age[0] }</label>
						</div>
					</div>
					<div class="form-group has-feedback">
						<div style="width: 15px; margin-left: 20px;">
							<select name="user.gender" id="gender">
								<option value="男">男
								<option value="女">女
							</select>
						</div>
					</div>
					<div class="form-group has-feedback">
						<label class="pwdLabel">密码</label> <input type="password"
							class="form-control" name="password" id="pwd" AUTOCOMPLETE="off" placeholder="密码" />
						<div class="error_sty">
							<label id="pwdblank">${fieldErrors.password[0] }</label>
						</div>
						<div class="pwdStrongth">
							<span class="cinnerprogress" id="innerprogress"></span>
						</div>
						<font id="strongthTip"></font>
					</div>
					<div class="form-group has-feedback">
						<label class="pwdsureLabel">确认密码</label> <input AUTOCOMPLETE="off" type="password"
							class="form-control" name="password2" id="pwd2"
							placeholder="确认密码" />
						<div class="error_sty">
							<label id="pwdblank2">${fieldErrors.password2[0] }</label>
						</div>
					</div>
					<div class="form-group has-feedback">
						<label class="checkLabel">验证码</label> <input type="text"
							class="form-control" name="checkCode" AUTOCOMPLETE="off" id="checkCode"
							placeholder="验证码" maxlength="4">
						<div align="left" style="margin-left: 15px;">
							<img src="pict/draw.action" id="image" alt="验证码" /> <a
								class="changeimage" onclick="refresh()"
								href="javascript:void(0)">看不清，换一张</a>
						</div>
						<div class="error_sty">
							<label id="identblank">${fieldErrors.checkCode[0] }</label>
						</div>
					</div>
					<div class="form-group has-feedback">
						<input type="submit" class="btn btn-success" value=立即注册 id="sub" />
						<br> <br> <a href="pict/LoginPage"
							class="btn btn-primary btn-lg active btn-sm glyphicon glyphicon-link"
							role="button">已有账号？立即登录</a> <br> <span id="msg"></span>
						<div class="error_sty">
							<label id="subblank"></label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="myjs/regist.js"></script>

</body>

</html>

