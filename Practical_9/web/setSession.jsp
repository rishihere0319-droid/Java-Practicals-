<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");

    if (username != null && !username.trim().isEmpty()) {
        // Store the user name in the HTTP session
        session.setAttribute("user_name", username);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Saved</title>
</head>
<body>
    <h2>User Name stored in session successfully!</h2>
    <a href="getSession.jsp">Click here to view the session variable</a>
</body>
</html>