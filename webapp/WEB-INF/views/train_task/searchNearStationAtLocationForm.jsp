<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>근처 기차역 검색</title>
</head>
<body>
	<h1>근처 기차역 검색</h1>
	<form action="searchNearStationAtLocation" action="${pageContext.request.contextPath}/train/searchNearStationAtLocation" method="post">
		<table border="1" style="text-align:center;">
			<tr>
				<th>항목</th>
				<th>정보</th>
				<th>비고</th>
			</tr>
			
			<tr>
				<td>위치</td>
				<td><input type="text" name="location" id="locationText" size="20"></td>
				<td>위도,경도(예 : 33.3333333,127.7777777)</td>
			</tr>
			<tr>
				<td>cityNum</td>
				<td><input type="text" name="cityNum" id="cityNumText" size="20"></td>
				<td>서울1, 가평2, 강릉3, 안동4, 경주5, 부산6, 통영7, 하동8, 전주9, 보성10, 순천11, 여수12</td>
			</tr>
			
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="기차역 찾기" />
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>