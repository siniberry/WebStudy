/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2022-05-20 03:44:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Created_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Created.jsp</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/css/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/css/created.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp);
      out.write("/js/util.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\tfunction sendIt()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tf = document.myForm;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 제목 입력 확인-----------------------------------\r\n");
      out.write("\t\t// 필수 입력 항목 기재 여부 확인 및 공백 처리\r\n");
      out.write("\t\tstr = f.subject.value;\r\n");
      out.write("\t\tstr = str.trim();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// ※ javascript 에는 trim() 이 존재하지 않음.\r\n");
      out.write("\t\t//\t  외부에서 참조한 util.js 에 만들어두었음.\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 테스트\r\n");
      out.write("\t\t//alert(\"|\" + str + \"|\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!str)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"\\n제목을 입력하세요~!!!\");\r\n");
      out.write("\t\t\tf.subject.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// ---------------------------------- 제목 입력 확인\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 이름 입력 확인-----------------------------------\r\n");
      out.write("\t\t// 필수 입력 항목 기재 여부 확인 및 공백 처리\r\n");
      out.write("\t\tstr = f.name.value;\r\n");
      out.write("\t\tstr = str.trim();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!str)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"\\n이름을 입력하세요~!!!\")\r\n");
      out.write("\t\t\tf.name.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// ---------------------------------- 이름 입력 확인\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 이메일 검사 -------------------------------------\r\n");
      out.write("\t\t// 필수 입력 항목이 아니므로 선택적인 입력이 가능하지만\r\n");
      out.write("\t\t// 입력을 한 상황이면, 이메일 형식에 맞게 입력했는 지\r\n");
      out.write("\t\t// 확인하는 처리\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (f.email.value) // 이메일을 입력한 상황이라면...\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif (!isValidEmail(f.email.value))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"\\n정상적인 이메일 형식을 입력하세요~!!!\");\r\n");
      out.write("\t\t\t\tf.email.focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// ------------------------------------- 이메일 검사\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 내용 입력 확인-----------------------------------\r\n");
      out.write("\t\t// 필수 입력 항목 기재 여부 확인 및 공백 처리\r\n");
      out.write("\t\tstr = f.content.value;\r\n");
      out.write("\t\tstr = str.trim();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!str)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"\\n내용을 입력하세요~!!!\");\r\n");
      out.write("\t\t\tf.content.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// ---------------------------------- 내용 입력 확인\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t// 패스워드 입력 확인-----------------------------------\r\n");
      out.write("\t\t// 필수 입력 항목 기재 여부 확인 및 공백 처리\r\n");
      out.write("\t\tstr = f.pwd.value;\r\n");
      out.write("\t\tstr = str.trim();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!str)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"\\n패스워드를 입력하세요~!!!\");\r\n");
      out.write("\t\t\tf.pwd.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// ---------------------------------- 패스워드 입력 확인\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tf.action = \"");
      out.print(cp );
      out.write("/Created_ok.jsp\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tf.submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"bbs\">\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"bbs_title\">\r\n");
      out.write("\t\t게 시 판 (JDBC 연동 버전)\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"\" method=\"post\" name=\"myForm\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"bbsCreated\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"subject\" size=\"64\" maxlength=\"100\" class=\"boxTF\">\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div><!-- close bbsCreated_bottomLine -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>작 성 자</dt>\t\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"name\" size=\"35\" maxlength=\"20\" class=\"boxTF\">\r\n");
      out.write("\t\t\t\t\t</dd>\t\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div> <!-- end bbsCreated_bottomLine -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>이 메 일</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"email\" name=\"email\" size=\"35\" maxlength=\"50\" class=\"boxTF\">\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div><!-- closed .bbsCreated_bottomLine -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div id=\"bbsCreated_content\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<textarea rows=\"12\" cols=\"63\" name=\"content\" class=\"boxTA\"></textarea>\r\n");
      out.write("\t\t\t\t\t</dd>\t\t\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div><!-- close #bbsCreated_content -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"bbsCreated_noLine\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>패스워드</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"pwd\" size=\"35\" maxlength=\"10\" class=\"boxTF\">\r\n");
      out.write("\t\t\t\t\t\t&nbsp;<span style=\"font-size: 6pt;\">(게시물 수정 및 삭제 시 필요)</span>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div> <!-- close .bbsCreated_noLine -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"bbsCreated_footer\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"등록하기\" class=\"btn2\" onclick=\"sendIt()\">\r\n");
      out.write("\t\t\t\t<input type=\"reset\" value=\"다시입력\" class=\"btn2\" \r\n");
      out.write("\t\t\t\tonclick=\"document.myForm.subject.focus();\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"작성취소\" class=\"btn2\"\r\n");
      out.write("\t\t\t\tonclick=\"javascript:location.href='");
      out.print(cp);
      out.write("/List.jsp'\">\r\n");
      out.write("\t\t\t</div><!-- close #bbsCreated_footer -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- close #bbsCreated -->\r\n");
      out.write("\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</div><!-- close #bbs -->\r\n");
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
