<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String sYear = request.getParameter("year");
	String sMonth = request.getParameter("month");
	
	Calendar cal = Calendar.getInstance();
	
	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH)+ 1;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);
	
	int selectYear = nowYear;
	int selectMonth = nowMonth;
	
	if(sYear != null || sMonth != null)
	{
		selectYear = Integer.parseInt(sYear);
		selectMonth = Integer.parseInt(sMonth);
	}
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive07.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	td {text-align: right;}
	td.now {background-color: #fddde8; font-weight: bold;}
	td.set{color: blue;}
	td.sun{color: red;}
	td.nowSat {background-color: #fddde8; font-weight: bold; color: blue;}
	td.nowSat {background-color: #fddde8; font-weight: bold; color: red;}
</style>
<script type="text/javascript">

	function formCalendar(obj)
	{
		obj.submit();
	}

</script>
</head>
<body>

<!--  
	○ 데이터 송수신 실습 07
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 연도와 월일 입력받아 화면에 출력해주는 형태의 페이지로 구성한다.
	   - 단, submit 버튼 없이 이벤트 처리를 할 수 있도록 한다.
	   - 전송한 내용을 수신해서 출력해주는 형태의 페이지로 구성한다.
	   - 년도 구성은 현재 년도를 기준으로 이전 10년, 이후 10년으로 구성한다.
	   	 (기본적으로 만년달력을 구성하는데 현재의 연, 월 은 달력 객체로부터 확인할 수 있도록 한다.)
	   - 월 구성을 1월 부터 12월 까지로 구성한다.
	   
	   [ 2022 ▼ ] 년 [ 4 ▼ ] 월
	   
	   ---------------------------
	   ---------------------------
	   ---------------------------
	   ---------------------------
	   
	   - 연도 select 나 월 select 의 내용 변화 시
	     해당 연 월의 달력을 출력해주는 형태의 페이지로 구성한다.
	     
	   - 사용자 최초 요정 주소는
	     http://localhost:8090/WebApp07/SendAndReceive07.jsp 로 한다.
	     
	○ SendAndReceive07.jsp
	
-->

<div>
	<h1>데이터 송수신 실습07</h1>
	<hr>
</div>

<div>
	<!-- form 의 action 속성 값 생략 → 요청 페이지 / 데이터의 수신처는 자기 자신 -->
	<form action="" method="post">
		<select id="year" name="year" onchange="formCalendar(this.form)">
			<!-- <option value="9999">9999</option> -->
	</select>년
		
		<select id="month" name="month" onchange="formCalendar(this.form)">
		<!-- <option value="9999">9999</option> -->
		</select>월
	</form>
</div>

<div>
	<!-- 달력을 그리게 될 지점 -->
</div>

</body>
</html>