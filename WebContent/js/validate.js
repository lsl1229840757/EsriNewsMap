function validateInput(inputName, blankId, labelClass) {
	if ($('#'+inputName).val() == "") {
		var value = $("." + labelClass).html();
		$('#'+blankId).html(value + "不能为空!");
		return false;
	} else {
		$('#'+blankId).html("");
		return true;
	}
};
function checkusername() {
	var flag = false;
	// 先检验是否为空
	if (validateInput('username', 'userblank', 'userLabel')) {
		// AJAX请求验证用户名
		/*$.ajax({
			type : "POST",
			url : "pict/ajax.action",
			data : "username=" + $("#username").val(),
			dataType : "json",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
			async : false,
			success : function(data) {
				if(data.error==1){
					$("#userblank").html("<font color='red'>"+data.username+"</font>");
					flag = false;
				}else if(data.error==0){
					$("#userblank").html("<font color='green'>"+data.username+"</font>");
					flag = true;
				}
			}
		});*/
	    $.ajaxSettings.async = false;
		$.get('pict/ajax.action',{'username':$("#username").val()},function(data){
			if(data.error==1){
				$("#userblank").html("<font color='red'>"+data.username+"</font>");
				flag = false;
			}else if(data.error==0){
				$("#userblank").html("<font color='green'>"+data.username+"</font>");
				flag = true;
			}
		},'json');
	    $.ajaxSettings.async = true;
	}
	return flag;
	
}
function refresh() {
	document.getElementById("image").src = "pict/draw.action?" + Math.random()
			+ new Date();
};
function validateAge(age, blankId) {
	var val = $("#" + age).val();
	var regex = /^(?:[1-9]?\d|100)$/;
	if (!regex.test(val)) {
		$("#" + blankId).html("年龄应是0~100之间的整数!");
		return false;
	}
	return true;
}
function pwdComplex()// 用于判断密码强度的
{
	var pwdobj = document.getElementById("pwd"); // 获取密码输入框对象
	var pwdTip = document.getElementById("pwdTip");// 获取密码提示文字对象
	var pwdprogress = document.getElementById("innerprogress"); // 获取span标签对象
	var strongthTip = document.getElementById("strongthTip");// 获取密码强度提示文字的对象
	var regxs = new Array();// 定义一个数组用于存放不同的正则表达式
	regxs[0] = /[^a-zA-Z0-9_]/g;
	regxs[1] = /[a-z]/g;
	regxs[2] = /[0-9]/g;
	regxs[3] = /[A-Z]/g;
	var val = pwdobj.value;// 获取用户输入的密码
	var len = val.length;// 获取用户输入的密码长度
	var sec = 0; // 定义一个变量用于存放密码强度
	if (len >= 6 && len <= 20) // 用于判断用户输入的密码强度
	{ // 至少六个字符
		for (var i = 0; i < regxs.length; i++) // 遍历所有正则表达式，检测用户输入的密码符合哪些正则表达式，如果符合则强度+1
		{
			if (regxs[i].test(val)) {
				sec++;
			}
		}
	} else {
		$("#pwdblank").html("密码应在6位以上，20位以下!");
		return false;
	}
	if (sec == 0) // 通过不同的密码强度调用不同的样式
	{
		strongthTip.innerText = "";
		// setAttribute("class",
		// "className")中class是指改变class这个属性，所以要带引号，className是span标签的类名，也是对应的样式名
		pwdprogress.setAttribute("class", "cinnerprogress");
	} else if (sec == 1) {
		strongthTip.innerText = "强度：弱";
		strongthTip.style.color = "red";
		pwdprogress.setAttribute("class", "strengthLv1");
	} else if (sec == 2) {
		strongthTip.innerText = "强度：中";
		strongthTip.style.color = "orange";
		pwdprogress.setAttribute("class", "strengthLv2");
	} else if (sec == 3) {
		strongthTip.innerText = "强度：强";
		strongthTip.style.color = "#09F";
		pwdprogress.setAttribute("class", "strengthLv3");
	} else if (sec == 4) {
		strongthTip.innerText = "强度：超强";
		strongthTip.style.color = "green";
		pwdprogress.setAttribute("class", "strengthLv4");
	}
	return true;
}

function checkrepassword(){
	if($("#pwd").val()==$("#pwd2").val()){
		return true;
	}else{
		$("#pwdblank2").html("两次密码不一致!");
		return false;
	}
	
}

function checkCode(){
	var flag = false;
	if(validateInput('checkCode','identblank','checkLabel')){
	    $.ajaxSettings.async = false;
		$.get('pict/ajaxImage.action',{'checkCode':$('#checkCode').val()},function(data){
			if(data.flag=='false'){
				$("#identblank").html("<font color='red'>"+data.info+"</font>");
				flag = false;
			}else if(data.flag=='true'){
				$("#identblank").html("<font color='green'>"+data.info+"</font>");
				flag = true;
			}
		},'json');
	    $.ajaxSettings.async = true;
	}
	return flag;
}