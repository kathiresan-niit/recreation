<html>
<head>
<%@page import="com.example.model.Motorola,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <!-- JS -->
<!--     <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script> -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <style type="text/css">
body {padding: 20px;}
input {margin-bottom: 5px; padding: 2px 3px; width: 209px;}
td {padding: 4px; border: 1px #CCC solid; width: 100px;}
    
</style>
<script>
var $rows = $('#tab tr');
$('#search').keyup(function() {
	alert('hi');
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
    
    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});
</script>

</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" >
 <form>
<div class="form-group">
	<div class="input-group">
		<div class="input-group-addon"><i class="fa fa-search"></i></div>
		<input type="text"  class="form-control" id="search"/>
<!-- 		 ng-model="byname"> -->
	</div>
</div>
</form>
<% try { %>
<div class="well well-sm">
	${message}<br>
		<c:if test="${not empty error}">
			<div class="error" style="color: #ff0000;">${error}</div>
		</c:if>
		</div>
<!-- 		<tr class="warning no-result"> -->
<!--       <td colspan="4"><i class="fa fa-warning"></i> No result</td> -->
<!--     </tr> -->

	<div class="tablediv">
		<div class="table table-hover  table-responsive">
			<table class="table" id="tab">
				<thead>
				
				<tr>
<!-- 					<tr ng-repeat="filter:byname"> -->
					<th width="6%">image</th>
						<th width="6%">product id</th>
						<th width="6%">product name</th>
						<th width="6%">availability</th>
						<th width="6%">price</th>
						<th width="6%">descriptions</th>
						<th width="6%">category</th>
						<th width="6%">sub category</th>
					</tr>
				</thead>
				
				<tbody>
					
						<c:forEach var="team" items="${team}">
							<tr >
							<td><img src="${team.imgpath}"/></td>
							<td>${team.pid}</td>
							<td>${team.pname}</td>
							<td>${team.avail}</td>
							<td>${team.price}</td>
							<td>${team.description}</td>
							<td>${team.category}</td>
<%-- 							<td>${team.imgpath}</td> --%>
							<td>${team.subcategory}</td>
							<td><a href="view/${team.pid}">view product</a><td>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					
						<td>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<a
							href="${pageContext.request.contextPath}/edit/${team.pid}">Edit</a><br>
							</security:authorize>
							</td>
							<td>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<a
							href="${pageContext.request.contextPath}/delete/${team.pid}">Delete</a><br>
							</security:authorize>
						</td>
					
					</c:if>
					</tr>
									</c:forEach>
									</tbody>
			</table>
		</div>
	</div>

<%
}
catch(javax.servlet.jsp.JspTagException e){
	
}
	
	%>

	<p>
		<a href="${pageContext.request.contextPath}/index">Home page</a>
	</p>
	</div>

</body>
</html>