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
	<c:forEach items="${ FAQdto }" var="dto">
	<tr> <td>${ dto.faqTitle }</td> </tr>
	<tr> <td>${ dto.faqContent }</td> </tr>
	</c:forEach>
	</table>
</body>
</html>