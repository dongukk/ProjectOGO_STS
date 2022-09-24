<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main 페이지</title>

<!-- 로그인처리 -->
<%
	String mesg = (String)session.getAttribute("mesg");
	if(mesg!=null){
%>
	<script type="text/javascript">
		alert("<%= mesg %>");
	</script>
<% 
	session.removeAttribute("mesg");
	} 
%>

    
	<jsp:include page="common/navBar/nav.jsp" flush="false"/>
</head>
<body>
	
   <%--  <jsp:include page="common/mainPage/ScrollAni.jsp" flush="false"/>
	<jsp:include page="common/mainPage/MainPage.html" flush="false"/>  --%>

	<br><br><br><br><br><h1>로그인하면 session저장한 login정보 출력 </h1>
	${ login }
</body>
</html>