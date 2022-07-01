<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="ob" class="com.test.FriendDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="ob"/>

<%
	String str = "";

	if(ob.getIdelType()!= null)
	{
		for(String temp : ob.getIdelType())
			str += temp + " ";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div>
		<h1> 등록 수신 결과</h1>
		<hr>
	</div>
	
	<div>
		<h1>출력 결과</h1>
		<h2>이름 : <%=ob.getName() %></h2>
		<h2>나이 : <%=ob.getAge() %></h2>
		<h2>성별 : <%=ob.getGender() %></h2>
		<h2>이상형 : <%=str %></h2>
	</div>
</body>
</html>