<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		var dom = $(".container");
		var myChart = echarts.init(dom[0],'dark');
		var app = {};
		option = null;
		var data2 = new Array(10);
		var yMax = 100;
		var dataShadow = [];
		
		for (var i = 0; i < data2.length; i++) {
		    dataShadow.push(yMax);
		}
		$.getJSON('../esri/exe.action', function(data) {
			myChart.setOption(option = {
					title: {
				        text: '特性示例：渐变色 阴影 点击缩放',
				        subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
				    },
				  
				    xAxis: {
				        data:data.map(function(item) {
							for(var i in item){
								return i;
							}
				        }),
				        axisLabel: {
				            inside: true,
				            textStyle: {
				                color: '#fff'
				            }
				        },
				        axisTick: {
				            show: false
				        },
				        axisLine: {
				            show: false
				        },
				        z: 10
				    },
				    yAxis: {
				        axisLine: {
				            show: false
				        },
				        axisTick: {
				            show: false
				        },
				        axisLabel: {
				            textStyle: {
				                color: '#999'
				            }
				        }
				    },
				    dataZoom: [
				        {
				            type: 'inside'
				        }
				    ],
				    series: [
				        { // For shadow
				            type: 'bar',
				            itemStyle: {
				                normal: {color: 'rgba(0,0,0,0.05)'}
				            },
				            barGap:'-100%',
				            barCategoryGap:'40%',
				            data: dataShadow,
				            animation: false
				        },
				        {
				            type: 'bar',
				            itemStyle: {
				                normal: {
				                    color:'#c71e1ebd'
				                },
				                emphasis: {
				                    color: '#c71e1ebd'
				                        
				                }
				            },
				            data: data.map(function(item) {
								for(var i in item){
									return item[i];
								}
							}),
				        }
				    ]
			})
		})
		// Enable data zoom when user click bar.
		var zoomSize = 6;
		myChart.on('click', function (params) {
		    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
		    myChart.dispatchAction({
		        type: 'dataZoom',
		        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
		        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
		    });
		});;
		if (option && typeof option === "object") {
		    myChart.setOption(option, true);
		}
	})
</script>
<style type="text/css">
	*{
		height:100%;
	}
	
	.container{
		width:100%;
		height:100%;
	}
</style>
</head>

<body>
	<div class="container">
		
	</div>
</body>
</html>