<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首屏蓝色</title>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-grid.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/fonts/iconfont.css">
    <link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
    <link href="css/motion.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
    <style type="text/css">
        @font-face {
            font-family: bar;
            src: url("bootstrap/fonts/MFYueHei.otf");
        }
        @font-face {
            font-family: center;
            src: url("bootstrap/fonts/center.otf");
        }
        @font-face {
            font-family: but2;
            src: url("bootstrap/fonts/button.ttf");
        }
        @font-face {
            font-family: but;
            src: url("bootstrap/fonts/button2.otf");
        }
        body{
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
        .background{
            width: 100%;
            height: auto;
            min-width: 100%;
            min-height: 100%;
            position: relative;
            z-index: -9999;
        }
        div.bar{
            background-color: transparent;
            border-radius: 50px;
            border: solid white 3px;
            width: 40px;
            height: 40px;
            margin-left: 7px;
            margin-top: 20px;
            margin-bottom: 20px;
            color: white;
            font-size: 25px;
            display: flex;
            justify-content: center;
            align-items: center;

        }
       
        div.face{
            background-color: transparent;
            border-radius: 50px;
            border: solid white 3px;
            width: 50px;
            height: 50px;
            color: white;
            font-size: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        div.banner{
            position: absolute;
            left: 0;
            top: 0;
            bottom: 0;
            right: 0;
            width: 100%;
            height: 100%;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            font-size: 70px;
        }

        div.logo{
            position: absolute;
            top: 30px;
            right: 30px;
            color: white;
            font-size: 40px;
            width: auto;
        }

        .execrise{
            border: solid white 2px;
            width: 280px;
            height: 70px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 35px;
            overflow: hidden;
            perspective: 800px;
            position: relative;
        }

        .box{
            width: 600px;
            height: 200px;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
        }

        .box:before{
            content: "";
            width: 100%;
            height: 100%;
            /**
            background: linear-gradient(36deg, #272b66 42.34%, transparent 42.34%) 0 0,
            linear-gradient(72deg, #2d559f 75.48%, transparent 75.48%) 0 0,
            linear-gradient(-36deg, #9ac147 42.34%, transparent 42.34%) 100% 0,
            linear-gradient(-72deg, #639b47 75.48%, transparent 75.48%) 100% 0,
            linear-gradient(36deg, transparent 57.66%, #e1e23b 57.66%) 100% 100%,
            linear-gradient(72deg, transparent 24.52%, #f7941e 24.52%) 100% 100%,
            linear-gradient(-36deg, transparent 57.66%, #662a6c 57.66%) 0 100%,
            linear-gradient(-72deg, transparent 24.52%, #9a1d34 24.52%) 0 100%,
            #43a1cd linear-gradient(#ba3e2e, #ba3e2e) 50% 100%;
            background-repeat: no-repeat;
            background-size: 50% 50%;
            **/
            opacity: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-clip-path: polygon(50% 0%, 90% 20%, 100% 60%, 75% 100%, 25% 100%, 0% 60%, 10% 20%);
            clip-path: polygon(50% 0%, 90% 20%, 100% 60%, 75% 100%, 25% 100%, 0% 60%, 10% 20%);
            transform: translateX(-50%) translateY(-50%) scale(0) rotate(360deg);
            transition: all 0.3s ease 0s;
        }

        .box:hover:before{
            opacity: 0.5;
            transform: translateX(-50%) translateY(-50%) scale(1.5) rotate(0);
        }

        .box:after{
            content: "";
            width: 100%;
            height: 100%;
            background: radial-gradient(rgba(255,255,255,0.9),transparent,transparent);
            position: absolute;
            top: 0;
            left: 0;
            opacity: 0;
        }

        .box:hover:after{ opacity: 1; }


        span{
            opacity: 1 !important;
        }

        span.center{
            font-style: italic;
            /*-webkit-filter: glow(color=#207CCA, strength=5);  Chrome, Safari, Opera */
            filter: drop-shadow(10px 10px 10px #207CCA);
            font-size: 72px;
        }
    </style>
</head>
<body>
<!--
<div class="bar"><span class="fa fa-bars"></span></div>
-->
<video class="background" muted loop autoplay><source src="resources/background.mp4" type="video/mp4"></video>
<div class="container">
<div class="banner">
	<span class="center box" style="font-family: center;">让新闻生动起来</span><br>
	<div class="box2">
		<div class="execrise" id="login">
			<a href="pict/LoginPage"><span style="font-family: but;">进入我的世界</span></a>
		</div>
	</div>
</div>
<div class="nav" style="font-family: bar !important;">
    <div class="nav-top">
        <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><div class="bar"><span class="fa fa-bars"></span></div></div>
    </div>
    <ul>
       <!--  <li class="nav-item">
            <a href="javascript:;"><span>记忆训练</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>数字训练</span></a></li>
                <li><a href="javascript:;"><span>扑克记忆</span></a></li>
                <li><a href="javascript:;"><span>词汇记忆</span></a></li>
                <li><a href="javascript:;"><span>图像记忆</span></a></li>
                <li><a href="javascript:;"><span>历史年代记忆</span></a></li>
                <li><a href="javascript:;"><span>数字听记</span></a></li>
                <li><a href="javascript:;"><span>人名头像记忆</span></a></li>
                <li><a href="javascript:;"><span>单词记忆</span></a></li>
            </ul>
        </li> -->
        <li class="nav-item">
        	<!-- 这里可以链接到一个关于用户的图表，当然，用户数量多了之后才可以 -->
            <a href="esri/"><span>用户概览</span></a>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><span>联系我们</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>商业合作</span></a></li>
                <li><a href="javascript:;"><span>学习交流</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><span>关于我们</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>开发人介绍</span></a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="logo"><span>LOGO</span></div>
</div>

<script>
</script>
</body>
</html>