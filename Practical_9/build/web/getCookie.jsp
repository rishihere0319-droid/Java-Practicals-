
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Read Cookie</title>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("user_name")) {
                userName = c.getValue();
                break;
            }
        }
    }
%>

    <h2>
        <% if (userName != null) { %>
            Welcome back, <%= userName %>!
        <% } else { %>
            No cookie found for User Name.
        <% } %>
    </h2>
    <a href="index.html">Go Back</a>
</body>
</html>