<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr> <td>${ NoticeDTO.nTitle }</td><td>${ NoticeDTO.nDate }</td><td>${ NoticeDTO.nickName }</td> </tr>
	<tr> <td colspan="3">${ NoticeDTO.nContent }</td> </tr>
</table>
<input type="button" value="목록으로" onclick="location.href='http://localhost:7069/ogo/notice'">
<c:if test="${ admin != null }">
	<input type="button" value="수정" onclick="location.href='loginCheck/NoticeUpdate1?nNum=${NoticeDTO.nNum}'">
	<input type="button" value="삭제" onclick="location.href='loginCheck/NoticeDelete?nNum=${NoticeDTO.nNum}'">
</c:if>

</body>
</html>