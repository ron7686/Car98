<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:useBean id="carType" class="rentcar.service.impl.CarTypeServiceImpl" /> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>CarRent Page</title>
</head>

<body><table border='1'>
				<tr>
					<th width='120'>車牌</th>
					<th width='120'>車型</th>
					<th width='120'>平日時租</th>
					<th width='120'>假日時租</th>
					<th width='120'>平日日租</th>
					<th width='120'>價日日租</th>
				</tr>
				<c:forEach var="aBean" items="${CarTypeData}">
					<tr>
						<td>${aBean.carBrand}</td>
						<td>${aBean.carType}</td>
						<td>${aBean.weekdayHourly}</td>
						<td>${aBean.holidayHourly}</td>
						<td>${aBean.weekdayDaily}</td>
						<td>${aBean.holidayDaily}</td>
					</tr>
				</c:forEach>
			</table>
  
</body>

</html>