package org.apache.jsp;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Ordenar comida</title>\n");
      out.write("    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"./css/styles.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container mt-5\">\n");
      out.write("        <h1>Ordenar comida rápida</h1>\n");
      out.write("        <div class=\"row chat-window col-xs-5 col-md-3\" id=\"chat_window_1\" style=\"margin-left:10px;\">\n");
      out.write("            <div class=\"col-xs-12 col-md-12\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading top-bar\">\n");
      out.write("                        <div class=\"col-md-8 col-xs-8\">\n");
      out.write("                            <h3 class=\"panel-title\"><span class=\"glyphicon glyphicon-comment\"></span> Chat - Miguel</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4 col-xs-4\" style=\"text-align: right;\">\n");
      out.write("                            <a href=\"#\"><span id=\"minim_chat_window\"\n");
      out.write("                                    class=\"glyphicon glyphicon-minus icon_minim\"></span></a>\n");
      out.write("                            <a href=\"#\"><span class=\"glyphicon glyphicon-remove icon_close\"\n");
      out.write("                                    data-id=\"chat_window_1\"></span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body msg_container_base\">\n");
      out.write("                        <div class=\"row msg_container base_sent\">\n");
      out.write("                            <div class=\"col-md-10 col-xs-10\">\n");
      out.write("                                <div class=\"messages msg_sent\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row msg_container base_receive\">\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-10 col-xs-10\">\n");
      out.write("                                <div class=\"messages msg_receive\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row msg_container base_receive\">\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-10 col-md-10\">\n");
      out.write("                                <div class=\"messages msg_receive\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row msg_container base_sent\">\n");
      out.write("                            <div class=\"col-xs-10 col-md-10\">\n");
      out.write("                                <div class=\"messages msg_sent\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row msg_container base_receive\">\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-10 col-md-10\">\n");
      out.write("                                <div class=\"messages msg_receive\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row msg_container base_sent\">\n");
      out.write("                            <div class=\"col-md-10 col-xs-10 \">\n");
      out.write("                                <div class=\"messages msg_sent\">\n");
      out.write("                                    <p>that mongodb thing looks good, huh?\n");
      out.write("                                        tiny master db, and huge document store</p>\n");
      out.write("                                    <time datetime=\"2009-11-13T20:00\">Timothy • 51 min</time>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-xs-2 avatar\">\n");
      out.write("                                <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\"\n");
      out.write("                                    class=\" img-responsive \">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-footer\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <input id=\"btn-input\" type=\"text\" class=\"form-control input-sm chat_input\"\n");
      out.write("                                placeholder=\"Write your message here...\" />\n");
      out.write("                            <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-primary btn-sm\" id=\"btn-chat\">Send</button>\n");
      out.write("                            </span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"btn-group dropup\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                <span class=\"glyphicon glyphicon-cog\"></span>\n");
      out.write("                <span class=\"sr-only\">Toggle Dropdown</span>\n");
      out.write("            </button>\n");
      out.write("            <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                <li><a href=\"#\" id=\"new_chat\"><span class=\"glyphicon glyphicon-plus\"></span> Novo</a></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-list\"></span> Ver outras</a></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-remove\"></span> Fechar Tudo</a></li>\n");
      out.write("                <li class=\"divider\"></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-eye-close\"></span> Invisivel</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"./js/jquery-3.4.1.min.js\"></script>\n");
      out.write("    <script src=\"./js/popper.min.js\"></script>\n");
      out.write("    <script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"./js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
