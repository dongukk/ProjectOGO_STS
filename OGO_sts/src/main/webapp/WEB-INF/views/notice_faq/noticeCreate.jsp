<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성</title>
<style type="text/css">
#noticeCreate{
	
	position: relative;
	top: 95px;
	margin-left: auto;
	margin-right: auto;
	border-radius: 30px;
}

#noticeCreate_table{

	/* border: 3px solid #c4c4c4; */
	border-radius: 30px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 16px;
	margin: auto;

}

#noticeCreate_nTitle{

    color: #000000; 
    border-radius: 40px;
    font-weight: 700;
    font-size: 22px;
    
}
#noticeCreate_bottom{

    color: #000000; 
    background: rgb(250, 248, 247);
    box-shadow: 0px 2px 3px 0px  #a0a6af;
    font-weight: 700;
    font-size: 22px;
    border-radius: 30px;
    
}

#noticeCreate_btn{

	 border: 2px solid #c4c4c4;
	 border-radius: 20px;

}

#noticeCreate_textarea{
	 border: 2px solid #c4c4c4;
	 border-radius: 20px;
}

#nc_title{
		
	 border: 0px;

}

</style>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&family=Secular+One&display=swap" rel="stylesheet">
</head>
<body>
	<form id="noticeCreate" action="NoticeCreate2" method="get">
	<table id="noticeCreate_table" >
	<tr id="noticeCreate_nTitle"> <td><input id="nc_title" name="nTitle" placeholder="제목을 입력해 주세요."></td> <td>${ login.userId }</td> </tr>
	<tr> 
		<td colspan="2"> 
			  <textarea id="noticeCreate_textarea" name="nContent" rows="23" cols="80" placeholder="내용을 입력해 주세요.">
				 
			  </textarea> 

		</td> 
	</tr>
	<tr> <td colspan="2" id="noticeCreate_bottom"> <input id="noticeCreate_btn" type="submit" value="글작성"> </td> </tr>
	</table>
	</form>
</body>
</html>