<%@page import="com.dto.classpage.ClassDTO"%>
<%@page import="com.dto.classpage.ClassImgDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//카테고리별로 경로설정
	ClassDTO cDTO=(ClassDTO)request.getAttribute("classDTO");
	String sCategory=cDTO.getSubCategory();
	String imgSrc="images/classPage/category/";
	if (sCategory.equals("메이크업")||sCategory.equals("스타일링")){
		imgSrc +="A_뷰티/";
	}else if (sCategory.equals("영어")||sCategory.equals("일본어·중국어")||sCategory.equals("기타 외국어")){
		imgSrc +="B_외국어/";
	}else if (sCategory.equals("댄스")||sCategory.equals("뮤직")){
		imgSrc +="C_댄스·뮤직/";
	}else if (sCategory.equals("요리·음료")||sCategory.equals("공예·DIY")){
		imgSrc +="D_요리·공예/";
	}else if (sCategory.equals("디자인")||sCategory.equals("영상")){
		imgSrc +="E_드로잉·영상/";
	}
%>
<div class="page classPhoto" id="classPhoto">
  <div class="name">
    <h2>클래스 Photo</h2>
  </div>
  <hr>
 
 <div class="classPhoto2 mb-5">
    <div id="photoPart">
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
	      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 3"></button>
	      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 3"></button>
      </div>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="<%=imgSrc%>${imgDTO.classPhoto1}" class="d-block w-100 h-100" >
	    </div>
	    <div class="carousel-item">
	      <img src="<%=imgSrc%>${imgDTO.classPhoto2}" class="d-block w-100 h-100" >
	    </div>
	    <div class="carousel-item">
	      <img src="<%=imgSrc%>${imgDTO.classPhoto3}" class="d-block w-100 h-100" >
	    </div>
	    <div class="carousel-item">
	      <img src="<%=imgSrc%>${imgDTO.classPhoto4}" class="d-block w-100 h-100" >
	    </div>
	    <div class="carousel-item">
	      <img src="<%=imgSrc%>${imgDTO.classPhoto5}" class="d-block w-100 h-100" >
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div> 
	</div>
</div> 
<br>
</div>