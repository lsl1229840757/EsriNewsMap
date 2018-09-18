$(function() {
	var dom = document.getElementById("analysis");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	$.getJSON('../esri/exe.action', function(data) {
		myChart.setOption(option = {
			title : {
				text : '新闻展示'
			},
			tooltip : {
				trigger : 'axis'
			},
			xAxis : {
				data : data.map(function(item) {
					for ( var i in item) {
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
				name : 'Beijing AQI',
				type : 'line',
				data : data.map(function(item) {
					for ( var i in item) {
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
