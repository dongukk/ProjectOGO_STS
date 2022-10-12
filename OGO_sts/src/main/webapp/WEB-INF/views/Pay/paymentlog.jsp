<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="../css/pay/paylog.css">
</head>
<body>

<section>
<h1 id="title">결제 내역 </h1>
<br>
<table class="table table-striped table-hover">
	<tr> <th class="Pname">상품명</th><th class="Pschedule">일정</th><th class="Pprice">가격</th><th class="Pdate">결제일</th> </tr>
	<c:forEach var="dto" items="${ list }">
	<tr> <td><a class="Pname" href="../ClassPage?listNum=${ dto.classnum }">${ dto.classname }</a>&nbsp;&nbsp;</td><td class="scheduleOverflow">${ dto.allschedule }&nbsp;&nbsp;</td><td class="Pprice">${ dto.price }&nbsp;&nbsp;</td><td class="Pdate">${ dto.orderdate }&nbsp;&nbsp;</td> </tr>
	</c:forEach>
</table>
</section>

</body>
</html>