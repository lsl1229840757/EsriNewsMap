particlesJS('particles-js', {
	particles : {
		color : '#fff',
		shape : 'edge', // "circle", "edge" or "triangle"
		opacity : 1,
		size : 4,
		size_random : true,
		nb : 150,
		line_linked : {
			enable_auto : true,
			distance : 100,
			color : '#fff',
			opacity : 1,
			width : 1,
			condensed_mode : {
				enable : false,
				rotateX : 600,
				rotateY : 600
			}
		},
		anim : {
			enable : true,
			speed : 1
		}
	},
	interactivity : {
		enable : true,
		mouse : {
			distance : 300
		},
		detect_on : 'canvas', // "canvas" or "window"
		mode : 'grab',
		line_linked : {
			opacity : .5
		},
		events : {
			onclick : {
				enable : true,
				mode : 'push', // "push" or "remove"
				nb : 4
			}
		}
	},
	/* Retina Display Support */
	retina_detect : true
});
/*
 * Background slideshow
 */
$("input[id=username]").blur(
		function() {
			if (checkusername()
					&& validateInput('username', 'userblank', 'userLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});
$("input[id=pwd]").blur(function() {
	if (pwdComplex() && validateInput('pwd', 'pwdblank', 'pwdLabel')) {
		$(this).data({
			's' : 1
		});
	} else {
		$(this).data({
			's' : 0
		});
	}
});
$("input[id=pwd2]").blur(
		function() {
			if (checkrepassword()
					&& validateInput('pwd2', 'pwdblank2', 'pwdsureLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});
$("input[id=checkCode]").blur(function() {
	if (checkCode() && validateInput('checkCode', 'identblank', 'checkLabel')) {
		$(this).data({
			's' : 1
		});
	} else {
		$(this).data({
			's' : 0
		});
	}
});
$("input[id=name]").blur(function() {
	validateInput('name', 'nameblank', 'nickLabel') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
});
$("input[id=age]").blur(
		function() {
			if (validateAge('age', 'ageblank')
					&& validateInput('age', 'ageblank', 'ageLabel')) {
				$(this).data({
					's' : 1
				});
			} else {
				$(this).data({
					's' : 0
				});
			}
		});

$("input[id=pwd]").keyup(function() {
	if (pwdComplex() && validateInput('pwd', 'pwdblank', 'pwdLabel')) {
		$(this).data({
			's' : 1
		});
	} else {
		$(this).data({
			's' : 0
		});
	}
});

$("input[id=name]").keyup(function() {
	validateInput('name', 'nameblank', 'nickLabel') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
});
$("input[id=age]").keyup(function() {
	if (validateAge() && validateInput('age', 'ageblank', 'ageLabel')) {
		$(this).data({
			's' : 1
		});
	} else {
		$(this).data({
			's' : 0
		});
	}
});
$("form").submit(function() {
	$(".form-control").blur();
	result = 0;
	$(".form-control").each(function() {
		alert($(this).data('s'));
		result += $(this).data('s');
	});
	if (result != 6) {
		$("#msg").html("<font color='red'>请确认用户信息是否全部正确填写!</font>");
		return false;
	}
	$("#pwd").val(md5($("#pwd").val()));
	$("#pwd2").val(md5($("#pwd2").val()));

});
$(".userLabel,.checkLabel,.ageLabel,.pwdLabel,.nickLabel,.pwdsureLabel").hide();