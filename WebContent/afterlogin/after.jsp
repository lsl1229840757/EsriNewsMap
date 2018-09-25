<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome To CartoNews</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/afterlogin/css/normalize.css" />
<script src="https://js.arcgis.com/4.8/"></script>
<script type="text/javascript">
	var path = "${pageContext.request.contextPath }"
</script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/afterlogin/css/style.css">
<link rel="stylesheet"
	href="https://js.arcgis.com/4.8/esri/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/starbgcss/star.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/outerjs/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/myjs/shownews.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zdialog/zDrag.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zdialog/zDialog.js"></script>
<script type="text/javascript">
	var diag = null;
	function d_close() {
		diag.close();
		window.location = "${pageContext.request.contextPath }/esri/homePage.action"
	}
	$(function() {
		var iWidth = $('#personinfo').width(); //弹出窗口的宽度;
		var iHeight = $('#personinfo').height(); //弹出窗口的高度;
		var iTop = (document.documentElement.clientHeight - iHeight) / 2
		var iLeft = (document.documentElement.clientWidth - iWidth) / 2
		$("#personinfo").css('position', 'absolute').css("top", iTop).css(
				"left", iLeft)

		$("#changeInformation")
				.click(
						function() {
							diag = new Dialog();
							diag.Width = 600;
							diag.Height = 480;
							diag.Title = "用户信息修改";
							diag.URL = "${pageContext.request.contextPath }/esri/enterchange.action";
							diag.show();
						});

		var nav = $('nav'), menu = $('nav h1'), main = $('main'), open = false, hover = false;
		menu.on('click', function() {
			open = !open ? true : false;
			nav.toggleClass('menu-active');
			main.toggleClass('menu-active');
			nav.removeClass('menu-hover');
			main.removeClass('menu-hover');
			console.log(open);
		});
		menu.hover(function() {
			if (!open) {
				nav.addClass('menu-hover');
				main.addClass('menu-hover');
			}
		}, function() {
			nav.removeClass('menu-hover');
			main.removeClass('menu-hover');
		});
		$('.right:eq(1)').hide();
		$('ul li').click(function() {
			idx = $(this).index('ul li');
			$('.right').eq(idx).show();
			$('.right').not($('.right').eq(idx)).hide();
			if (idx == 1) {
				$('#canvas').hide();
			} else {
				$('#canvas').show();
			}
		})
	});
</script>
<style type="text/css">
*{
	font-family: Consolas;
}
.info {
	font-size: 18px;
	color: white;
	margin-bottom: 40px;
}

.fieldname {
	margin-right: 20px;
}

#personinfo {
	width: 500px;
	height: 500px;
	z-index: 10;
	border: 2px solid;
	border-radius: 25px;
	-moz-border-radius: 25px;
	padding-top:70px;
	padding-left: 90px;
	box-shadow: 0px 1px 5px 5px #888888;
}
</style>
</head>
<body>

	<canvas id="canvas"></canvas>
	<div class="container">
		<nav class="menu-activea">
		<h1>MENU</h1>
		<ul>
			<li>个人信息</li>
			<li>新闻地图</li>
		</ul>
		</nav>

		<div id="personinfo" class="right">
			<div class="welcome text-info">
				<b>${sessionScope.msg }欢迎进入新闻地图</b>
			</div>

			<div id="username" class="info">
				<span class="fieldname">用户名:</span> <span class="text-muted"><b>${sessionScope.user.username }</b></span>
			</div>
			<div id="name" class="info">
				<span class="fieldname">昵称:</span><b><span class="text-info">${sessionScope.user.name }</span></b>
			</div>
			<div id="age" class="info">
				<span class="fieldname">年龄:</span><b><span class="text-muted">${sessionScope.user.age }</span></b>
			</div>
			<div id="gender" class="info">
				<span class="fieldname">性别:</span> <b><span class="text-muted">${sessionScope.user.gender }</span></b>
			</div>
			<a href="javascript:void(0);"
				class="btn btn-primary active glyphicon glyphicon-link btn-sm"
				role="button" id="changeInformation"><b>修改信息</b></a>&emsp; <a
				href="../esri/statistics" class="btn btn-success btn-sm"
				role="button" target="_blank"><b>新闻数据统计<b></b></a>&emsp; <a href="../esri/waterfall"
				class="btn btn-info btn-sm" role="button" target="_blank"><b>瀑布流展示新闻</b></a>
		</div>

		<div id="viewDiv" class="right"></div>
	</div>
	<script src="${pageContext.request.contextPath }/myjs/star.js"></script>
</body>
</html>