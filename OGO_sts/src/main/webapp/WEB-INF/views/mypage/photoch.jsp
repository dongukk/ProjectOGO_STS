<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const browseBtn = document.querySelector('.browse-btn');
const realInput = document.querySelector('#real-input');

browseBtn.addEventListener('click',()=>{
	realInput.click();
});





function realInputFile(e){
    var sel_files = [];
    
    sel_files = [];
    $('#imagePreview').empty();
    
    var files = e.target.files;
    var fileArr = Array.prototype.slice.call(files);
    var index = 0;
    
    fileArr.forEach(function(f){
    	if(!f.type.match("image/.*")){
        	alert("이미지 확장자만 업로드 가능합니다.");
            return;
        };
            reader.readAsDataURL(f);
        }


)};

$('#real-input').on('change',readInputFile);



</script>
</head>
<body>
<!-- 	<form action="reg" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="title" value=""></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3"><input type="file" name="filename"  size="40" ></td>
			</tr>
		</table>
		<div>

			<button>저장</button>
			<a href="list.jsp">취소</a>
		</div>
	</form>
	 -->
	
	
	<input type="file" id="real-input" class="image_inputType_file" accept="img/*" required multiple>
<button class="browse-btn">사진업로드</button>
</body>
</html>