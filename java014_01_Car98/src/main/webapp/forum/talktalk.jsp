<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MemberTalk Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
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
<link rel="stylesheet" href="<%=path %>/css/talktalk.css">

<script src="http://maps.google.com/maps/api/js"></script>
<script src=""></script>
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
	background-image: url(<%=path %>/image/Desktop.png);
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
	<!-- page bar -->
	<br>
	<nav class="">
		<ul class="pagination pagination-sm justify-content-center mb-2">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">5</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
		<br>
	</nav>
	<!-- 文章標題 -->
	<div class="container">
		<div class="row">
			<div class="col-12 text-white">${TalkBean.postTitle}</div>
			<!-- 作者資訊 -->
			<div class="col-2">
				<br> <a href="#"><img class="photo" src="<%=path %>/image/喬巴1.jpg"></a>
				<div class="author">多尼多尼喬巴</div>
				<div class="account">zzz94572</div>

			</div>
			<!-- 文章內容 -->
			<div class="col-10">
				<ul class="article-information">
					<li class="floor">樓主<br>
					<a href="#">發表於 2020-09-01 09:21 PM</a></li>

					<li class="gp">讚12</li>
					<li class="bp">噓18</li>
				</ul>
				<div class="col-12 article-content">
					${TalkBean.postText} <img class="picture"
						src="https://picsum.photos/id/222/500/600" alt=""><br>
				</div>
				<!-- 按讚功能 -->
				<div class="col-12 article-mood">
					<ul class="like-or-hate">
						<li id="like1" button class="fas fa-thumbs-up fa-2x" type="button">12</li>
						<li id="hate1" button class="fas fa-thumbs-down fa-2x"
							type="button">1</li>
					</ul>
				</div>
			</div>
	     	
			</div>
			<div class="btn-toolbar" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group mr-2" role="group" aria-label="First group">
				</div>
			</div>
		</div>
	</div>
	<!-- 留言內容 -->
	<c:forEach var="comment" items="${CommentBean}">
		<div class="container">
			<div class="row">
<%-- 				<div class="col-12 text-white">${TalkBean.postTitle}</div> --%>
			<!-- 作者資訊 -->
			<div class="col-2">
				<br> <a href="#"><img class="photo" src="<%=path %>/image/喬巴1.jpg"></a>
				<div class="author">多尼多尼喬巴</div>
				<div class="account">zzz94572</div>

			</div>
			<!-- 文章內容 -->
			<div class="col-10">
				<ul class="article-information">
					<li class="floor">${comment.comId}樓<br>
					<a href="#">發表於 ${comment.comTime}</a></li>

					<li class="gp">讚12</li>
					<li class="bp">噓18</li>
				</ul>
				<div class="col-12 article-content">
					${comment.comText}<br>
				</div>
				<!-- 按讚功能 -->
				<div class="col-12 article-mood">
					<ul class="like-or-hate">
						<li id="like1" button class="fas fa-thumbs-up fa-2x" type="button">12</li>
						<li id="hate1" button class="fas fa-thumbs-down fa-2x"
							type="button">1</li>
						<button id="updateButton" >編輯</button>
						<a id="deleteButton" href="${pageContext.request.contextPath}/forum/deleteCom.do?comId=${comment.comId}">刪除</a>
					</ul>
				</div>
			</div>
			</div>
		</div>
	</c:forEach>
	
	<!-- 留言輸入 -->
		<div class="container">
			<div class="row">
				<div class="col-12 mt-2">
					<form class="comment"
						action="${pageContext.request.contextPath}/forum/comment.do"
						method="post">
						<textarea id="comments" name="comments" class="" cols="68"
							rows="5" placeholder="請輸入內容...."></textarea>
						<input type="file" class="form-control-file"
							id="exampleFormControlFile1"> <input class="float-right"
							type="submit" value="送出">
					</form>

				</div>
			</div>
		</div>

	    <hr>


	<!-- page bar -->
		<nav class="">
			<ul class="pagination pagination-sm justify-content-center mb-2">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
  <!-- footer -->
    <div class="footer-bottom  bg-dark text-light">
     <div class="container-fluid">
       <p class="pull-left">
          Copyright@ 2020 by Car98 Group
      </p>
    </div>
  </div>
  </body>
</html>