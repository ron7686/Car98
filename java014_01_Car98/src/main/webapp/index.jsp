<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
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
<link rel="stylesheet" href="./css/all.css">
</head>
<body>
	<jsp:include page="/fragment/topIndex.jsp" />
	<!-- carousel -->
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item header-carousel-item bg-cover active">
				<img src="${pageContext.request.contextPath}/image/CAR1.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item header-carousel-item bg-cover">
				<img src="${pageContext.request.contextPath}/image/CAR2.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item header-carousel-item bg-cover">
				<img src="${pageContext.request.contextPath}/image/CAR3.jpg"
					class="d-block w-100" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!-- About -->
	<div class="jumbotron-fluid bg-dark">
		<div data-aos="flip-left" data-aos-easing="ease-out-cubic"
			data-aos-duration="2000">
			<h3 class="display-5 text-light pt-2 pl-2">About</h3>
			<p class="lead text-light pl-2">This is a simple hero unit, a
				simple jumbotron-style component for calling extra attention to
				featured content or information.</p>
		</div>
		<a class="btn btn-primary mb-2 ml-2 btn-sm" href="#" role="button">Learn
			more</a>
	</div>
	<!-- card -->
	<section class="py-5">
		<div class="container-md w-100 m-auto">
			<div class="h2 d-flex justify-content-center">實用資訊</div>
			<div class="row">
				<div class="col-md-4">
					<div class="information-card">
						<p class="information-card-text">Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime,Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime.</p>
						<div class="information-card-info text-center">
							<img src="./image/fuel_PNG28.png" alt=""
								class="information-card-img">
							<h4 class="information-card-name">Car好康</h4>
							<div class="information-card-position">今日油價</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="information-card">
						<p class="information-card-text">Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime,Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime.</p>
						<div class="information-card-info text-center">
							<img src="./image/empty-shopping-cart.png" alt=""
								class="information-card-img">
							<h4 class="information-card-name">Car好買</h4>
							<div class="information-card-position">熱門商品</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="information-card">
						<p class="information-card-text">Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime,Lorem ipsum dolor sit, amet
							consectetur adipisicing elit. Maxime.</p>
						<div class="information-card-info text-center">
							<img src="./image/speech-bubble-outline.png" alt=""
								class="information-card-img">
							<h4 class="information-card-name">Car論壇</h4>
							<div class="information-card-position">熱門話題</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<jsp:include page="/fragment/footer.jsp"></jsp:include>
	<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
	<script>
    AOS.init();
</script>
</body>
</html>
