<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Registered Users</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>User Records List</h2>

<%
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
%>

    <table>
        <tr>
            <th>Username</th>
            <th>Password</th>
        </tr>
<%
        boolean hasRecords = false;
        while (rs.next()) {
            hasRecords = true;
%>
        <tr>
            <td><%= rs.getString("username") %></td>
            <td><%= rs.getString("password") %></td>
        </tr>
<%
        }

        if (!hasRecords) {
            out.println("<tr><td colspan='2'>No users found in the database.</td></tr>");
        }
%>
    </table>

<%
    } catch (ClassNotFoundException e) {
        out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
    } catch (SQLException e) {
        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
    }
%>

    <br>
    <a href="register.html">Add New User</a> | 
    <a href="login.html">Go to Login</a>
</body>
</html>