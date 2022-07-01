<%@page import="java.net.URLDecoder"%>
<%@page import="com.test.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.util.MyUtil"%>
<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
//  프로젝트의 path만 가져옴 즉, /WebApp20만 가져옴
	String cp = request.getContextPath();
%>
<%
	/*
		우리 보통 데이터 전송하는 실습할 때,
		send 페이지 1개, receive 페이지 1개 짝지어서 만듦.
		얘네 사이의 거리가 발생하면서 토스하고 사이에서 로직처리를 하게 하는 개념이 등장하면서
		이것을 포워딩 처리하느냐, 리다이렉트 시키느냐에 대한 논의를 함.
		우리 sendAndReceive 파일을 만듦.
		
		List.jsp 는 내가 요청한 페이지도 list 파일,
		요청해서 이동할 페이지도 list 파일이므로
		내가 먼저 받아야함
		
		물론 상황에 따라 article.jsp 가 될 수도 있고,
		updatedForm.jsp 가 될 수도 있긴 한데,
		일단 지금보면 list.jsp 인 것.

	*/
	// 이전 페이지로부터 넘어온 게시물 번호 수신
	String strNum = request.getParameter("num");
	int num = 0;
	if (strNum != null)
		num = Integer.parseInt(strNum);
	
	// 이전 페이지로부터 넘어온 페이지 번호 수신
	String pageNum = request.getParameter("pageNum");
	int currentPage = 1;
	if (pageNum != null)
		currentPage = Integer.parseInt(pageNum);
	
	// 이전 페이지로부터 검색 키와 검색 값 수신
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
	
	if (searchKey != null)		//-- 검색 기능을 통해 이 페이지가 요청되었을 경우
	{
		// 넘어온 값이 GET 방식이라면...
		// → GET 은 한글 문자열을 인코딩해서 보내기 때문에...
		// 페이지 인코딩이랑 키값을 가져오는 인코딩 방식은 다름
		//  request : HTML Form 을 통해 전달되는 값을 가져올 때 사용
		//	getMethod() : 현재 요청이 GET, POST 인지 확인하여 가져옴
		// 	equalsIgnoreCase() : 대소문자 구분 안하고 비교
		if (request.getMethod().equalsIgnoreCase("GET"))
		{
			// 디코딩 처리
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
	}
	else						//-- 검색 기능이 아닌 기본적인 페이지 요청이 이루어졌을 경우
	{
		searchKey = "subject";
		searchValue = "";
	}

	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	MyUtil myUtil = new MyUtil();


	// 전체 데이터 갯수 구하기
	int dataCount = dao.getDataCount(searchKey, searchValue);
	
	
	// 전체 페이지를 기준으로 총 페이지 수 계산
	int numPerPage = 10;			//-- 한 페이지에 표시할 데이터 갯수
	int totalPage = myUtil.getPageCount(numPerPage, dataCount);
	
	
	// 전체 페이지 수 보다 표시할 페이지가 큰 경우
	// 표시할 페이지를 전체 페이지로 처리
	// → 한 마디로, 데이터를 삭제해서 페이지가 줄어들었을 경우...
	if (currentPage > totalPage)
		currentPage = totalPage;
	
	
	// 데이터베이스에서 가져올 시작과 끝 위치
	// 4(5페이지-1)*한페이지에 10개 = 40+1
	int start = (currentPage-1) * numPerPage + 1;
	int end = currentPage * numPerPage;
	
	
	// 실제 리스트 가져오기
	List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);
	
	
	// 페이징 처리
	// 페이징 처리란 출력될 페이지만 나눠서 가져오는 것
	String param = "";
	
	
	// 검색값이 존재한다면...
	if (!searchValue.equals(""))
	{
		// ""사이에는 공백이 존재하면 안된다.
		param += "?searchKey=" + searchKey;
		param += "&searchValue=" + searchValue;
	}
	
		
	String listUrl = "List.jsp" + param;
	String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);
	
	
	// 글 내용 보기 주소
	String articleUrl = cp + "/Article.jsp";
		
	if (param.equals(""))
	{
		// article 의 목적 : 리스트 내에서 클릭해서 상세 정보 보는거
    	// pageNum을 넘겨주는 이유 : 리스트 돌아가기 시에 원래 있던 페이지로 이동하기 위해서
		articleUrl = articleUrl + "?pageNum=" + currentPage;
	}
	else
	{
		articleUrl = articleUrl + param + "&pageNum=" + currentPage;
	}
	
	DBConn.close();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/list.css">
