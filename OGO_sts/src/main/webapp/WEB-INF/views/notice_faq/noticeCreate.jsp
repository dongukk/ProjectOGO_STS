<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="NoticeCreate2" method="get">
	<table border="1">
	<tr> <td><input name="nTitle" placeholder="제목을 입력해 주세요."></td> <td>${ login.userId }</td> </tr>
	<tr> 
		<td colspan="2"> 
			  <textarea name="nContent" rows="40" cols="100" placeholder="내용을 입력해 주세요.">
				
			  </textarea> 

		</td> 
	</tr>
	<tr> <td colspan="2"> <input type="submit" value="글작성"> </td> </tr>
	</table>
	</form>
</body>
</html>