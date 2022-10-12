<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
 <head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <link rel="stylesheet"  href="../css/tour/indextutor.css?after" />
     <link rel="shortcut icon" href="../images/logo/favicon.ico" type="image/x-icon">
<%-- <jsp:include page="NavBar.html" flush="true"></jsp:include>
<jsp:include page="LoginBar.jsp" flush="true" />--%>
<script type="text/javascript">

//취소누르면 회원정보창 닫기
$(function(){
$("#close").click( function(){
	
	location.href='MainForm.jsp';
});
});

</script>





<style type="text/css">

main {
  position: relative;
  width: 1000;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}


  a {
text-decoration: none;
}

aside a:visited{
	color: white;
}


a:visited{
	color: black;
}

a :active{
	color: white;
}

a:hover {
text-decoration: underline;
}   


.side_bar {
  margin: 0 20px;
  margin-top: 108px;
  padding: 10px;
  width: 230px;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: black;
  gap: 20px;
  border-radius: 15%;
  position: fixed;
}

.side_bar > p {
  color: white;
  font-size: 18px;
}


/* 추가함 */

    li {
      list-style: none;
    }

    .real-upload {
      display: none;
    }

    .upload {
      width: 30px;
      height: 30px;
      background-color: antiquewhite;
        background-image:url('/ogo/images/tour/change2.jpg');
          position: absolute;
            border-radius: 50%;
            box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
             bottom: 780px;
            right: 450px;
            z-index: 1;
    }

    .image-preview {
  position: relative;
  width: 150px;
  height: 150px;
  background-image:url("/ogo/images/tour/" +${profile});
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
  border-radius: 50%;
    }
    
  section{padding-top: 100px;}



</style>

<jsp:include page="/WEB-INF/views/common/navBar/nav.jsp" flush="true"/>
</head>
<body>

       <section>
      <aside>
        <div class="side_bar">
          <p><a href="/ogo/loginCheck/Mypage">프로필 관리</a></p>
          <p><a href="/ogo/hearts">My 찜</a></p>
          <p><a href="paymentlog?userId=${ login.userId }">결제 내역</a></p>
          <p><a href="/ogo/loginCheck/register">튜터 등록</a></p>
        </div>
      </aside>     
        <main>
        <h1>튜터 등록</h1>
 

<!--   추가함  -->      
   
  <div class="upload"></div>
  <ul class="image-preview" style="background-image: url('${profile}')"></ul>
	<input type="hidden" value="${profile}" name="timg">
 <div class="profile_container">



        </div>

	
	<form action="../loginCheck/register" method="post" enctype="multipart/form-data"><!-- 이거 수정함 -->
		<input type="file" name="tutorimg" class="real-upload" accept="image/*">



		<br>
		<div class="info_input2">
	<input type="hidden"  value=""  name="userId" ><!-- hidden 을 이용한 id 전송 -->
        	    <p>튜터명</p>	<input class="form-control" name="tname" value="" type="text" placeholder="이름을 입력하세요" aria-label="default input example">
		</div>
		
			
			<div style="text-align: right;">
				<span id="result2"></span>
			</div><br>
			
			
		<!-- <input >  -->
		
		<div class="info_input2">
		
            <p>튜터 자격 인증</p>
            <div class="form-floating">
            <div class="col-12 mt-3">
	    <label class="form-label"></label>
	    <div class="input-group mb-3">
	      <input type="file" class="form-control" id="tcertificate" name="tcertificate">
	      <label class="input-group-text" for="tcertificate">Upload</label>
	  	</div>
           <!--  <button class="Upload_button" 
            style="width: 100px; height: 30px; font-size: medium; position: relative; left : 450px; bottom: 50px;">업로드</button> -->
  <textarea name="tcertificate" class="form-control" placeholder="자격을 인증할 수 있는 자격증, 교육이력 등을 반드시 첨부해주세요! 미첨부 시 튜터 등록에서 제외될 수 있습니다." 
  id="floatingTextarea2" style="height: 80px"></textarea>
  <!-- <label  for="floatingTextarea2">자격을 인증할 수 있는 자격증</label> -->
