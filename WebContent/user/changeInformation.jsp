<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/outerjs/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/particles/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/particles/css/default.css">
<link rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath }/particles/css/style.css">
<link rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath }/mycss/changeInformation.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/myjs/validate.js"></script>
</head>
<body>
	<div id="particles-js" style="height: 100%; width: 100%">
		<div class="container">
			<form action="../esri/changeinfo.action" method="post"
				name="changeForm" class="col-xs-6" id="changeform">
				<div class="welcome text-primary">你好,${sessionScope.user.name }</div>
				<div class="form-group has-feedback">
					<label class="nickLabel">昵称</label> <span
						class="glyphicon glyphicon-tree-deciduous form-control-feedback"></span>
					<input AUTOCOMPLETE="off" type="text"
						value="${sessionScope.user.name }" class="form-control"
						name="user.name" id="name" placeholder="昵称" />
					<div class="error_sty">
						<label id="nameblank">${fieldErrors.name[0] }</label>
					</div>
				</div>

				<div class="form-group has-feedback">
					<label class="ageLabel">年龄</label> <span
						class="glyphicon glyphicon-chevron-left form-control-feedback"></span>
					<input AUTOCOMPLETE="off" type="text"
						value="${sessionScope.user.age }" class="form-control" name="age"
						id="age" placeholder="年龄" maxlength="3" />
					<div class="error_sty">
						<label id="ageblank">${fieldErrors.age[0] }</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<label class="genderLabel">性别</label></br>
					<div>
						<select name="user.gender" id="gender">
							<option value="男">男</option>
							<option value="女"
								${sessionScope.user.gender =='女'? 'selected':''}>女</option>
						</select>
					</div>
				</div>

				<div class="form-group has-feedback">
					<label class="checkLabel">验证码</label> <input AUTOCOMPLETE="off"
						type="text" class="form-control" name="checkCode" id="checkCode"
						maxlength="4" placeholder="验证码 "> <img
						src="../pict/draw.action" id="image" alt="验证码" /> <a
						class="changeimage" onclick="refresh()" href="javascript:void(0)">看不清，换一张</a>
					<div class="error_sty">
						<label id="identblank">${fieldErrors.checkCode[0] }</label>
					</div>

					<div class="form-group has-feedback">
						<input type="submit" value=立即修改 class="btn btn-success" id="sub" />
						<span id="msg"></span> <input type="reset" value=重置
							class="btn btn-default">
					</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/myjs/changeInformation.js"></script>
</body>
</html>