<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
</head>
<body>
<div class="container">
	<div class="row">
		<form class="form-signin mg-btm" name="loginForm" action="<c:url value='/login'/>" method="POST">
    	<h3 class="heading-desc">
		Login</h3>

		<div class="main">	
            <label>Email</label>    
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            	<input type="text" id="username" name="username" class="form-control" placeholder="username | password" autofocus>
            </div>
            <label>password</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input type="password" id="password" name="password" class="form-control" placeholder="password">
            </div>
    
        	<div class="row">
                <div class="col-xs-6 col-md-6">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </div>
                <div class="col-xs-6 col-md-6 pull-right">
                 
                    <input type="submit" class="btn btn-large btn-success pull-right" value="Login"/>
                </div>
            </div>
		</div>
        
		<span class="clearfix"></span>	

		<div class="login-footer">
    		<div class="row">
                <div class="col-xs-6 col-md-6">
                    <div class="left-section">
                    <span>${message}</span>
                        <c:if test="${not empty error}">
                   <div class="error" style="color: #ff0000 ;">${error}</div>
               </c:if> 
    				</div>
                </div>
                <div class="col-xs-6 col-md-6 pull-right">
                </div>
            </div>
		</div>
      </form>
	</div>
</div>
</body>
</html>

<!-- <!--  -->
<!-- // oldcode  -->
<!-- <body> -->
<!-- ${message} -->
<!-- 	<h1>Login</h1> -->
<%-- <%-- 	<c:url value="/j_spring_security_check" />" method="post"> --%> 
<!-- 		<form name="loginForm" action="<c:url value='/login'/>" method="post"> -->
               
<!--                <div class="form-group"> -->
<!--                    <label for="username">User: </label> -->
<!--                    <input type="text" id="username" name="username" class="form-control" /> -->
<!--                </div> -->
<!--                <div class="form-group"> -->
<!--                    <label for="password">Password:</label> -->
<!--                    <input type="password" id="password" name="password" class="form-control" /> -->
<!--                </div> -->

<!--                <input type="submit" value="Submit" class="btn btn-default"> -->

<!--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
<!--            </form> -->



<!-- </body> -->
<!-- 

<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
${message}
	<h1>Login</h1>
<%-- 	<c:url value="/j_spring_security_check" />" method="post"> --%>
<form name="loginForm" action="<c:url value='/login'/>" method="post">
               <c:if test="${not empty error}">
                   <div class="error" style="color: #ff0000 ;">${error}</div>
               </c:if>
               <div class="form-group">
                   <label for="username">User: </label>
                   <input type="text" id="username" name="username" class="form-control" />
               </div>
               <div class="form-group">
                   <label for="password">Password:</label>
                   <input type="password" id="password" name="password" class="form-control" />
               </div>

               <input type="submit" value="Submit" class="btn btn-default">

               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
           </form>



</body>
</html>

 -->


