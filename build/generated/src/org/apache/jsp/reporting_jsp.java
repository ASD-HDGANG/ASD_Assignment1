package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reporting_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\"> \n");
      out.write("\t<title>Reporting</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\">  \n");
      out.write("\t<script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form role=\"form\">\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"name\">What problem you just met? </label>\n");
      out.write("\t\t<textarea class=\"form-control\" rows=\"5\"></textarea>\n");
      out.write("\t</div>\n");
      out.write("    \n");
      out.write("</form>\n");
      out.write("   \n");
      out.write("\t  <div class=\"col-sm-offset-2 col-sm-20\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t <a class=\"button\"  href =\"reportManage.jsp\">send</a>\n");
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("    <div class=\"col-sm-offset-2 col-sm-20\">\n");
      out.write("\t\t\t\n");
      out.write("\t\n");
      out.write("                 <a class=\"button\"  href =\"main.jsp\">back</a>\n");
      out.write("            </div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
