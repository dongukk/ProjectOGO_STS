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
</body>
</html>