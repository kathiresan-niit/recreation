<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<!-- styles for project -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value='resources/bootstrap/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='resources/bootstrap/css/style.css'/>" />
<script src=<c:url value='"resources/js/jquery-1.12.3.min.js'/>"></script>
<script src="<c:url value='resources/js/bootstrap.min.js'/>" /></script>
<script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
          </script>
        <c:url value="/perform_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
        </form>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<span> <a class="navbar-brand" href="#">logo</a>
			</span>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
					
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Projects</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><span><li><s:if
								test="${pageContext.request.userPrincipal.name != null}">
								<h6>
									Welcome : ${pageContext.request.userPrincipal.name} 
									
<%-- 									<security:authentication var="user" --%>
<%-- 										property="principal.authorities" /> --%>

									<security:authorize var="loggedIn" access="isAuthenticated()">										<security:authorize access="hasRole('ROLE_ADMIN')">
									Admin <a href="${pageContext.request.contextPath}/logout"> Logout</a>
	        					</security:authorize>

										<security:authorize access="hasRole('ROLE_ADMIN')">
									User
	        					</security:authorize>
									</security:authorize>
								</h6>
							</s:if></span></li>
								<c:if test="${pageContext.request.userPrincipal.name == null}">
				<li><a href="<c:url value='/userRegister'/>"> <span
						class="glyphicon glyphicon-user"></span> Join with Us</li>
				</a>
				<li> <a href="<c:url value='/login'/>"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:if>
			</ul>
		</div>
	</div>
</nav>
