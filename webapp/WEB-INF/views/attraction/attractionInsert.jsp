<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>관광지 정보 입력</title>
</head>
<body>

	<div>
		 <form id="" action="${pageContext.request.contextPath}/attraction/atrInsert" method="post">
			<table border="1" style="text-align: center;">
				<tr>
					<th style="height:30px; width:150px;">항목</th>
					<th>정보</th>
					<th>비고</th>
				</tr>
				
				<tr>
					<td>지역 번호</td>
					<td><input type="text" name="cityList_no" id="" style="height:30px; width:200px;" ></td>
					<td> 1: 서울, 2: 가평, 3: 강릉, 4: 안동, 5: 경주, 6: 부산, 7: 통영, 8: 하동, 9: 전주, 10: 보성, 11: 순천, 12: 여수 </td>
				</tr>
				
				<tr>
					<td>관광지 이름</td>
					<td><input type="text" name="name" id="" style="height:30px; width:200px;" ></td>
					<td></td>
				</tr>
				
				<tr>
					<td>관광지 주소</td>
					<td><input type="text" name="address" id="" style="height:30px; width:200px;" ></td>
					<td></td>
				</tr>

				<tr>
					<td>관광지 위치(y,x)</td>
					<td><input type="text" name="location" id="" style="height:30px; width:200px;"></td>
					<td>관광지 위치 기입시 띄어쓰기없이 "Y좌표,X좌표" 순으로 기입해야 합니다.</td>
				</tr>

				<tr>       
					<td>관광지 사진</td>
					<td><input type="text" name="picture" id="" style="height:30px; width:200px;"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>관광지 정보</td>
					<td><input type="text" name="info" id="" style="height:30px; width:200px;"></td>
					<td></td>
				</tr>

				<tr>
					<td>관광지 카테고리</td>
					<td><input type="text" name="category" id="" style="height:30px; width:200px;"></td>
					<td>inn, food, tour 만 입력 가능 합니다.</td>
				</tr>

				<tr>
					<td colspan=3 align=right>	
						<input type="submit" style="height:50px; width:200px; font-size:20px; font-weight: bold" value="관광지 정보 등록">
						<input type="button" style="height:50px; width:200px; font-size:20px; font-weight: bold" value="취소" onclick="window.history.back()" />
					</td>
				</tr>

			</table>
 		</form>
	</div>
</body>
</html>
