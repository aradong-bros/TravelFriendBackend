<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>운행경로 정보 입력</title>
</head>
<body>
	<form id="trainOperationRouteInsertForm" action="${pageContext.request.contextPath}/train/trainOperationRouteInsert" method="post">
		<table border="1" style="text-align:center;">
			<tr>
				<th>항목</th>
				<th>정보</th>
				<th>비고</th>
			</tr>
			
			<tr>
				<td>no</td>
				<td><input type="text" name="no" id="noText" size="20"></td>
				<td>비고없음</td>
			</tr>
			<tr>
				<td>trainInfo_no</td>
				<td><input type="text" name="trainInfo_no" id="trainInfo_noText" size="20"></td>
				<td>기차 정보의 no 값이 있어야 합니다.</td>
			</tr>
			<tr>
				<td>trainLine_no</td>
				<td><input type="text" name="trainLine_no" id="trainLine_noText" size="20"></td>
				<td>노선 정보의 no 값이 있어야 합니다.</td>
			</tr>
			<tr>
				<td>trainStation_no</td>
				<td><input type="text" name="trainStation_no" id="trainStation_noText" size="20"></td>
				<td>역 정보의 no 값이 있어야 합니다.</td>
			</tr>
			<tr>
				<td>trainCategory_no</td>
				<td><input type="text" name="trainCategory_no" id="trainCategory_noText" size="20"></td>
				<td>카테고리 정보의 no 값이 있어야 합니다.</td>
			</tr>
			<tr>
				<td>order</td>
				<td><input type="text" name="order" id="orderText" size="20"></td>
				<td>비고없음</td>
			</tr>
			<tr>
				<td>departreTime</td>
				<td><input type="text" name="departureTime" id="departreTimeText" size="20"></td>
				<td>형식 : 시간:분:초 (날짜는 생략합니다.)</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="카테고리 정보 등록">
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>