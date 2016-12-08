<%--Necessary include for each file using JSTL syntax--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- If session message exists, output it. --%>
<% if (session.getAttribute("message") != null) { %>
<%= session.getAttribute("message") %>
<% } %>