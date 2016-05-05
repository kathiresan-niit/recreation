<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>		
<form:form method="POST"  commandName="Cust" action="${pageContext.request.contextPath}/userprocess">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
<tbody>
	<tr>
		<td>product Name:</td>
		<td><form:input path="uname"></form:input></td>
		
	</tr>
	<tr>
		<td>available:</td>
		
		<td><form:input path="pass"></form:input></td>
	</tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	<tr>
		<td>description :</td>
		<td><form:input path="cpassword"></form:input></td>
	</tr>
	<tr>
		<td>Category:</td>
		
		<td><form:input path="mail"></form:input></td>
		<td><form:errors path="mail" cssClass="error"></form:errors></td>
	</tr>
	
	<tr>
	<tr><td>
	  <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</td></tr>
	
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