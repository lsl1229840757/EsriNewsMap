$("input[id=checkCode]").blur(function() {
	validateInput('checkCode', 'identblank', 'checkLabel') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
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
$("input[id=checkCode]").keyup(function() {
	validateInput('checkCode', 'identblank', 'checkLabel') ? $(this).data({
		's' : 1
	}) : $(this).data({
		's' : 0
	});
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
		result += $(this).data('s');
	});
	if (result != 3) {
		$("#msg").html("<font color='red'>请确认用户信息是否全部正确填写!</font>");
		return false;
	}
});