<script type="text/javascript">

	function sendIt()
	{
		var f = document.searchForm;
		
		// 검색 키워드에 대한 유효성 검사 코드 활용 가능~!!!
		
		// check~!!!
		// action에서 지정되어도 수정하거나, 없는걸 지정가능
		f.action = "<%=cp%>/List.jsp";
		
		f.submit();
	}

</script>
</head>
<body>

<%-- 
<div>
	<h1><%=cp %></h1>
</div>
--%>


<div id="bbsList">

	<div id="bbsList_title">
		게 시 판 (JDBC 연동 버전)
	</div>
	
	<div id="bbsList_header">
	
		<div id="leftHeader">
		
			<!-- 검색 폼 구성 -->
			<form action="" name="searchForm" method="post">
				<select name="searchKey" class="selectFiled">
					
					<!-- 
					<option value="subject">제목</option>
					<option value="name">작성자</option>
					<option value="content">내용</option>
				 	-->
				 	
					<%
					if (searchKey.equals("name"))			// 수신한 searchKey 가 name 이라면...
					{
					%>
						<option value="subject">제목</option>
						<option value="name" selected="selected">작성자</option>
						<option value="content">내용</option>
					<%
					}
					else if (searchKey.equals("content"))	// 수신한 searchKey 가 content 라면...
					{
					%>
						<option value="subject">제목</option>
						<option value="name">작성자</option>
						<option value="content" selected="selected">내용</option>
					<%
					}
					else									// 수신한 searchKey 가 subject 이거나... 없으면...
					{
					%>
						<option value="subject">제목</option>
						<option value="name">작성자</option>
						<option value="content">내용</option>
					<%
					}
					%>
					
				</select>
				<input type="text" name="searchValue" class="textFiled" value="<%=searchValue%>">
				<input type="button" value="검색" class="btn2" onclick="sendIt()">
			</form>
			
			
		</div><!-- #leftHeader -->
		
		<div id="rightHeader">
			<input type="button" value="글올리기" class="btn2"
			onclick="javascript:location.href='<%=cp%>/Created.jsp'">
		</div><!-- #rightHeader -->
		
	</div><!-- #bbsList_header -->


	<div id="bbsList_list">

		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div><!-- #title -->
		
		<div id="lists">
			<!-- 
			<dl>
				<dd class="num">1</dd>
				<dd class="subject">안녕하세요</dd>
				<dd class="name">김정용</dd>
				<dd class="created">2022-04-25</dd>
				<dd class="hitCount">0</dd>
			</dl>
			-->
			
			<%
			for (BoardDTO dto : lists)
			{
			%>  
			 
			<dl>
				<dd class="num"><%=dto.getNum() %></dd>
				<dd class="subject">
					<a href="<%=articleUrl%>&num=<%=dto.getNum()%>"><%=dto.getSubject() %></a>
				</dd>
			</dl>
			<dl>
				<dd class="name"><%=dto.getName() %></dd>
				<dd class="created"><%=dto.getCreated() %></dd>
				<dd class="hitCount"><%=dto.getHitCount() %></dd>
			</dl>
			
			<%
			}
			%>
			
		</div>
		
		<div id="footer">
		
			<!-- <p>1 Prev 21 22 23 24 25 26 27 28 29 30 Next 42</p> -->
			<!-- <p>등록된 게시물이 존재하지 않습니다.</p> -->
			
			<p>
			
			<%
			if (dataCount != 0)
			{
			%>
				<%=pageIndexList %>
			<%
			}
			else
			{
			%>
				등록된 게시물이 존재하지 않습니다.
			<%
			}
			%>
			
			</p>
			
			
		</div><!-- #footer -->
		
		
	</div><!-- #bbsList_list -->



</div><!-- #bbsList -->




























</body>
</html>