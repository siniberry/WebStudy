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
//  ??????????????? path??? ????????? ???, /WebApp20??? ?????????
	String cp = request.getContextPath();

      out.write('\r');
      out.write('\n');

	/*
		?????? ?????? ????????? ???????????? ????????? ???,
		send ????????? 1???, receive ????????? 1??? ???????????? ??????.
		?????? ????????? ????????? ??????????????? ???????????? ???????????? ??????????????? ?????? ?????? ????????? ???????????????
		????????? ????????? ???????????????, ??????????????? ??????????????? ?????? ????????? ???.
		?????? sendAndReceive ????????? ??????.
		
		List.jsp ??? ?????? ????????? ???????????? list ??????,
		???????????? ????????? ???????????? list ???????????????
		?????? ?????? ????????????
		
		?????? ????????? ?????? article.jsp ??? ??? ?????? ??????,
		updatedForm.jsp ??? ??? ?????? ?????? ??????,
		?????? ???????????? list.jsp ??? ???.

	*/
	// ?????? ?????????????????? ????????? ????????? ?????? ??????
	String strNum = request.getParameter("num");
	int num = 0;
	if (strNum != null)
		num = Integer.parseInt(strNum);
	
	// ?????? ?????????????????? ????????? ????????? ?????? ??????
	String pageNum = request.getParameter("pageNum");
	int currentPage = 1;
	if (pageNum != null)
		currentPage = Integer.parseInt(pageNum);
	
	// ?????? ?????????????????? ?????? ?????? ?????? ??? ??????
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
	
	if (searchKey != null)		//-- ?????? ????????? ?????? ??? ???????????? ??????????????? ??????
	{
		// ????????? ?????? GET ???????????????...
		// ??? GET ??? ?????? ???????????? ??????????????? ????????? ?????????...
		// ????????? ??????????????? ????????? ???????????? ????????? ????????? ??????
		//  request : HTML Form ??? ?????? ???????????? ?????? ????????? ??? ??????
		//	getMethod() : ?????? ????????? GET, POST ?????? ???????????? ?????????
		// 	equalsIgnoreCase() : ???????????? ?????? ????????? ??????
		if (request.getMethod().equalsIgnoreCase("GET"))
		{
			// ????????? ??????
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
	}
	else						//-- ?????? ????????? ?????? ???????????? ????????? ????????? ??????????????? ??????
	{
		searchKey = "subject";
		searchValue = "";
	}

	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	MyUtil myUtil = new MyUtil();


	// ?????? ????????? ?????? ?????????
	int dataCount = dao.getDataCount(searchKey, searchValue);
	
	
	// ?????? ???????????? ???????????? ??? ????????? ??? ??????
	int numPerPage = 10;			//-- ??? ???????????? ????????? ????????? ??????
	int totalPage = myUtil.getPageCount(numPerPage, dataCount);
	
	
	// ?????? ????????? ??? ?????? ????????? ???????????? ??? ??????
	// ????????? ???????????? ?????? ???????????? ??????
	// ??? ??? ?????????, ???????????? ???????????? ???????????? ??????????????? ??????...
	if (currentPage > totalPage)
		currentPage = totalPage;
	
	
	// ???????????????????????? ????????? ????????? ??? ??????
	// 4(5?????????-1)*??????????????? 10??? = 40+1
	int start = (currentPage-1) * numPerPage + 1;
	int end = currentPage * numPerPage;
	
	
	// ?????? ????????? ????????????
	List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);
	
	
	// ????????? ??????
	// ????????? ????????? ????????? ???????????? ????????? ???????????? ???
	String param = "";
	
	
	// ???????????? ???????????????...
	if (!searchValue.equals(""))
	{
		// ""???????????? ????????? ???????????? ?????????.
		param += "?searchKey=" + searchKey;
		param += "&searchValue=" + searchValue;
	}
	
		
	String listUrl = "List.jsp" + param;
	String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);
	
	
	// ??? ?????? ?????? ??????
	String articleUrl = cp + "/Article.jsp";
		
	if (param.equals(""))
	{
		// article ??? ?????? : ????????? ????????? ???????????? ?????? ?????? ?????????
    	// pageNum??? ???????????? ?????? : ????????? ???????????? ?????? ?????? ?????? ???????????? ???????????? ?????????
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
      out.write("\t\t// ?????? ???????????? ?????? ????????? ?????? ?????? ?????? ??????~!!!\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// check~!!!\r\n");
      out.write("\t\t// action?????? ??????????????? ???????????????, ????????? ????????????\r\n");
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
      out.write("\t\t??? ??? ??? (JDBC ?????? ??????)\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"bbsList_header\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"leftHeader\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<!-- ?????? ??? ?????? -->\r\n");
      out.write("\t\t\t<form action=\"\" name=\"searchForm\" method=\"post\">\r\n");
      out.write("\t\t\t\t<select name=\"searchKey\" class=\"selectFiled\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<option value=\"subject\">??????</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"name\">?????????</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"content\">??????</option>\r\n");
      out.write("\t\t\t\t \t-->\r\n");
      out.write("\t\t\t\t \t\r\n");
      out.write("\t\t\t\t\t");

					if (searchKey.equals("name"))			// ????????? searchKey ??? name ?????????...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">??????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\" selected=\"selected\">?????????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\">??????</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					else if (searchKey.equals("content"))	// ????????? searchKey ??? content ??????...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">??????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\">?????????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\" selected=\"selected\">??????</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					else									// ????????? searchKey ??? subject ?????????... ?????????...
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"subject\">??????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"name\">?????????</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"content\">??????</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"searchValue\" class=\"textFiled\" value=\"");
      out.print(searchValue);
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"??????\" class=\"btn2\" onclick=\"sendIt()\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- #leftHeader -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"rightHeader\">\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"????????????\" class=\"btn2\"\r\n");
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
      out.write("\t\t\t\t<dt class=\"num\">??????</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"subject\">??????</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"name\">?????????</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"created\">?????????</dt>\r\n");
      out.write("\t\t\t\t<dt class=\"hitCount\">?????????</dt>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t</div><!-- #title -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"lists\">\r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dd class=\"num\">1</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"subject\">???????????????</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"name\">?????????</dd>\r\n");
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
      out.write("\t\t\t<!-- <p>????????? ???????????? ???????????? ????????????.</p> -->\r\n");
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
      out.write("\t\t\t\t????????? ???????????? ???????????? ????????????.\r\n");
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
