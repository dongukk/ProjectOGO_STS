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
<style type="text/css">
aside {
  width: 150px;
}
.side_bar {
  margin: 0 20px;
  margin-top: 108px;
  padding: 10px;
  width: 230px;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: black;
  gap: 20px;
  border-radius: 15%;
  position: fixed;
}

.side_bar > p {
  color: white;
  font-size: 18px;
  text-decoration: none;
}
main {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
main {
  position: relative;
  padding: 20px 300px;
  width: 1000;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}
</style>
</head>
<body>

<section>
	  <aside>
        <div class="side_bar">
          <p><a href="/ogo/loginCheck/Mypage">프로필 관리</a></p>
          <p><a href="/ogo/hearts">My 찜</a></p>
          <p><a href="paymentlog?userId=${ login.userId }">결제 내역</a></p>
          <p><a href="/ogo/loginCheck/register">튜터 등록</a></p>
        </div>
      </aside>  
      <br>
      <br>
<h1 id="title">결제 내역 </h1>
<br>
<table class="table table-striped table-hover"  style=" width:1000px; margin-left: 500px; ">
	<tr> <th class="Pname"  style="width: 200px;">상품명</th><th class="Pschedule"  style="width: 200px;">일정</th><th class="Pprice" style="width: 200px;">가격</th><th class="Pdate" style="width: 200px;">결제일</th> </tr>
	<c:forEach var="dto" items="${ list }">
	<tr> <td><a class="Pname" href="../ClassPage?listNum=${ dto.classnum }">${ dto.classname }</a>&nbsp;&nbsp;</td><td class="scheduleOverflow">${ dto.allschedule }&nbsp;&nbsp;</td><td class="Pprice">${ dto.price }&nbsp;&nbsp;</td><td class="Pdate">${ dto.orderdate }&nbsp;&nbsp;</td> </tr>
	</c:forEach>
</table>
</section>

</body>
</html>