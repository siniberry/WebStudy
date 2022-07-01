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
<title>GetTest02.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
<style type="text/css">
	*
	{
		font-family: 나눔바른펜;
	}
	body
	{
		font-size: 10pt;
		font-family: 굴림;
	}
	#resultDiv
	{
		width: 180px;
		height: 180px;
		border: 2px solid #499bd7;
	}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	// ※ 『$.get(url, data, callBack)』
	//    - 매개변수로 전달받은 URL을 사용하여 서버에 대한 GET 요청을 전송한다.
	
	//    cf. ajax.open("GET", url, async)

	$(function()
	{
		$("#loadBtn").click(function()
		{

			var nickName = $("#nickName").val();
			
			$.get("GetTest02_ok.jsp", {nickName:nickName}, function(data)
			{
				$("#resultDiv").html(data);
			});
			
		});
		
		$("#clearBtn").click(function()
		{
			$("#resultDiv").empty();
		});
		
	});
</script>
</head>
<body>

<div>
	<h1>jQuery 의 get() 활용 실습</h1>
	<hr>
</div>

<div>
	<input type="text" id="nickName" class="txt">
	<br>
	
	<button type="button" id="loadBtn" class="btn">눌러보자</button>
	<button type="button" id="clearBtn" class="btn">지워보자</button>
</div>
<br>

<div id="resultDiv">
<!-- 
슈퍼맨님 안녕하세요.<br>
반갑습니다.
 -->
</div>










<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />






</body>
</html>