<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Get Session</title>
</head>
<body>
    <h2>Retrieved Session Value:</h2>
    <%
        String sessionVal = (String) session.getAttribute("userSessionKey");
        if (sessionVal != null) {
    %>
            <p><strong>Session Value:</strong> <%= sessionVal %></p>
    <%
        } else {
    %>
            <p><strong>No session variable found!</strong></p>
    <%
        }
    %>
</body>
</html>