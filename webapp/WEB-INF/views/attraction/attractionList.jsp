<!-- 태그지시자 입력, 이걸해야 JSTL 사용 가능 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 이걸 선언해줘야 JSTL 중 core를 사용가능 prefix는 name에 해당 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <!-- JSTL 중 fomat 를 사용가능 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  <!-- JSTL 중 function 를 사용가능 -->

<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>관광지 정보 리스트</title>
</head>
<body>

	<div>
		<button style="height:80px; width:250px; font-size:20px; font-weight: bold" 
				onclick="location.href='http://localhost:8080/TravelFriendBackend/attraction/atrInsertform'">새로운 관광지 정보 등록
		</button>
		
			<span></span>
		
		<button style="height:80px; width:250px; font-size:20px; font-weight: bold" 
				onclick="location.href='http://localhost:8080/TravelFriendBackend/attraction/atrMain'">메인으로 돌아가기
		</button>
		
		<br><br>
		
		<table border="1" style="text-align: center;">
			<tr>
				<th style="height:30px; width:150px;">관광지 번호</th>
				<th style="height:30px; width:150px;">지역 번호</th>
				<th style="height:30px; width:150px;">관광지 이름</th>
				<th style="height:30px; width:150px;">관광지 위치(y,x)</th>
				<th style="height:30px; width:150px;">관광지 사진</th>
				<th style="height:30px; width:150px;">관광지 정보</th>
				<th style="height:30px; width:150px;">관광지 카테고리</th>
				<th style="height:30px; width:150px;">삭제 / 수정</th>
			</tr>
			
			<c:forEach items="${atrList}" var="atrVo" varStatus="status">
			<tr>
				<td>${atrVo.postList_no }</td>
				<td>${atrVo.cityList_no }</td>
				<td>${atrVo.postList_name }</td>
				<td>${atrVo.postList_location }</td>
				<td>${atrVo.postList_picture }</td>
				<td>${atrVo.postList_info }</td>
				<td>${atrVo.postList_category }</td>
				<td>
					<button onclick="location.href='http://localhost:8080/TravelFriendBackend/attraction/atrModifyform/${atrVo.postList_no}'">수정</button> 
					<span></span>
					<button onclick="location.href='http://localhost:8080/TravelFriendBackend/attraction/atrDeleteform/${atrVo.postList_no}'">삭제</button> 
				</td>
				
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>