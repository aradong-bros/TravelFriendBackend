<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/TravelFriendBackend/attraction/atrModify/${atrVo.postList_no }" method="post">
		<table border="1" style="text-align: center;">
			<tr>
				<th style="height: 30px; width: 150px;">관광지 번호</th>
				<th style="height: 30px; width: 150px;">지역 번호</th>
				<th style="height: 30px; width: 150px;">관광지 이름</th>
				<th style="height: 30px; width: 150px;">관광지 위치(y,x)</th>
				<th style="height: 30px; width: 150px;">관광지 사진</th>
				<th style="height: 30px; width: 150px;">관광지 정보</th>
				<th style="height: 30px; width: 150px;">관광지 카테고리</th>
				<th style="height: 30px; width: 150px;">수정 / 취소</th>
			</tr>
	
			
			<tr>
				<td>${atrVo.postList_no }</td>
				<td>${atrVo.cityList_no }</td>
				<td><input type="text" name="postList_name" value="${atrVo.postList_name }"></td>
				<td><input type="text" name="postList_location" value="${atrVo.postList_location }"></td>
				<td><input type="text" name="postList_picture" value="${atrVo.postList_picture }"></td>
				<td><input type="text" name="postList_info" value="${atrVo.postList_info }"></td>
				<td><input type="text" name="postList_category" value="${atrVo.postList_category }"></td>
				<td>
					<input type="submit" value="수정 확인">
						<span></span> 
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>

