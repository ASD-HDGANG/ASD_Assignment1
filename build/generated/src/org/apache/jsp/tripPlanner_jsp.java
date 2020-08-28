package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tripPlanner_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\"> \n");
      out.write("\t<title>Trip Planner</title> \n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\">  \n");
      out.write("\t<script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Report.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\n");
      out.write("    <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"departure\" class=\"col-sm-2 control-label\">Input your departure:</label>\n");
      out.write("\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" id=\"departure\" \n");
      out.write("\t\t\t\t   placeholder=\"Input your departure:\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"destination\" class=\"col-sm-2 control-label\">destination</label>\n");
      out.write("\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" id=\"destination\" \n");
      out.write("\t\t\t\t   placeholder=\"input your destination:\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t<div class=\"checkbox\">\n");
      out.write("\t\t\t\t<label>\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\"> remember\n");
      out.write("\t\t\t\t</label>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t <a class=\"button\"  href =\"tripPlannerServlet\">Search</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t <a class=\"button\"  href =\"main.jsp\">Back</a>\n");
      out.write("            </div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("<div class=\"container\" align=\"center\">\n");
      out.write("\t<h2>Map</h2>\n");
      out.write("\t<p> </p>            \n");
      out.write("\t<img src=\"css/train.jpg\" class=\"img-rounded\" alt=\" \" width=\"600\" height=\"500\"> \n");
      out.write("</div>\n");
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
