<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 데이터 수신 (Send04_01.html → Receive04.jsp)
	
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	String userTel = request.getParameter("userTel");
	
	String userGender = request.getParameter("userGender");
	String userCity = request.getParameter("userCity");
	
	//String userSubject = request.getParameter("userSubject");
	
	// check~!!!
	String[] userSubjectArr = request.getParameterValues("userSubject");
	
	String subjectStr = "";
	
	if(userSubjectArr != null)
	{
		for(int i=0; i<userSubjectArr.length; i++)
		{
			subjectStr += " [" + userSubjectArr[i].toString() + "]";
		}
	}
	
	// ※ 추후에는 수신된 데이터를... 쿼리문을 통해 DB에 입력하는
	//	  처리 과정 등이 포함될 것임을 염두하며 작업을 진행할 수 있도록 하자.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive04.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
	span{ color: red; font-weight: bold; font-size: 15pt; }
</style>

</head>
<body>

<div>
	<h1>데이터 송수신 실습 04</h1>
	<hr>
</div>

<div>
	<h2>가입 승인 내역</h2>
	
	<!-- <p>아이디 : 1031cory</p> -->
	<p>아이디 : <%=userId %></p>
	
	<!-- <p>비밀번호 : berry1031</p> -->
	<p>비밀번호 : <%=userPw %></p>
	
	<!-- <p>전화번호 : 010-6267-0734</p> -->
	<p>전화번호 : <%=userTel %></p>
	
	<!-- <p>성별 : 여</p> -->
	<p>성별 : <%=userGender %></p>
	
	<!-- <p>지역 : 서울</p> -->
	<p>지역 : <%=userCity %></p>
	
	<!-- <p>수강과목 : []</p> -->
	<p>수강과목 : <%=subjectStr %></p>
	
</div>


</body>
</html>