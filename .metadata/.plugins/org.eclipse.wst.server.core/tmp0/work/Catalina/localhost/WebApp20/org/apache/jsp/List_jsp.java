/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2022-05-20 03:43:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;
import com.test.BoardDTO;
import java.util.List;
import com.util.MyUtil;
import com.test.BoardDAO;
import com.util.DBConn;
import java.sql.Connection;

public final class List_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.util.MyUtil");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.net.URLDecoder");
    _jspx_imports_classes.add("com.util.DBConn");
    _jspx_imports_classes.add("com.test.BoardDAO");
    _jspx_imports_classes.add("com.test.BoardDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
//  프로젝트의 path만 가져옴 즉, /WebApp20만 가져옴
	String cp = request.getContextPath();

      out.write('\r');
      out.write('\n');

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


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>List.jsp</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/css/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/css/list.css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction sendIt()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar f = document.searchForm;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 검색 키워드에 대한 유효성 검사 코드 활용 가능~!!!\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// check~!!!\r\n");
      out.write("\t\t// action에서 지정되어도 수정하거나, 없는걸 지정가능\r\n");
      out.write("\t\tf.action = \"");
      out.print(cp);
      out.write("/List.jsp\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tf.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"bbsList\">\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"bbsList_title\">\r\n");
      out.write("\t\t게 시 판 (JDBC 연동 버전)\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"bbsList_header\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"leftHeader\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<!-- 검색 폼 구성 -->\r\n");
      out.write("\t\t\t<form action=\"\" name=\"searchForm\" method=\"post\">\r\n");
      out.write("\t\t\t\t<select name=\"searchKey\" class=\"selectFiled\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<option value=\"subject\">제목</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"name\">작성자</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"content\">내용</option>\r\n");
      out.write("\t\t\t\t \t-->\r\n");
      out.write("\t\t\t\t \t\r\n");
      out.write("\t\t\t\t\t");

					if (searchKey.equals("name"))			// 수신한 searchKey 가 name 이라면...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">제목</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\" selected=\"selected\">작성자</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\">내용</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					else if (searchKey.equals("content"))	// 수신한 searchKey 가 content 라면...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">제목</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\">작성자</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\" selected=\"selected\">내용</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					else									// 수신한 searchKey 가 subject 이거나... 없으면...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">제목</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\">작성자</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\">내용</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"searchValue\" class=\"textFiled\" value=\"");
      out.print(searchValue);
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"검색\" class=\"btn2\" onclick=\"sendIt()\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- #leftHeader -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"rightHeader\">\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"글올리기\" class=\"btn2\"\r\n");
      out.write("\t\t\tonclick=\"javascript:location.href='");
      out.print(cp);
      out.write("/Created.jsp'\">\r\n");
      out.write("\t\t</div><!-- #rightHeader -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div><!-- #bbsList_header -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"bbsList_list\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"title\">\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dt class=\"num\">번호</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"subject\">제목</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"name\">작성자</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"created\">작성일</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"hitCount\">조회수</dt>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t</div><!-- #title -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"lists\">\r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dd class=\"num\">1</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"subject\">안녕하세요</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"name\">김정용</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"created\">2022-04-25</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"hitCount\">0</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t-->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

			for (BoardDTO dto : lists)
			{
			
      out.write("  \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dd class=\"num\">");
      out.print(dto.getNum() );
      out.write("</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"subject\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(articleUrl);
      out.write("&num=");
      out.print(dto.getNum());
      out.write('"');
      out.write('>');
      out.print(dto.getSubject() );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dd class=\"name\">");
      out.print(dto.getName() );
      out.write("</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"created\">");
      out.print(dto.getCreated() );
      out.write("</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"hitCount\">");
      out.print(dto.getHitCount() );
      out.write("</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<!-- <p>1 Prev 21 22 23 24 25 26 27 28 29 30 Next 42</p> -->\r\n");
      out.write("\t\t\t<!-- <p>등록된 게시물이 존재하지 않습니다.</p> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

			if (dataCount != 0)
			{
			
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(pageIndexList );
      out.write("\r\n");
      out.write("\t\t\t");

			}
			else
			{
			
      out.write("\r\n");
      out.write("\t\t\t\t등록된 게시물이 존재하지 않습니다.\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- #footer -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div><!-- #bbsList_list -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div><!-- #bbsList -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
