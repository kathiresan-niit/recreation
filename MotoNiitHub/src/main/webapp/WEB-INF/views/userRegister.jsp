<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp" %>
</head>
<body>
<h1>Add team page</h1>
<p>Here you can add a new team.</p>

		
<form method="POST" action="${pageContext.request.contextPath}/team/userprocess">
<table>
<tbody>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="uname"/></td>
	</tr>
	<tr>
		<td>password:</td>
		<td><input type="password" name="pass"/></td>
	</tr>
	<tr>
		<td>confirm password :</td>
		<td><input type="password" name="cpassword"/></td>
	</tr>
	<tr>
		<td>mail id </td>
		<td><input type="email" name="mail" /></td>
		       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</tr>
	
	<tr>
		<td><input value="Register" type="submit"></td>
		<td></td>
	</tr>
	
</tbody>
</table>
</form>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>
</body>
</html>