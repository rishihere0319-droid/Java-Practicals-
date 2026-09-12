<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    session.setAttribute("userSessionKey", "Prasad_123");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Set Session</title>
</head>
<body>
    <h2>Session Variable Set Successfully!</h2>
    <a href="getSession.jsp">Click here to view Session Variable</a>
</body>
</html>