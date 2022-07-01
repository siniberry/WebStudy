<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String result ="";
	result += "<ul>";
	for(int i=1;i<=9;i++)
	{
		// 숫자$ → 인자 넣고싶은 값 설정할 수 있음	
		//result += String.format("<li><a href='Receive09.jsp?gugudan=%d'>%d</a></li>",i,i);
		//result += String.format("<li><a href='Receive09.jsp?gugudan=%2$d'>%1$d</a></li>",10,20);
		result += String.format("<li><a href='Receive09.jsp?gugudan=%1$d'>%1$d단</a></li>",i);
	}
	result += "</ul>";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send09.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	a {text-decoration: none;}	/* 밑줄 없애는 것 */
</style>
</head>
<body>

<!--  
	○ 데이터 송수신 실습 09
	   - a 태그(링크 태그)에 대한 반복문 처리를 하는 JSP 페이지를 구성한다.
	   - 이를 활용하여 구구단 리스트를 동적으로 구성하여
	     선택에 따른 결과 페이지를 출력해 주는 형태의 페이지로 구현한다.
	   - submit 버튼 없이 이벤트 처리를 할 수 있도록 한다.
	   
	   구구단 선택
	   
	   1단
	   2단
	   3단
	    :
	   7단
	   8단
	   9단
	   
	   - 해당 단을 클릭햇을 때
	     구구단을 출력해주는 형태의 페이지로 구현한다.
	     
	   - 사용자 최초 요청 주소
	     http://localhost:8090/WebApp07/send09.jsp
	 
	 ○ Send09.jsp
	    Receive09.jsp
	 
-->

<div>
	<h1>데이터 송수신 실습 09</h1>
	<hr>
</div>


<div>
	<h2>구구단 선택</h2>
	<%=result %>
</div>

</body>
</html>