<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Read Session Variable</title>
</head>
<body>
<%
  
    String userName = (String) session.getAttribute("user_name");
%>

    <h2>
        <% if (userName != null) { %>
            Welcome back, <%= userName %>!
        <% } else { %>
            No session variable found for User Name.
        <% } %>
    </h2>
    <a href="index.html">Go Back</a>
</body>
</html>