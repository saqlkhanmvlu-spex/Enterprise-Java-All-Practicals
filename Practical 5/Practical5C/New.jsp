<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core Tag Example</title>
</head>
<body>
<c:forEach var = "j" begin="5" end="15">
Item <c:out value = "${j}"/><p>
</c:forEach>
</body>
</html>
