<%@page import="com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo"%>
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
<title>기차 리스트</title>
</head>
<body>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/train/trainInfoInsertform">기차 추가하기</a> 
			<a href="${pageContext.request.contextPath}/train/trainStation">역 정보 보기</a> 
			<a href="${pageContext.request.contextPath}/train/trainLine">노선 정보 보기</a> 
			<a href="${pageContext.request.contextPath}/train/trainCategory">카테고리 정보 보기</a> 
			<a href="${pageContext.request.contextPath}/train/trainOperationRoute">운행경로 정보 보기</a>
		</p>
	</div>
	
	<table border="1" style="text-align:center;">
		<tr>
			<th>no</th>
			<th>trainNum</th>
			<th>trainModel</th>
			<th>삭제/ 수정</th>
		</tr>
		
		<c:forEach items="${trainInfoList}" var="trainInfoVo">
		<tr>
			<td>${trainInfoVo.no}</td>
			<td>${trainInfoVo.trainNum}</td>
			<td>${trainInfoVo.trainModel}</td>
			<td>
				<button onclick="location.href='http://localhost:8080/TravelFriendBackend/train/trainInfoModifyform/${trainInfoVo.no}'">수정</button> 
				<span></span>
				<button onclick="location.href='http://localhost:8080/TravelFriendBackend/train/trainInfoDelete/${trainInfoVo.no}'">삭제</button> 
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>