<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String idStr = request.getParameter("id");
	String pwdStr = request.getParameter("pwd");
	String nameStr = request.getParameter("name");
	String telStr = request.getParameter("tel");
	String genderStr = request.getParameter("gender");
	String cityStr = request.getParameter("city");
	
	String[] majorArr = request.getParameterValues("userSubject");
			 
	String gender ="";
	if(genderStr.equals("F"))
		gender = "여성";
	else if(genderStr.equals("M"))
		gender="남성";
		
	String city = "";
	if(cityStr.equals("서울"))
		city = "서울";
	else if(cityStr.equals("대전"))
		city="대전";
	else if(cityStr.equals("대구"))
		city="대구";
	else if(cityStr.equals("광주"))
		city="광주";
	
	String major="";
	if(majorArr != null)
	{
		for(String item : majorArr)
		{
			major += "[" + item + "]";
		}
	}
	
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
	<h2>회원 가입이 완료되었습니다 ^^</h2>
	<h2>회원 가입 정보</h2>
	<h3>아이디 : <%=idStr %></h3>
	<h3>비밀번호 : <%=pwdStr %></h3>
	<h3>이름 : <%=nameStr %></h3>
	<h3>전화번호 : <%=telStr %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>지역 : <%=city %></h3>
	<h3>수강과목 : <%=major %></h3>
	
</div>


</body>
</html>