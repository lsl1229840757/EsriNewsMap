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
var dom = $('.statistics')
var myChart = echarts.init(dom[0], 'dark');
var app = {};
option = null;
$.getJSON('../esri/exe.action', function(data) {
	myChart.setOption(option = {
		title : {},
		tooltip : {
			trigger : 'axis',
			position : function(p) { // 其中p为当前鼠标的位置
				return [ p[0] + 10, p[1] - 10 ];
			},
			axisPointer : {
				type : 'cross',
				label : {
					backgroundColor : '#283b56'
				}
			},
			extraCssText : 'width:160px;height:60px;background:#272626a6'
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
			name : '新闻数目',
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

var dom2 = $(".statistics2");
var myChart2 = echarts.init(dom2[0], 'dark');
option = null;
$.getJSON('../esri/exe.action', function(data) {
	myChart2.setOption(option = {
		title : {

		},
		tooltip : {
			position : function(p) { // 其中p为当前鼠标的位置
				return [ p[0] + 10, p[1] - 10 ];
			},
			axisPointer : {
				type : 'cross',
				label : {
					backgroundColor : '#283b56'
				}
			},
			extraCssText : 'width:160px;height:60px;background:#272626a6'
		},
		xAxis : {
			data : data.map(function(item) {
				for ( var i in item) {
					return i;
				}
			}),
			axisLabel : {
				inside : true,
				textStyle : {
					color : '#fff'
				}
			},
			axisTick : {
				show : false
			},
			axisLine : {
				show : false
			},
			z : 10
		},
		yAxis : {
			axisLine : {
				show : false
			},
			axisTick : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#999'
				}
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
			type : 'inside'
		} ],
		series : [ {
			name : '新闻数目',
			type : 'bar',
			itemStyle : {
				normal : {
					color : '#c71e1ebd'
				},
				emphasis : {
					color : '#c71e1ebd'

				}
			},
			data : data.map(function(item) {
				for ( var i in item) {
					return item[i];
				}
			}),
		} ]
	})
})
// Enable data zoom when user click bar.
var zoomSize = 6;
myChart2.on('click', function(params) {
	console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
	myChart2.dispatchAction({
		type : 'dataZoom',
		startValue : dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
		endValue : dataAxis[Math.min(params.dataIndex + zoomSize / 2,
				data.length - 1)]
	});
});
if (option && typeof option === "object") {
	myChart2.setOption(option, true);
}
$('.statistics2').hide();
$('ul li').click(function() {
	idx = $(this).index('ul li');
	if (idx == 0) {
		$('.statistics').show();
		$('.statistics2').hide();
	} else {
		$('.statistics2').show();
		$('.statistics').hide();
	}
})