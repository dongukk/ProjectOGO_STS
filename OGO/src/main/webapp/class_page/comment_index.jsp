<%@page import="com.dto.classpage.ClassCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Jua&family=Nanum+Gothic+Coding&family=Noto+Sans+KR:wght@900&family=Sunflower:wght@300&display=swap" rel="stylesheet">
	<link rel='stylesheet' href='comment.css'>
    <form id="cmt_form">
    
    <% 
	List<ClassCommentDTO> list = (List<ClassCommentDTO>) request.getAttribute("commentlist"); 
%>
    
	        <div class="cmt_header cmheader">수강생 후기
	        </div> <!--header-->
	        <div class="score">
	                 <b id="cmt_score">★4.3</b> <!--더미텍스트: 평균구하는 값 기입필요-->
	                 <b id="cmt_total">/ 5.0</b>
	        </div>
	
	        <div class="line1"><hr class="cmt_line1"></div>
	        <div class="line2"><hr class="cmt_line2"></div>
	        <div class="line3"><hr class="cmt_line3"></div>
	        <div class="line4"><hr class="cmt_line4"></div>
	     
	        <div class="img1"></div>
	        <div class="img2"></div>
	        <div class="img3"></div>
	    

	        <button class="button_body" id="cmt_button1">글쓰기</button>
        
	       
    </form>
