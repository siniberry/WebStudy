<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%	
	// GetTest02_ok.jsp

	String nickName = request.getParameter("nickName");
	
	
	/* if (!(nickName.equals("") || nickName.equals(" ")))
		result = String.format("%s님안녕하세요.<br>반갑습니다.", nickName); */
	
	
	
%>
<%-- <%=nickName%>님안녕하세요.<br>반갑습니다. --%>
${param.nickName}님 안녕하세요.
<br>
반갑습니다.