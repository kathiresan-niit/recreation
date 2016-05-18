<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%@include file="header.jsp" %>
<h1>Edit moto 	page</h1>
<p>edit</p>
<p>${message}</p>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/edit/${team.pid}">
<table>
<tbody>
<tr>
		<td>product Id:</td>
		<td><form:input path="pid" readonly="true"></form:input></td>
	</tr>

	<tr>
		<td>product Name:</td>
		<td><form:input path="pname" value="${team.pname}"></form:input></td>
	</tr>
	<tr>
		<td>available:</td>
		<td><form:input path="avail"></form:input></td>
	</tr>
	<tr>
		<td>description :</td>
		<td><form:input path="description"></form:input></td>
	</tr>
	<tr>
		<td>Category:</td>
		<td><form:input path="category"></form:input></td>
	</tr>
	<tr>
		<td>Sub-category:</td>
		<td><form:input path="subcategory"></form:input></td>
	</tr>
	<tr>
		<td>price :</td>
		<td><form:input path="price" value="${team.price}"></form:input></td>
	</tr>

	<tr>
		<td><input value="Edit" type="submit"></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>
</body>
</html>