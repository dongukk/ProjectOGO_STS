<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/mypage/mypage.css">
<link rel="shortcut icon" href="../images/logo/favicon.ico" type="image/x-icon">
<script type="text/javascript">
<% %>

$(document).ready(function() {
	
	
	//취미 가져오기
	var hobby = $("#hobby").val();	
	console.log("가져온 취미 풀네임"+hobby);
	//,를 기준으로 나누기
	var Harr = hobby.split(',');
	console.log("분리된 취미"+Harr);
	//하나씩 찍어보기
	for ( var harr of Harr) {
		console.log("가져온 취미들  "+harr);
		
		if (harr == "뷰티·심리.퍼스널 검사") {
			$("#hobby1").prop('checked',true);
		}else if (harr == "외국어") {
			$("#hobby2").prop('checked',true);
		}else if (harr == "요리·공예·취미") {
			$("#hobby3").prop('checked',true);
		}else if (harr == "댄스·뮤직") {
			$("#hobby4").prop('checked',true);
		}else if (harr == "스포츠·피트니스") {
			$("#hobby5").prop('checked',true);
		}else if (harr == "뷰티·마인드.펫") {
			$("#hobby6").prop('checked',true);
		}else if (harr == "드로잉·디자인·영상") {
			$("#hobby7").prop('checked',true);
		}
	}//for
	
	
	
	
// 취미 다중 체크박스 값 가져오기 함수
// btnChk 라는 버튼이 눌렸을 때, hobby라는 name을 가진 체크박스들을 확인하여 눌린 체크박스의 value값을 가져오도록 코딩
// gHobby라는 새로운 변수를 만들어서 눌린 체크박스의 값을 ',(콤마)'를 이용하여 하나의 변수에 만들어보았으며, 최종으로 만들어진 gHobby 값을 hidden(히든)에 담아서 Controller로 보내주었다.
$('#btnChk').click(function() {
	var gHobby = "";
	$("input[name=hobby]:checked").each(function() 
		{if(gHobby == ""){
			gHobby = $(this).val();
		} else {gHobby = gHobby + "," + $(this).val();}});
			$('#gHobby').val(gSize);});
// 취미 다중체크박스 전체선택,해제
$("#hobbyAll").click(function() {
	if($("#hobbyAll").is(":checked")) $("input[name=hobby]").prop("checked", true);
	else $("input[name=hobby]").prop("checked", false);
});
// 하위항목 체크박스 모두 선택시 상위 전체체크박스 활성화 기능
$("input[name=hobby]").click(function() {
	var total = $("input[name=hobby]").length;
	var checked = $("input[name=hobby]:checked").length;
	
	if(total != checked) 
		$("#hobbyAll").prop("checked", false);
	else 
		$("#hobbyAll").prop("checked", true); 
});

// 비번확인
// 키 이벤트 발생시 패스워드 일치여부 검사 
$("#userPasswd2").keyup(function(){
	var passwd = $("#userPasswd").val();
	var mesg = "비밀번호가 일치하지 않습니다.";
	if(passwd == $(this).val()){
		mesg = "비밀번호 일치";
		$("#result").css("color","green");
	} else {
		$("#result").css("color","red");
	}
	$("#result").text(mesg);
});

// 이메일 선택 이벤트
$("#sel").change(function (){
	$("#email2").val($(this).val());
});

//nicknameCheck 버튼 클릭 함수 (ajax 비동기 처리)
$("#nicknameCheckBtn").click(function(){
	
	// 닉네임 입력안했을시 이벤트 중지
	var nickname = $("#nickname").val();
	var Tnickname = $("#Tnickname").val()
	if(nickname.length == 0){
		alert("닉네임을 입력하세요");	
		return false;
	}
	
	// 비동기 처리
	$.ajax({
		url: '../loginCheck/CheckID',
		type: 'get',
		dataType: "text",
		data: {nickname:nickname,
			Tnickname:Tnickname},
		success: function(data, status, xhr) {
			console.log(data);
			if(data > 0) {
				$("#result2").text("닉네임 사용불가능");
				$("#result2").css("color","red");
			}else if (data == "0" || data == 0) {
				$("#result2").text("현재 닉네임");
				$("#result2").css("color","green");
			} else {
				$("#result2").text("닉네임 사용가능");
				$("#result2").css("color","green");
			}
		},
		error: function(xhr, status, error) {
			console.log(error);
		}			
	}); // end ajax
});	// end nicknameCheck
// 닉네임 중복시 회원가입 이벤트 중지
$("form").submit(function () {
	var result2 = $("#result2").text();
	console.log(result2);
	if(result2 == "닉네임 사용불가능"){
		alert("닉네임이 중복입니다.");
		$("#nickname").focus();
		event.preventDefault();
	}	
});

});	// end ready

