<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// MemberDelete.jsp
	//-- 이전페이지(MemberSelete.jsp)로부터 넘어온 데이터(sid) 수신
	
	String sid = request.getParameter("sid");
	
	MemberDAO dao = new MemberDAO();
	
	// 사용자가 요청할 url, 리다이렉트 될 주소를 담을 것임
	// 시은이부터는 삭제 되지만 이삭이는 쉽게 삭제가 안돼 ~
	String strAddr = "";
	
	try
	{
		// 데이터베이스 연결
		dao.connection();
		
		// dao.remove(sid) -> 불가능
		
		// 참조 레코드 수 확인
		int checkCount = dao.refCount(sid);
		//-- TBL_MEMBER 테이블의 제거하고자 하는 데이터의
		//   SID 를 참조하는 TBL_MEMBERSCORE 테이블 내의 데이터 갯수 확인
		
		if(checkCount == 0)		// 제거 가능
		{
			dao.remove(sid);
			strAddr = "MemberSelect.jsp";
		}
		else					// 제거 불가
		{
			//dao.remove(sid);
			//-- TBL_MEMBERSCORE 테이블의 데이터가
			//   TBL_MEMBER 테이블의 SID를 참조하고 있는 경우로
			//   삭제가 불가능한 상황
			//-- 제거하지 못하는 사유를 안내하는 페이지로 이동
			//	 + 리스트로 돌아가기 번호
			
			strAddr = "Notice.jsp";
			
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	finally
	{
		try
		{
			// 데이터베이스 연결 종료
			dao.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	// check ★
	// 클라이언트가 MemberSelect.jsp 페이지를 다시 요청할 수 있도록 안내
	response.sendRedirect(strAddr);

	// 아래 문서 보여주는 코드 모두 제거
%>
