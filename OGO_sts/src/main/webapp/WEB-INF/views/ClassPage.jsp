<%@page import="com.dto.classpage.ClassDTO"%>
<%@page import="com.dto.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- tosspayment -->
<script src="https://js.tosspayments.com/v1"></script>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>클래스 신청</title>
<link rel="stylesheet" href="css/classPage/classPage.css">
<%
	String heartYN = (String)request.getAttribute("heartYN");
	String heartCount = String.valueOf(request.getAttribute("heartCount"));
	ClassDTO cDTO =(ClassDTO)request.getAttribute("classDTO");
	int classNum=cDTO.getClassNum();
	
	MemberDTO mDTO= (MemberDTO)session.getAttribute("login"); 
	String userId=null;
	if(mDTO!=null){ //로그인 되어있는 경우
		userId = mDTO.getUserId();
	}
%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		//찜 버튼 클릭
		$("#heart").on("click", function() {
			
			if ("<%=userId%>" == null || "<%=userId%>"=="null") {
				alert("로그인 후 사용가능합니다");
			}else {
				var heart =$("#heart");
				//ajax 
				$.ajax({
					type: "get",
					url: "HeartClick",
					dataType: "text",
					async: false,
					data: { //서버에 넘겨줄 데이터
						userId : "<%=userId%>",
						classNum : <%=classNum%>,
						heartYN : <%=heartYN%>
					},
					success: function(data, status, xhr) {
						console.log("success");
						console.log(data);
						if (data=="insert") {
							heart.attr("src","images/classPage/heart2.png");
							alert("찜 목록에 추가되었습니다");
						}else { //delete인 경우
							heart.attr("src","images/classPage/heart1.png");
							alert("찜 목록에서 삭제되었습니다");
						}
					},
					error: function(xhr, status, e) {
						console.log("heart error");
						console.log(e, status);
					}
				})//ajax end
				
				//찜 개수 구하기
				$.ajax({
					type: "get",
					url: "HeartCount",
					dataType: "text",
					data: { //서버에 넘겨줄 데이터
						classNum : <%=classNum%>
					},
					success: function(data, status, xhr) {
						console.log("count success");
						$("#heartCount").text(data);
					},
					error: function(xhr, status, e) {
						console.log("count error");
						console.log(e, status);
					}
				})//ajax end
			}
		});//like click
		
		//드롭다운
		var idxArr=[];
		$(".dropdown-item").on("click", function() {
			var selectSchedule = $(this).text();
			var scheduleChoice =$("#scheduleChoice");
			
			var idx= selectSchedule.substring(0, 1);
			
			if (idxArr.indexOf(idx, 0)== -1) { //idx가 idxArr에 존재하지 않는 경우
				idxArr.push(idx); //idxArr에 추가
				//선택한 일정 정보 드롭다운 하단에 추가
				scheduleChoice.append("<div class='input-group mb-1' id='select"+idx+"'>"+
						"<input type='text' class='form-control' value="+selectSchedule+" readonly>"+
						"<button type='button' class='btn' id='close"+idx+"'>X</button>"+
						"<br></div>");
				
				$("#selectSched"+idx).val(selectSchedule.substring(4));
			}else { //idx가 idxArr에 이미 존재하는 경우
				alert("이미 선택한 회차입니다.");
			}
			
			//선택회차 개별 삭제 기능
			$("#close"+idx).on("click", function() {
				$("#select"+idx).detach(); //id가 select+idx인 div g태그 삭제
				var del = idxArr.indexOf(idx);
				if (del > -1) { //idxArr 배열에 del이 존재하는 경우
					idxArr.splice(del, 1); //배열에서 del 삭제
				}
				$("#selectSched"+idx).val(""); //hidden 태그 value도 삭제
			})
		})//수강회차 선택 end
		
		//수강결제 폼 submit-수강결제 시 (수강결제 버튼 클릭)
		$("#payForm").on("submit", function() {
			var count=0;
			for (var i = 1; i <= 10; i++) {
				var value=$("#selectSched"+i);
				if (value.val().length>0) {
					count++;
				}
			}
			if ("<%=userId%>"==null || "<%=userId%>"=="null") { //로그인을 하지 않은 경우
				alert("로그인이 필요합니다");
				event.preventDefault();
			}else if (count==0) { //회차를 선택하지 않은 경우
				alert("원하는 수강 회차를 선택해주세요");
				event.preventDefault();
			}else{ //로그인 되어있고, 수강회차도 선택한 경우
				//수강결제정보 ajax
				$.ajax({
					type: "post",
					url: "ClassOrder",
					dataType: "text",
					async: false,
					data: { //서버에 넘겨줄 데이터
						classNum : $("#classNumber").val(),
						schedule1 : $("#selectSched1").val(),
						schedule2 : $("#selectSched2").val(),
						schedule3 : $("#selectSched3").val(),
						schedule4 : $("#selectSched4").val(),
						schedule5 : $("#selectSched5").val(),
						schedule6 : $("#selectSched6").val(),
						schedule7 : $("#selectSched7").val(),
						schedule8 : $("#selectSched8").val(),
						schedule9 : $("#selectSched9").val(),
						schedule10 : $("#selectSched10").val(),
						price : $("#classPrice").val()
					},
					success: function(data, status, xhr) {
						event.preventDefault();
						if (data!="성공") {
							alert(data);
						}else{
							console.log("classOrder success");
							$("#Pay_button1").trigger("click");
						}
					},
					error: function(xhr, status, e) {
						console.log("classOrder error");
						console.log(e, status);
					}
				})//ajax end
			}
		}) //결제 폼 end
		
		
		//결제 버튼 누를시
		$("#Pay_button1").click(function() {
			  
			if ("<%=userId%>" != null) {			
				$.ajax({
					type: "get",
					url: "PayMain", 
					dataType: "json",
					success: function (data, status, xhr) {
						console.log(data);
						$("#Pay_span1_CLASSNAME").html(data.CLASSNAME);
						$("#Pay_span2_PLACE").html(data.PLACE);
						$("#Pay_span3_countDate").html( data.countDate+"회");
						$(".Pay_span4_price").html(data.price);
						$("#customerName").val(data.customerName);
						$("#orderNum").val(data.orderNum);
						
					},
					error: function(xhr, status, error) {
						/* console.log(status+error); */
					}
				});//ajax
				
			}else {
				e.preventDefault();
				alert("로그인 후 이용해주세요");
			}//else
				
			});//button.click
		
		
		
	})//
