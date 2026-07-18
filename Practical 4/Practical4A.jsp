<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Intrinsic Objects</title>
</head>
<body>
    <h2>Saqlain Khan T013</h2>
<h1>Use of Intrinsic Objects in JSP</h1>
<h2>Request Object</h2>
Query String: <%= request.getQueryString() %><br>
Context Path: <%= request.getContextPath() %><br>
Remote Host: <%= request.getRemoteHost() %><br>
<h2>Response Object</h2>
Character Encoding: <%= response.getCharacterEncoding() %><br>
Content Type: <%= response.getContentType() %><br>
Locale: <%= response.getLocale() %><br>
<h2>Session Object</h2>
Session ID: <%= session.getId() %><br>
Creation Time: <%= new java.util.Date(session.getCreationTime()) %><br>
Last Access Time: <%= new java.util.Date(session.getLastAccessedTime()) %><br>
</body>
</html>
