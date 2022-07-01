<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// sid 수신
	// 수신한 sid 를 가지고 회원 데이터 조회
	// 조회해서 얻어낸 데이터를 폼에 구성
	
	// 이전 페이지로(MemberSelect.jsp)부터 데이터(sid) 수신
	
	String sid = request.getParameter("sid");
	String name = "";
	String tel = "";
	
	MemberDAO dao = new MemberDAO();
	
	try
	{
		// 데이터베이스 연결
		dao.connection();
		
		MemberDTO member = dao.searchMember(sid);
		name = member.getName();
		tel = member.getTel();
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	finally
	{
		try
		{
			dao.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberUpdateForm.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">

<script type="text/javascript">

	function memberSubmit()
	{
		var memberForm = document.getElementById("memberForm");
		var uName = document.getElementById("uName");
		var nMsg = document.getElementById("nameMsg");
		
		nMsg.style.display = "none";
		
		if(uName.value == "")
		{
			nMsg.style.display = "inline";
			uName.focus();
			return;
		}
		
		// form 을 직접 지정하여 submit 액션 수행
		memberForm.submit();
	}
	
	function memberReset()
	{
		var memberForm = document.getElementById("memberForm");
		var uName = document.getElementById("uName");
		var nMsg = document.getElementById("nameMsg");
		
		nMsg.style.display = "none";
		
		// form 을 직접 지정하여 reset 액션 수행 → .reset() 은 어디서 나온거지?
		memberForm.reset();
		
		uName.focus();
	}

</script>
</head>
<body>

<div>
	<h1>회원 <span style="color: red;">명단</span> 관리 
	      및 <span style="color: blue;">수정</span> 페이지</h1>
	<hr>
</div>

<div>
	<a href="MemberSelect.jsp"><button type="button">회원 명단 관리</button></a>
	<br><br>
</div>


<div>
	<!-- 회원 정보 수정 폼 구성 -->
	<form action="MemberUpdate.jsp?sid=<%=sid %>" method="post" id="memberForm">
		<table class="table">
			<tr>
				<!-- value 가 들어가는 이유? 수정할 때 이름, 전화번호 각각의 값이 먼저 담겨있어야 페이지에 수정할 때 보이니까-->
				<th>이름(*)</th> 
				<td>
					<input type="text" id="uName" name="uName" value="<%=name %>">
				</td>
				<td>
					<span class="errMsg" id="nameMsg">이름을 입력해야 합니다.</span>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>	
					<input type="text" id="uTel" name="uTel" value="<%=tel %>">
				</td>
				<td>
				</td>
			</tr>
		</table>
		
		<%-- <!-- 수정메소드 호출할 때 sid/name/tel 다 넘겨받지만 클라이언트가 수정할 때 이름과 전화번호만 수정하므로 sid 는 갖고 있되, hidden -->
		<input type="hidden" name="sid" value="<%= sid%>">  --%>
		<br>
		<a href="javascript:memberSubmit()"><button type="button">수정하기</button></a>
		<a href="javascript:memberReset()"><button type="button">취소하기</button></a>
		<a href="MemberSelect.jsp"><button type="button">목록으로</button></a>
	</form>
</div>
</body>
</html>