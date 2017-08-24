package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>DataBaseBenchmark</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <style>\r\n");
      out.write("    body {background:url(images/background39.png);}\r\n");
      out.write("    a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    outline: none;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    width: 140px;\r\n");
      out.write("    height: 45px;\r\n");
      out.write("    line-height: 45px;\r\n");
      out.write("    border-radius: 45px;\r\n");
      out.write("    margin: 10px 20px;\r\n");
      out.write("    font-family: 'Montserrat', sans-serif;\r\n");
      out.write("    font-size: 11px;\r\n");
      out.write("    text-transform: uppercase;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    letter-spacing: 3px;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    color: #524f4e;\r\n");
      out.write("    background: white;\r\n");
      out.write("    box-shadow: 0 8px 15px rgba(0,0,0,.1);\r\n");
      out.write("    transition: .3s;\r\n");
      out.write("    }\r\n");
      out.write("    a:hover {\r\n");
      out.write("    background: #2EE59D;\r\n");
      out.write("    box-shadow: 0 15px 20px rgba(46,229,157,.4);\r\n");
      out.write("    color: white;\r\n");
      out.write("    transform: translateY(-7px);\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("    <body>\r\n");
      out.write("        <img src=\"../images/background39.jpg\" width=\"198\" height=\"198\" alt=\"background39\"/>\r\n");
      out.write("        <a href=\"Data.htm\">Data List</a>\r\n");
      out.write("        <br>\r\n");
      out.write("        <a href=\"Menu.htm\">Menu</a>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
