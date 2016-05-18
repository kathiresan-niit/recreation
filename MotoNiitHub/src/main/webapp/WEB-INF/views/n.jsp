<!DOCTYPE html>
<html lang="en">
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
    <title>Angular Sort and Filter</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <style>
        body { padding-top:50px; }
    </style>

    <!-- JS -->
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<script type="text/javascript">
angular.module('sortApp',[]).controller('mainController',function($scope,$http){
	alert("hi");
	
		console.log("im in getProduct");
		$http({method:'GET',url:'/MotoNiitHub/cat2/micromax'}).success(function(data,status,headers,config)
				
		{
		alert(data);	
			//$scope.categ=JSON.parse(JSON.stringify(data));
			$scope.categ=data;
			console.log("length"+categ.length);
			for(var c=0;c<$scope.categ.length;c++)
				{
					var cc=$scope.categ[c];
					console.log(cc);
					console.log($scope.categ);
					return $scope.categ;
				}
			
			
		});
	
});


</script>


</head>
<body>


<div class="container" ng-app="sortApp" ng-controller="mainController">
  <form>
<div class="form-group">
	<div class="input-group">
		<div class="input-group-addon"><i class="fa fa-search"></i></div>
		<input type="text" class="form-control" placeholder="search" ng-model="byname">
	</div>
</div>
</form>


<div class="table table-bordered table-stripedtable-responsive">
<table class="display table" width="100%">
<thead>
<tr>
<th>pid</th>
<th>pname</th>
<th>cost</th>
<th>available</th>
</tr>
</thead>
<tbody>
	<tr ng-repeat="c in categ|filter:byname">
		<td>{{c.pid}}</td>
		<td>{{c.pname}}</td>
		<td>{{c.cost}}</td>
		<td>{{c.available}}</td>
	</tr>
</tbody>
</table>
</div>
</div>
</body>
</html>