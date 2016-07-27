<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>운행 정보 수정</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/train/trainOperationRouteModify/${trainOperationRouteVo.no}" method="post">
		<table border="1" style="text-align:center;">
			<tr>
				<th>no</th>
				<th>trainInfo_no</th>
				<th>trainLine_no</th>
				<th>trainStation_no</th>
				<th>trainCategory_no</th>
				<th>order</th>
				<th>departureTime</th>
				<th>수정/ 취소</th>
			</tr>
			
			<tr>
				<td><input type="text" name="no" value="${trainOperationRouteVo.no}"></td>
				<td><input type="text" name="trainInfo_no" value="${trainOperationRouteVo.trainInfo_no}"></td>
				<td><input type="text" name="trainLine_no" value="${trainOperationRouteVo.trainLine_no}"></td>
				<td><input type="text" name="trainStation_no" value="${trainOperationRouteVo.trainStation_no}"></td>
				<td><input type="text" name="trainCategory_no" value="${trainOperationRouteVo.trainCategory_no}"></td>
				<td><input type="text" name="order" value="${trainOperationRouteVo.order}"></td>
				<td><input type="text" name="departureTime" value="${trainOperationRouteVo.departureTime}"></td>
				<td>
					<input type="submit" value="수정 확인">
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>