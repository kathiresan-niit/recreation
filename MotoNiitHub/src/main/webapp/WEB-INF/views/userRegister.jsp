<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color:red;
}
body{
    background-color: #525252;
}
.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</style>
</head>
<body>		
<%@include file="header.jsp" %>

<div>




</div>
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default" style="height:120%;margin-left:-16%;width:140%;">
        		<div class="panel-heading">
        		
			    		<h3 class="panel-title">Please sign Up here... <small>It's free!</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form role="form" method="POST"  commandName="Cust" action="${pageContext.request.contextPath}/userRegister">
<%-- 			    		<form:errors path="*" cssClass="errorblock" element="div" /> --%>
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <form:input path="uname"  class="form-control input-sm" placeholder="First Name"/>
			                <form:errors path="uname" cssErrorClass="error" element="div" />
			    					</div>
			    				</div>
			    				
			    			</div>

			    			<div class="form-group">
			    				<form:input type="email"  path="mail" class="form-control input-sm" placeholder="Email Address"/>
			    				<form:errors path="mail" cssErrorClass="error" element="div" />
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password"  path="pass" class="form-control input-sm" placeholder="Password"/>
			    						<form:errors path="pass" cssErrorClass="error" element="div" />
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password"  path="cpassword" class="form-control input-sm" placeholder="Confirm Password"/>
			    						<form:errors path="cpassword" cssErrorClass="error" element="div" />
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    			  <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			    		</form:form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>
</body>
</html>