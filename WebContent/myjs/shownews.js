var colorarray = [[35,205,182,0.5],[142,229,213,0.5],[148,251,240,0.5],[192,247,252,0.5],[172,248,211,0.5],[230,228 ,192,0.5],[231,202,127,0.5],[255,215,187,0.5],[255,179,168,0.5],[255,76,108,0.5]]
function formatDate(time,format='YY-MM-DD hh:mm'){
    var date = new Date(time);

    var year = date.getFullYear(),
        month = date.getMonth()+1,//月份是从0开始的
        day = date.getDate(),
        hour = date.getHours(),
        min = date.getMinutes(),
        sec = date.getSeconds();
    var preArr = Array.apply(null,Array(10)).map(function(elem, index) {
        return '0'+index;
    });////开个长度为10的数组 格式为 00 01 02 03

    var newTime = format.replace(/YY/g,year)
                        .replace(/MM/g,preArr[month]||month)
                        .replace(/DD/g,preArr[day]||day)
                        .replace(/hh/g,preArr[hour]||hour)
                        .replace(/mm/g,preArr[min]||min)
                        .replace(/ss/g,preArr[sec]||sec);

    return newTime;         
}
require([
      "esri/Map",
      "esri/views/SceneView",
      "esri/layers/GraphicsLayer",
      "esri/Graphic", 
      "dojo/domReady!"
    ], function(Map,SceneView,GraphicsLayer, Graphic){
    		var map = new Map({
    	        basemap: "dark-gray"
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
               scale: 60000000,          
               center:  [117, 36]
           	});
           	var graphicsLayer = new GraphicsLayer();
          	map.add(graphicsLayer);
          	var tar = null;
			//初始化新闻
    		//第一次访问,这里使用ajax获取当天的全部新闻
		  	$.ajax({
		  		method : "POST",
		  		timeout : 5000,
		  		url : "../esri/initiateNews",
		  		data :"pubDate="+new Date().getTime(),
		  		dataType : "json",
		  		contentType :'application/x-www-form-urlencoded; charset=UTF-8',
		  		async:false,
		  		success : function(data) {
		  			//这里的数据是jsonArray
		  			for(var i=0;i<data.length;i++){
		  				showNews(data[i]);
		  			}
		  			tar = [data[0].longitude,data[0].latitude];
		  			var popup = view.popup;
		  			 popup.on("trigger-action", function(event) {
		 		        if (event.action.id === "goIt") {
		 		        	if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
		 		        	   window.open(event.action.url[1]);
		 		        	} else {
		 		        		window.open(event.action.url[0]);
		 		        	}
		 		        }
		 		      });
		  		},
		  		error : function() {
		  			alert("error");
		  		}
		  	});
		  	
			var opts = {
	           		  duration: 7000,
	           		};
	           		view.goTo({
	           		  target: tar,
	           		  zoom:10
	           		}, opts);
		  	
		  	
		  	// 这里设置只能再请求5次，即前5天的数据，负数为放大，正数为缩小
		  	
		  	var flag = 0;
		  	var container = [null,null,null,null,null];
		  	view.on("mouse-wheel",function(event){
                if(event.deltaY > 0){
                }else{
                	//放大
                	if(flag < 2 && container[flag] == null){
                		$.ajax({
            		  		method : "POST",
            		  		timeout : 5000,
            		  		url : "../esri/getMoreNews",
            		  		data :{"flag":flag},
            		  		dataType : "json",
            		  		contentType :'application/x-www-form-urlencoded; charset=UTF-8',
            		  		async:false,
            		  		success : function(data) {
            		  			//这里的数据是jsonArray
            		  			for(var i=0;i<data.length;i++){
            		  				showNews(data[i]);
            		  			}
            		  			var popup = view.popup;
            		  			 popup.on("trigger-action", function(event) {
            		 		        if (event.action.id === "goIt") {
            		 		        	if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            		 		        	   window.open(event.action.url[1]);
            		 		        	} else {
            		 		        		window.open(event.action.url[0]);
            		 		        	}
            		 		        }
            		 		      });
            		  			 flag++;
            		  		},
            		  		error : function() {
            		  			alert("error");
            		  		}
            		  	});
                	}
                	
                }
            });
		  	
  	//传入一个news的jsonObject
  	function showNews(news){
  			var point = {
  		        type: "point", 
  		        x: news.longitude,
  		        y: news.latitude,
  		      };
  			var col =  colorarray[Math.floor(Math.random()*11)];
  		    var markerSymbol = {
  		    	//这里以后设置大小
  		        type: "simple-marker", 
  		        color:col,
  		        outline: { 
  		          color:col,
  		          width: 0.1
  		        },
  		      size:Math.random()*15+5//15-30
  		      };

  		      //类似于Map
  		    var attribute = {
  		    		  关键字: news.keyWord,
  		    		  新闻来源:news.origin,
  		    		  时间:formatDate(new Date(news.pubDate*1000)),
  		      };
  		  var go = {
  		        title: "查看详情",
  		        id: "goIt",
  		        url:[news.webUrl,news.mobileUrl]
  		      };
  		    var template = {
  		    		title: "<p align = 'center'><b>"+news.title+"</b></p>",
   		            content: [{
   		              type: "fields",
   		              fieldInfos: [{
   		                fieldName: "关键字"
   		              }, {
   		                fieldName: "新闻来源"
   		              }, {
   		                fieldName: "时间"
   		              }
   		              ]
   		            },{
   		            	type:"text",
   		            	title:"预览图片"
   		            },{
   		             type: "media",
   		            mediaInfos: [{
   		              type: "image",
   		           value: {
   	                sourceURL: news.picUrl
   		           	}
   		            }]
   		           }],
   		        actions: [go]
  		      };
  		    var pointGraphic = new Graphic({
  		        geometry: point,
  		        symbol: markerSymbol,
  		        attributes:attribute,
  		        popupTemplate:template
  		      });
  		    graphicsLayer.add(pointGraphic);
  		    return pointGraphic;
  	}
    });