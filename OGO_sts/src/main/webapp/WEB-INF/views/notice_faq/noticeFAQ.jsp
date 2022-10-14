<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&family=Urbanist:wght@800&display=swap" rel="stylesheet">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/notice/faq.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
      $( document ).ready( function() {
        
        
        $(".faq").on("click", function() {
        	var faqId = $(this).attr("id");
        	$("#A"+faqId).slideToggle();
        });
       
        
      });
    </script>
</head>
<body>
<%-- 	<table border="1">
	<c:forEach items="${ FAQdto }" var="dto">
	<tr> <td>${ dto.faqTitle }</td> </tr>
	<tr> <td>${ dto.faqContent }</td> </tr>
	</c:forEach>
	</table> --%>
	<div  id="faq_flexbox">
		<table class="faq_flex">
			<tr>
				<td id="faq_title1">FAQ</td>
			</tr>
			<tr>
				<td id="faq_title2">자주 묻는 질문을 모아봤어요</td>
			</tr>		
		</table>
	
	<div class="faq_flex">
	<c:forEach items="${ FAQdto }" var="dto"  varStatus="status">
		 <div class="accordion accordion-flush" id="accordionFlushExample">
		  <div class="accordion-item w-75"></div>
		    <h2 class="accordion-header" id="flush-heading${status.count}">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${status.count}" aria-expanded="false" aria-controls="flush-collapse${status.count}">
		        ${ dto.faqTitle }
		      </button>
		    </h2>
		    <div id="flush-collapse${status.count}" class="accordion-collapse collapse" aria-labelledby="flush-heading${status.count}" data-bs-parent="#accordionFlushExample">
		      <div class="accordion-body">
		        <strong>${ dto.faqContent }</strong> 
		      </div>
		    </div>
		  </div>
		</c:forEach>
		</div>
	</div> <!-- end flex -->
	<div id="faq_block"></div>
	<!-- footer html 현재 기능 아무것도 없음-->
	<footer>
		<div class="container">
			<div class="f_top">
				<ul class="f_nav">
					<li class="depth1">
					<p class="tit">COMPANY</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;">회사 소개</a></li>
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;">언론 보도</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">POLICIES</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;">이용약관</a></li>
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;">개인정보처리방침</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">SUPPORT</p>
						<ul class="depth2">
							<li><a href="NoticeMain.jsp" target="_blank" style="color:#fff; text-decoration:none;">FAQ</a></li>
							<li><a href="NoticeMain.jsp" target="_blank" style="color:#fff; text-decoration:none;">공지사항</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">B2B</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;" >기업교육</a></li>
							<li><a href="#" target="_blank" style="color:#fff; text-decoration:none;">브랜드제휴</a></li>
						</ul>	
					</li>
				</ul>
			</div>
		</div>
		
		<div class="container2">
			<div class="f_info" style="color:#fff">
				<p>상호:(주)오고  |  주소 : 서울특별시 강남구 테헤란로 70 5층  |  사업자등록번호 : 123-45-67890  |  대표자명 : 김취준</p>
				<p>(주)오고는 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 (주)오고는 튜터가 등록한 상품·클래스정보 및 거래에 관한
					의무와 책임을 지지 않습니다. 단, (주)오고가 튜터로 등록, 판매한 클래스는 튜터로서 의무와 책임을 부담합니다.</p>
				<p>Copyright ⓒ2022 ogo inc, ltd. All rights reserved</p>
			</div>
		</div>
	</footer> 		
	
</body>
</html>