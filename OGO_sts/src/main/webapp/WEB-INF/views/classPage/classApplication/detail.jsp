<%@page import="com.dto.classpage.ClassDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ClassDTO cDTO = (ClassDTO)request.getAttribute("classDTO");
	String schedule1 =cDTO.getSchedule1();
	String schedule2 =cDTO.getSchedule2();
	String schedule3 =cDTO.getSchedule3();
	String schedule4 =cDTO.getSchedule4();
	String schedule5 =cDTO.getSchedule5();
	String schedule6 =cDTO.getSchedule6();
	String schedule7 =cDTO.getSchedule7();
	String schedule8 =cDTO.getSchedule8();
	String schedule9 =cDTO.getSchedule9();
	String schedule10 =cDTO.getSchedule10();

	
	String place =cDTO.getPlace();
%>
<div id="detail" class="page mb-5">
  <div class="name">
  	<div class="classpage_tab1-1">
   	 <h2 class="tab_menu">일정 및 장소 안내</h2>
    </div>
  </div>
   <div id="tab_scrollbar" class="classpage_tab1-1n classpageTab_hidden">
	<div class="row">
	  <div class="col-sm-2" id="classDetail1" style="text-align: center;">
	  	<b style="font-size: 20px;">-일정 </b><br>
	  </div>
	  <div class="col-sm-10">
	  	<%	String[] schedArr= {schedule1,schedule2,schedule3,schedule4,schedule5,
	  			schedule6,schedule7,schedule8,schedule9,schedule10}; 
	  		for(int i=0;i<schedArr.length;i++){
	  			String sched=schedArr[i];%>
	  			<%=(i+1)%>회차 - <%if(sched!=null){out.print(sched);}else{%>해당 클래스의 <%=(i+1)%>회차 일정은 없습니다.<%} %><br>
	  	<%	}	%>	
			<br><br>
	  </div>
	</div>
	<div class="row">
		<div class="col-sm-2" id="classDetail2" style="text-align: center;">
			<b style="font-size: 20px;">-장소 </b><br>
		</div>
		<div class="col-sm-10">
			<%= place %>
			<br><br>
			<!-- 지도 -->
			<!-- <p style="margin-top:-12px">
			    <em class="link">
			        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
			            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
			        </a>
			    </em>
			</p> -->
			<div class="card mt-3" style="width: 80%;">
			<div class="card-body">
			  <div id="map" class="" style="width:100%;height:350px;"></div>
		 	</div>  
		</div>
		</div>
	</div>
   </div>		
		
		
		
</div>