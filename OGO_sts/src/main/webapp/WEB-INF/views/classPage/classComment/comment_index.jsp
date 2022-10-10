<%@page import="com.dto.comment.ClassCommentPageDTO"%>
<%@page import="com.dto.member.MemberDTO"%>
<%@page import="com.dto.comment.ClassCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 	 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  	 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Jua&family=Nanum+Gothic+Coding&family=Noto+Sans+KR:wght@900&family=Sunflower:wght@300&display=swap" rel="stylesheet">
	<link rel='stylesheet' href='comment.css'>
<!-- 값없을 시 제외 -->
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	 $(function() {
		 /* create button */
		$("#cmt_submit1").click(function() {
			alert("Create_CommentServlet");
			
			$("textarea").remove("#cmt_textarea2");
			$("#cmt_submit1").attr("type", "submit");
			$("#cmt_form").attr("action", "loginCheck/comment_create");
			
		})		
		
		/* update button */
		$("#cmt_submit2").click(function() {
			//alert("Update_CommentSerlvet");
			
			$("textarea").remove("#cmt_textarea");
			$("#cmt_submit2").attr("type", "submit");
			$("#cmt_form").attr("action", "loginCheck/comment_update");
		})		
		/* delete button */
		$("#cmt_button3").click(function() {
			//alert("Delete_CommentServlet");
			
			$("textarea").remove("#cmt_textarea");
			$("textarea").remove("#cmt_textarea2");
			$("#cmt_button3").attr("type", "submit");
			$("#cmt_form").attr("action", "loginCheck/comment_delete");
		})		
		
		/* notice==null에 따른 img,hr 제외  */
		if($(".notice1>#notice_detail").val()==null){
			$(".img1").css("display","none");
			$(".cmt_line2").css("display","none");
		}else{
			$(".img1").show();
			$(".cmt_line2").show();
		}
		if($(".notice2>#notice_detail").val()==null){
			$(".img2").css("display","none");
			$(".cmt_line3").css("display","none");
		}else{
			$(".img2").show();
			$(".cmt_line3").show();
		}
		if($(".notice3>#notice_detail").val()==null){
			$(".img3").css("display","none");
			$(".cmt_line4").css("display","none");
		}else{
			$(".img3").show();
			$(".cmt_line4").show();
		}
		
		
		
	}) //end funtion 
 
 <% String mesg = (String) session.getAttribute("mesg"); 
 	if(mesg != null){
 %>
	alert("<%= mesg %>");

<%} session.removeAttribute("mesg"); %> 

</script>
    <form action="" id="cmt_form" method="get" >

    
	        <div class="cmt_header cmheader">수강생 후기
	        </div> <!--header-->
	        <div class="score">
	                <!--  <b id="cmt_score">★4.3</b> 더미텍스트: 평균구하는 값 기입필요
	                 <b id="cmt_total">/ 5.0</b> -->
	        </div>
	
	        <div class="line1"><hr class="cmt_line1"></div>
	        <div class="line2"><hr class="cmt_line2"></div>
	        <div class="line3"><hr class="cmt_line3"></div>
	        <div class="line4"><hr class="cmt_line4"></div>
	     
	        <div class="img1"></div>
	        <div class="img2"></div>
	        <div class="img3"></div>



	
	        <div class="notice1"><br>
	        	<p id="notice_detail"><b>&nbsp&nbsp ${cmtpagedto.list[0].comment_notice}</b></p>
	        </div> <!--임시 text DB연동-->

	        <div class="notice2"><br>
	        	<p id="notice_detail"><b>&nbsp&nbsp ${cmtpagedto.list[1].comment_notice}</b></p>
	        </div> <!--임시 text DB연동-->

	
	        <div class="notice3"><br>
	        	<p id="notice_detail"><b>&nbsp&nbsp ${cmtpagedto.list[2].comment_notice}</b></p>
	        </div> <!--임시 text DB연동-->
 

	
	<table id="cmt_page1">
		<tr> 
			<td colspan="2" id="cmt_page2">
				<br>
				
				
			
		
				<c:forEach varStatus="status" begin="1" end="${ cmtpagedto.totalPage/cmtpagedto.perPage }" >
					<c:if test="${ cmtpagedto.curPage  == status.index }">
							&nbsp&nbsp${ status.index }&nbsp&nbsp
					</c:if> 
					
					<c:if test="${ cmtpagedto.curPage  != status.index }">
					<a href="ClassPage?curpage=${ status.index }">&nbsp${ status.index }&nbsp</a>  
					</c:if> 
				</c:forEach>
				
				<c:if test="${ cmtpagedto.totalPage%cmtpagedto.perPage >0 }">
					<a href="ClassPage?curpage=<fmt:parseNumber var="i" integerOnly="true" value="${cmtpagedto.totalPage/cmtpagedto.perPage+1}"/>${i}"><fmt:parseNumber var="i" integerOnly="true" value="${cmtpagedto.totalPage/cmtpagedto.perPage+1}"/> ${i}</a> <!-- 소수점 제거  -->
				</c:if>
		
				
			</td>
		</tr>
		</table>

		<!-- delete button -->
		<c:if test="${login !=null }">
		<button type="" id="cmt_button3" onclick="location.href'Delete_CommentServlet'">삭제</button>
		</c:if>
		<!-- update button -->
		<c:if test="${ login != null }">
		<!-- () =test
		if() => if test="" -->
		<button type="button" class="btn btn-primary" id="cmt_button2" data-bs-toggle="modal" 
			data-bs-target="#staticBackdrop">수정
		</button>
		</c:if>
			
			<!-- Modal -->
			<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="staticBackdropLabel">수정하기</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body" id="textarea2">
			         <textarea id="cmt_textarea2" name="cmttextarea2" rows="5" cols="60"></textarea>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			        <button type="" class="btn btn-primary" id="cmt_submit2" >확인</button>
			      </div>
			    </div>
			  </div>
			</div>

<!-- create button -->    
	<c:if test="${login !=null }">
	<button type="button" class="btn btn-primary button_body" id="cmt_button1" data-toggle="modal" data-target="#myModal"
 			style="background-color: purple;">쓰기
 	</button>
 	</c:if>

			<!-- The Modal -->
			<div class="modal" id="myModal">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">글쓰기</h4>
			      </div>
			      <!-- Modal body -->
			      <div class="modal-body">
			        <textarea id="cmt_textarea" name="cmttextarea" rows="5" cols="60"></textarea>
			        <!-- ClassDTO cDTO =(ClassDTO)request.getAttribute("classDTO"); -->
			        <input id="classDTO" name="classDTO" type="hidden" value="${ classDTO }"> 
			      </div>
			      <!-- Modal footer -->
			      <div class="modal-footer">
			       	<button type="" class="cmt_submit" id="cmt_submit1" 
			      		style="position: relative; background-color: rgb(220,53,69); 
			      		color: white; border: 0px; border-radius: 4px; width: 54px; height: 38px;
			      		text-align: center;">확인</button>
			        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>

  </form>
  
 