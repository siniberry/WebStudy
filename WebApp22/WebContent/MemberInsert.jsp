<%@page import="java.util.List"%>
<%@page import="com.test.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	//MemberInsert.jsp

	// 5명분 데이터 수신 → 객체 구성 → 자료구조 구성 → setAttribute()
	//						MemberDTO
	
	// MemberList.jsp 를 요청할 수 있도록 안내
	
	List<MemberDTO> lists = new ArrayList<MemberDTO>();
	
	for(int i=1; i<6; i++)
	{
		MemberDTO dto = new MemberDTO();
		
		dto.setName(request.getParameter("name" + i));
		dto.setTel(request.getParameter("tel"+ i));
		dto.setAddr(request.getParameter("addr"+ i));
		
		lists.add(dto);
	} 
	request.setAttribute("lists", lists);

	/* 
	라이언트로부터 최초에 들어온 요청을 
	JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 
	특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스
	즉 /MemberInsert.jsp 로 들어온 요청을 /MemberInsert.jsp 내에서 
	RequestDispatcher를 사용하여 MemberList.jsp로 요청을 보낼 수 있다
	 */
	RequestDispatcher rd = request.getRequestDispatcher("MemberList.jsp");
	rd.forward(request, response);
	
%>

<%-- <jsp:forward page="MemberList.jsp"></jsp:forward> --%>
