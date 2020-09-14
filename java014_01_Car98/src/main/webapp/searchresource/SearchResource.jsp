<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CarSearch Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
<link rel="stylesheet" href="../css/SearchResource.css">

<script src="http://maps.google.com/maps/api/js"></script>
<script src="../javascript/SearchResource.js"></script>
<style>
#carouselExampleFade .carousel-inner .carousel-item img {
	height: 720px;
}

.footer-bottom {
	margin-top: 1em;
	/* border-top: 1px solid #DDDDDD; */
	padding-top: 10px;
	padding-bottom: 5px;
}

.footer-bottom p.pull-left {
	padding-top: 6px;
	font-size: 0.5em;
	display: flex;
	align-items: center;
	justify-content: center;
}

.bg-cover {
	background-size: cover;
}

body {
	background-image: url(../image/Desktop.png);
	background-position: center;
	background-attachment: fixed;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<!-- navbar -->
	<jsp:include page="/fragment/topIndex.jsp" />
	<!-- Search Area -->
	<section class="my-5">
		<div class="container text-white mainarea">
			<div class="row">
				<div class="col-12 maintitle ">
					<h2>Car好康</h2>
				</div>

				<div class="col-6">
					<form action="" class="searchitem">
						搜尋項目： <select name="" id="" class="subitem">
							<option value="">選擇項目</option>
							<option value="">加油站</option>
							<option value="">自助洗車</option>
							<option value="">停車場</option>
						</select>
					</form>
				</div>
				<div class="col-6">
					<form>
						搜尋： <select class="select" name="area" id="searchitem"
							style="width: 250px">
							<option value="selectarea">搜尋地區</option>
							<optgroup label="台北市">
								<option value="dist1">內湖</option>
								<option value="dist2">中山</option>
								<option value="dist3">萬華</option>
							</optgroup>
							<optgroup label="新北市">
								<option value="dist5">樹林</option>
								<option value="dist6">板橋</option>
								<option value="dist7">中和</option>
								<option value="dist8">汐止</option>
							</optgroup>
						</select>
					</form>
					<!-- <button><i class="fas fa-search-location"></i></button> -->
				</div>
				<div class="col-12 mt-2">
					<iframe src="https://maps.google.com?output=embed&q=北科大"
						width="100%" height="460"> </iframe>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/fragment/footer.jsp"></jsp:include>

</body>
</html>