<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기차 정보 수정</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/train/trainInfoModify/${trainInfoVo.no}" method="post">
		<table border="1" style="text-align:center;">
			<tr>
				<th>no</th>
				<th>trainNum</th>
				<th>trainModel</th>
				<th>수정/ 취소</th>
			</tr>
			
			<tr>
				<td><input type="text" name="no" value="${trainInfoVo.no}"></td>
				<td><input type="text" name="trainNum" value="${trainInfoVo.trainNum}"></td>
				<td><input type="text" name="trainModel" value="${trainInfoVo.trainModel}"></td>
				<td>
					<input type="submit" value="수정 확인">
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>