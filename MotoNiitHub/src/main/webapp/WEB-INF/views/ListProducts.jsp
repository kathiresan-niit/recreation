<%@page import="com.example.model.Motorola,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%@include file="header.jsp" %>
	<h1>List of teams</h1>

	<p>Here you can see the list of the products, edit them, remove or
		update.</p>

	<div class="tablediv">
		<div class="table table-hover  table-responsive">
			<table class="display table">
				<thead>
					<tr>
						<th width="6%">product id</th>
						<th width="10%">product name</th>
						<th width="6%">availability</th>
						<th width="6%">price</th>
						<th width="6%">descriptions</th>
						<th width="6%">category</th>
						<th width="6%">sub category</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="team" items="${team}">

							<td>${team.pid}</td>
							<td>${team.avail}</td>
							<td>${team.category}</td>
							<td>${team.description}</td>
							<td>${team.imgpath}</td>
							<td>${team.pname}</td>
							<td>${team.price}</td>
							<td>${team.subcategory}</td>
					</tr>
					${pageContext.request.userPrincipal.name != null}
					<c:if test="${pageContext.request.userPrincipal.name != null}">
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/team/edit/${team.pid}">Edit</a><br>
							<a
							href="${pageContext.request.contextPath}/team/delete/${team.pid}">Delete</a><br>
						</td>
					</tr>
					</security:authorize>
					</c:if>
					</c:forEach>
					</tr>

				</tbody>
			</table>
		</div>
	</div>


	<p>
		<a href="${pageContext.request.contextPath}/index">Home page</a>
	</p>
</body>
</html>