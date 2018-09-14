<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>柱状图</title>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<style type="text/css">
body {
	background: #000;
}

.axis path, .axis line {
	fill: none;
	stroke: #00CED1;
	stroke-width: 1;
	shape-rendering: crispEdges;
}

.stroke_width {
	stroke-width: 0.3vmin;
}
</style>
<script>
	
</script>
</head>
<body>
	<div class="container">
		<div id="lineChart" width="1000" height="500"></div>
	</div>
	
	<script type="text/javascript" src="js/lineChart.js"></script>
</body>
</html>