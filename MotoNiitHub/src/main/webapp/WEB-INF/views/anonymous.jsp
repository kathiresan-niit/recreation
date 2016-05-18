<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>

<body>
	<h1>Anonymous page</h1>
${message}
<img src="<c:url value='/resources/images/giphy.gif'/>"/>
	
<%-- 	<%request.setAttribute("mes", (String)request.getAttribute("message")); --%>
	<security:authorize access="hasRole('ROLE_USER')">
	
	<%
	String path =request.getServletContext().getContextPath();
	if(path=="adminLoginPage" || path.contains("admin")){
	%>
	<a href="<c:url value='/index' />">To Login</a>
	<%} %>
<% 
int i=0;
Thread.currentThread().sleep(4000);
out.println(i++);
request.getRequestDispatcher("index.jsp").forward(request, response); %>
</security:authorize>
	
</body>
</html>