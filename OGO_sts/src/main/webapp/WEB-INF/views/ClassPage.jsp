<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ClassPage.jsp<br>

  <div id="right">
	<!-- 결제 박스 -->
	<jsp:include page="classPage/classApplication/box.jsp"></jsp:include>
  </div>
  <div id="left">
	<!-- 네비탭 -->
	<%-- <jsp:include page="class_page/classNavtab.jsp"></jsp:include> --%>
	<br>
		<!-- 클래스 이미지, 클래스 이름 -->
		<jsp:include page="classPage/classApplication/title.jsp"></jsp:include>
		<br>
	<div class="classpage_box1">
		<!-- 클래스 소개 -->
		<jsp:include page="classPage/classApplication/classInfo.jsp"></jsp:include>
		<br>
		<!-- 일정 및 장소 안내 -->
		<jsp:include page="classPage/classApplication/detail.jsp"></jsp:include>
		<br>
	</div>
	<div class="classpage_box2">	
		<!-- 튜터 소개 -->
		<jsp:include page="classPage/classApplication/tutorInfo.jsp"></jsp:include>
		<br>
		<!-- 공지사항 -->
		<jsp:include page="classPage/classApplication/notice.jsp"></jsp:include>
		<br>
		<!-- 유의사항 -->
		<jsp:include page="classPage/classApplication/attention.jsp"></jsp:include>
		<br>
	</div>	
		<!-- 클래스 포토 -->
		<jsp:include page="classPage/classApplication/classPhoto.jsp"></jsp:include>
		<br>
		<!-- 수강생 후기 아래에 추가 -->
  </div>
</body>
</html>