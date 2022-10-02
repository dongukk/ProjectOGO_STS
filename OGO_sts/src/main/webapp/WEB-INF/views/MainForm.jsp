<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main 페이지</title>

	<c:if test="${!empty mesg}">
		<script>alert("${mesg}");</script>	
		<c:remove var="mesg"></c:remove>
	</c:if>

    
	<jsp:include page="common/navBar/nav.jsp" flush="false"/>
</head>
<body>
	
   <%--  <jsp:include page="common/mainPage/ScrollAni.jsp" flush="false"/>
	<jsp:include page="common/mainPage/MainPage.html" flush="false"/>  --%>

	<br><br><br><br><br><h1>로그인 test</h1>
	<% if(session.getAttribute("login")!=null){ %>
	${ login }<br><br>
	<img src="upload/member/${ login.profilePhoto}"> 
	<%} %><br><br>
	프로그레스바 test 시작
	-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>
	-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>
	프로그레스바 test 끝
</body>
</html>