<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Stored Cookies</title>
    <style>
        table { border-collapse: collapse; width: 50%; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Client-Side Cookies</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
%>
    <table>
        <thead>
            <tr>
                <th>Cookie Name</th>
                <th>Cookie Value</th>
            </tr>
        </thead>
        <tbody>
<%
        for (Cookie c : cookies) {
%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
            </tr>
<%
        }
%>
        </tbody>
    </table>
<%
    } else {
%>
        <p>No cookies found on the client browser.</p>
<%
    }
%>
</body>
</html>