</script>
<jsp:include page="common/navBar/nav.jsp" flush="true"/>
</head>
<body>

<div class="wrap">
  <div id="right">
	<!-- 결제 박스 -->
	<jsp:include page="classPage/classApplication/box.jsp"></jsp:include>
  </div>
  <div id="left">
	<!-- 네비탭 -->
	<%-- <jsp:include page="class_page/classNavtab.jsp"></jsp:include> --%>
	<br>
		<!-- 클래스 이미지, 클래스 이름 -->
		<jsp:include page="classPage/classApplication/title.jsp"></jsp:include>
		<br>
	<div class="classpage_box1">
		<!-- 클래스 소개 -->
		<jsp:include page="classPage/classApplication/classInfo.jsp"></jsp:include>
		<br>
		<!-- 일정 및 장소 안내 -->
		<jsp:include page="classPage/classApplication/detail.jsp"></jsp:include>
		<br>
	</div>
	<div class="classpage_box2">	
		<!-- 튜터 소개 -->
		<jsp:include page="classPage/classApplication/tutorInfo.jsp"></jsp:include>
		<br>
		<!-- 공지사항 -->
		<jsp:include page="classPage/classApplication/notice.jsp"></jsp:include>
		<br>
		<!-- 유의사항 -->
		<jsp:include page="classPage/classApplication/attention.jsp"></jsp:include>
		<br>
	</div>	
		<!-- 클래스 포토 -->
		<jsp:include page="classPage/classApplication/classPhoto.jsp"></jsp:include>
		<br>
		<!-- 수강생 후기 아래에 추가 -->
		
		
		
		<!-- 결제버튼 -->
		<button id="Pay_button1" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">결제</button>
		
		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
		  <div class="offcanvas-header">
		    <h4 id="offcanvasRightLabel">결제 목록을 확인해 주세요</h4>
		    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		  </div>
		  <div class="offcanvas-body">
		    <span id="Pay_span1_CLASSNAME"></span>
		    <br>
		    <br>
		    <span id="Pay_span2_PLACE"></span>
		    <br>
		    <br>
		    <span id="Pay_span3_countDate"></span> &nbsp;&nbsp;    
		    <span id="Pay_price" class="Pay_span4_price"></span>
		    <span>원</span>
		 	<br>
		 	<br> 
		 	<input type="hidden" id="customerName" value="">
		 	<input type="hidden" id="orderNum" value="">
		 	
		 	
		 	<section>
		      <!-- ... -->
		      <span>총 주문금액</span>
		      <span class="Pay_span4_price" id="Pay_span4_price"></span>
		      <span>원</span>
		      <button id="payment-button">결제하기</button>
		    </section>
		    
		    <script>
      var clientKey = 'test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq'
      var tossPayments = TossPayments(clientKey)
      var button = document.getElementById('payment-button') // 결제하기 버튼
	  var Cname = document.getElementById("Pay_span1_CLASSNAME"); //결제할 class이름
	  var Cprice = document.getElementById("Pay_span4_price");
      var CnameT = Cname.innerText/* +"외 3건" */;
      var Cusername = document.getElementById("customerName");
      var CorderNum = document.getElementById("orderNum");
	  
      button.addEventListener('click', function () {

        tossPayments.requestPayment('카드', {
          amount: Cprice.innerText,
          orderId: CorderNum.value,
          orderName: Cname.innerText,
          customerName: Cusername.value,
          successUrl:'http://localhost:7069/ogo/PaySuccess',
          failUrl: 'http://localhost:8097/Pay/fail.jsp',
        })
      })
    </script>
		
		  </div>
		</div>


  </div>
</div>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>