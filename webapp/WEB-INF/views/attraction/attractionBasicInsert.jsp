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
		 <form id="" action="${pageContext.request.contextPath}/attraction/atrBasicInsert" method="post">
			<table border="1" style="text-align: center;">
				<tr>
					<th style="height:30px; width:400px;">기존 데이터 파일 경로 입력</th>
					<th>확인 / 취소</th>
				</tr>
				
				<tr>
					<td><input type="text" name="FilePath" id="" style="height:20px; width:300px;"></td>
					<td width="150px">
						<input type="submit" value="확인" />
						<input type="button" value="취소" onclick="window.history.back()" />
					</td>
				</tr>
			</table>
		</form>
		
			<h1>※ 해당 파일의 경로중 '\' 를 '/' 으로 바꿔서 입력해야 합니다.</h1>
		
	</div>
</body>
</html>
