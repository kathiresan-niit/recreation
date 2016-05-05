<html>

<head>
<%@page import="com.example.model.Motorola,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<%@include file="header.jsp" %>

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

					<c:forEach var="team" items="${team}">

							<td>${team.pid}</td>
							<td>${team.avail}</td>
							<td>${team.category}</td>
							<td>${team.description}</td>
							<td>${team.imgpath}</td>
							<td>${team.pname}</td>
							<td>${team.price}</td>
							<td>${team.subcategory}</td>
					
					<c:if test="${pageContext.request.userPrincipal.name != null}">
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/team/edit/${team.pid}">Edit</a><br/>
							<a
							href="${pageContext.request.contextPath}/team/delete/${team.pid}">Delete</a><br/>
						</td>
					</tr>
					</security:authorize>
					</c:if>
					</c:forEach>
					

				</tbody>
			</table>
		</div>
	</div>


	<p>
		<a href="${pageContext.request.contextPath}/index">Home page</a>
	</p>
</body>
</html>
</body>
</html>