<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改成功!</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
<style type="text/css">
.welcome{
	font-size:30px;
	margin-bottom: 30px;
}
</style>
<script type="text/javascript">
$(function(){
	$("#Ok").click(function(){
		top.d_close();
	});
});
</script>
</head>
<body>
<h1>修改信息成功!</h1>
<button class="btn btn-success" role="button" id = "Ok">确认</button>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>