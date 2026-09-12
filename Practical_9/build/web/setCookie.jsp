<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");

    if (username != null && !username.trim().isEmpty()) {
        // Create a new Cookie
        Cookie userCookie = new Cookie("user_name", username);
        
        // Set cookie age to 24 hours (86400 seconds)
        userCookie.setMaxAge(60 * 60 * 24);
        
        // Add cookie to the response
        response.addCookie(userCookie);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Saved</title>
</head>
<body>
    <h2>Cookie has been saved successfully!</h2>
    <a href="getCookie.jsp">Click here to view the saved cookie</a>
</body>
</html>