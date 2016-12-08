<%--
  Created by IntelliJ IDEA.
  users.User: Moravia
  Date: 12/8/16
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/messages.jsp" />

    <h1>Create a new ads.Ad!</h1>

    <form action="${param.action}" method="post">

        <input type="hidden" name="id" value="${ad.id}">

        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input id="description" name="description" class="form-control" type="text" value="${ad.description}">
        </div>

        <input class="btn btn-primary btn-block" type="submit">
    </form>

</body>
</html>
