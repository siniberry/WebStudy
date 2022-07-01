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
<title>JsonTest02.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#sendBtn").click(function()
		{
			var params = "name=" + $.trim($("#name").val()) 
		        + "&content=" + $.trim($("#content").val());
				
			$.ajax(
			{
				type:"POST"
				, url:"JsonTest02_ok.jsp"
				, data:params
				, dataType:"json"
				,success:function(jsonObj)
				{
					var out = "";
					
					
					// 수신된 jsonObj 는 json 배열 객체
					// → 배열방만큼 반복문 순환
					for (var idx=0; idx<jsonObj.length; idx++)
					{
						var num = jsonObj[idx].num;
						var name = jsonObj[idx].name;
						var content = jsonObj[idx].content;
						
						out += "<br>=========================";
						out += "<br> 번호 : " + num;
						out += "<br> 이름 : " + name;
						out += "<br> 내용 : " + content;
						out += "<br>=========================<br>";
					}
					
					$("#result").html(out);
					
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
					
					// 내가 푼 풀이
					/*
					 요소 하나안에 num name content가 들어감
					 [{"num" : "1", "name" : "임소민1", "content" : "안녕하세요1"}
					, {"num" : "2", "name" : "임소민2", "content" : "안녕하세요2"}
					, {"num" : "3", "name" : "임소민3", "content" : "안녕하세요3"}
					, {"num" : "4", "name" : "임소민4", "content" : "안녕하세요4"}
					, {"num" : "5", "name" : "임소민5", "content" : "안녕하세요5"}]
					
					
					var num;
					var name;
					var content;
					
					for(var i=0; i<5; i++)
					{
						// check~!!!
						num = jsonObj[i].num;
						name = jsonObj[i].name;
						content = jsonObj[i].content;
						
						out += "<br>=========================";
						out += "<br> 번호 : " + num;
						out += "<br> 이름 : " + name;
						out += "<br> 내용 : " + content;
						out += "<br>=========================<br>";
					}
					
					
					$("#result").html(out);
					
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
					*/
					
				}
				, beforeSend:showRequest
				, error:function(e)
				{
					alert(e.responseText);
				}
			});
		});
	});
	
	function showRequest()
	{
		if (!$.trim($("#name").val()))
		{
			alert("이름을 입력해야 합니다.");
			$("#name").focus();
			
			return false;
		}
		
		if (!$.trim($("#content").val()))
		{
			alert("내용을 입력해야 합니다.");
			$("#content").focus();
			
			return false;
		}
		
		return true;
	}

</script>

</head>
<body>

<div>
	<h1>jQuery의 ajax() 활용 실습</h1>
	<p>json control</p>
	<hr>
</div>

<div>
	이름 <input type="text" id="name" class="txt"><br><br>
	내용 <input type="text" id="content" class="txt"><br><br>
	
	<input type="button" value="등록하기" id="sendBtn" class="btn">
</div>
<br><br>

<div id="result">
</div>



</body>
</html>