<%@page import="db.HotelRoomListDTO"%>
<%@page import="db.HotelDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<center>
	 <!--  데이터 베이스에 연결하여 최신순  뿌려 주는 데이터를 가져옴 -->
	 
	 <%
	 
			HotelDAO hdao = new HotelDAO();
	 
	 		//Arraylist 데이터를 저장
	 		ArrayList<HotelRoomListDTO> arrayList = hdao.getSelectHotel();
	 		
	 %>
	 	<table	width="1000">
	 	
	 		<tr height="100" >
		 		<td colspan="3" align="center">
	 				<font size="6" color="black">예약하기</font>
	 			</td>
	 		</tr>
	 		
	 		
	 		<tr height="240">
	 <%
	 	for(int i=0; i < arrayList.size(); i++) {
	 		HotelRoomListDTO dto = arrayList.get(i);
	 
	 %>
	 			<td width="333" align="center">
	 				<a href="HotelMain.jsp?center=HotelReserveInfo.jsp?no=<%=dto.getNo()%>">
	 					<img alt="" src="img/<%=dto.getImg()%>" width="300" height="220">
	 				</a>
	 				<p><%= dto.getName() %>
	 			</td>
	 <%
	 	}
	 %>		
	 		</tr>
	 	</table>
    <!--<hr color="red" size="3"> -->
		 	<p>
		 		<font size="4" color="black"><b>Room 검색</b></font><br><br><br>
		 	</p>
		 	<form action="HotelMain.jsp?center=HotelCartegoryList.jsp" method="post">
		 	   <font size="3" color="black"><b>Room 검색 하기</b></font>&nbsp;&nbsp;
		 			<select name="category">
		 				<option value="1">스탠다드룸 (Standard Room)</option>
		 				<option value="2">슈페리어룸 (Superior Room)</option>
		 				<option value="3">딜럭스룸 (Deluxe Room)</option>
		 				<option value="4">이그제큐티브룸 (Executive Room)</option>
		 				<option value="5">스위트룸 (Suite Room)</option>
		 			</select>&nbsp;&nbsp;
		 			<input type="submit" value="검색" style="font-size:15pt; height:30px; width:100px;">&nbsp;&nbsp;	 	
		 	</form>
	
	 		<br><br>
	 	 <!-- 따로 돌아 갈야 하기에 form태그 밖에 -->
	 		<input type="button" value="전체 검색" onclick="location.href='HotelMain.jsp?center=HotelAllList.jsp'" 
	 	style="font-size:15pt; height:30px; width:100px;">
	</center>
</body>
</html>









