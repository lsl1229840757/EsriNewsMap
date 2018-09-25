<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Go It!</title>
<script type="text/javascript" src="outerjs/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="mycss/index.css">
<script type="text/javascript">
	$(function() {
		$("#EnterSpan").click(function() {
			window.location = "${pageContext.request.contextPath}/pict/LoginPage"
		});
		var obj = document.getElementById("Enter");
		var clientWidth = document.documentElement.clientWidth;
		var clientHeight = document.documentElement.clientHeight;
		var objWidth = obj.offsetWidth;
		var objHeight = obj.offsetHeight;
		var x = (clientWidth - objWidth) / 2;
		var y = (clientHeight - objHeight) / 2;
		obj.style.position = "absolute";
		obj.style.left = x + "px";
		obj.style.top = y + "px";
	});
</script>
</head>
<body>
	<div id="container">
		<div class="enter" id="Enter">
			<span style="font-family: but; color: white" id="EnterSpan">CartoNews</span>
		</div>
		<canvas id="canvas"></canvas>
	</div>
	<script type="text/javascript" src="myjs/index.js"></script>
</body>
</html>