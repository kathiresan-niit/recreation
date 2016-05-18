<html>

<head>
<%@page import="com.example.model.Motorola,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<%@include file="header.jsp" %>
hieee ${err}
	<c:if test="${not empty err}">
			hi<div class="error" style="color: #ff0000;">${err}</div>
		</c:if>
	<p>
		<a href="${pageContext.request.contextPath}/index">Home page</a>
	</p>
</body>
</html>
</body>
</html>