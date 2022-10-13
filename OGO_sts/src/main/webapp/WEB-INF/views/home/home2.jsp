<%@page import="com.dto.classpage.ClassDTO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.dto.classlist.classlistDTO"%>
<%@page import="com.controller.classlist.classlistController" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">	
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">

<style type="text/css"> 
a { text-decoration:none } /*하이퍼링크 밑줄 제거*/
</style> 

<meta charset="UTF-8">

<title>OGO:어디로든 비행</title>
<link rel="stylesheet" type="text/css" href="css/classlist/home2.css">
<jsp:include page="../common/navBar/nav.jsp" flush="true"/>
</head>

<body>
<section>
<jsp:include page="/WEB-INF/views/classPage/classApplication/classOpenLogin.jsp"></jsp:include>
		<div class="intro_bg">
				<div class="intro_text">
				<h1>내가 원하는 행성으로, <br>바로 착지!</h1>
				<h4 class="contents1">배우고 싶었던 분야를 전문가에게 직접, 원하는 일정에 들어보세요</h4>
				</div>	
		</div>		
	<!-- intro end -->
	
	<ul class="amount">
	<li>
		<div>
			<div class="contents1">지금까지 생성된 행성 수</div>
			<div class="result">815</div>
		</div>
	</li>
	<li>
		<div>
			<div class="contents1">우주를 탐험 중인 비행사</div>
			<div class="result">3,234</div>
		</div>
	</li>
	<li>
		<div>
			<div class="contents1">최종 목표 행성수</div>
			<div class="result">100,000+</div>
		</div>
	</li>
	<li>
		<div>
			<div class="contents1">함께 하는 이들</div>
			<div class="result">21,084</div>
		</div>
	</li>
	</ul>
	<!-- amount end -->
	
	<!-- 본문 시작 -->
	<div class="main">
	<div class="main_text0" id="link_main_text0">
		<h1>CLASS LIST</h1>
		<div class="contents1">필터링 기능으로 원하는 행성을 찾으세요</div>
		</div>
		</div>
	
	
	<!-- 필터링 시작 -->
	<div class=filter>
	<div style="display:flex; justify-content:center; ">
	<!-- 버튼 요소 -->
		<a href="home2" style="color:red; text-decoration:none">전체보기</a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
		<p>
		<a href="ClassListCategoryServlet?listsortdate=desc" data-value="new" style="text-decoration:none; color:#787878;">최신순</a> &nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
		<a href="ClassListCategoryServlet?priceasc" data-value="asc" style="text-decoration:none; color:#787878;">낮은 가격</a> &nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
		<a href="ClassListCategoryServlet?pricedesc" data-value="desc" style="text-decoration:none; color:#787878;">높은 가격</a> 
	</div> 
	</div>
	
		<!-- 좌측 검색창-->
	<div class="menu">
		<div class="searchArea">
				<form>
				<input type="search" placeholder="Search">
				<span>검색</span>
				</form>
				</div> 
		<!-- 좌측 카테고리 -->
	    <ul class="category">
		<li>
			<button class=cate style="color:#fff; font-weight:bold;">뷰티</button>
			<ul class="subcate">
				<li><a href="home2?subcategory=메이크업" style="text-decoration:none">메이크업</a></li>
				<li><a href="home2?subcategory=스타일링" style="text-decoration:none">스타일링</a></li>
			</ul>
		</li>
		<li>
			<button class=cate style="color:#fff; font-weight:bold;">외국어</button>
			<ul class="subcate">
				<li><a href="home2?subcategory=영어" style="text-decoration:none">영어</a>	
				<li><a href="home2?subcategory=일본어·중국어" style="text-decoration:none">일본어·중국어</a>	
				<li><a href="home2?subcategory=기타 외국어" style="text-decoration:none">기타 외국어</a>	
			</ul>
		</li>
		<li>
			<button class=cate style="color:#fff; font-weight:bold;">댄스·뮤직</button>
			<ul class="subcate">
				<li><a href="home2?subcategory=댄스" style="text-decoration:none">댄스</a>	
				<li><a href="home2?subcategory=뮤직" style="text-decoration:none">뮤직</a>	
			</ul>
		</li>
		<li>
			<button class=cate style="color:#fff; font-weight:bold;">요리·공예</button>
			<ul class="subcate">
				<li><a href="home2?subcategory=요리·음료" style="text-decoration:none">요리·음료</a>	
				<li><a href="home2?subcategory=공예·DIY" style="text-decoration:none">공예·DIY</a>		
			</ul>
		</li>
		<li>
			<button class=cate style="color:#fff; font-weight:bold;">드로잉·디자인·영상</button>
			<ul class="subcate">
				<li><a href="home2?subcategory=디자인" style="text-decoration:none">디자인</a>	
				<li><a href="home2?subcategory=영상" style="text-decoration:none">영상</a>	
			</ul>
		</li>
		</ul>
	</div>
	<!--중간 main_text0 end -->	

