<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="NoticeUpdate2" method="get">
	<input type="hidden" name="nNum" value="${ dto.nNum }">
	<table border="1">
	<tr> <td><input name="nTitle" value="${ dto.nTitle }"></td> <td><input type="text" name="nickName" value="${ dto.nickName }"></td> <td>${ dto.nDate }</td> </tr>
	<tr> 
		<td colspan="3"> 
			  <textarea name="nContent" rows="40" cols="100">
				${ dto.nContent }
			  </textarea> 

		</td> 
	</tr>
	<tr> <td colspan="3"> <input type="submit" value="수정"> </td> </tr>
	</table>
	</form>
	
</body>
</html>