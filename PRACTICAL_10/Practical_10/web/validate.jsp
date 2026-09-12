<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Validation Result</title>
</head>
<body>
<%
   
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    String dbURL = "jdbc:mysql://localhost:3306/mydatabase";
    String dbUser = "root";
    String dbPass = "root";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user);
        pstmt.setString(2, pass);

        rs = pstmt.executeQuery();

        if (rs.next()) {
            out.println("<h3>Login Successful! Welcome, " + user + "</h3>");
        } else {
            out.println("<h3 style='color:red;'>Invalid Username or Password!</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }

    } catch (ClassNotFoundException e) {
        out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
    } catch (SQLException e) {
        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
    }
%>
</body>
</html>