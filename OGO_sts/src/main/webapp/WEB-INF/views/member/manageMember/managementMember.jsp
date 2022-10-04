<%@page import="java.io.Console"%>
<%@page import="com.dto.member.MemberDTO"%>
<%@page import="com.dto.member.PageDTO"%>
<%@page import="com.service.member.MemberService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
    
<%
	
 	
	 
	 
%>

	<c:if test="${!empty mesg}">
		<script>alert("회원 ${mesg}을(를) 탈퇴시켰습니다.");</script>	
		<c:remove var="mesg"></c:remove>
	</c:if>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	
	// 체크박스 다중선택
	function chk(n) {
		var lang= $(".delCheck");
		for(var i=0; i< lang.length; i++){
			lang[i].checked= n.checked;
		}
	}
	
	// 선택된 항목 회원들 삭제
	function delAll() {
		document.querySelector("#MemberForm").action='deleteAllMember'; 
	}
	
	// 회원 1명 삭제
	function delMember(n) {
		event.preventDefault(); 
		location.href="deleteMember?userId="+n;		
	}
	
</script>
<style type="text/css">
	#ManageMember {padding-top: 100px; padding-bottom: 10px;}
	#ManageMember #title {text-align: center;  margin-bottom: 30px; }
	#ManageMember #table { border: 1px solid !important; margin-left: auto; margin-right: auto; min-width: 1550px; margin-bottom: 5px;} 
	#ManageMember #table_head {height: 50px; color: white; background-color: gray;}
	#ManageMember #hobby {width: 400px;}
	#ManageMember #deleteAllMember {margin-left: 20px; margin-top: 10px;}
	#ManageMember #search {float: left;}
	#ManageMember #memberPage {text-align: center; font-size: 20px; font-family: 'Noto Sans KR', sans-serif; margin-left: 500px; margin-right: auto; margin-top: 10px;}
    #ManageMember #memberPage a {text-decoration: none; }
</style>
</head>
<body>
<section id="ManageMember">
<h1 id="title">회원관리 목록</h1>
<table border="1" cellpadding=10 id="table">
<!-- 검색기능 -->
		<tr>
			<td colspan="5">
				<form id="search" action="managementMember">
					<select name="searchName" style="height: 30px;">
						<option value="nickname" <c:if test="${empty searchName}">selected="selected"</c:if>>닉네임</option>
						<option value="address"  <c:if test="${searchName eq 'address'}">selected="selected"</c:if> >주소</option>
					</select> 
					<input type="text" name="searchValue" value="${searchValue}">	 
					<input type="submit" id="searcBtn" value="검색">
				</form>
			</td>
		</tr>
<form id="MemberForm">
	<tr id="table_head">
	   <th><input type="checkbox" name="delCheckAll" id="delCheckAll" onclick="chk(this)"></th>
	   <th>userId</th>
	   <th>nickname</th>
	   <th>birth</th>
	   <th>phone</th>
	   <th>주소</th>
	   <th>email</th>
	   <th id="hobby">hobby</th>
	   <th>등급</th>
	   <th>탈퇴</th>
	 </tr>
<c:forEach var="dto" items="${pDTO.getList()}" varStatus="status">
<tr>
	<td><input type="checkbox" name="delCheck"  class="delCheck" value="${dto.userId}"></td>
	    <td>${dto.userId}</td>
	    <td>${dto.nickname}</td>
	    <td>${dto.birth.substring(0,10)}</td>
	    <td>${dto.phone1}-${dto.phone2}-${dto.phone3}</td>
	    <td>${dto.address2}</td>
	    <td>${dto.email1}@${dto.email2}</td>
	    <td>${dto.hobby}</td> 
	    <td><c:choose>
	    <c:when test="${dto.userId eq 'admin'}">관리자</c:when>
	    <c:when test="${fn:contains(dto.userId, 'tutor')}">강사</c:when>
	    <c:otherwise>일반회원 </c:otherwise>
	    </c:choose></td>
	    <td><button onclick="delMember('${dto.userId}')" >탈퇴</button></td>
	</tr>
</c:forEach>
</table>
<button id="deleteAllMember" onclick="delAll()">선택한 회원 탈퇴</button>
<span id="memberPage">
				<%	
				PageDTO pDTO = (PageDTO) request.getAttribute("pDTO");
				int curPage = pDTO.getCurPage();		// 현재 볼 페이지 번호
		        int perPage = pDTO.getPerPage();		// 한페이지에 보여질 목록 수 
				int totalCount = pDTO.getTotalCount(); 	// 전체 레코드 갯수 
				int totalPage = totalCount/perPage;		// 전체 페이지 수
				if(totalCount%perPage!=0) totalPage++;	// ex) 전체레코드 9개/보여질목록수 2개 = 나머지1  전체페이지 증가++
		        for(int i=1; i<= totalPage; i++){		// 1부터 전체페이지수까지 증가
		          	if(i== curPage){					// 만약 i가 현재볼 페이지라면
		          		out.print(i+"&nbsp;");			// i를 보여준다
		          	}else{								// RowBound(offset, limit) // 시작 idx, 몇개
		          		                                //   offset = (원하는 페이지, -1)* perpage
		          		                                //   limit = purpage
		          		out.print("<a href='managementMember?curPage="+i+"&searchName='${searchName}'&searchValue='${searchValue}'>"+"&nbsp;"+i+"&nbsp;"+"</a>");
		          		
		          	}
		        }//end for
				%>
</span>

</form>
</section>
</body>
</html>