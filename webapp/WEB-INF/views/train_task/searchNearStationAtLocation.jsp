<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
<title>근처 기차역 검색 결과</title>
</head>
<body>
	<div>
		<p>
			<input type="button" value="다시 검색" onclick="window.history.back()" />
		</p>
	</div>
	<h1>[${location}] 좌표 근처 기차역 검색 결과</h1>
	<table border="1" style="text-align:center;">
		<tr>
			<th>기차역</th>
			<th>역간 거리</th>
		</tr>
		
		<c:forEach items="${distanceMapList}" var="distanceMap">
		<tr>
			<td>${distanceMap.stationName}</td>
			<td>${distanceMap.distance}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>