<%@page import="db.HotelRoomListDTO"%>
<%@page import="db.HotelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

<%

		int no = Integer.parseInt(request.getParameter("no"));
		
		//데이터베이스에 접근
		HotelDAO rdao = new HotelDAO();
		//room 하나에 대한 정보를 얻어옴
		HotelRoomListDTO dto = rdao.getOneHotel(no);	
		
		
		
		//카테고리 분류값을 받아옴
		int category = dto.getCategory();
		String temp = "";
		if (category == 1)
			temp = "스탠다드룸 (Standard Room)";
		else if (category == 2)
			temp = "슈페리어룸 (Superior Room)";
		else if (category == 3)
			temp = " 딜럭스룸 (Deluxe Room)";
		else if (category == 4)
			temp = " 이그제큐티브룸 (Executive Room)";
		else if (category == 5)
			temp = " 스위트룸 (Suite Room)";
%>
	<center>
		<form action="HotelMain.jsp?center=HotelOptionSelect.jsp" method="post">
			<table width="1000">
			
				<tr height="100">
					<td colspan="3" align="center"><font size="6" color="white">INFORMATION&nbsp;<%=dto.getName()%></font>
					</td>
				</tr>
				
				<tr>
					<td rowspan="6" width="600"><img alt=""
						src="img/<%=dto.getImg()%>" width="550"></td>
					<td width="250" align="center"><font size="3" color="white">등급</font></td>
					<td width="250" align="center"><font size="3" color="white"><%=temp%></font></td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">가격</font></td>
					<td width="250" align="center"><font size="3" color="white">&#8361;&nbsp;<%=dto.getPrice()%>&nbsp;원
					</font></td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">사용인원</font></td>
					<td width="250" align="center"><font size="3" color="white">2명</font></td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">인터넷</font></td>
					<td width="250" align="center"><font size="3" color="white">무료&nbsp;와이파이&nbsp;및&nbsp;유선&nbsp;인터넷&nbsp;제공</font></td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">조식/석식</font></td>
					<td width="250" align="center"><font size="3" color="white">가능</font></td>
				</tr>
				
				<tr>
					<td width="250" align="center"><font size="3" color="white">룸서비스</font></td>
					<td width="250" align="center"><font size="3" color="white">가능</font></td>
				</tr>
				
				
				
			</table>
		<br>
			<br>
			<br> <font size="4" color="white"><%=dto.getInfo()%></font> <br>
			<div style="height: auto; width: 200px; margin: 50px 0px 0px 0px;">
				<ul>
					<li>
						<input type="hidden" name="no" value="<%= dto.getNo() %>">
						<input type="hidden" name="img" value="<%= dto.getImg() %>">
						<input type="submit" value="예약하기"
						style="font-size: 15pt; height: 50px; width: 150px;">
					</li>
				</ul>
			</div>
			<br>
			<br>
		</form>
	</center>
</body>
</html>