<!DOCTYPE html>
<html lang="en">
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Angular Sort and Filter</title>

<%@include file="header.jsp" %>
<!-- CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- JS -->
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script
	src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script type="text/javascript">
	angular.module('carApp',[]).controller('mainController',function($scope,$http){
		alert("hi");
		
			console.log("im in getProduct");
			
			$scope.addItemToCart = function (itemId) {
		        $http.put('http://localhost:8080/MotoNiitHub/addItem/'+itemId).success(function () {
		            alert("Item added to the cart!");
		        });
		    };
		});
			
	</script>
</head>
<body>

	<c:if test='${team ne null}'>
		<div class="table table-bordered table-stripedtable-responsive">
			<table class="display table" id="example" width="100%">
				<thead>
					<tr>
					<th>image</th>
						<th>pid</th>
						<th>pname</th>
						<th>cost</th>
						<th>available</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td><img src="#" alt="img na"/></td>
						<td>${team.pid}</td>
						<td>${team.pname}</td>
						<td>${team.price}</td>
						<td>${team.avail}</td>
						<td>
						<div class="container" ng-app="carApp" ng-controller="mainController">
							<div class="span6">
							<div class="span4 no_margin_left">
									<p ng-controller="mainController">
									<a href="<c:url value="ListProducts" />" class="btn btn-primary">Back</a>
									<c:if test="${pageContext.request.userPrincipal.name  != 'admin'}">
										<a href="#" class="btn btn-primary"
										   ng-click="addItemToCart('${team.pid}')"><span
												class="glyphicon glyphicon-shopping-cart"></span>Add to cart
											</a>
										<a href="<c:url value='/viewcart'/>" class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
									</c:if>
								</p>
							</div>	
							</div>
							</div>
						</td>
						<td>	<a href="${pageContext.request.contextPath}/memberShip" style="margin: 50;">Add to cart</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		</c:if>
		<%@include file="Footer.jsp" %>
</body>
</html>