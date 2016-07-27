<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>※ 기본 데이터가 있는경우 먼저 삽입해 주세요!</h1>
		
				<br>
				
		<button style="height:80px; width:300px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrBasicInsertform'">기본 데이터 저장(.txt 파일)
		</button>
		
		<h1>===============================</h1>
				
		<button style="height:80px; width:250px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrInsertform'">새로운 관광지 정보 등록
		</button>
		
			<br><br>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/1'">1<br>서울<br>지역코드 : 1<br>시군구코드 : null
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/2'">2<br>가평<br>지역코드 : 31<br>시군구코드 : 1  
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/3'">3<br>강릉<br>지역코드 : 32<br>시군구코드 : 1
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/4'">4<br>안동<br>지역코드 : 35<br>시군구코드 : 11
		</button>
		
			<br><br>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/5'">5<br>경주<br>지역코드 : 35<br>시군구코드 : 2
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/6'">6<br>부산<br>지역코드 : 6<br>시군구코드 : null
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/7'">7<br>통영<br>지역코드 : 36<br>시군구코드 : 17
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/8'">8<br>하동<br>지역코드 : 36<br>시군구코드 : 18
		</button>
		
			<br><br>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/9'">9<br>전주<br>지역코드 : 37<br>시군구코드 : 12
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/10'">10<br>보성<br>지역코드 : 38<br>시군구코드 : 10
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/11'">11<br>순천<br>지역코드 : 38<br>시군구코드 : 11
		</button>
		
		<button style="height:120px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrList/12'">12<br>여수<br>지역코드 : 38<br>시군구코드 : 13
		</button>
		
			<br><br><br><br>
		
		<button style="height:80px; width:200px; font-size:20px; font-weight: bold" 
				onclick="location.href='${pageContext.request.contextPath}/attraction/atrAllList'">전체 관광지 리스트
		</button>
	</div>

</body>
</html>