<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// MemberUpdate.jsp
	
	// sid, name, tel 다 가지고 와야함!
	request.setCharacterEncoding("UTF-8");
	String sid = request.getParameter("sid");			// check~!!!
	String name = request.getParameter("uName");
	String tel = request.getParameter("uTel");
	
	MemberDAO dao = new MemberDAO();
	
	try
	{
		dao.connection();
		
		// MemberDTO 구성	
		MemberDTO member = new MemberDTO();
		member.setSid(sid);
		member.setName(name);
		member.setTel(tel);
		
		// dao 의 modify() 메소드 호출 (MemberDTo 를 넘기기 때문에 MemberDTO 구성해야함!!)
		dao.modify(member);
		
		// 이후 반환 결과에 따른 분기 처리 가능 ~!!!
		
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
	
	//  MemberSelect.jsp 페이지 요청할 수 있도록 안내	
	response.sendRedirect("MemberSelect.jsp");
%>