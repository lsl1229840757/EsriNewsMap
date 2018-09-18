<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
	href="${pageContext.request.contextPath }/css/star.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/shownews.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zdialog/zDrag.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zdialog/zDialog.js"></script>
<script type="text/javascript">
var diag = null;
function d_close(){
	diag.close();
	window.location = "${pageContext.request.contextPath }/esri/homePage.action"
}
$(function() {
$("#changeInformation").click(function(){
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
	.info{
		font-size: 25px;
		color: white;
		margin-bottom: 10px;
	}
	
</style>
</head>
<body>

	<canvas id="canvas"> </canvas>
	<div class="container">
		<nav class="menu-activea">
		<h1>MENU</h1>
		<ul>
			<li>个人信息</li>
			<li>新闻地图</li>
		</ul>
		</nav>

		<div id="personinfo" class="right">
			<div class="welcome text-primary">${sessionScope.msg }欢迎进入新闻地图</div>

			<div id="username" class="info">
				用户名:
				<u><span class="muted">${sessionScope.user.username }</span></u>
			</div>
			<div id="name" class="info">
				昵称:
				<u><span>${sessionScope.user.name }</span></u>
			</div>
			<div id="age" class="info">
				年龄:
				<u><span>${sessionScope.user.age }</span></u>
			</div>
			<div id="gender" class="info">
				性别:
				<u><span>${sessionScope.user.gender }</span></u>
			</div>
			<a href="javascript:void(0);"
				class="btn btn-primary active glyphicon glyphicon-link"
				role="button" id="changeInformation">修改信息</a> <a href="../esri/statistics"
				class="btn btn-success" role="button" target="_blank">新闻数据统计</a>
				<a href="../esri/waterfall"
				class="btn btn-success" role="button" target="_blank">瀑布流展示新闻</a>
		</div>

		<div id="viewDiv" class="right"></div>
	</div>
	<script src="${pageContext.request.contextPath }/js/star.js"></script>
</body>
</html>