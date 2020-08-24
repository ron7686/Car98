<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/all.css">
<style>
input[type="submit"]:disabled {
	background-color: red;
}

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
</style>

<title>註冊</title>
</head>

<body class="bg-dark">
	<jsp:include page="../fragment/topIndex.jsp"></jsp:include>
	<form class="needs-validation mx-5 text-white" novalidate>
		<div class="form-row my-5">
			<div class="col-md-4 mt-5 mb-2">
				<label for="validationCustom01">姓名: </label> <input type="text"
					class="form-control" value="${param.memberName}"
					id="validationCustom01" placeholder="姓名" required>
				<div class="invalid-feedback">請輸入姓名</div>

			</div>
			<div class="col-md-4 mt-5 mb-2">
				<label for="validationCustom02">暱稱: </label> <input type="text"
					class="form-control w-auto" value="${param.memberId}"
					id="validationCustom02" placeholder="暱稱" required>
				<div class="invalid-feedback">請輸入暱稱</div>
			</div>
		</div>
		<div class="form-group w-50">
			<label for="exampleInputEmail1">Email address: </label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				value="${param.memberEmail}" aria-describedby="emailHelp"
				placeholder="Enter email"
				pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" required>
			<small id="emailHelp" class="form-text text-muted">We'll
				never share your email with anyone else.</small>
			<div class="invalid-feedback">請輸入正確的email</div>
		</div>
		<div class="form-row d-inline">
			<div class="col-md-6 mb-2">
				<label for="validationCustom03">生日: </label> <input type="date"
					class="form-control" id="validationCustom03"
					value="${param.memberBirth}" placeholder="" required>
				<div class="invalid-feedback">請選擇日期</div>
			</div>
			<div class="col-md-3 mb-2">
				<label for="validationCustom04">性別: </label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="${param.memberSex1}" checked> <label
						class="form-check-label text-primary" for="gridRadios1"> 男
					</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="${param.memberSex2}"> <label
						class="form-check-label text-danger" for="gridRadios2"> 女
					</label>
				</div>
			</div>
			<div class="invalid-feedback">Please provide a valid state.</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label for="exampleFormControlFile1">上傳頭像: </label> <input
					type="file" class="form-control-file" id="exampleFormControlFile1"
					value="${param.memberHeadPic}">
			</div>
		</div>

		<div class="form-group w-50 p-2">
			密碼 <input type="text" id="pwdId" class="form-control"
				pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" required>
			<div class="valid-feedback">符合規則</div>
			<div class="invalid-feedback">需包含字母、數字、8個字符 不含特殊符</div>
		</div>
		<div class="form-group w-50 p-2">
			確認密碼 <input type="text" id="cPwdId" class="form-control myCpwdClass"
				pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
				value="${param.memberPassword}" required>
			<div id="cPwdValid" class="valid-feedback">密碼相符</div>
			<div id="cPwdInvalid" class="invalid-feedback">密碼不相同</div>
		</div>
		<div class="form-group">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value=""
					id="invalidCheck" required> <label class="form-check-label"
					for="invalidCheck"> 是否同意註冊 </label>
				<div class="invalid-feedback">You must agree before
					submitting.</div>
			</div>
		</div>
		<button class="btn btn-secondary" type="submit">確認送出</button>
	</form>
	<!-- footer -->
	<jsp:include page="/fragment/footer.jsp"></jsp:include>

	<script
		src="${pageContext.request.contextPath}/javascript/registerForm.js"></script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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