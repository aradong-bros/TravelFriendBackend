<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 정보 입력</title>
</head>
<body>
	<form id="trainCategoryInsertForm" action="${pageContext.request.contextPath}/train/trainCategoryInsert" method="post">
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
				<td>workDate</td>
				<td><input type="text" name="workDate" id="workDateText" size="20"></td>
				<td>String Type</td>
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