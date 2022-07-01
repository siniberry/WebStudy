<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%

	request.setAttribute("result", "EL 테스트");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test3.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>EL 관련 실습</h1>
	<hr>
</div>

<div>
	<!-- action 속성 생략 → su1 과 su2 데이터를 전송하며 요청하는 페이지는 자기 자신 ~!!!-->
	<form method="post">
		정수1 <input type="text" name="su1" class="txt"><br>
		정수2 <input type="text" name="su2" class="txt"><br>
		<button type="submit" class="btn">결과 확인</button>
	</form>
</div>

<div>
	<h2>폼 데이터 수신</h2>
	
	<!-- 폼의 데이터를 수신하는 방법 1 -->
	<h3><%=request.getParameter("su1") %></h3>
	

	<h3>${param.su1}</h3>
</div>
<br><br>


<div>
	<h2>폼의 데이터를 받아 연산 수행</h2>
	
	<!-- 폼의 데이터를 받아 연산을 수행하는 방법 1 -->
	<!-- 하나만 넣었을 때 오류 : 처음 파라미터로 받은 게 없을 때는 null 로 표시되지만 submit을 누르면 빈 문자열로 인식 -->
	<%
		String s1 = request.getParameter("su1");
		String s2 = request.getParameter("su2");
	
		int s = 0;
		
		/* 최초에 웹을 실행했을 때만 null로 실행  */
		if (s1!=null && s2!=null)
		{
			s = Integer.parseInt(s1) + Integer.parseInt(s2);			
		}
	%>
	<h3>합 : <%=s %></h3>
	
	<!-- 폼의 데이터를 받아 연산을 수행하는 방법 2 -->
	<!-- EL을 사용하는 구문 : 달러{} → 제이쿼리에서 쓰는 거랑 비슷하게 생김 주의-->
	<!-- null 값에 관대하기 때문에 클라이언트에게 서비스 할 때 사용하기 편리함 -->
	<!-- 넘어온파라미터에서 su1을 가져오겠다 -->
	<h3>합 : ${param.su1 + param.su2}</h3>
	<!-- → 파라미터 수신도 알아서... -->
	<!-- → 필요한 캐스팅도 알아서 자동으로 수행 -->
	<!-- → null 을 대하는 방식도 유연함 check~!!! -->
	
</div>
<br><br>

<div>
	<h2>setAttribute() 로 넘긴 데이터 수신</h2>
	
	<!-- setAttribute() 로 넘긴 데이터를 수신하는 방법 1 -->
	<h3><%= request.getAttribute("result") %></h3>
	
	<!-- setAttribute() 로 넘긴 데이터를 수신하는 방법 2 -->
	<h3>${result}</h3>
</div>


</body>
</html>