</div>
         	
         	
         	<!-- <textarea rows="8" cols="80" placeholder="자격을 인증할 수 있는 자격증, 교육이력 등을 반드시 첨부해주세요! 미첨부 시 튜터 등록에서 제외될 수 있습니다." style="margin-top: 0;"></textarea> -->
            <div></div>
          </div>      
          <br>
          
		 <div class="info_input2"><!-- 동적 셀렉트 -->
			<p>자격 분야 선택</p>
			   <p>
      <select name="tcategory_id_parent" class="form-select form-select-sm" aria-label=".form-select-sm example" id="s1" onchange="optionChange();" style="width: 300px; display: inline;">
        <option>분야 선택</option>
        <option value="a">뷰티</option>
        <option value="b">외국어</option>
        <option value="c">댄스·뮤직</option>
        <option value="d">요리·공예</option>
        <option value="e">드로잉·디자인·영상</option>
      </select>
      <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="s2" name="tcategory_id" style="width: 300px; float: right; display: inline;">
      <option></option>
      </select>
    </p>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      function optionChange() {
        var a = ['메이크업','스타일링'];
        var a2 = ['106','107'];
        var b = ['영어','일본어 중국어','기타 외국어'];
        var b2 = ['108','109','110'];
        var c = ['댄스','뮤직'];
        var c2 = ['111','112'];
        var d = ['요리·음료','공예·DIY'];
        var d2 = ['113','114'];
        var e = ['디자인','영상'];
        var e2 = ['115','116'];
        
        var v = $( '#s1' ).val();
        var o;
        if ( v == 'a' ) {
          o = a;
        } else if ( v == 'b' ) {
          o = b;
        } else if ( v == 'c' ) {
          o = c;
        } else if ( v == 'd' ) {
          o = d;
        } else if ( v == 'e' ) {
          o = e;
        } 
        else {
          o = [];
        }
        
        var p;
        if ( v == 'a' ) {
          p = a2;
        } else if ( v == 'b' ) {
          p = b2;
        } else if ( v == 'c' ) {
          p = c2;
        } else if ( v == 'd' ) {
          p = d2;
        } else if ( v == 'e' ) {
          p = e2;
        } 
        else {
          p = [];
        }
        $( '#s2' ).empty();
        $( '#s2' ).append( '<option></option>' );
        for ( var i = 0; i < o.length; i++ ) {
          $( '#s2' ).append( '<option value="'+p[i]+'">' + o[ i ] + '</option>' );
        }
      }
    </script>
		</div><br>

		  <div class="info_input2">
            <p>튜터 소개</p>
					<div class="form-floating">
						<textarea class="form-control" name="tintroduce" placeholder="hungry"
							id="floatingTextarea2" style="height: 150px"></textarea>
						<label for="floatingTextarea2" class="count">최소 50자 이상으로 자유롭게 소개해주세요</label>
					</div>
		</div><br>

		<input  class="submit_button" type="submit" value="저장하기">
     <button class="closeBtn"  type="button"  id="close" >취소</button>
    
	</form>

</main>
  <aside></aside>
</section>

<script>
    $(document).ready(function () {
        var flag='${flag}'
        if (flag != '' && flag != null) {
            alert(flag);
            var check=confirm("클래스페이지로 가시겠습니까?");
            if(check){
            	location.href="";//클래스 페이지 ?
            }else{
            	location.href="/ogo/MainForm";
            }
          
      
        }
    });

     function createElement(e, file) {
      const li = document.createElement('li');
      const img = document.createElement('img');
      img.setAttribute('src', e.target.result);
      img.setAttribute('data-file', file.name);
      li.appendChild(img);

      return li;
    } 

    const realUpload = document.querySelector('.real-upload');
    const upload = document.querySelector('.upload');
    const imagePreview = document.querySelector('.image-preview');

    upload.addEventListener('click', () => realUpload.click());
    
    
    function getImageFiles(e) {
    	const file = e.target.files[0];
    	const reader = new FileReader();
    	reader.readAsDataURL(file);
    	reader.onload = () =>{
    		imagePreview.style.backgroundImage = 'url(\''+reader.result+'\')';
    	}
    }
    realUpload.addEventListener('change', getImageFiles);
    </script>
    
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>