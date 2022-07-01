<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 자기 자신 페이지로부터 데이터 수신 후 처리하는 부분
	String sYear = request.getParameter("year");
	String sMonth = request.getParameter("month");
	
	// Calendar 객체 생성
	Calendar cal = Calendar.getInstance();
	
	// 현재 년 월 일 받아오기
	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH)+1;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);
	
	// 표시할 달력의 년, 월 구성 → 페이지 최초 요청을 감안한 코드
	int selectYear = nowYear;
	int selectMonth = nowMonth;
	
	// 페이지가 최초 요청이 닐경우
	if( sYear != null || sMonth != null)
	{
		selectYear = Integer.parseInt(sYear);
		selectMonth = Integer.parseInt(sMonth);
	}
	
	//버튼 -----------------------------------------------------------------------------
	// ◀ 누르면 한달전
	int preYear = selectYear;
	int preMonth = selectMonth -1;
	
	// 연도 월에서 2022년 1월에서 클릭 시 2021년 12월!!
	if(preMonth<1)
	{
		preYear = selectYear -1;
		preMonth = 12;
	}
	
	// ▶ 누르면 month+1
	int nextYear = selectYear;
	int nextMonth = selectMonth +1;
	
	// 연도 월에서 2022년 12월 클릭 시 2023년 1월!
	if(nextMonth>12)
	{
		nextYear = selectYear +1;
		nextMonth = 1;
	}
	
	//-----------------------------------------------------------------------------
	
	// 만년 달력그리기
	int[] months = {31, 28, 31, 30, 31,30,31,31,30,31,30,31};
	
	// 윤년 설정 하기
	if(selectYear%4==0 && selectYear%100!=0 ||  selectYear%400==0)
	{
		months[1]=29;
	}
	
	// 날수 누적
	int nalsu;
	
	// 요일 항목 배열 구성
	String[] weekNames = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	
	// 현재 년도 ~ 입력받은 년도 이전 년도까지의 날 수 계산
	nalsu = (selectYear-1)*365 + (selectYear-1)/4 - (selectYear-1)/100 + (selectYear-1)/400;
	
	// 현재 월 → 입력받은 월의 이전 월까지의 날 수 추가
	for(int i=0; i<selectMonth-1;i++)
		nalsu +=months[i];
	
	nalsu++;								// +1
	
	int week = nalsu%7;						//-- 요일 변수
	int lastDay = months[selectMonth-1];	//-- 마지막 날짜 변수
	
	// 달력 그리기
		String calStr = "";
		calStr +="<table border=1>";
		
	// 요일 이름 발생
	calStr += "<tr>";
	for(int i=0; i<weekNames.length; i++)
	{
		if(i==0)
			calStr += "<th style='color:red;'>" + weekNames[i] + "</th>";
		else if(i==6)
			calStr += "<th style='color:blue;'>" + weekNames[i] + "</th>";
		else
			calStr += "<th>" + weekNames[i] + "</th>";
	}
	calStr += "</tr>";
		
		
	// 빈 칸 공백 td 발생
	calStr += "<tr>";
	for(int i=1; i<=week; i++)
	{
		calStr += "<td></td>";
	}
		
	// 날짜 td 발생
	for(int i=1; i<=lastDay; i++)
	{
		week++;
			
		if(selectYear==nowYear && selectMonth==nowMonth && i==nowDay && week%7==0)
			calStr += "<td class='nowSat'>" + i + "</td>";
		else if (selectYear==nowYear && selectMonth==nowMonth && i==nowDay && week%7==1)
			calStr += "<td class='nowSun'>" + i + "</td>";
		else if (selectYear==nowYear && selectMonth==nowMonth && i==nowDay)
			calStr += "<td class='now'>" + i + "</td>";
		else if(week%7==0)
			calStr += "<td class='sat'>" + i + "</td>";
		else if(week%7==1)
			calStr += "<td class='sun'>" + i + "</td>";
		else
			calStr += "<td>" + i + "</td>";		
			
		// 일요일일 때마다 개행
		if(week%7==0)
		{
			calStr += "</tr><tr>"; 
		}
	}
			
		// 빈 칸 공백 td 발생
		for(int i=0; i<week; i++,week++)
		{
			if(week%7==0)
				break;
				
			calStr += "<td></td>";
		}
			
		if(week%7!=0)
			calStr += "</tr>";
				
		calStr += "</table>";
		
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive08.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	a {text-decoration: none;}
	td {text-align: center;}
	td.now {background-color: #fddde8; font-weight: bold;}
	td.sat {color: blue;}
	td.sun {color: red;}
	table {margin-left:40%;}
	form {margin-left: 40%;}
	h1 {margin-left: 40%;}
</style>
<script type="text/javascript">
	
	function formChange(obj)
	{
		obj.submit();
	}
	
</script>

</head>
<body>

<!--  
	○ 데이터 송수신 실습 08
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 연도와 월을 입력받아 화면에 출력해주는 형태의 페이지로 구성한다.
	   - 단, submit 버튼 없이 이벤트 처리를 한다.
	   - 전송한 내용을 수신해서 출력해주는 형태의 단독 페이지로 구성한다.
	   
	   <a>태그 링크 사용			
	   ---								// 2022년 4월에서 오른편 클릭햇을 때 2022년 5월!!
	   ◀ 2022년 4월 ▶				// 2022년 4월에서 왼편 클릭햇을 때 2022년 3월!!
	   
	   ------------------------------
	   ------------------------------
	   ------------------------------
	   ------------------------------
	   
	   - 『◀』 이나 『▶』 클릭 시
	     해당 년 월의 달력을 출력해주는 형태의 페이지로 구성한다.
	       
	   - 사용자 최초 요정 주소는
	     http://localhost:8090/WebApp07/SendAndReceive08.jsp 로 한다.
	     
	○ SendAndReceive08.jsp   
-->


<div>
	<h1>데이터 송수신 실습 08</h1>
	<hr>
</div>
<br>
<div>
	<form action="" method="get">
		<a href="SendAndReceive08.jsp?year=<%=preYear %>&month=<%=preMonth%>">◀</a>
		<%=selectYear %>년 <%=selectMonth %>월
		<a href="SendAndReceive08.jsp?year=<%=nextYear %>&month=<%=nextMonth%>">▶</a>
		<br>
	</form>
</div>

<br>

<div>
	<%=calStr %>
</div>
</body>
</html>