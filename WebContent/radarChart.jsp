<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图像</title>
<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>

<style>
body {
	overflow: hidden;
	margin: 0;
	font-size: 14px;
	font-family: "Helvetica Neue", Helvetica;
}

.axis path, .axis line {
	fill: none;
	stroke: #1E90FF;
	stroke-width: 1;
	shape-rendering: crispEdges;
}

#chart {
	position: absolute;
	top: 50px;
	left: 100px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="chart"></div>
	</div>
	<script type="text/javascript" src="js/radar-chart.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>