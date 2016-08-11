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
<title>기차 시간 조회 결과(환승)</title>
</head>
<body>
	<div>
		<p>
			<input type="button" value="다시 검색" onclick="window.history.back()" />
		</p>
	</div>
	<h1>${goDate} [${startStation}역 -> ${endStation}역] 조회결과(환승)</h1>
	<table border="1" style="text-align:center;">
		<tr>
			<th>출발역</th>
			<th>환승역</th>
			<th>도착역</th>
			<th>출발시간</th>
			<th>환승역도착시간</th>
			<th>환승역출발시간</th>
			<th>도착시간</th>
			<th>열차번호/환승열차번호</th>
			<th>열차기종/환승열차기종</th>
			<th>운행시간</th>
		</tr>
		
		<c:forEach items="${trainTimeList}" var="timeMap">
		<tr>
			<td>${timeMap.startStationName}</td>
			<td>${timeMap.transferStationName}</td>
			<td>${timeMap.endStationName}</td>
			<td>${timeMap.departureTime}</td>
			<td>${timeMap.transferStationArrivalTime}</td>
			<td>${timeMap.transferStationDepartureTime}</td>
			<td>${timeMap.arrivalTime}</td>
			<td>${timeMap.trainNum}/${timeMap.transferTrainNum}</td>
			<td>${timeMap.trainModel}/${timeMap.transferTrainModel}</td>
			<td>${timeMap.operationTime}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>