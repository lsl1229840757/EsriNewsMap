<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/afterlogin/css/normalize.css" />
<script src="https://js.arcgis.com/4.8/"></script>
<!--CSS RESET-->

<link rel="stylesheet" href="${pageContext.request.contextPath }/afterlogin/css/style.css">
<link rel="stylesheet"
	href="https://js.arcgis.com/4.8/esri/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/star.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/shownews.js"></script>
<script type="text/javascript">
	$(function() {
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
		$('.right:eq(2)').hide();
		$('ul li').click(function() {
			idx = $(this).index('ul li');
			$('.right').eq(idx).show();
			
			$('.right').not($('.right').eq(idx)).hide();
			if(idx==1){
				$('#canvas').hide();
			}else{
				$('#canvas').show();
			}
		})
	});
</script>
</head>
<body>

	<canvas id="canvas">
	</canvas>
	<div class="container">
		<nav class="menu-activea">
		<h1>MENU</h1>
		<ul>
			<li>个人信息</li>
			<li>新闻地图</li>
			<li>数据分析</li>
		</ul>
		</nav>
		
		<div id="personinfo" class="right">
			<div class="welcome text-primary">${sessionScope.msg }欢迎进入新闻地图</div>
			用户名:
			<p class="muted">${sessionScope.user.username }</p>
			昵称:
			<p class="text-info">${sessionScope.user.name }</p>
			年龄:
			<p class="muted">${sessionScope.user.age }</p>
			性别:
			<p class="muted">${sessionScope.user.gender }</p>
			<a href="../esri/enterchange.action"
				class="btn btn-primary btn-lg active btn-sm glyphicon glyphicon-link"
				role="button">修改信息</a>
		</div>

		<div id="viewDiv" class="right">
		
		</div>

		<div id="analysis" class="right">
			<h1>xxxxxxxxxxxx</h1>
		</div>

	</div>
	<script src="${pageContext.request.contextPath }/js/star.js"></script>
</body>
</html>