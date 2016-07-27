<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" style="text-align: center;">
		<tr>
				<th style="height:30px; width:150px;">관광지 번호</th>
				<th style="height:30px; width:150px;">지역 이름</th>
				<th style="height:30px; width:150px;">관광지 이름</th>
				<th style="height:30px; width:150px;">관광지 주소</th>
				<th style="height:30px; width:150px;">관광지 위치(y,x)</th>
				<th style="height:30px; width:150px;">관광지 사진</th>
				<th style="height:30px; width:150px;">관광지 정보</th>
				<th style="height:30px; width:150px;">관광지 카테고리</th>
			<th style="height: 30px; width: 150px;">삭제 / 취소</th>
		</tr>

			<tr>
				<td>${atrVo.no }</td>
				<td>${clVo.name }</td>
				<td>${atrVo.name }</td>
				<td>${atrVo.address }</td>
				<td>${atrVo.location }</td>
				<td>${atrVo.picture }</td>
				<td>${atrVo.info }</td>
				<td>${atrVo.category }</td>
				<td>
					<button onclick="location.href='${pageContext.request.contextPath}/attraction/atrDelete/${atrVo.no}'">삭제 확인</button>
						<span></span> 
					<input type="button" value="취소" onclick="window.history.back()" />
				</td>

			</tr>
	</table>

</body>
</html>

		