<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="BidService"
	class="commodity.service.impl.BidServiceImpl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty BidService.selectBid}">
   			目前尚未有任何商品資料<br>
		</c:when>
		<c:otherwise>
                               商品資料如下：<br>
			<table border='1'>
				<tr>
					<th width='120'>編號</th>
					<th width='120'>名稱</th>
					<th width='120'>種類</th>
					<th width='120'>價格</th>
					<th width='120'>數量</th>
					<th width='120'>上架時間</th>
					<th width='120'>商品圖片 </th>
				</tr>
				<c:forEach var="aBean" items="${BidService.selectBid}">
					<tr>
						<td>${aBean.bidId}</td>
						<td>${aBean.bidItemName}</td>
						<td>${aBean.bidDetail}</td>
						<td>${aBean.bidPrice}</td>
						<td>${aBean.bidSelled}</td>
						<td>${aBean.bidTime}</td>
						<td><img height='100' width='80'
							src='${pageContext.servletContext.contextPath}/_00_init/getBidImage?id=${aBean.bidId}'></td>
					</tr>
				</c:forEach>
			</table>

		</c:otherwise>
	</c:choose>
	<jsp:include page="/fragment/footer.jsp" />
</body>
</html>