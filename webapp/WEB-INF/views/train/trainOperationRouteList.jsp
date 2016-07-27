<%@page import="com.estsoft.futures.aradongbros.travelfriend.vo.TrainOperationRouteVo"%>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>운행경로 리스트</title>
</head>
<body>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/train/trainOperationRouteInsertform">운행정보 추가하기</a> 
			<a href="${pageContext.request.contextPath}/train/trainStation">역 정보 보기</a>
			<a href="${pageContext.request.contextPath}/train/trainInfo">기차 정보 보기</a> 
			<a href="${pageContext.request.contextPath}/train/trainLine">노선 정보 보기</a> 
			<a href="${pageContext.request.contextPath}/train/trainCategory">카테고리 정보 보기</a> 
		</p>
	</div>
	
	<table border="1" style="text-align:center;">
		<tr>
			<th>no</th>
			<th>trainInfo_no</th>
			<th>trainLine_no</th>
			<th>trainStation_no</th>
			<th>trainCategory_no</th>
			<th>order</th>
			<th>departureTime</th>
			<th>삭제/ 수정</th>
		</tr>
		
		<c:forEach items="${trainOperationRouteList}" var="trainOperationRouteVo">
		<tr>
			<td>${trainOperationRouteVo.no}</td>
			<td>${trainOperationRouteVo.trainInfo_no}</td>
			<td>${trainOperationRouteVo.trainLine_no}</td>
			<td>${trainOperationRouteVo.trainStation_no}</td>
			<td>${trainOperationRouteVo.trainCategory_no}</td>
			<td>${trainOperationRouteVo.order}</td>
			<td>${trainOperationRouteVo.departureTime}</td>
			<td>
				<button onclick="location.href='http://localhost:8080/TravelFriendBackend/train/trainOperationRouteModifyform/${trainOperationRouteVo.no}'">수정</button> 
				<span></span>
				<button onclick="location.href='http://localhost:8080/TravelFriendBackend/train/trainOperationRouteDelete/${trainOperationRouteVo.no}'">삭제</button> 
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>