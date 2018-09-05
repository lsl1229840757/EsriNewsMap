	var width = 500, height = 500;
	var colorscale = d3.scale.category10();
	var LegendOptions = [ '亚洲', '非洲','欧洲','北美洲','南美洲','大洋洲','南极洲'];
	//各大洲数据，到时候用ajax传来
	var data = [ 
			[
				{axis:"过去24个小时数量",value:12},
				{axis:"f",value:777},
				{axis:"d",value:777}

			],
			[
				{axis:"过去24个小时数量",value:13},
				{axis:"f",value:888},
				{axis:"d",value:888}
			],
			[
				{axis:"过去24个小时数量",value:66},
				{axis:"f",value:999},
				{axis:"d",value:999}
			],
			[
				{axis:"过去24个小时数量",value:44},
				{axis:"f",value:222},
				{axis:"d",value:222}
			],
			[
				{axis:"过去24个小时数量",value:22},
				{axis:"f",value:111},
				{axis:"d",value:111}
			],
			[
				{axis:"过去24个小时数量",value:99},
				{axis:"f",value:333},
				{axis:"d",value:333}
			],
			[
				{axis:"过去24个小时数量",value:44},
				{axis:"f",value:444},
				{axis:"d",value:444}
			]
		 ];
	//绘图
	var mycfg = {
		w : width,
		h : height,
		maxValue: 0.6,
	    levels: 8,
	    ExtraWidthX: 300
	}


	RadarChart.draw("#chart", data, mycfg);
	var svg = d3.select('#container').selectAll('svg').append('svg').attr("width",
			width + 300).attr("height", height);
	var text = svg.append("text").attr("class", "title").attr('transform',
			'translate(90,0)').attr("x", width - 70).attr("y", 10).attr(
			"font-size", "12px").attr("fill", "#404040").text(
			"各大洲过去24个小时新闻数量");

	var legend = svg.append("g").attr("class", "legend").attr("height", 100)
			.attr("width", 200).attr('transform', 'translate(90,20)');
	legend.selectAll('rect').data(LegendOptions).enter().append("rect").attr(
			"x", width - 65).attr("y", function(d, i) {
		return i * 20;
	}).attr("width", 10).attr("height", 10).style("fill", function(d, i) {
		return colorscale(i);
	});
	
	legend.selectAll('text').data(LegendOptions).enter().append("text").attr(
			"x", width - 52).attr("y", function(d, i) {
		return i * 20 + 9;
	}).attr("font-size", "11px").attr("fill", "#737373").text(function(d) {
		return d;
	});