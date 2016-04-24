<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add team page</h1>
<p>Here you can add a new team.</p>

		
<form:form method="POST"  enctype="multipart/form-data" commandName="team" action="${pageContext.request.contextPath}/team/add/process">
<table>
<tbody>
	<tr>
		<td>product Name:</td>
		<td><form:input path="pname"></form:input></td>
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
		<td><form:input path="price"></form:input></td>
	</tr>
	<tr>
	<td>Upload image: </td>
	<td><input type="file" name="f"/></td>
	
	</tr>
	<tr>
		<td><input value="Add" type="submit"></td>
		<td></td>
	</tr>
	
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>
</body>
</html>