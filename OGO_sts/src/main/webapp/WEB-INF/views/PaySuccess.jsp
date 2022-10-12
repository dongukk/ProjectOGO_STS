<%@page import="com.dto.pay.PayDTO"%>
<%@page import="com.dao.pay.PayDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <jsp:include page="common/navBar/nav.jsp" flush="true"/>
  <title>Document</title>
  
  <!-- <meta http-equiv="refresh" content="10; url=loginCheck/paymentlog?userId=admin">  -->
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <link rel="stylesheet" href="css/pay/payment.css">
  
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<section>
      <h1>결제 완료!</h1>
      <br>
	<table class="table table-striped">
      <tr>
      <th>상품명</th>
      <th>일정</th>
      <th>가격</th>
      <th>결제일</th>
      </tr>
      <c:forEach items="${ list }" var="list">
      	<tr>
      <td>${ list.classname }</td>
      <td>${ list.allschedule }</td> 
      <td>${ list.price }원</td>
      <td>${ list.orderdate }</td>
      </tr>
      </c:forEach>
</table>
	<input type="hidden" id="userid" value="${ list[0].userid}">
	  <span id="countdown" style="color: red;">10</span> <span style="color: red;">초 뒤 결제 내역 페이지 이동 합니다.</span>
    <br>
</section>


<script type="text/javascript">

  let time = 10;

  const countDown = document.getElementById('countdown');
  

  setInterval(updateCountDown,1000)
  setTimeout(function(){
	  const userid = document.getElementById('userid').value;
    location.href='loginCheck/paymentlog?userId='+userid;
  },11000);
  function updateCountDown() {

    let seconds = time;

    countDown.innerHTML = seconds;
    time--;
  }
  
  </script>
</body>
</html>