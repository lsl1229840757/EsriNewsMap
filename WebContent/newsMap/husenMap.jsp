<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
  <title>新闻地图界面</title>

  <style>
    html,
    body,
    #viewDiv {
      padding: 0;
      margin: 0;
      height: 100%;
      width: 100%;
    }
    
    .docking-control {
      font-family: "Avenir Next", "Helvetica Neue", Helvetica, Arial, sans-serif;
      position: absolute;
      z-index: 10;
      top: 50%;
      left: 50%;
      width: 250px;
      height: 80px;
      padding: 10px;
      box-sizing: border-box;
      margin: -40px 0 0 -125px;
      background-color: #fff;
      color: #323232;
      text-align: center;
      -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
    }
    
    .docking-control label {
      display: inline-block;
      font-weight: bold;
      margin: 0 0 10px 0;
      padding: 0;
      font-size: 16px;
    }
  </style>

  <link rel="stylesheet" href="https://js.arcgis.com/4.2/dijit/themes/claro/claro.css">
  <link rel="stylesheet" href="https://js.arcgis.com/4.2/esri/css/main.css">
  <script src="https://js.arcgis.com/4.2/"></script>

  <script>
    require([
      "esri/Map",
      "esri/views/MapView",
      "esri/WebMap",

      "dojo/dom",
      "dojo/on",
      "dojo/domReady!"
    ], function (
      Map, MapView, WebMap,
      dom, on
    ) {

        var webmap = new WebMap({
          portalItem: { // autocasts as new PortalItem()
            id: "3af548bac6054938b615d08104197ba0"
          }
        });

        var view = new MapView({
          map: webmap,
          popup: {
            dockEnabled: true,
            dockOptions: {
              // Disables the dock button from the popup
              buttonEnabled: false,
              // Ignore the default sizes that trigger responsive docking
              breakpoint: false,
            }
          },
          container: "viewDiv"
        });

        popup = view.popup;

        view.then(function () {

          var centerPoint = view.center.clone();

          popup.open({
            title: "Popup dock positions",
            location: centerPoint,
            content: "Use the control in the center of the map to change the location where the popup will dock."
          });

          // Watch currentDockPosition of the popup and open the 
          // popup at the at position. 
          popup.watch("currentDockPosition", function (value) {
            popup.open();
          });

          var selectNode = dom.byId("dockPositionControl");

          // Let user change the position dockOptions.position property of the 
          // popup at runtime from the drop-down list. 
          on(selectNode, "change", function (e) {
            popup.set("dockOptions", {
              breakpoint: false,
              buttonEnabled: false,
              position: e.target.value
            });
          })

        });
      });
  </script>
</head>

<body>
  <div id="viewDiv">
    <div class="docking-control">
      <label for="dockPositionControl">Popup Dock Position</label>
      <select id="dockPositionControl">
        <option selected value="auto">Auto</option>
        <option value="top-left">Top Left</option>
        <option value="top-center">Top Center</option>
        <option value="top-right">Top Right</option>
        <option value="bottom-left">Bottom Left</option>
        <option value="bottom-center">Bottom Center</option>
        <option value="bottom-right">Bottom Right</option>
      </select>
    </div>
  </div>
</body>

</html>
