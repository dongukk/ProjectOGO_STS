<%@page import="com.dto.notice.NoticePageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#noticeTable{padding-top: 100px;}
</style>
</head>
<body>
	<section id="noticeTable">
	<table border="1">
		<tr> <th>No.</th><th>제목</th><th>작성일</th><th>작성자</th> </tr>
		
		<c:forEach var="NTdto" items="${ Pdto.list }" varStatus="status">
		<c:if test="${ Pdto.curPage == '1' }">
			<tr> <td>${status.index +1}</td><td><a href="noticeContent?nNum=${ NTdto.nNum }">${NTdto.nTitle}</a></td><td>${NTdto.nDate}</td><td>${NTdto.nickName}</td> </tr> 
		</c:if>
		<c:if test="${ Pdto.curPage != '1' }">
		<tr> <td>${((Pdto.curPage-1)*Pdto.perPage + status.index)+1}</td><td><a href="noticeContent?nNum=${ NTdto.nNum }">${NTdto.nTitle}</a></td><td>${NTdto.nDate}</td><td>${NTdto.nickName}</td> </tr> 
		</c:if>
		</c:forEach>
		<tr>
			<td colspan="4">
			
			<%-- 
			 <% 
			NoticePageDTO Pdto =(NoticePageDTO) request.getAttribute("Pdto");
			int perpage = Pdto.getPerPage();
			int totalcount = Pdto.getTotalCount();
			int totalPage = totalcount/perpage;
			if(totalcount%perpage > 0) { totalPage++; }
			%> 
			--%>
			
				<c:forEach varStatus="status" begin="1" end="${ Pdto.totalCount/Pdto.perPage }" > <%-- end="<%= totalPage %>" --%> 
					<c:if test="${ Pdto.curPage  == status.index }">
							&nbsp&nbsp${ status.index }&nbsp&nbsp
					</c:if> 
					
					<c:if test="${ Pdto.curPage  != status.index }">
					<a href="notice?curpage=${ status.index }">&nbsp${ status.index }&nbsp</a>  
					</c:if> 
				</c:forEach>
				
				<c:if test="${ Pdto.totalCount/Pdto.perPage >0 }">
					<a href="notice?curpage=<fmt:parseNumber var="i" integerOnly="true" value="${Pdto.totalCount/Pdto.perPage+1}"/>${i}"><fmt:parseNumber var="i" integerOnly="true" value="${Pdto.totalCount/Pdto.perPage+1}"/> ${i}</a> <!-- 소수점 제거  -->
				</c:if>
				
			</td>
		</tr>
	</table>
	<c:if test="${ admin != null }">
		<input type="button" value="글 작성" onclick="location.href='loginCheck/NoticeCreate1'">
	</c:if>
	</section>
</body>
</html>