// idCheck 버튼 클릭 함수
$(function(){
	$("#idCheckBtn").click(function(){
		// window.open() - window객체로 창은 여는 메서드
		// open(url, name, option)
		// window.open("idCheck1.jsp", "idCheck1", "width=400, height=400, top=100, left=400");
		idCheckWindowOpen();
	});
	// id입력칸 눌러도 idCheck창 오픈
	$("#userId").click(function(){
		idCheckWindowOpen();
	});
	function idCheckWindowOpen(){
		window.open("idCheck1.jsp", "", "width=450, height=200, top=100, left=400");
	}
});
//취소누르면 회원정보창 닫기
$(function(){
$("#close").click( function(){
	
	location.href='../home2';
});
});

</script>

<style type="text/css">
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
   bottom: 800px;
   right: 550px;
   z-index: 1;
 }

.image-preview {
  position: relative;
  width: 150px;
  height: 150px;
  background-image:url("../upload/member/${ login.profilePhoto}");
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
  border-radius: 50%;
}
</style>
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
        <h1>MY SPACE</h1>

     <div class="upload"></div>
	   <ul class="image-preview" style="background-image: url('../upload/member/${ login.profilePhoto}')"></ul>	
	  <div class="profile_container">
 	</div>
       		
	<form action="../loginCheck/MemberUpdate" method="post" enctype="multipart/form-data"><!-- 이거 수정함 --> 
		<input type="hidden" value="${ login.profilePhoto}" name="mimg">   
		<input type="file" name="changeProfile" class="real-upload" accept="image/*">	
		<br>

	
