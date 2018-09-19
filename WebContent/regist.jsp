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

<title>新闻地图注册</title>
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
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/MD5.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="regist/css/style.css">
<style type="text/css">
/*用于修饰密码强度条外边框div*/
.pwdStrongth {
	border: 1px solid hsla(0, 0%, 100%, 1);
	border-radius: 5px;
	height: 15px;
	width: 200px;
	margin-left: 15px;
}
/*用于设置span标签的初始样式*/
.cinnerprogress {
	display: block;
	height: 100%;
	background-color: transparent;
	border-radius: 5px;
	width: 100%;
}
/*下面四个将用于设置span标签在不同密码强度的样式*/
.strengthLv1 {
	display: block;
	height: 100%;
	border-radius: 5px;
	background: red;
	width: 25%;
}

.strengthLv2 {
	display: block;
	height: 100%;
	border-radius: 5px;
	background: orange;
	width: 50%;
}

.strengthLv3 {
	display: block;
	height: 100%;
	border-radius: 5px;
	background: #09F;
	width: 75%;
}

.strengthLv4 {
	display: block;
	height: 100%;
	border-radius: 5px;
	background: green;
	width: 100%;
}

.error_sty {
	color: #ff5b5b;
	font-size: 14px;
	line-height: 18px;
	overflow: hidden;
	position: relative;
	text-align: left;
	bottom: 0;
	margin-left: 20px;
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
		/*
		    Background slideshow
		 */
		$("input[id=username]").blur(
				function() {
					if (checkusername()
							&& validateInput('username', 'userblank',
									'userLabel')) {
						$(this).data({
							's' : 1
						});
					} else {
						$(this).data({
							's' : 0
						});
					}
				});
		$("input[id=pwd]").blur(function() {
			if (pwdComplex() && validateInput('pwd', 'pwdblank', 'pwdLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});
		$("input[id=pwd2]").blur(
				function() {
					if (checkrepassword()
							&& validateInput('pwd2', 'pwdblank2',
									'pwdsureLabel')) {
						$(this).data({
							's' : 1
						});
					} else {
						$(this).data({
							's' : 0
						});
					}
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
		$("input[id=name]").blur(function() {
			validateInput('name', 'nameblank', 'nickLabel') ? $(this).data({
				's' : 1
			}) : $(this).data({
				's' : 0
			});
		});
		$("input[id=age]").blur(
				function() {
					if (validateAge('age', 'ageblank')
							&& validateInput('age', 'ageblank', 'ageLabel')) {
						$(this).data({
							's' : 1
						});
					} else {
						$(this).data({
							's' : 0
						});
					}
				});

		$("input[id=pwd]").keyup(function() {
			if (pwdComplex() && validateInput('pwd', 'pwdblank', 'pwdLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});

		$("input[id=name]").keyup(function() {
			validateInput('name', 'nameblank', 'nickLabel') ? $(this).data({
				's' : 1
			}) : $(this).data({
				's' : 0
			});
		});
		$("input[id=age]").keyup(function() {
			if (validateAge() && validateInput('age', 'ageblank', 'ageLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});
		$("form").submit(function() {
			$(".form-control").blur();
			result = 0;
			$(".form-control").each(function() {
				alert($(this).data('s'));
				result += $(this).data('s');
			});
			if (result != 6) {
				$("#msg").html("<font color='red'>请确认用户信息是否全部正确填写!</font>");
				return false;
			}
			$("#pwd").val(md5($("#pwd").val()));
			$("#pwd2").val(md5($("#pwd2").val()));

		});
		$(".userLabel,.checkLabel,.ageLabel,.pwdLabel,.nickLabel,.pwdsureLabel")
				.hide();
	});
</script>
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

	<!-- Javascript -->


</body>

</html>

