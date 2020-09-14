<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
	crossorigin="anonymous" />
<style>
.footer-bottom {
	margin-top: 1em;
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

body {
	background-image: url(../image/Desktop.png);
	background-position: center;
	background-attachment: fixed;
	background-repeat: no-repeat;
	background-size: cover;
}

.container-height {
	height: 500px;
}
</style>
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			var forms = document.getElementsByClassName('needs-validation');
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
</head>
<body>
	<!-- navbar -->
	<jsp:include page="/fragment/topIndex.jsp" />
	<!-- form-->
	<!-- <section class="my-5"> -->
	<div class="container d-flex text-white container-height">
		<div class="row align-items-center">
			<div class="col-md-6">
				<img src="${pageContext.request.contextPath}/image/car98logo.png"
					width="100%" height="200px" alt="">
			</div>
			<div class="col-md-6">
				<form action="<c:url value='/login/login.do' />" method="POST"
					class="needs-validation" name="loginForm" novalidate>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" placeholder="name@gmail.com"
							name="userId" value="${requestScope.user}${param.userId}"
							required>
						<div class="invalid-feedback">請輸入Email</div>
						<Font color='red' size="-1">${ErrorMsgKey.EmailEmptyError}</Font>
					</div>
					<div class="form-group">
						<label for="password">密碼</label> <input type="password"
							class="form-control" id="password" placeholder="password"
							name="pswd" value="${requestScope.password}${param.pswd}"
							required>
						<div class="invalid-feedback">請輸入密碼</div>
						<Font color='red' size="-1">${ErrorMsgKey.PassowrdEmptyError}</Font>

					</div>
					<Font color='red' size="-1"> ${ErrorMsgKey.LoginError}&nbsp;</Font>
					<div class="my-3 text-center">
						<input type="submit" value="登入" class="btn btn-secondary ml-2">
						<!-- 						<button type="button" class="btn btn-secondary ml-3">取消</button> -->
					</div>
					<div class="my-3 text-center">
						<input type="checkbox" name="rememberMe" class="mr-2"
							<%-- 沒有寫，記住密碼的欄位不會打勾。 --%>
               <c:if test='${requestScope.rememberMe==true}'>
                  checked='checked'
               </c:if>
							value="true"><label for="validationCustom04">記住密碼
						</label>
					</div>
					<div class="my-3 text-center">
						<a href="${pageContext.request.contextPath}/register/register.jsp"
							class="text-light">註冊帳號</a> <a href="#" class="text-light ml-2">忘記密碼</a>
					</div>

					<div class="my-3 text-center">
						<a href="#" class="text-light"><i
							class="fab fa-facebook-square fa-2x"></i></a> <a href="#"
							class="text-light"><i class="fab fa-google fa-2x"></i></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- </section> -->
	<!-- footer -->
	<div class="footer-bottom fixed-bottom bg-dark text-light">
		<div class="container-md">
			<p class="pull-left">Copyright@ 2020 by Car98 Group</p>
		</div>
	</div>
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
</body>
</html>