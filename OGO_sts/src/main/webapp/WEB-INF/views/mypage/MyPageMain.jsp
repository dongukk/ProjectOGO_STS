<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
<% String mesg = (String)request.getAttribute("mesg");
	System.out.print(mesg);
%>
	$(document).ready(function() {
		
		if (<%=mesg%> != null) {
			alert('<%=mesg%>');
		}
		
		
		//비밀번호 바꾸기
		$("#ChangePW").on("click", function() {
			console.log("passwd1"+$("#passwd1").val());
			console.log("passwd2"+$("#passwd2").val());
			
			if ($("#passwd1").val() == $("#passwd2").val()) {
				location.href='ChangePW?passwd='+$("#passwd2").val();
				
				
			}else if ($("#passwd1").val() == "" ||  $("#passwd2").val()=="") {
				alert('비밀번호를 입력해 주세요.');
			}
			else {
				alert("비밀번호가 일치 하지 않습니다. 다시 입력해 주세요.");
			}
		});
		
		
		//아이디 중복 확인 검사
		$("#IDC").on("click", function () {
			console.log($("#NewID").val());
			
			$.ajax({
			url:"../loginCheck/CheckID",
			method:"get",
			data:{ "userid":$('#NewID').val()},
			dataType: "text", 
			success: function (data, xhr, status) {
				console.log('성공'+data);
			},
			error: function(xhr, status, error) {
				console.log(status, error);
			} 
			});//ajax
		});//아이디 중복 확인 검사
			
			
				
		
			
		
		
	});
</script>
</head>
<body>
	<h1>MY SPACE</h1>
	<table border="1">
		<tr><td>아이디 &nbsp ${ login.userId }</td></tr>
		<tr> <td> 비밀번호 변경 &nbsp<input type="password" id="passwd1" placeholder="변경할 비밀번호를 입력하세요." > </td> </tr>
		<tr> <td> 비밀번호 확인 &nbsp<input type="password" id="passwd2"> &nbsp <input id="ChangePW" type="button" value="비밀번호 변경"> </td> </tr>
		<tr> <td> 닉네임 &nbsp <input id="NewID" type="text" value ="${ login.nickname }"> <input type="button" value="중복 확인" id="IDC"> </td> </tr>
	
	</table>
	
	
</body>
</html>