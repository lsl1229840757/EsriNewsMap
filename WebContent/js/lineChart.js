var border_color = "#708090";
// 用于填充的颜色
var fillcolor = "rgba(204, 238, 255, .1)";
var dotcolor = "#00CED1";
// 数据
var data = [ [ "2000-07-24", 202 ], [ "2000-07-25", 215 ],
		[ "2000-07-26", 179, ], [ "2000-07-27", 199 ], [ "2000-07-28", 134 ],
		[ "2000-07-29", 176 ], [ "2000-07-30", 134 ], [ "2000-07-31", 134 ] ];
//定义格式
var format = d3.time.format("%Y-%m-%d");
var width = 1000;
var height = 500;
//创建svg图形
var svg = d3.select("#lineChart").append('svg').attr("width", width).attr(
		"height", height);
var div02 = d3.select("#lineChart").append('div').attr("class", "tooltip02").style(
		"opacity", 0);
var margin = {
	top : 20,
	right : 25,
	bottom : 100,
	left : 60
};
width = width - margin.left - margin.right, height = height - margin.top
		- margin.bottom;
var mysvg = svg.append("g").attr("transform",
		"translate(" + margin.left + "," + margin.top + ")");
/*
定义比例尺，将x的范围区间映射到[ 0, width ]上,相当于定义域和值域。
domain() 和 range() 分别设定比例尺的定义域和值域
*/
var xscale = d3.time.scale().domain(
		[ format.parse(data[0][0]), format.parse(data[data.length - 1][0]) ])
		.range([ 0, width ]);
var xAxis = d3.svg.axis()
				.scale(xscale)	//设置比例尺
				.orient("bottom")	//标度位置
				.ticks(10)	//标度个数
				.tickFormat(d3.time.format("%Y-%m-%d"));	//格式化
//线性比例尺:linear()。
var yscale = d3.scale.linear().domain([ 0, d3.max(data, function(d) {
	return d[1]
}) * 1.3 ]).range([ height, 0 ]);

var yAxis = d3.svg.axis().scale(yscale).orient("left").ticks(10);

var line = d3.svg.line().x(function(d) {
	return xscale(format.parse(d[0]))
}).y(function(d) {
	return yscale(d[1])
}).interpolate("linear");

var area = d3.svg.area().x(function(d) {
	return xscale(format.parse(d[0]));
}).y0(height).y1(function(d) {
	return yscale(d[1]);
}).interpolate("linear");
//将x轴添加到svg图像之中
mysvg.append("g").attr("transform", "translate(0," + height + ")").attr(
		"class", "x_axis").style("fill", "#F0E68C")
		.style("font-size", "1em").call(xAxis).selectAll("text").attr(
				"transform", "rotate(-70)").style("text-anchor", "end");
//将y轴添加到svg图像之中
mysvg.append("g").attr("class", "y_axis").style("fill", "#F5DEB3").style(
		"font-size", "1.3em").call(yAxis);

var svg_path4 = mysvg.append('path').attr("d", line(data)).attr("fill", "none")
		.attr("stroke-width", "0.16em").attr("stroke", border_color);
do_animation(svg_path4);

svg_path5 = mysvg.append("path").datum(data).attr("d", area(data)).attr("fill",
		fillcolor).attr("stroke-width", "0");
function do_animation(path) {
	var totalLength = path.node().getTotalLength();
	path.attr("stroke-dasharray", totalLength + " " + totalLength).attr(
			"stroke-dashoffset", totalLength).transition().duration(2000).ease(
			"linear").attr("stroke-dashoffset", 0);
}
mysvg.selectAll("dot").data(data).enter().append("circle").attr("r", 2.5).attr(
		"cx", function(d) {
			return xscale(format.parse(d[0]));
		}).attr("cy", function(d) {
	return yscale(d[1]);
}).attr("fill", dotcolor).attr("stroke-width", "0").on(
		"mouseover",
		function(d, i) {
			div02.transition().duration(200).style("opacity", 1);
			div02.html(function() {
				return '<div style="color:#fff">' + d[1] + '</div>';
			}).style("left", (d3.event.pageX) + "px").style("top",
					(d3.event.pageY - 20) + "px");
			d3.select(this).attr("r", "6").attr("opacity", "0.8");
		}).on("mouseout", function(d, i) {
	div02.transition().duration(500).style("opacity", 0);
	d3.select(this).attr("r", "3").attr("opacity", "1.0");
});
