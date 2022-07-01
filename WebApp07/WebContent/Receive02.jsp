<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	// send02.html 로 부터의 데이터 수신(→ 스크립트 릿 영역)
	
	request.setCharacterEncoding("UTF-8");

	String userName = request.getParameter("userName");
	String korStr = request.getParameter("kor");
	String engStr = request.getParameter("eng");
	String matStr = request.getParameter("mat");
	
	int kor=0;
	int eng=0;
	int mat=0;
	int tot=0;
	double avg=0;
	
	try
	{
		kor = Integer.parseInt(korStr);
		eng = Integer.parseInt(engStr);
		mat = Integer.parseInt(matStr);
		
		tot = kor+eng+mat;
		avg = tot/3.0;
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터 송수신 실습 02</h1>
</div>

<div>
	<h2>가입 확인</h2>
	<span style="color: blue;"><%=userName %></span>님,
	성적처리가 완료되었습니다. <br>
	회원님의 점수는 
	국어 : <span><%=kor %></span>점,
	영어 : <span><%=eng %></span>점,
	수학 : <span><%=mat %></span>점 입니다. <br>
	총점은 <span><%=tot %></span>점,
	평균은 <span><%=String.format("%.1f", avg) %></span>입니다.
	<%-- 평균은 <span><%=avg %></span>입니다. --%>
</div>


</body>
</html>