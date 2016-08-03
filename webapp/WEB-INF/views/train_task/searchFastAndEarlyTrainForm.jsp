<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기차 최단시간 조회</title>
</head>
<body>
	<h1>기차 최단시간 조회</h1>
	<form id="searchFastAndEarlyTrainForm" action="${pageContext.request.contextPath}/train/searchFastAndEarlyTrain" method="post">
		<table border="1" style="text-align:center;">
			<tr>
				<td>출발역</td>
				<td><input type="text" name="startStation" id="startStationText" size="15"></td>
			</tr>
			<tr>
				<td>도착역</td>
				<td><input type="text" name="endStation" id="endStationText" size="15"></td>
			</tr>
			<tr>
				<td>출발일</td>
				<td><input type="date" name="goDate" id="goDatePicker"></td>
			</tr>
			<tr>
				<td colspan="2" align=right>
					<input type="submit" value="찾기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>