<!-- 상품 목록 3개씩 정렬 -->
<div class=classlist>
	<table width="100%" cellspacing="0" cellpadding="0">
		
			<tr>
				<td>
					<table style="margin-left:auto; margin-right:auto; border-collapse:separate">
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td height="1" colspan="8" bgcolor="CECECE"></td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>
		
						<tr>
						
		
						
						<c:forEach var="cVO" items="${classlist}" varStatus="status">
					
						 <td>
						 	<table style=padding:15px >
										<tr>
											<td>
												
											</td>
										</tr>
										<tr>
										
											<td height="10">
										</tr>
										<tr>
											<td class= "td_default" align ="center">
												<a class= "a_black" href=""> 
												<br>
												</a>
												<font color="gray">
												<!-- 이미지연결  -->
													<%-- <%=listDTO.get(i).getClassNum() %> --%>
													<a href="ClassPage?listNum=${cVO.classNum}">
													<img src="upload/classPage/category/${cVO.id}_${cVO.name}/${cVO.classphoto1}" width="250" height="200">
													<%-- <%=listDTO.get(i).getId()%>_<%=listDTO.get(i).getName()%>/<%=listDTO.get(i).getClassphoto1()%> --%>
													</a>	
												</font>
											</td>
											
										</tr>
										<tr>
											<td height="10">
										</tr>
										<tr>
											<td class="td_name" align ="center" width='220px' height='45px' style="word-break:break-all">
											<strong>${cVO.className}<%-- <%= listDTO.get(i).getClassName() %> --%></strong>
											</td>
										</tr>
										<tr>
											<td height="10">
										</tr>
										<tr>
											<td class="td_price" align ="center">
												<font color="#B21EF1">
													${cVO.price}
													<%-- <%= listDTO.get(i).getPrice() %> --%>	
												</font>
											</td>
										</tr>
									</table>
								</td>
							<!-- 한줄에 3개씩 보여주기 -->	
						  
						 <%--  ${status.index} <!-- i역할 --> --%>
						   <c:if test="${status.count%3==0}">
						   
						       <tr>
						        <td height="30">
						        </td>
						        </tr>
							</c:if> 
						</c:forEach> <!-- for -->
					</tr>
				</table>
			</td>
		</tr>				
	</table>					 
</div>		

	
	<!-- main_text2 클래스 등록하기 시작 -->
	<div class="create">
		<ul>
			<li>
			<div><h1>클래스 등록</h1></div>
			<div>어떤 분야든 전문성을 갖고있다면, 지금 바로 클래스를 등록해주세요</div>
			<div class="more2"><a href="loginCheck/ClassCreate" style="color:#fff; text-decoration:none"">
			클래스 등록하기</a>
			</div>
			</li>
			<li></li>
		</ul>
	</div>
</section>

	<!-- footer html 현재 기능 아무것도 없음-->
	<footer>
		<div class="container">
			<div class="f_top">
				<ul class="f_nav">
					<li class="depth1">
					<p class="tit">COMPANY</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff;">회사 소개</a></li>
							<br>
							<li><a href="#" target="_blank" style="color:#fff;">언론 보도</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">POLICIES</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff;">이용약관</a></li>
							<br>
							<li><a href="#" target="_blank" style="color:#fff;">개인정보처리방침</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">SUPPORT</p>
						<ul class="depth2">
							<li><a href="../notice" target="_blank" style="color:#fff;">FAQ</a></li>
							<br>
							<li><a href="../notice" target="_blank" style="color:#fff;">공지사항</a></li>
						</ul>	
					</li>
					<li class="depth1">
					<p class="tit">B2B</p>
						<ul class="depth2">
							<li><a href="#" target="_blank" style="color:#fff;">기업교육</a></li>
							<br>
							<li><a href="#" target="_blank" style="color:#fff;">브랜드제휴</a></li>
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
				<br>
				<p>Copyright ⓒ2022 ogo inc, ltd. All rights reserved</p>
			</div>
		</div>
	</footer> 
</body>
</html> 