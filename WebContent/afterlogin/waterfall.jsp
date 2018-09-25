<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="../outerjs/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Mono:300,500,700"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/afterlogin/css2/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/afterlogin/css2/demo.css" />
<script>
	document.documentElement.className = 'js';
</script>
<script>
	$(function() {
		$.getJSON('../esri/initiateNews.action', function(data) {
			$('.grid__item').each(function(i) {
				for ( var key in data[i]) {
					var picUrl = data[i].picUrl;
					var title = data[i].title;
					var keyWord = data[i].keyWord;
					var webUrl = data[i].webUrl;
					$(this).html("<a href = "+webUrl+" target = '_blank'>"+title+".【关键字】:"+keyWord+"</a>");
					$(this).css({"background-image": "url(" + picUrl + ")",'background-repeat':'no-repeat','background-size':'100% 100%','-moz-background-size':'100% 100%'});
				}
			})
		})
	})
</script>

<style type="text/css">
	.grid__item{
		color:white;
		font-size: 16px;
		font-family: Consolas;
	}
</style>
</head>

<body class="loading">
	<main> <header class="codrops-header">
	<h1 class="codrops-header__title">瀑布流展示新闻</h1>
	</header>
	<div class="content content--side content--right">
		<div class="control control--effects">
			<span class="control__title">run effect</span>
			<button class="control__btn" data-fx="Hapi">Hapi</button>
			<button class="control__btn" data-fx="Amun">Amun</button>
			<button class="control__btn" data-fx="Kek">Kek</button>
			<button class="control__btn" data-fx="Isis">Isis</button>
			<button class="control__btn" data-fx="Montu">Montu</button>
			<button class="control__btn" data-fx="Osiris">Osiris</button>
			<button class="control__btn" data-fx="Satet">Satet</button>
			<button class="control__btn" data-fx="Atum">Atum</button>
			<button class="control__btn" data-fx="Ra">Ra</button>
			<button class="control__btn" data-fx="Sobek">Sobek</button>
			<button class="control__btn" data-fx="Ptah">Ptah</button>
			<button class="control__btn" data-fx="Shu">Shu</button>
		</div>
	</div>
	<div class="content content--center">
		<div class="grid grid--type-c">
			<div class="grid__sizer"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
			<div class="grid__item"></div>
		</div>
	</div>
	</main>

	<script src="${pageContext.request.contextPath }/afterlogin/js/imagesloaded.pkgd.min.js"></script>
	<script src="${pageContext.request.contextPath }/afterlogin/js/masonry.pkgd.min.js"></script>
	<script src="${pageContext.request.contextPath }/afterlogin/js/anime.min.js"></script>
	<script src="${pageContext.request.contextPath }/afterlogin/js/main.js"></script>
</body>
</html>