<%@page import="com.dto.notice.NoticePageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&family=Secular+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">	
	<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
	<link rel="stylesheet" href="css/notice/noticeTable.css">
<head>
<meta charset="UTF-8">
<title>OGO:공지사항&FAQ</title>
<style type="text/css">
	#noticeTable{padding-top: 100px;}
</style>
</head>
<div class="intro_header">
<div class="intro_text">
<h1>SUPPORT</h1> 
<h4>편리한 모험을 위해 OGO는 끊임없이 연구합니다</h4>
</div>
</div>

<body id="notice_body">
	<div id="notice_title"  >NOTICE</div>
	<table id="notice_table1">
		<tr id="tr1"> <th>No.</th><th id="td2">제목</th><th id="td3">작성일</th><th>작성자</th> </tr>
		
		<c:forEach var="NTdto" items="${ Pdto.list }" varStatus="status">
		<c:if test="${ Pdto.curPage == '1' }">
			<tr> <td>${status.index +1}</td><td><a class="a1" href="noticeContent?nNum=${ NTdto.nNum }">${NTdto.nTitle}</a></td><td>${NTdto.nDate}</td><td>${NTdto.nickName}</td> </tr> 
		</c:if>
		<c:if test="${ Pdto.curPage != '1' }">
		<tr> <td>${((Pdto.curPage-1)*Pdto.perPage + status.index)+1}</td><td><a class="a1" href="noticeContent?nNum=${ NTdto.nNum }">${NTdto.nTitle}</a></td><td>${NTdto.nDate}</td><td>${NTdto.nickName}</td> </tr> 
		</c:if>
		</c:forEach>
		</table>
			<!-- <td colspan="4"> -->
			
			<%-- 
			 <% 
			NoticePageDTO Pdto =(NoticePageDTO) request.getAttribute("Pdto");
			int perpage = Pdto.getPerPage();
			int totalcount = Pdto.getTotalCount();
			int totalPage = totalcount/perpage;
			if(totalcount%perpage > 0) { totalPage++; }
			%> 
			--%>
			<table id="notice_table2">
			<tr>
				<td colspan="2" id="notice_perage1">
					<br>
				<c:forEach varStatus="status" begin="1" end="${ Pdto.totalCount/Pdto.perPage }" > <%-- end="<%= totalPage %>" --%> 
					<c:if test="${ Pdto.curPage  == status.index }">
							&nbsp&nbsp${ status.index }&nbsp&nbsp
					</c:if> 
					
					<c:if test="${ Pdto.curPage  != status.index }">
					<a class="a1" href="notice?curpage=${ status.index }">&nbsp${ status.index }&nbsp</a>  
					</c:if> 
				</c:forEach>
				
				<c:if test="${ Pdto.totalCount/Pdto.perPage >0 }">
					<a class="a1" href="notice?curpage=<fmt:parseNumber var="i" integerOnly="true" value="${Pdto.totalCount/Pdto.perPage+1}"/>${i}"><fmt:parseNumber var="i" integerOnly="true" value="${Pdto.totalCount/Pdto.perPage+1}"/> ${i}</a> <!-- 소수점 제거  -->
				</c:if>
				</td>
			</tr>
			<tr>
			<td>
				<c:if test="${ admin != null }">
				<input id="notice_btn" type="button" value="글 작성" onclick="location.href='loginCheck/NoticeCreate1'">
				</c:if>
			</td>
			</tr>
			</table>
			
</body>
</html>