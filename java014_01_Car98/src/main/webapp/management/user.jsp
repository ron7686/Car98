
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
<link rel="stylesheet" href="../css/all.css">
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

#snackbar {
	visibility: hidden;
	min-width: 250px;
	margin-left: -125px;
	background-color: #333;
	color: #fff;
	text-align: center;
	border-radius: 2px;
	padding: 16px;
	position: fixed;
	z-index: 1;
	left: 50%;
	bottom: 30px;
	font-size: 17px;
}

#snackbar.show {
	visibility: visible;
	-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@
-webkit-keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
-webkit-keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
@
keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>

<title>會員資料</title>
</head>

<body class="bg-dark">
	<jsp:include page="../fragment/topIndex.jsp"></jsp:include>
	<form class="needs-validation mx-5 text-white" novalidate method="POST"
		action="<c:url value='/_01_register/update.do'/>"
		enctype="multipart/form-data">
		<div class="col-md-3 mt-5 p-1">
			<div class="form-group">

				<label for="exampleFormControlFile1s"> <input type="file"
					name="image" id="image_file" style="display: none;" /> <img
					style="width: 350px; height: 350px; border-radius: 50%;"
					src='${pageContext.request.contextPath}/_00_init/getMemberImage?id=${LoginOK.memId}'
					id="show_image">
				</label>
				<p class="mt-2">
					<img id="image">
				</p>
			</div>
		</div>
		<div class="form-row my-5 w-50">
			<div class="col-md-4 mt-1 mb-2">
				<label for="validationCustom01">姓名: </label> <input type="text"
					class="form-control" value="${memberBean.name}" name="name"
					id="validationCustom01" placeholder="姓名" required>
				<div class="invalid-feedback">請輸入姓名</div>
				<font color="red" size="-1">${MsgMap.errorName}</font>

			</div>
			<div class="col-md-4 mt-1 mb-2">
				<label for="validationCustom02">暱稱: </label> <input type="text"
					class="form-control w-auto" value="${memberBean.id}"
					name="memberId" id="validationCustom02" placeholder="暱稱" required>
				<div class="invalid-feedback">請輸入暱稱</div>
				<font color="red" size="-1">${MsgMap.errorIdEmpty}</font>
			</div>

		</div>
		<div class="form-group w-50 mb-5">
			<label for="validationCustom02">手機號碼: </label> <input type="tel"
				class="form-control w-auto" value="${memberBean.phone}" name="phone"
				id="validationCustom02" placeholder="手機號碼"
				pattern="[0-9]{4}[0-9]{3}[0-9]{3}" required>
			<div class="invalid-feedback">請輸入正確的號碼</div>
			<font color="red" size="-1">${MsgMap.errorPhone}</font>
		</div>
		<div class="form-group w-50">
			<label for="exampleInputEmail1">Email address: </label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				value="${memberBean.email}" name="email"
				aria-describedby="emailHelp" placeholder="Enter email"
				pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$"
				disabled="disabled" required> <small id="emailHelp"
				class="form-text text-muted">We'll never share your email
				with anyone else.</small>
			<div class="invalid-feedback">請輸入正確的email</div>
			<font color="red" size="-1">${MsgMap.errorIdDup}</font>
		</div>

		<div class="form-row d-inline">
			<div class="col-md-6 mb-2">
				<label for="validationCustom03">生日: </label> <input type="date"
					class="form-control" id="validationCustom03" name="birth"
					value="${memberBean.birth}" placeholder="YYYY-MM-DD"
					pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" disabled="disabled" required>
				<div class="invalid-feedback">請選擇日期</div>
				<font color="red" size="-1">${ErrorMsg.errorBirth}</font>
			</div>
			<div class="col-md-3 mt-3">
				<label for="validationCustom04">性別: </label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="M"
						${memberBean.sex =="M" ? "checked='checked'" : ""}> <label
						class="form-check-label text-primary" for="gridRadios1"> 男
					</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="F"
						${memberBean.sex =="F" ? "checked='checked'" : ""}> <label
						class="form-check-label text-danger" for="gridRadios2"> 女
					</label>
				</div>
				<font color="red" size="-1">${MsgMap.errorSex}</font>

			</div>
		</div>
		<div class="mb-3">
			<button class="btn btn-secondary" id="button" type="submit">確認送出</button>
		</div>
	</form>

	<!-- Button trigger modal -->
	<div class="mt-2 mb-2 needs-validation mx-5 text-white">
		<button type="button" class="btn btn-secondary" data-toggle="modal"
			data-target="#staticBackdrop">修改密碼</button>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">修改密碼</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="<c:url value='/_01_reguster/change.do'/>"
					method="POST">
					<div class="modal-body">
						<div class="form-group w-50 mx-auto">
							<p class="text-secondary">新密碼</p>
							<input type="password" id="pwdId" class="form-control"
								name="password" required>
							<div class="valid-feedback">符合規則</div>
							<div class="invalid-feedback">需包含大小字母、數字、特殊符號、8個字符</div>
							<font color="red" size="-1">${ErrorMsg.passwordError}</font>
						</div>
						<div class="form-group w-50 mx-auto">
							<p class="text-secondary">確認密碼</p>
							<input type="password" id="cPwdId"
								class="form-control myCpwdClass" value="${param.memberPassword}"
								name="password1" required>
							<!-- 								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}" -->
							<div id="cPwdValid" class="valid-feedback">密碼相符</div>
							<div id="cPwdInvalid" class="invalid-feedback">密碼不相同</div>
							<font color="red" size="-1">${MsgMap.passwordError}${MsgMap.errorPassword1Empty}</font>
						</div>
					</div>
					<div class="modal-footer justify-content-center">
						<button type="submit" class="btn btn-secondary"
							onclick="myFunction()">送出</button>
						<c:if test="${empty MsgMap}">
							<div id="snackbar">修改成功</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>
	</div>
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
	<script>
		$("#show_image").click(function(e) {
			document.getElementById("image_file").click();
		});

		$("#image_file").on("change", function(event) {
			const file = event.target.files[0];
			let readFile = new FileReader();
			readFile.readAsDataURL(file);
			readFile.addEventListener("load", function(e) {
				let image = document.getElementById("show_image");
				image.src = this.result;

				// image.width = 500 ;
				image.style.maxWidth = "350px"; //css屬性
				image.style.maxHeight = "350px";
			});
		});
	</script>
	<c:if test="${empty MsgMap}">
		<script>
		function myFunction() {
			var x = document.getElementById("snackbar");
			x.className = "show";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 3000);
		}
	</script>
	</c:if>
	<c:if test="${!empty MsgMap}">
		<script>
			$('#staticBackdrop').modal('show')
		</script>
	</c:if>
</body>

</html>