<div style="text-align: left; color: red;">* 항목은 필수입력 사항입니다.</div>
		<div class="info_input">
	<input type="hidden"  value="${ login.userId }"  name="userId" ><!-- hidden 을 이용한 id 전송 -->
        	    <p style="width: 100px;">아이디</p>	${ login.userId }
		</div>
		
		
  <div class="info_input">
             <p style="width: 300px;">비밀번호 변경(*)</p>   
            <input name="userPasswd" id="userPasswd" type="password" required="required"  value="${ login.userPasswd }"  class="form-control" 
				placeholder="비밀번호를 입력해주세요.">		
		</div>
				<div class="info_input">
					 <p style="width: 300px;">비밀번호 변경 확인(*)</p>
					<input name="userPasswd2" id="userPasswd2" type="password"  value="${ login.userPasswd }" 
						required="required"  class="form-control"
						placeholder="비밀번호를 재입력해주세요.">
				</div>
				<div style="text-align: right;">
					<span id="result"></span>
				</div>



				<div class="info_input">			
		               <p style="width: 150px;">닉네임(*)</p>		
		        <input type="hidden" name="Tnickname" id="Tnickname" value="${ login.nickname }">
				<input name="nickname" id="nickname" class="form-control" required="required" class="form-control" 
					placeholder="힌트기능 : 닉네임 중복체크를 이용하세요." value="${ login.nickname }" > 
				<div class="input-group-btn">
					<button type="button" id="nicknameCheckBtn" class="btn2">닉네임 중복체크</button>
					
				</div>
				
			</div>
			<div style="text-align: right;">
				<span id="result2"></span>
			</div>
		

         <div class="info_input">
            <p style="width: 100px;">이름</p>
           ${ login.userName }
            <div></div>
          </div>   

		 <div class="info_input">
			<p style="width: 100px;">생년월일</p>
			<c:set var="birth" value="${ login.birth }" />
			${ fn:substring(birth,0,10) }
		</div> 
		
		     <div class="info_input">
            <p style="width: 100px;">연락처</p>
         <div class="form-inline"><!-- phone1 해야됨 -->
				<select name="phone1" style="height: 25px;" >
					<option  value="010" <c:if test="${ login.phone1 eq '010' }">selected="selected"</c:if> >010</option>
					<option  value="02"  <c:if test="${ login.phone1 eq '02' }">selected="selected"</c:if> >02</option>
					<option  value="031" <c:if test="${ login.phone1 eq '031' }">selected="selected"</c:if> >031</option>
					<option  value="051"  <c:if test="${ login.phone1 eq '051' }">selected="selected"</c:if> >051</option>
				</select>
				- <input name="phone2" class="phone2" style="width:80px" type="text" maxlength="4" required="required"
				 pattern="[0-9]{4}" title="숫자 4자리를 입력할 수 있습니다." value="${ login.phone2 }">
				- <input name="phone3" class="phone3" style="width:80px" type="text" maxlength="4" required="required"
				 pattern="[0-9]{4}" title="숫자 4자리를 입력할 수 있습니다."  value="${ login.phone3 }"> 
			</div>
		</div>
		
		
		
		      <div class="info_input3">
            <p style="width: 100px; height: 15px;">주소(*)</p>
			  <input type="text" name="post" id="post" placeholder="우편번호" value="${ login.post }">
			<input type="button"  class="but"     onclick="execDaumPostcode()" value="우편번호 찾기"><br>
     </div> 
     
       <div class="info_input3">
			<input type="text"  size="50"  name="address1" id="address1" placeholder="도로명주소" value="${ login.address1 }">
     </div> 
     
            <div class="info_input4">
			<input type="text"   size="50"   name="address2" id="address2" placeholder="지번주소" value="${ login.address2 }">
			<span id="guide" style="color:#999"></span>
     </div> 

	
		
			 <div class="info_input">
            <p style="width: 100px;">이메일</p> 
			<!-- type : email - 모바일의 키패드가 email입력 패드로 바뀐다. 입력한 데이터가 이메일 양식에 맞는지 검사한다. -->
			<input type="text" name="email1" id="email1" required="required" value="${ login.email1 }">@
	        <input type="text" name="email2" id="email2" required="required" placeholder="직접입력"  value="${ login.email2 }">
	        <select id="sel" style="height: 27px;">
	       		<option selected >이메일 선택</option>  <!-- disabled 있었는데 지웠음 다른거 모르겠음 -->
		        <option value="daum.net">daum.net</option>
		        <option value="naver.com">naver.com</option>
		        <option value="nate.com">nate.com</option>
		        <option value="yahoo.com">yahoo.com</option>
	       </select>
		</div>

		<label for="hobby">관심있는 클래스 분야</label><span> (복수선택 가능)</span>
		<input type="hidden" id="hobby" value="${ login.hobby }" >
		<div class="checkbox-group">
			<input type="checkbox" name="hobbyAll" id="hobbyAll"> 전체 선택<br>		
			<input name="hobby" type="checkbox" id="hobby1" value="뷰티·심리.퍼스널 검사" > 뷰티·심리.퍼스널 검사&emsp;
			<input name="hobby" type="checkbox" id="hobby2" value="외국어" > 외국어&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
			<input name="hobby" type="checkbox" id="hobby3" value="요리·공예·취미" > 요리·공예·취미&emsp;&emsp;&nbsp;
			<input name="hobby" type="checkbox" id="hobby4" value="댄스·뮤직"> 댄스·뮤직 &emsp;<br>
			<input name="hobby" type="checkbox" id="hobby5" value="스포츠·피트니스"> 스포츠·피트니스&nbsp;&nbsp;&nbsp;
			<input name="hobby" type="checkbox" id="hobby6" value="뷰티·마인드.펫" > 뷰티·마인드.펫&emsp;&nbsp;
			<input name="hobby" type="checkbox" id="hobby7" value="드로잉·디자인·영상"> 드로잉·디자인·영상&emsp;<br>
		</div><br>
		<button class="submit_button" type="submit">저장하기</button>    
     <button class="closeBtn"  type="button"  id="close">취소</button>
     <div class="exit"><a href="../MemberDelete?userId=${ login.userId }">회원 탈퇴하기</a></div>
	</form>

</main>
  <aside></aside>
</section>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js" ></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('post').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address1').value = fullRoadAddr;
                document.getElementById('address2').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();

    }
</script>
<script type="text/javascript">
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
	
	var fd = new FormData($("#fphoto")[0]); 
    fd.append("changeProfile",$("input[name=changeProfile]")[0].files[0]);
	console.log("이미지변경2");
	console.log(file);
	console.log(reader);
	console.log(fd);
	
	var formData = new FormData();
	var inputFile = $("input[name=changeProfile]");
	var files = inputFile[0].files;
	console.log(formData);
	console.log(files);
	/* $.ajax({
        type: "post",
        url: "/change/profilePhoto", 
		enctype: "multipart/form-data",
		data: formData,
        processData: false,
        contentType: false,
        success: function(data,status,xhr) {
            alert("사진이 정상적으로 변경되었습니다.");
            window.location.reload(true);
            alert(data);
        },
        error: function(xhr,status,error) {
            alert("사진 업로드시 에러 발생");
            return false;
        }
    }); */
	
	
}
realUpload.addEventListener('change', getImageFiles);


</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
