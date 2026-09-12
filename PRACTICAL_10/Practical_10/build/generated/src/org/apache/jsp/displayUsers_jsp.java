package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class displayUsers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("    <title>All Registered Users</title>\n");
      out.write("    <style>\n");
      out.write("        table {\n");
      out.write("            width: 50%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #dddddd;\n");
      out.write("            text-align: left;\n");
      out.write("            padding: 8px;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>User Records List</h2>\n");
      out.write("\n");

    String dbURL = "jdbc:mysql://localhost:3306/mydatabase";
    String dbUser = "root";
    String dbPass = "root";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        stmt = conn.createStatement();
        String sql = "SELECT * FROM users";
        rs = stmt.executeQuery(sql);

      out.write("\n");
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>Username</th>\n");
      out.write("            <th>Password</th>\n");
      out.write("        </tr>\n");

        boolean hasRecords = false;
        while (rs.next()) {
            hasRecords = true;

      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( rs.getString("username") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("password") );
      out.write("</td>\n");
      out.write("        </tr>\n");

        }

        if (!hasRecords) {
            out.println("<tr><td colspan='2'>No users found in the database.</td></tr>");
        }

      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");

    } catch (ClassNotFoundException e) {
        out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
    } catch (SQLException e) {
        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
    }

      out.write("\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <a href=\"register.html\">Add New User</a> | \n");
      out.write("    <a href=\"login.html\">Go to Login</a>\n");
      out.write("</body>\n");
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
