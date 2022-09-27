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
		<tr> <th>No.</th><th>제목</th><th>작성일</th><th>작성자</th> </tr>
		
		<c:forEach var="NTdto" items="${ NTdtoList }">
		<tr> <td>${NTdto.nNum}</td><td><a href="noticeContent?nNum=${ NTdto.nNum }">${NTdto.nTitle}</a></td><td>${NTdto.nDate}</td><td>${NTdto.nickName}</td> </tr> 
		</c:forEach>
	</table>
</body>
</html>