<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
*{
	height:100%;
}
</style>
</head>

<body>
	<div id="container"></div>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom,'dark');
			var app = {};
			option = null;
			$.getJSON('../esri/exe.action', function(data) {
				myChart.setOption(option = {
					title : {
						text : '新闻展示'
					},
					xAxis : {
						data :data.map(function(item) {
							for(var i in item){
							return i;
							}
						}),
					},
					yAxis : {
						splitLine : {
							show : false
						}
					},
					toolbox : {
						left : 'center',
						feature : {
							dataZoom : {
								yAxisIndex : 'none'
							},
							restore : {},
							saveAsImage : {}
						}
					},
					dataZoom : [ {
						startValue : '2018-09-01'
					}, {
						type : 'inside'
					} ],
					visualMap : {
						top : 10,
						right : 10,
						pieces : [ {
							gt : 0,
							lte : 10,
							color : '#096'
						}, {
							gt : 10,
							lte : 20,
							color : '#ffde33'
						}, {
							gt : 20,
							lte : 30,
							color : '#ff9933'
						}, {
							gt : 30,
							lte : 40,
							color : '#cc0033'
						}, {
							gt : 40,
							lte : 50,
							color : '#660099'
						}, {
							gt : 50,
							color : '#7e0023'
						} ],
						outOfRange : {
							color : '#999'
						}
					},
					series : {
						name : '新闻数目',
						type : 'line',
						data : data.map(function(item) {
							for(var i in item){
								return item[i];
								}
						}),
						markLine : {
							silent : true,
							data : [ {
								yAxis : 10
							}, {
								yAxis : 20
							}, {
								yAxis : 30
							}, {
								yAxis : 40
							}, {
								yAxis : 50
							} ]
						}
					}
				});
			});
			;
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		})
	</script>
</body>
</html>