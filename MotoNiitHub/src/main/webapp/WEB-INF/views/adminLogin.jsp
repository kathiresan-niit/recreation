
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<style>
@import "font-awesome.min.css";
@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
  padding-top: 20px;
  padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}

/* Custom page header */
.header {
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}

/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media (min-width: 768px) {
  .container {
    max-width: 730px;
  }
}
.container-narrow > hr {
  margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p + h4 {
  margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
	<c:if test="${pageContext.request.userPrincipal.name == null}">
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
                    <span>${param.error}</span>
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
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null}">
      <c:redirect url="/adminLandingpage"></c:redirect>
      </c:if>
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


