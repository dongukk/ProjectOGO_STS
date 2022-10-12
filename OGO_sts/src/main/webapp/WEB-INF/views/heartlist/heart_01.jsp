<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>좋아요</title>
<!--  <link rel="stylesheet"  href="HeartList/heart_01.css" /> -->
 <link rel="stylesheet"  href="/ogo/css/heartlist/index7.css?after" />

<!-- <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> -->

<%-- <jsp:include page="NavBar.html" flush="true"></jsp:include>
<jsp:include page="LoginBar.jsp" flush="true" /> --%>
<hr>

<!-- 여기서부턴 제이쿼리 -->  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
//전체체크
$("#allCheck").on("click", function(){

	var result = this.checked;
	$(".check").each(function(idx, data){
		this.checked=result;;
	});
});



//개별 삭제 버튼
$(".delBtn").on("click", function(){

	var num=$(this).attr("data-xxx");
	location.href="hearts/"+num;

});




//전체 선택
$("#allCheck").on("click", function(){
	
	var result=this.checked;
	$(".check").each(function(idx,data){
	data.checked=result;
		
	});
	
});



//전체 삭제
$("#delAllCart").on("click", function(){
	
	var num=[];
	$(".check:checked").each(function(idx, ele){
		num[idx] = $(this).val();
	});
	console.log(num);
 	location.href="hearts/all/"+num; 
});




  
});
</script> 

<style type="text/css">



a {
text-decoration: none;
}

aside a:visited{
	color: white;
}

a:visited{
	color: black;
}

a :active{
	color: white;
}

a:hover {
text-decoration: underline;
} 

section{padding-top: 50px;}
</style>
<jsp:include page="/WEB-INF/views/common/navBar/nav.jsp" flush="true"/>  
</head>
<body>

  
   
     <section>
      <aside>
        <div class="side_bar">
          <p><a href="/ogo/loginCheck/Mypage">프로필 관리</a></p>
          <p><a href="/ogo/hearts">My 찜</a></p>
          <p><a href="/ogo/loginCheck/paymentlog?userId=${ login.userId }">결제 내역</a></p>
          <p><a href="/ogo/loginCheck/register">튜터 등록</a></p>
        </div>
      </aside>  
       <main>
       <h1 style="line-height: 2.0; ">MY 찜</h1>
     <h2 style="position: relative; right: 330px; ">MY 찜 목록</h2>



			<table width="100%" cellspacing="0" cellpadding="0" border="0">

				<tr>
					<td height="5">
				</tr>

<!-- 				<tr>
					<td colspan="10">
						<hr size="1" color="CCCCCC">
					</td>
				</tr> -->

				<tr>
					<td height="7">
				</tr>

				<tr style="height: 60px;">
					<th class="td_default" align="center"><strong>전체선택</strong><input type="checkbox"
						name="allCheck" id="allCheck" style="width: 100px;"></th>
					<!-- <th class="td_default" align="center"><strong>번호</strong></th> -->
					<th class="td_default" align="center" style="width: 150px;"><strong>클래스번호</strong></th>
					<th class="td_default" align="center"><strong>클래스정보</strong></th>
					<th class="td_default" align="center"><strong>가격</strong></th>
					<th width="100"></th>
					<th width="30"></th>
				</tr>

				<tr>
					<td height="7">
				</tr>

				<form name="myForm">

	<c:forEach var="heart" items="${list}" >콘텐츠


				<tr>
					<td class="td_default" width="80">
						<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> 
						<input type="checkbox" name="check" id="check81" class="check" value="${heart.num}"></td>
						

					<td class="td_default" width="80">${heart.classNum}</td> 
					<!-- <td class="td_default" width="80"><img
				src="images/items/.gif" border="0" align="center"
				width="80" /></td> -->



					<td class="td_default" width="500">
						<br>${heart.className}
					</td>


					<td class="td_default" align="center" width="80">${heart.price}</td>


					<!-- <td><input type="button" value="신청" onclick="order('81','a')"></td> -->



					<td class="td_default" align="center" width="30" style='padding-left: 10px'>
				<input type="button" value="삭제" class="delBtn" data-xxx="${heart.num}"></td><!-- data-xxx 사용자 정의 속성 -->
				<td height="10"></td> 


					<td height="10"></td>
				</tr>
	</c:forEach>




				</form>
				<tr>
					<td colspan="10">
						<hr size="1" color="CCCCCC">
					</td>
				</tr>
				 <tr>
					<td height="30">
				</tr> 

				<tr>
					<td align="left" colspan="5">
						<a class="a_black" href="#" id="delAllCart"> 전체삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td height="20">
				</tr>

			</table>



		</main>   
       <aside></aside>
      </section>
    

</body>
</html>