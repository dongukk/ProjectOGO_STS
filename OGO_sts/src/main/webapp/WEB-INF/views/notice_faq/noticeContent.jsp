<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&family=Secular+One&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/notice/noticeContent.css">
</head>
<body>
		<table id="noticeContent_body">
			<tr id="noticeContent_tr1" > <td>${ NoticeDTO.nTitle }</td><td>${ NoticeDTO.nDate }</td><td>${ NoticeDTO.nickName }</td> </tr>
			<tr id="noticeContent_tr2" class="noticeContent_color"> <td colspan="3">&nbsp&nbsp ${ NoticeDTO.nContent }</td> </tr>
			
			<tr id="noticeContent_tr3" > 
				<td id="noticeContent_btn">
					<c:if test="${ admin != null }">
					<input type="button" class="nbtn" value="수정" onclick="location.href='loginCheck/NoticeUpdate1?nNum=${NoticeDTO.nNum}'">
					<input type="button" class="nbtn" value="삭제" onclick="location.href='loginCheck/NoticeDelete?nNum=${NoticeDTO.nNum}'">
					</c:if>
				</td>
			</tr>
		</table>

</body>
</html>