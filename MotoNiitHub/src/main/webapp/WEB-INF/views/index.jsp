<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<%@include file="header.jsp"%>
<!-- slider starts -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="<c:url value='/resources/images/01.jpg'/>" alt="Image" />
			<div class="carousel-caption">
				<h3>Listen to your heart's MUSIC !!! $</h3>
				<p>Money Money....</p>
			</div>
		</div>

		<div class="item">
			<img src="<c:url value='/resources/images/02.jpg'/>" alt="Image" />
			<div class="carousel-caption">
				<h3>B one with music u hear!!! $</h3>

				<p>${message1}</p>
			</div>
		</div>


		<div class="item">
			<img src="<c:url value='/resources/images/03.jpg'/>" alt="Image" />
			<div class="carousel-caption">
				<h3>Ride ur WAY with melodies $</h3>
				<p>..sa.re.ga..ma</p>
			</div>
		</div>


	</div>
	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>
<!-- slider ends -->
</head>
<body>
	<div class="container text-center">
		<h3>What We Do!!!</h3>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<a href="${pageContext.request.contextPath}/team/list?cat=moto">
					<img src="<c:url value='/resources/images/tm.png'/>"
					class="img-responsive" style="height: 150px; width: 80%"
					alt="Image">
				</a>
				<p>Current Project</p>
			</div>
			<div class="col-sm-4">
				<a href="category2"> <img
					src="<c:url value='/resources/images/09.png'/>"
					class="img-responsive" style="height: 30%; width: 80%" alt="Image"></a>
				<p>Project 2</p>
			</div>
			<div class="col-sm-4">
				<a href="category2"> <img
					src="<c:url value='/resources/images/10.jpg'/>"
					class="img-responsive" style="height: 30%; width: 80%" alt="Image"></a>
				<p>Project 2</p>
			</div>
		</div>
		<div class="well" style="background-color: gray; height: 2%;"></div>
		<div>
			<div class="col-sm-4">
				<div class="well">
					<p>
						<a href="<c:url value='/generateQr'/>">Generate QR</a>
					</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well">
					<button type="button" class="btn btn-info" data-toggle="collapse"
						data-target="#demo">Simple collapsible</button>

					<div id="demo" class="collapse">
						<form action="<c:url value='/sendmail'/>">
							<input type="text" name="mailid" style="color: green;">
							<button type="submit" class="btn-primary">subscribe with
								us</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well">
					<p>Some text..</p>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br>



	<%@include file="Footer.jsp"%>
</body>
</html>
