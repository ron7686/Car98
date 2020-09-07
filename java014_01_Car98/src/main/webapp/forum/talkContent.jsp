<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CarTalk Page</title>
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
<link rel="stylesheet" href="../css/talkContent.css">
<script src="http://maps.google.com/maps/api/js"></script>
<script src="../javascript/talkContent.js"></script>
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
<body onload="startTime()">
	<!-- navbar -->
	<jsp:include page="/fragment/topIndex.jsp" />
	<!--Main Area -->
	<section class="my-5">

		<div class="container text-white main">
			<div class="row">
				
				<div class="col-12">
					<ul class="texttitle">
						<li class="mx-auto"><h2>發表新文章</h2></li>
						<li class="ml-auto"><span id="nowDateTimeSpan"></span></li>
					</ul>
				</div>
				<!-- 分類選項 -->
				<div class="col-12 classification">
					<select name="" id="" class="select mt-2">
						<option value="discuss">討論</option>
						<option value="share">分享＆心得</option>
						<option value="help">求助＆問題</option>
						<option value="announcement">公告</option>
					</select>
				</div>
				<!-- 編輯列表 -->
				<div class="col-12  editor-list">

					<select class="font-area mt-2" name="" id="" data-toggle="tooltip"
						data-placement="bottom" title="字級">
						<option value="">大</option>
						<option value="">中</option>
						<option value="">小</option>
					</select>

					<button type="button " class="btn-light " data-toggle="tooltip"
						data-placement="bottom" title="粗體">
						<i class="fas fa-bold"></i>
					</button>
					<button type="button" class="btn-light " data-toggle="tooltip"
						data-placement="bottom" title="斜體">
						<i class="fas fa-italic"></i>
					</button>
					<button type="button" class="btn-light " data-toggle="tooltip"
						data-placement="bottom" title="底線">
						<b><u>U</u></b>
					</button>
					<button type="button" class=" btn-light font "
						data-toggle="tooltip" data-placement="bottom" title="字型顏色">
						<b><u>A</u></b> <input class="manycolor" type="color"
							list="colors" data-toggle="tooltip" data-placement="bottom"
							title="更多顏色">
					</button>


					
				</div>
				<!-- 內文輸入 -->
				<div class="col-9">
					<form class="mt-3" action="talk.do" method="Post">
						<input class="title" type="text"  name="title"
							placeholder="請輸入文章標題......." value="${param.title}">
							<span class="errormsg"><b>${ErrorMsgKey.TitleEmptyError}</b></span>
						<textarea class="mt-2" name="text" id="article" cols="100" rows="20" placeholder="請輸入內容......" >${param.text}</textarea>
						<span class="errormsg"><b>${ErrorMsgKey.TextEmptyError}</b></span>
						<input type="submit" value="發佈文章" class="publish">
					</form>
				</div>
				<!-- 插入附件 -->
				<div class="col-3">
					<ul class="annex ">
						<li>
							<form>
								<div class="form-group">
									<img src="../image/view.jpeg" width="50" height="50"> <label
										for="exampleFormControlFile1">插入圖片</label> <input type="file"
										class="form-control-file" id="exampleFormControlFile1">
								</div>
							</form>
						</li>
						<li>
							<div>
								<form>
									<div class="form-group">
										<img src="../image/film.jpg" alt="" width="50" height="50">
										<label for="exampleFormControlFile1">插入影片＆連結</label> <input
											type="file" class="form-control-file"
											id="exampleFormControlFile1">
									</div>
								</form>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/fragment/footer.jsp"></jsp:include>
</body>
</html>