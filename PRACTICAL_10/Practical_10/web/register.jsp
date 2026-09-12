<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
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

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user);
        pstmt.setString(2, pass);

        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            out.println("<h3 style='color:green;'>Registration Successful!</h3>");
            out.println("<a href='login.html'>Click here to Login</a>");
        } else {
            out.println("<h3 style='color:red;'>Registration Failed. Try again.</h3>");
            out.println("<a href='register.html'>Try Again</a>");
        }

    } catch (SQLIntegrityConstraintViolationException e) {
        out.println("<h3 style='color:red;'>Username already exists! Choose another.</h3>");
        out.println("<a href='register.html'>Try Again</a>");
    } catch (ClassNotFoundException e) {
        out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
    } catch (SQLException e) {
        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");
    } finally {
        if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
    }
%>
</body>
</html>