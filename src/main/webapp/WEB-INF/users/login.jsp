<%--
  Created by IntelliJ IDEA.
  users.User: Moravia
  Date: 12/5/16
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/messages.jsp" />

<h1>Login</h1>
<form action="/login", method="POST">
    <input type="text" name="username" placeholder="Input your username">
    <input type="text" name="password" placeholder="Input your password">
    <button type="submit"></button>
</form>
</body>
</html>
