<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home page</h1>
	<br>
	<div class="well well-sm">
	${message}<br>
		<c:if test="${not empty error}">
			<div class="error" style="color: #ff0000;">${error}</div>
		</c:if>
		</div>
		<div class="col-sm-6">
		welcome , ${pageContext.request.userPrincipal.name}
		</div>
		<br><br><br>
	
	<div class="col-sm-6">
				<div class="well">
					<p><a href="${pageContext.request.contextPath}/team/add" >Add new Product</a></p>
				</div>
				
			</div>
	<div class="col-sm-4">
				<div class="well">
					<p>	<a	href="${pageContext.request.contextPath}/team/list/all">View All Product</a></p>
				</div>				
			</div>
	<%@include file="Footer.jsp"%>
</body>
</html>