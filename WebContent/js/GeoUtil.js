function xytoLat(mercator){
		var lonlat={x:0,y:0};
		var x = mercator.x/20037508.34*180;
		var y = mercator.y/20037508.34*180;
		y= 180/Math.PI*(2*Math.atan(Math.exp(y*Math.PI/180))-Math.PI/2);
		lonlat.x = x;
		lonlat.y = y;
		return lonlat;
	}