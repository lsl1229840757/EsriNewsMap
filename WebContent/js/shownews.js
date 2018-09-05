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
		  		url : "../esri/initiateNews",
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
		  			alert("error");
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