<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Index of all Ads</h1>

<%= Arrays.toString(((List)(request.getAttribute("ads"))).toArray()) %>

<%= ((List) request.getAttribute("ads")).size() %>

<%-- foreach $ads as ad --%>
<c:forEach items="${requestScope.ads}" var="ad">
    <c:out value="${ad.getTitle()}"/>
    <c:out value="${ad.getBody()}"/>
</c:forEach>

<c:forEach var="i" begin="1" end="5">
    Item <c:out value="i"/><p>
    ${i}
</c:forEach>

</body>
</html>
