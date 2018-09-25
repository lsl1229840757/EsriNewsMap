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
$("input[id=username]").blur(function() {
	validateInput('username', 'userblank', 'input_sty') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
});
$("input[id=pwd]").blur(function() {
	validateInput('pwd', 'pwdblank', 'input_sty2') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
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
$("input[id=username]").keyup(function() {
	validateInput('username', 'userblank', 'input_sty') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
});
$("input[id=pwd]").keyup(function() {
	validateInput('pwd', 'pwdblank', 'input_sty2') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
});

$("form").submit(function() {
	$(".form-control").blur();
	result = 0;
	$(".form-control").each(function() {
		result += $(this).data('s');
	});
	if (result != 3) {
		$("#msg").html("<font color='red'>请检查登录信息是否完善!</font>");
		return false;
	}
	$("#pwd").val(md5($("#pwd").val()));

});
$(".input_sty,.input_sty2,.checkLabel").hide();
