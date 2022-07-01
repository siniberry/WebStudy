<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	// JsonTest02_ok.jsp
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	// 반환해 줄 쿼리 스트링
	String result = "";
	
	
	// JSON 데이터(배열)
	// [{"이름1":"값1", "이름2":"값2", "이름3":"값3"}, {"이름1":"값1", "이름2":"값2", "이름3":"값3"}, {"이름1":"값1", "이름2":"값2", "이름3":"값3"}]
	
	// {"num":"1", "name":"임소민1", "content":"안녕하세요1"},		
	// {"num":"2", "name":"임소민2", "content":"안녕하세요2"},		
	// {"num":"3", "name":"임소민3", "content":"안녕하세요3"},		
	// {"num":"4", "name":"임소민4", "content":"안녕하세요4"},		
	// {"num":"5", "name":"임소민5", "content":"안녕하세요5"},
	
	//					↓
	
	// {"num":"1", "name":"임소민1", "content":"안녕하세요1"},		
	// {"num":"2", "name":"임소민2", "content":"안녕하세요2"},		
	// {"num":"3", "name":"임소민3", "content":"안녕하세요3"},		
	// {"num":"4", "name":"임소민4", "content":"안녕하세요4"},		
	// {"num":"5", "name":"임소민5", "content":"안녕하세요5"} 	← 마지막 컴마 제거
	
	//					↓
	
	// [{"num":"1", "name":"임소민1", "content":"안녕하세요1"},		
	// {"num":"2", "name":"임소민2", "content":"안녕하세요2"},		
	// {"num":"3", "name":"임소민3", "content":"안녕하세요3"},		
	// {"num":"4", "name":"임소민4", "content":"안녕하세요4"},		
	// {"num":"5", "name":"임소민5", "content":"안녕하세요5"} ]
	
			
	for(int i=1; i<=5; i++)
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("{\"num\":\"" + i + "\"");				
		sb.append(",\"name\":\"" + name + i + "\"");		
		sb.append(",\"content\":\"" + content + i + "\"},");			//-- check 『,』
		
		result += sb.toString();
		
		
	}		
			
	// 마지막 『,』 제거(탈락)
	result = result.substring(0, result.length()-1);
			
	// json 베열 객체 구성
	result = "[" + result + "]";
			
	out.println(result); 
	
	
	// 내가 한 풀이 
	/* 
	StringBuffer sb = new StringBuffer();
	
	//sb.append("[");		// check~!!
	sb.append("[");
	for(int i=1; i<=5; i++)
	{
		sb.append("{\"num\":\"" + i + "\"");				
		sb.append(",\"name\":\"" + name + "\"");		
		sb.append(",\"content\":\"" + content + "\"}");
		if (!(i>=5))
			sb.append(",");
	}
	sb.append("]");
	
	result=sb.toString();
	
	out.println(result); 
	*/
%>
