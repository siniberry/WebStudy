<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoadTest03.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
<style type="text/css">
	.txtNum
	{
		width: 100px;
		text-align: right;
	}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	// AjaxTest02와 같은 내용
	// $(document).ready(); 이랑 같다
	$(function()
	{
		$("#sendButton").click(function()
		{
			var su1 = $("#su1").val();
			var su2 = $("#su2").val();
			var oper  = $("#oper").val();
			
			//var url = "LoadTest03_ok.jsp?su1=" + su1 + "&su2=" + su2 + "&oper=" + oper; 
			// 지금은 빨리 보기 위해 jsp 이렇게 했지만 실무에서는 컨트롤러로 보내고 받고 해야함
			var url = "loadtest03.do?su1=" + su1 + "&su2=" + su2 + "&oper=" + oper; 
			
			$("#result").load(url);		// responseText
			
		});
	});
	
</script>
</head>
<body>

<div>
	<h1>jQuery 의 load() 활용 실습</h1>
	<hr>
</div>

<div>
	<input type="text" id="su1" class="txt txtNum">
	
	<select id="oper">
		<option value="add">덧셈</option>
		<option value="sub">뻴셈</option>
		<option value="mul">곱셈</option>
		<option value="div">나눗셈</option>
	</select>
	
	<input type="text" id="su2" class="txt txtNum">
	
	<input type="button" value="=" id="sendButton" class="btn">
</div>
<br>

<div id="result">
</div>
<br>

<div>
	<input type="radio" name="rdo">rd1
	<input type="radio" name="rdo">rd2
</div>

<div>
	<input type="checkbox" name="chk">chk1
	<input type="checkbox" name="chk">chk2
</div>

<div>
	<input type="text">
</div>

</body>
</html>