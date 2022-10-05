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
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="Pay_css/cash.css">
  <link rel="stylesheet" href="Pay_css/button.css">
  <link rel="stylesheet" href="Pay_css/reset.css">
</head>
<body>
  <div class="header">
    <div class="info">
      <h1>결제내역</h1>
    </div> 
  </div>
	<div class="middle">
    <table border="1">
      <tr>
      <th>이미지</th>
      <th>상품명</th>
      <th>일정</th>
      <th>가격</th>
      <th>결제일</th>
      </tr>
      <c:forEach items="${ list }" var="list">
      	<tr>
      <td>${ list.CLASSPHOTO1 }</td>
      <td>${ list.CLASSNAME }</td>
      <td>${ list.allschedule }</td> 
      <td>${ list.PRICE }원</td>
      <td>${ list.ORDERDATE }</td>
      </tr>
      </c:forEach>
    </table>
    <br>


    <a href="http://localhost:7069/ogo/"><button id="btn1">OGO Main</button></a>


    <script>
      const btn = document.getElementById('btn1')
      const onClick = e => {
        const { x, y, width, height} = btn.getBoundingClientRect()
        const radius = Math.sqrt(width * width + height * height)
        btn.style.setProperty('--diameter', radius * 2 + 'px')
        const { clientX, clientY } = e
        const left = (clientX - x - radius) / width * 100 + '%'
        const top = (clientY - y - radius) / height * 100 + '%'

        btn.style.setProperty('--left', left)
        btn.style.setProperty('--top', top)
        btn.style.setProperty('--a', '')
        setTimeout(() => {
          btn.style.setProperty('--a', 'ripple-effect 500ms linear')
        }, 5)
      }

      btn.addEventListener('click', onClick)
    </script>
  </div>

</body>
</html>