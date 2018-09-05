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
<script src="particles/js/particles.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/MD5.js"></script>
<style type="text/css">
html {-apple-system ,"Helvetica Neue",Arial,"PingFang SC","Hiragino Sans
	GB",STHeiti,"Microsoft YaHei","Microsoft JhengHei","Source Han Sans
	SC","Noto Sans CJK SC","Source Han Sans CN","Noto Sans SC","Source Han
	Sans TC","Noto Sans CJK TC","WenQuanYi Micro Hei",SimSun,sans-serif
	
}
canvas{
	margin-top:100px;
}
* {
	font-style: 微软雅黑;
}

body {
	background-size: cover;
}

.container {
	width: 477px;
	height: 479px;
	margin: 0 auto;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -239px;
	margin-left: -238px;
	box-shadow: 0px 0px 40px #888888;
}

.form-group {
	max-width: 1000px;
	margin: 0 auto;
}

.col-xs-6 {
	max-width: 500px;
	width: 75%;
	margin: 0px 50px auto;
}

.col-xs-6 .form-control {
	position: relative;
	font-size: 14px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.col-xs-6 .form-control:focus {
	z-index: 2;
}

.welcome {
	font-size: 25px;
	margin: 0 auto;
	margin-bottom: 60px;
	padding-top: 30px;
	width: 200px;
}

.col-xs-6 input[type="text"] {
	margin-bottom: 14px;
	border-radius: 0;
	background: url(images/login_user.png) 0 0 #1c1d1d no-repeat;
	padding-left: 60px;
	color: #895b52;
}

.col-xs-6 input[type="password"] {
	margin-bottom: 10px;
	border-radius: 0;
	background: url(images/login_pas.png) 0 0 #1c1d1d no-repeat;
	padding-left: 60px;
	color: #895b52;
}

.error_sty {
	color: #ff5b5b;
	font-size: 14px;
	line-height: 18px;
	overflow: hidden;
	position: relative;
	bottom: 0;
}
</style>

<script type="text/javascript">
	$(function() {
		particlesJS('particles-js', {
			particles : {
				color : '#fff',
				shape : 'edge', // "circle", "edge" or "triangle"
				opacity : 1,
				size : 4,
				size_random : true,
				nb : 150,
				line_linked : {
					enable_auto : true,
					distance : 100,
					color : '#fff',
					opacity : 1,
					width : 1,
					condensed_mode : {
						enable : false,
						rotateX : 600,
						rotateY : 600
					}
				},
				anim : {
					enable : true,
					speed : 1
				}
			},
			interactivity : {
				enable : true,
				mouse : {
					distance : 300
				},
				detect_on : 'canvas', // "canvas" or "window"
				mode : 'grab',
				line_linked : {
					opacity : .5
				},
				events : {
					onclick : {
						enable : true,
						mode : 'push', // "push" or "remove"
						nb : 4
					}
				}
			},
			/* Retina Display Support */
			retina_detect : true
		});
		$("input[id=username]").blur(
				function() {
					validateInput('username', 'userblank', 'input_sty') ? $(
							this).data({
						's' : 1
					}) : $(this).data({
						's' : 0
					});
				});
		$("input[id=pwd]").blur(function() {
			validateInput('pwd', 'pwdblank', 'input_sty2') ? $(this).data({
				's' : 1
			}) : $(this).data({
				's' : 0
			});
		});
		$("input[id=checkCode]").blur(
				function() {
					if (checkCode()
							&& validateInput('checkCode', 'identblank',
									'checkLabel')) {
						$(this).data({
							's' : 1
						});
					} else {
						$(this).data({
							's' : 0
						});
					}
				});
		$("input[id=username]").keyup(
				function() {
					validateInput('username', 'userblank', 'input_sty') ? $(
							this).data({
						's' : 1
					}) : $(this).data({
						's' : 0
					});
				});
		$("input[id=pwd]").keyup(function() {
			validateInput('pwd', 'pwdblank', 'input_sty2') ? $(this).data({
				's' : 1
			}) : $(this).data({
				's' : 0
			});
		});

		$("form").submit(function() {
			$(".form-control").blur();
			result = 0;
			$(".form-control").each(function() {
				result += $(this).data('s');
			});
			alert(result);
			if (result != 3) {
				$("#msg").html("<font color='red'>请检查登录信息是否完善!</font>");
				return false;
			}
			$("#pwd").val(md5($("#pwd").val()));

		});
		$(".input_sty,.input_sty2,.checkLabel").hide();
		/*$("#sub").click(function(){
			alert("登录...");
			if(validateInput('username','userblank','input_sty')&&validateInput('pwd','pwdblank','input_sty2')&&validateInput('checkCode','identblank','input_sty3')){
				$("#pwd").val(md5($("#pwd").val()));
				$("#loginForm").submit();			
			}else{
				$("#msg").html("<font color='red'>请检查登录信息是否完善!</font>");
			}
		});*/

	});
</script>

</head>
<body>
	<div id="particles-js" style="height: 100%; width: 100%">
		<div class="container">
			<div class="welcome text-primary">欢迎登录新闻地图</div>
			<form action="pict/login" method="post" name="loginForm"
				class="col-xs-6" id="loginForm">
				<div class="form-group has-feedback">
					<label class="input_sty">用户名</label> <input type="text"
						class="form-control" name="user.username" id="username"
						placeholder="用户名" />
					<div class="error_sty">
						<label id="userblank">${fieldErrors.username[0] }</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<label class="input_sty2">密码</label> <input type="password"
						class="form-control" name="user.password" id="pwd"
						placeholder="密码" />
					<div class="error_sty">
						<label id="pwdblank">${fieldErrors.password[0] }</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<label class="checkLabel">验证码</label> <input type="text"
						class="form-control" name="checkCode" id="checkCode" maxlength="4"
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
</body>
</html>

