<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<th width='120'>商店</th>
					<th width='120'>城市</th>
					<th width='120'>區域</th>
					<th width='120'>街道</th>
				</tr>
				<c:forEach var="rcBean" items="${rcBean}">
					<tr>
						<td>${rcBean.store}</td>
						<td>${rcBean.city}</td>
						<td>${rcBean.district}</td>
						<td>${rcBean.street}</td>
					</tr>
				</c:forEach>
			</table>
  
</body>

</html>