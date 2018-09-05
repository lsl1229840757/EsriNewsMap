<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://js.arcgis.com/4.8/esri/css/main.css">
  <script src="https://js.arcgis.com/4.8/"></script>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<style type="text/css">
	html, body, #viewDiv {
		padding: 0;
		margin: 0;
		height: 100%;
		width: 100%;
	}
</style>
<script>
  require([
      "esri/Map",
      "esri/views/SceneView",
      "esri/layers/GraphicsLayer",
      "esri/Graphic", 
      
      "dojo/domReady!"
    ], function(Map,SceneView,GraphicsLayer, Graphic){
    		var map = new Map({
    	        basemap: "hybrid"
    	      });

           	var view = new SceneView({
             container: "viewDiv",
             map: map,
             environment: {
                 atmosphere: {
                   quality: "high"
                 },
                 lighting: {
                   directShadowsEnabled: true,
                   ambientOcclusionEnabled: true
                 }
               },
               scale: 18000000,          
               center: [117, 36]  
           	});
           	var graphicsLayer = new GraphicsLayer();
          	map.add(graphicsLayer);
			//初始化新闻
    		//第一次访问,这里使用ajax获取当天的全部新闻
		  	$.ajax({
		  		method : "POST",
		  		timeout : 5000,
		  		url : "esri/initiateNews",
		  		data :"pubDate="+new Date().getTime(),
		  		dataType : "json",
		  		contentType :'application/x-www-form-urlencoded; charset=UTF-8',
		  		async:true,
		  		success : function(data) {
		  			//这里的数据是jsonArray
		  			for(var i=0;i<data.length;i++){
		  				alert(data[i]);
		  				showNews(data[i]);
		  				
		  			}
		  		},
		  		error : function() {
		  			alert("${pageContext.request.contextPath}/esri/initiateNews");
		  			alert("Error XMLHttpRequest");
		  		}
		  	});
	      
  	//传入一个news的jsonObject
  	function showNews(news){
  			var point = {
  		        type: "point", 
  		        x: news.longitude,
  		        y: news.latitude,
  		      };

  		    var markerSymbol = {
  		    	//这里以后设置大小
  		        type: "simple-marker", 
  		        color: [226, 119, 40],
  		        outline: { 
  		          color: [255, 255, 255],
  		          width: 2
  		        }
  		      };

  		      //类似于Map
  		    var attribute = {
  		    		  标题: "<a href='"+news.webUrl+"' target=_blank>"+news.title+"</a>",
  		    		  关键字: news.keyWord,
  		    		  新闻来源:news.origin,
  		    		  时间:news.pubDate
  		      };
  		    var template = {
  		    		 title: news.title,
   		            content: [{
   		              type: "fields",
   		              fieldInfos: [{
   		                fieldName: "标题",
   		              }, {
   		                fieldName: "关键字"
   		              }, {
   		                fieldName: "新闻来源"
   		              }, {
   		                fieldName: "时间"
   		              }]
   		            }]
  		      };
  		    var pointGraphic = new Graphic({
  		        geometry: point,
  		        symbol: markerSymbol,
  		        attributes:attribute,
  		        popupTemplate:template
  		      });
  		    graphicsLayer.add(pointGraphic);
  	}
  		
    });
  </script>
</head>

<body>
  <div id="viewDiv"></div>
</body>
</html>